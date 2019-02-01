package com.zkyf.invoking.model;

import java.util.Date;

public class Team {
    private Integer temNo;

    private String temUuid;

    private Date crtStamp;

    private Integer crtNo;

    private Date oprStamp;

    private Integer oprNo;

    private Integer temRemoved;

    private Integer temKind;

    private Integer prjNo;

    private Integer temParentno;

    private String temId;

    private String temCaption;

    private String temRemark;

    private Integer temOutsource;

    private Integer lbrNo;

    private Integer temCount;

    private Integer temMembers;

    private Integer arsQuality;

    private Integer arsTime;

    private Integer arsSafe;

    public Integer getTemNo() {
        return temNo;
    }

    public void setTemNo(Integer temNo) {
        this.temNo = temNo;
    }

    public String getTemUuid() {
        return temUuid;
    }

    public void setTemUuid(String temUuid) {
        this.temUuid = temUuid == null ? null : temUuid.trim();
    }

    public Date getCrtStamp() {
        return crtStamp;
    }

    public void setCrtStamp(Date crtStamp) {
        this.crtStamp = crtStamp;
    }

    public Integer getCrtNo() {
        return crtNo;
    }

    public void setCrtNo(Integer crtNo) {
        this.crtNo = crtNo;
    }

    public Date getOprStamp() {
        return oprStamp;
    }

    public void setOprStamp(Date oprStamp) {
        this.oprStamp = oprStamp;
    }

    public Integer getOprNo() {
        return oprNo;
    }

    public void setOprNo(Integer oprNo) {
        this.oprNo = oprNo;
    }

    public Integer getTemRemoved() {
        return temRemoved;
    }

    public void setTemRemoved(Integer temRemoved) {
        this.temRemoved = temRemoved;
    }

    public Integer getTemKind() {
        return temKind;
    }

    public void setTemKind(Integer temKind) {
        this.temKind = temKind;
    }

    public Integer getPrjNo() {
        return prjNo;
    }

    public void setPrjNo(Integer prjNo) {
        this.prjNo = prjNo;
    }

    public Integer getTemParentno() {
        return temParentno;
    }

    public void setTemParentno(Integer temParentno) {
        this.temParentno = temParentno;
    }

    public String getTemId() {
        return temId;
    }

    public void setTemId(String temId) {
        this.temId = temId == null ? null : temId.trim();
    }

    public String getTemCaption() {
        return temCaption;
    }

    public void setTemCaption(String temCaption) {
        this.temCaption = temCaption == null ? null : temCaption.trim();
    }

    public String getTemRemark() {
        return temRemark;
    }

    public void setTemRemark(String temRemark) {
        this.temRemark = temRemark == null ? null : temRemark.trim();
    }

    public Integer getTemOutsource() {
        return temOutsource;
    }

    public void setTemOutsource(Integer temOutsource) {
        this.temOutsource = temOutsource;
    }

    public Integer getLbrNo() {
        return lbrNo;
    }

    public void setLbrNo(Integer lbrNo) {
        this.lbrNo = lbrNo;
    }

    public Integer getTemCount() {
        return temCount;
    }

    public void setTemCount(Integer temCount) {
        this.temCount = temCount;
    }

    public Integer getTemMembers() {
        return temMembers;
    }

    public void setTemMembers(Integer temMembers) {
        this.temMembers = temMembers;
    }

    public Integer getArsQuality() {
        return arsQuality;
    }

    public void setArsQuality(Integer arsQuality) {
        this.arsQuality = arsQuality;
    }

    public Integer getArsTime() {
        return arsTime;
    }

    public void setArsTime(Integer arsTime) {
        this.arsTime = arsTime;
    }

    public Integer getArsSafe() {
        return arsSafe;
    }

    public void setArsSafe(Integer arsSafe) {
        this.arsSafe = arsSafe;
    }
}