package org.hibernate.model;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Random;

@Embeddable
@MappedSuperclass
public abstract class DomainEntityId implements Serializable {

    private final Long domainId;

    protected DomainEntityId() {
        Random random = new Random();
        this.domainId = random.nextLong();
    }

    public Long getDomainId() {
        return domainId;
    }
}
