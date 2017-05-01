package ru.stqa.yuri.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import biz.futureware.mantis.rpc.soap.client.ProjectData;
import model.Issue;
import model.Project;
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
Issue issue = new Issue().withSummary("Test issue")
        .withDescription("Test issue description").withProject(projects.iterator().next());
        Issue created=  app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary()); //сравниваем Summary
    }
}
