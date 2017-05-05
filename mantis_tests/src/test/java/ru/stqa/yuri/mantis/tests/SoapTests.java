package ru.stqa.yuri.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import biz.futureware.mantis.rpc.soap.client.ProjectData;
import model.Issue;
import model.Project;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by bilovyur on 30.04.2017.
 */
public class SoapTests extends TestBase {

    @BeforeMethod
    public void startMailServer() throws RemoteException, ServiceException, MalformedURLException {
        app.mail().start(); //запуск Mail Server перед тестом
      Integer  issueId = app.soap().getIssueNumber();
        skipIfNotFixed(issueId);
    }

    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
        //  projects = mc.mc_projects_get_user_accessible("administrator", "root");
        System.out.println("Quantity of projects:"+projects.size()); //сколько проектов доступно
        for(Project project:projects ){
            System.out.println("Name of project:" + project.getName());
        }

    }

    @Test
    public void testCreateIssue()throws MalformedURLException, ServiceException, RemoteException{
        Set<Project> projects = app.soap().getProjects();
        Issue issue = new Issue().withSummary("Test issue2")
        .withDescription("Test issue description").withProject(projects.iterator().next());
        Issue created=  app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary()); //сравниваем Summary
    }

    @Test
    public void testCheckIfFixedIssue() throws RemoteException, ServiceException, MalformedURLException {
    //    Set<Project> projects = app.soap().getIssue();
        app.soap().getIssue(0000001);


    }

    @Test
    public void testGetStatuses() throws RemoteException, ServiceException, MalformedURLException {
        app.soap().getStatuses();

    }

    @Test
    public void testCheckResolution() throws RemoteException, ServiceException, MalformedURLException {
        Integer  issueId = app.soap().getIssueNumber();
      //  app.soap().getResolution(issueId)
        assertEquals(app.soap().getResolution(issueId), "fixed"); //проверим на то, что если дефект закрыт, то он fixed
    }

    @AfterMethod(alwaysRun = true)
    public void startTest() {
        app.mail().stop(); //остановка Mail Server после теста

    }
}
