package com.demo.asset.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "return_device")
public class ReturnRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "use_id")
    private String useId;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "user")
    private String user;

    @Column(name = "remark")
    private String remark;

    public ReturnRecord() {
        this.returnDate = new Date();
        this.user = "";
        this.remark = "";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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
