package model;

/**
 * Created by bilovyur on 01.05.2017.
 */
public class Issue {

    private int id; //идентификатор баг репорта
    private String summary; // описание баг репорта

    public int getId() {
        return id;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Issue withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public Issue withProject(Project project) {
        this.project = project;
        return this;
    }

    private String description;
    private Project project; //баг всегда должен быть привязан к какому то проекту
}

