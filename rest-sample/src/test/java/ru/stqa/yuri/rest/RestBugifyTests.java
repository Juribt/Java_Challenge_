package ru.stqa.yuri.rest;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by bilovyur on 07.05.2017.
 */
public class RestBugifyTests extends TestBase{

    @BeforeMethod
    public void startTestBugify() throws IOException {
        Integer issueId = getIssueNumber(); //получаем номер дефекта
        skipIfNotFixed(issueId);  //проверяем зарезолвен дефект или нет
            }

    @BeforeTest
    public void init(){
        RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==","");
    }


    @Test
    public void testCreateIssue() throws IOException {
        Set<Issue> oldIssues = getIssues();
        Issue newIssue = new Issue().withSubject("Test subject_from Yuri").withDescription("Test bugify");
        int issueId = createIssue(newIssue);
        Set<Issue> newIssues = getIssues();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues, oldIssues);
    }


    private Set<Issue> getIssues() throws IOException {
        String json = RestAssured.get("http://demo.bugify.com/api/issues.json").asString();
           JsonElement parsed =new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
            return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    }



    private int createIssue(Issue newIssue) throws IOException {

        String json = RestAssured.given()
                .parameter("subject", newIssue.getSubject())
                .parameter("description", newIssue.getDescription())
                .post("http://demo.bugify.com/api/issues.json").asString();

        JsonElement parsed = new JsonParser().parse(json); //парсим значения в post response
        System.out.println("Bug report:" + parsed.getAsJsonObject().get("issue_id").getAsInt());
        return parsed.getAsJsonObject().get("issue_id").getAsInt(); //возвращаем id созданного баг репорта
    }

    public int getIssueNumber (){
        int issueNumber = 0000007;
        return issueNumber;
    }


}
