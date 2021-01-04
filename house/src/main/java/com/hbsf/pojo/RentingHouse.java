package com.hbsf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * java实体类
 * javabean
 */
public class RentingHouse {
    private Integer id;

    private Integer room;

    private Integer landlord;

    private Integer lodger;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ctime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date etime;

    private String status;

    private String other;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getLandlord() {
        return landlord;
    }

    public void setLandlord(Integer landlord) {
        this.landlord = landlord;
    }

    public Integer getLodger() {
        return lodger;
    }

    public void setLodger(Integer lodger) {
        this.lodger = lodger;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public RentingHouse() {
    }

    @Override
    public String toString() {
        return "RentingHouse{" +
                "id=" + id +
                ", room=" + room +
                ", landlord=" + landlord +
                ", lodger=" + lodger +
                ", ctime=" + ctime +
                ", stime=" + stime +
                ", etime=" + etime +
                ", status='" + status + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public RentingHouse(Integer id, Integer room, Integer landlord, Integer lodger, Date ctime, Date stime, Date etime, String status, String other) {
        this.id = id;
        this.room = room;
        this.landlord = landlord;
        this.lodger = lodger;
        this.ctime = ctime;
        this.stime = stime;
        this.etime = etime;
        this.status = status;
        this.other = other;
    }
}