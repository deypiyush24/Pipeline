package model.user;

public class Departments {

    private String department_name;
    private int head_count;
    private Lead lead;

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getHead_count() {
        return head_count;
    }

    public void setHead_count(int head_count) {
        this.head_count = head_count;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }



}
