package appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import model.Issue;
import model.Project;
import model.Status;

import javax.mail.Flags;
import javax.mail.Message;
import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.trim;

/**
 * Created by bilovyur on 01.05.2017.
 */
public class SoapHelper {
    private ApplicationManager app;

    public SoapHelper(ApplicationManager app) {
        this.app = app;
    }

    public Set<Project> getProjects() throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
        ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator", "root");
        return Arrays.asList(projects).stream()
                .map((p) -> new Project().withId(p.getId()
                        .intValue()).withName(p.getName())).collect(Collectors.toSet());
    }

    private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
        return new MantisConnectLocator().getMantisConnectPort(new URL("http://localhost:8081/mantisbt-2.3.1/api/soap/mantisconnect.php"));
    }

    public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
        String[] categories = mc.mc_project_get_categories("administrator"
                ,"root", BigInteger.valueOf(issue.getProject().getId()));
        IssueData issueData = new IssueData();
     //   mc.mc_issue_add("administrator", "root", issueData);
        issueData.setSummary(issue.getSummary());
        issueData.setDescription(issue.getDescription());
        issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName())); //получить категорию
        issueData.setCategory(categories[0]); //установить какую то категорию
        BigInteger issueId = mc.mc_issue_add("administrator", "root", issueData);
        IssueData createdIssueData = mc.mc_issue_get("administrator", "root", issueId);
     //   System.out.println("Status:" + createdIssueData.getStatus(issueId.));
     //   System.out.println("Fixed in version" + createdIssueData.getFixed_in_version());
     //   System.out.println("Version is:" + createdIssueData.getVersion());
        return new Issue().withId(createdIssueData.getId().intValue())
                .withSummary(createdIssueData.getSummary())
                .withDescription(createdIssueData.getDescription())
                .withProject(new Project().withId(createdIssueData.getProject().getId().intValue())
                .withName(createdIssueData.getProject().getName()));
    }

    public boolean getIssue (int issueId) throws MalformedURLException, ServiceException, RemoteException {

     MantisConnectPortType mc = getMantisConnect();
    IssueData getIssueData = mc.mc_issue_get("administrator", "root", BigInteger.valueOf(issueId));
    ObjectRef[] getIssueStatus = mc.mc_enum_status("administrator", "root");
    boolean statusBug = true;

     if (getIssueData.getStatus().getName().equals( getIssueStatus[5].getName())) // status = resolved
    {
             statusBug = false;
    }
        return statusBug;

}
    public int getIssueNumber (){
     int issueNumber = 0000001;
     return issueNumber;
         }

    public String getResolution(int issueId) throws RemoteException, MalformedURLException, ServiceException {
        MantisConnectPortType mc = getMantisConnect();
        IssueData getResolutionData = mc.mc_issue_get("administrator", "root", BigInteger.valueOf(issueId));
        return getResolutionData.getResolution().getName();
    }





    public void getStatuses () throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
      ObjectRef[] getIssueStatus = mc.mc_enum_status("administrator", "root");
       for (ObjectRef status: getIssueStatus ){
           System.out.println("Status_name:" + status.getName());
           System.out.println("Status_id:" + status.getId());
       }
      // getIssueStatus[5].getId();
        System.out.println("Actual_status:" +  getIssueStatus[5].getId());
    }

  //  getResolutions

    public void getResolutions () throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
        ObjectRef[] getResolutionStatus = mc.mc_enum_resolutions("administrator", "root");
        for (ObjectRef status: getResolutionStatus ){
            System.out.println("Resolution_name:" + status.getName());
            System.out.println("Resolution_id:" + status.getId());
        }
        // getIssueStatus[5].getId();
      //  System.out.println("Actual_status:" +  getIssueStatus[5].getId());
    }
}
