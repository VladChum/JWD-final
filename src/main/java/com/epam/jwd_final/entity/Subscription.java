package com.epam.jwd_final.entity;

import java.util.Date;
import java.util.Objects;

public class Subscription extends AbstractBaseEntity {
    private Long userId;
    private Date startDate;
    private Date endDate;
    private Long tariffPlanId;

    public Subscription(Long id,  Date startDate, Date endDate, Long userId, Long tariffPlanId) {
        super(id);
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tariffPlanId = tariffPlanId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTariffPlanId() {
        return tariffPlanId;
    }

    public void setTariffPlanId(Long tariffPlanId) {
        this.tariffPlanId = tariffPlanId;
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

    @Override
    public int hashCode() {
        return Objects.hash(userId, startDate, endDate, tariffPlanId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Subscription subscription = (Subscription) obj;
        return Objects.equals(userId, subscription.userId)
                && Objects.equals(startDate, subscription.startDate)
                && Objects.equals(endDate, subscription.endDate)
                && Objects.equals(tariffPlanId, subscription.tariffPlanId);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "userId=" + userId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", tariffPlanId=" + tariffPlanId +
                '}';
    }
}
