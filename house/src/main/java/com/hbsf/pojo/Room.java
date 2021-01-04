package com.hbsf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Room {
    private Integer id;

    private String name;

    private String location;

    private String model;

    private BigDecimal price;

    private Integer owner;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", owner=" + owner +
                ", area='" + area + '\'' +
                ", createtime=" + createtime +
                ", state=" + state +
                ", hot=" + hot +
                '}';
    }

    public Room(Integer id, String name, String location, String model, BigDecimal price, Integer owner, String area, Date createtime, Integer state, Integer hot) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.model = model;
        this.price = price;
        this.owner = owner;
        this.area = area;
        this.createtime = createtime;
        this.state = state;
        this.hot = hot;
    }

    public Room() {
    }

    private String area;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    private Integer state;

    private Integer hot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
}