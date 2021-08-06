package com.epam.jwd.entity;

import java.util.Date;
import java.util.Objects;

public class Discount extends AbstractBaseEntity {
    private Date startDate;
    private Date endDate;
    private double size;

    public Discount(Long id, Date startDate, Date endDate, double size) {
        super(id);
        this.startDate = startDate;
        this.endDate = endDate;
        this.size = size;
    }

    public Discount(Date startDate, Date endDate, double size) {
        super(1L);
        this.startDate = startDate;
        this.endDate = endDate;
        this.size = size;
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, size);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Discount discount = (Discount) obj;
        return Objects.equals(startDate, discount.startDate)
                && Objects.equals(endDate, discount.endDate)
                && Objects.equals(size, discount.size);
    }

    @Override
    public String toString() {
        return "Discount{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", size=" + size +
                '}';
    }
}
