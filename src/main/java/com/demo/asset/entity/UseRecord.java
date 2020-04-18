package com.demo.asset.entity;

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
}
