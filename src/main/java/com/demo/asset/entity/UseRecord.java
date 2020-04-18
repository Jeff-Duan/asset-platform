package com.demo.asset.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "use_device")
public class UseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "device_id")
    private long deviceId;

    @Column(name = "use_date")
    private Date useDate;

    @Column(name = "user")
    private String user;

    @Column(name = "remark")
    private String remark;

    @OneToOne(mappedBy = "useRecord", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ReturnRecord returnRecord;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id", insertable = false, updatable = false)
    @JsonIgnore
    private Device device;

    public UseRecord() {
        this.useDate = new Date();
        this.user = "";
        this.remark = "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ReturnRecord getReturnRecord() {
        return returnRecord;
    }

    public void setReturnRecord(ReturnRecord returnRecord) {
        this.returnRecord = returnRecord;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
