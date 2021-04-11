package com.epam.jwd_final.entity;

public abstract class AbstractBaseEntity implements BaseEntity {
    private static long countId = 0;
    private Long id;

    public AbstractBaseEntity() {
        this.id = countId++;
    }

    @Override
    public Long getId() {
        return id;
    }
}
