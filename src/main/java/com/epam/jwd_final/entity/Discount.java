package com.epam.jwd_final.entity;

import java.util.Date;

public class Discount extends AbstractBaseEntity {
    private Date startDate;
    private Date endDate;
    private double size;


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
