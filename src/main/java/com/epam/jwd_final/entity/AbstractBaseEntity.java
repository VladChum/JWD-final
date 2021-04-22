package com.epam.jwd_final.entity;

public abstract class AbstractBaseEntity implements BaseEntity {
    private Long id;

    public AbstractBaseEntity(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
