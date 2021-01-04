package com.hbsf.util;

import java.util.List;

public class NavBean {

    private Integer id;
    private String title;
	private String icon;
	private String href;
	private Boolean spread;
	private List<NavBean> children;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public List<NavBean> getChildren() {
        return children;
    }

    public void setChildren(List<NavBean> children) {
        this.children = children;
    }

    public NavBean(Integer id, String title, String icon, String href, Boolean spread, List<NavBean> children) {
        super();
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
        this.children = children;
    }

    public NavBean() {
        super();
    }


}
