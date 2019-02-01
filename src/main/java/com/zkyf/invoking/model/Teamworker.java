package com.zkyf.invoking.model;

import java.util.Date;

public class Teamworker {
    private Integer twkNo;

    private String twkUuid;

    private Date crtStamp;

    private Integer crtNo;

    private Date oprStamp;

    private Integer oprNo;

    private Integer twkRemoved;

    private Integer twkState;

    private Integer prjNo;

    private Integer temNo;

    private Integer empNo;

    private String twkStartstamp;

    private String twkEndstamp;

    private Integer twkDuty;

    private Integer twkWorkbreed;

    private Integer temParentno;

    public Integer getTwkNo() {
        return twkNo;
    }

    public void setTwkNo(Integer twkNo) {
        this.twkNo = twkNo;
    }

    public String getTwkUuid() {
        return twkUuid;
    }

    public void setTwkUuid(String twkUuid) {
        this.twkUuid = twkUuid == null ? null : twkUuid.trim();
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

    public Integer getTwkRemoved() {
        return twkRemoved;
    }

    public void setTwkRemoved(Integer twkRemoved) {
        this.twkRemoved = twkRemoved;
    }

    public Integer getTwkState() {
        return twkState;
    }

    public void setTwkState(Integer twkState) {
        this.twkState = twkState;
    }

    public Integer getPrjNo() {
        return prjNo;
    }

    public void setPrjNo(Integer prjNo) {
        this.prjNo = prjNo;
    }

    public Integer getTemNo() {
        return temNo;
    }

    public void setTemNo(Integer temNo) {
        this.temNo = temNo;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getTwkStartstamp() {
        return twkStartstamp;
    }

    public void setTwkStartstamp(String twkStartstamp) {
        this.twkStartstamp = twkStartstamp == null ? null : twkStartstamp.trim();
    }

    public String getTwkEndstamp() {
        return twkEndstamp;
    }

    public void setTwkEndstamp(String twkEndstamp) {
        this.twkEndstamp = twkEndstamp == null ? null : twkEndstamp.trim();
    }

    public Integer getTwkDuty() {
        return twkDuty;
    }

    public void setTwkDuty(Integer twkDuty) {
        this.twkDuty = twkDuty;
    }

    public Integer getTwkWorkbreed() {
        return twkWorkbreed;
    }

    public void setTwkWorkbreed(Integer twkWorkbreed) {
        this.twkWorkbreed = twkWorkbreed;
    }

    public Integer getTemParentno() {
        return temParentno;
    }

    public void setTemParentno(Integer temParentno) {
        this.temParentno = temParentno;
    }
}