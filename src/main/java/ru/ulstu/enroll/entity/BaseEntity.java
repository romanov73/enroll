package ru.ulstu.enroll.entity;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity implements Serializable, EntityAPI {
    private static final long serialVersionUID = 1L;
    
}
