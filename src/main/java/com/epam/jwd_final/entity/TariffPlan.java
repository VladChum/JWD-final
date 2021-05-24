package com.epam.jwd_final.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class TariffPlan extends AbstractBaseEntity {
    private String name;
    private BigDecimal price;
    private Long discountId;
    private int speed;
    private boolean active;

    public TariffPlan(Long id, String name, BigDecimal price, Long discountId, int speed, boolean active) {
        super(id);
        this.name = name;
        this.price = price;
        this.discountId = discountId;
        this.speed = speed;
        this.active = active;
    }

    public TariffPlan(String name, BigDecimal price, int speed) {
        super(1L);
        this.name = name;
        this.price = price;
        this.speed = speed;
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, discountId, speed);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TariffPlan tariffPlan = (TariffPlan) obj;
        return Objects.equals(name, tariffPlan.name)
                && Objects.equals(price, tariffPlan.price)
                && Objects.equals(discountId, tariffPlan.discountId)
                && Objects.equals(speed, tariffPlan.speed)
                && Objects.equals(active, tariffPlan.active);
    }

    @Override
    public String toString() {
        return "TariffPlan{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", discountId=" + discountId +
                ", speed=" + speed +
                ", active=" + active +
                '}';
    }
}
