package model;

/**
 * Created by bilovyur on 04.05.2017.
 */
public class Status {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Status)) return false;

        Status status = (Status) o;

        if (getId() != status.getId()) return false;
        return getStatusName() != null ? getStatusName().equals(status.getStatusName()) : status.getStatusName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getStatusName() != null ? getStatusName().hashCode() : 0);
        return result;
    }

    public int getId() {

        return Id;
    }

    public Status withId(int id) {
        this.Id = id;
        return this;
    }

    public String getStatusName() {
        return statusName;
    }

    public Status withStatusName(String statusName) {
        this.statusName = statusName;
        return this;
    }

    private int Id;
    private String statusName;

}
