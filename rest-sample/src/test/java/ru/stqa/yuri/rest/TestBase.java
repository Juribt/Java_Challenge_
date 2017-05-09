package ru.stqa.yuri.rest;

import com.jayway.restassured.RestAssured;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.SkipException;
import java.io.IOException;





/**
 * Created by bilovyur on 09.05.2017.
 */
public class TestBase {


    public static void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
    public static boolean isIssueOpen(int issueId) throws IOException {

        return getIssues(issueId);
    }

    public static boolean getIssues(Integer issueId ) throws IOException {
        boolean issueStatus = true;

        String json = RestAssured.get("http://demo.bugify.com/api/issues/"+issueId +".json").asString();
        JsonElement parsed =new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        String str1 = issues.toString();
        if (str1.contains("Resolved")){
            issueStatus = false;
        }

        return issueStatus;
    }


}
