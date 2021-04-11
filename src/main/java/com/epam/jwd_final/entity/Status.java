package com.epam.jwd_final.entity;

import com.epam.jwd_final.exception.UnknownEntityException;

import java.util.Arrays;

public enum Status implements BaseEntity {
    ACTIVATE(1L),
    BANNED(2L),
    SUSPENDED(3L);

    private final Long id;

    Status(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name();
    }

    public static Status resolveStatusById(int id) throws UnknownEntityException{
        return Arrays.stream(Status.values())
                .filter(status -> status.id.equals((long) id))
                .findFirst()
                .orElseThrow(() -> new UnknownEntityException("Impossible to resolve status by specified id"));
    }
}
