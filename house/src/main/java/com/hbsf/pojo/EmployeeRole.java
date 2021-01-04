package com.hbsf.pojo;

public class EmployeeRole {
    private Integer id;

    private Integer empid;

    private Integer roleid;

    private String other;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public EmployeeRole() {
    }

    public EmployeeRole(Integer id, Integer empid, Integer roleid, String other) {
        this.id = id;
        this.empid = empid;
        this.roleid = roleid;
        this.other = other;
    }
}