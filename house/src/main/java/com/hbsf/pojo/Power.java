package com.hbsf.pojo;

public class Power {
    private Integer id;

    private String name;

    private String url;
    private String menutype;

    private String powercharacteristic;

    private Integer parentId;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMenutype() {
        return menutype;
    }

    public void setMenutype(String menutype) {
        this.menutype = menutype == null ? null : menutype.trim();
    }

    public String getPowercharacteristic() {
        return powercharacteristic;
    }

    public void setPowercharacteristic(String powercharacteristic) {
        this.powercharacteristic = powercharacteristic == null ? null : powercharacteristic.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}