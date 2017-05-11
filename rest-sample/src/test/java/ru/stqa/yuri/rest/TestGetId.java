package ru.stqa.yuri.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by bilovyur on 09.05.2017.
 */
public class TestGetId {

    @Test
    public void testGetIssue() throws IOException {

      Integer testId =  getIssueId();
        System.out.println("ID:" + testId  );
       // System.out.println(getIssue1.toString().);
    }

    private Executor getExecutor() {
        return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==","");
    }


    private boolean getIssues(Integer issueId ) throws IOException {
        String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues/"+ issueId + ".json"))
                .returnContent().asString();//
        JsonElement parsed =new JsonParser().parse(json);
 //       JsonElement issues = parsed.getAsJsonObject().get("issues");
        JsonElement issues = parsed.getAsJsonObject().get("issues");
      //String str1 = issues.isJsonNull()  ? "" : issues.getAsString();
        String str1 = issues.toString();
        System.out.println(str1);
        if (str1.contains("Resolved")){
            System.out.println("The issue is in resolved state");
        }
        //boolean contains = IntStream.of(str1).anyMatch(x -> x == 4);

       // item.get("start").isJsonNull() ? "" : item.get("start").getAsString();
       // JsonElement separate_issue = issues.getAsJsonArray();
  //      boolean contains;
      //  if (IntStream.of(issues).anyMatch(x -> x == 4)) contains = true;
     //   else contains = false;

       // String findIssue = separate_issue.

     //   int[] a = {1,2,3,4};
     //   boolean contains = IntStream.of(a).anyMatch(x -> x == 4);      separate_issue

     //   System.out.println("Status:" + separate_issue);
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    }

    private Integer getIssueId( ) throws IOException {
        String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json"))
                .returnContent().asString();
        JsonElement parsed =new JsonParser().parse(json);
        return parsed.getAsJsonObject().get("issue_id").getAsInt();

    }


}
