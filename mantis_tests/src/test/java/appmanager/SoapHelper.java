package appmanager;

import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import biz.futureware.mantis.rpc.soap.client.ProjectData;
import model.Issue;
import model.Project;

import javax.xml.rpc.ServiceException;

/**
 * Created by bilovyur on 01.05.2017.
 */
public class SoapHelper {
    private ApplicationManager app;

    public SoapHelper (ApplicationManager app){
        this.app = app;
    }

    public Set<Project> getProjects() throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
        ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator", "root");
        return Arrays.asList(projects).stream().map((p) -> new Project().withId(p.getId().intValue()).withName(p.getName())).collect(Collectors.toSet());
    }

    private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
        return new MantisConnectLocator().getMantisConnectPort(new URL("http://localhost:8081/mantisbt-2.3.1/api/soap/mantisconnect.php"));
    }

    public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException {
        MantisConnectPortType mc = getMantisConnect();
        mc.mc_issue_add("administrator","root",);

    }

}
