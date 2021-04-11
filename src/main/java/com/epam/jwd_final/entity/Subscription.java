package com.epam.jwd_final.entity;

import java.util.Date;

public class Subscription extends AbstractBaseEntity {
    private User user;
    private Date startDate;
    private Date endDate;
    private TariffPlan tariffPlan;

    public Subscription(User user, Date startDate, Date endDate, TariffPlan tariffPlan) {
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tariffPlan = tariffPlan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public TariffPlan getTariffPlan() {
        return tariffPlan;
    }

    public void setTariffPlan(TariffPlan tariffPlan) {
        this.tariffPlan = tariffPlan;
    }
}
