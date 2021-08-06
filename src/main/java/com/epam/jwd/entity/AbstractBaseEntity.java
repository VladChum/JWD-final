package com.epam.jwd.entity;

public abstract class AbstractBaseEntity {
    private final Long id;

    public AbstractBaseEntity(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
}
