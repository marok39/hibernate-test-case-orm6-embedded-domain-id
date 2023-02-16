package org.hibernate.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import org.assertj.core.annotations.NonNull;

@MappedSuperclass
public abstract class DomainEntityModel<ID extends DomainEntityId> {

    @EmbeddedId
    @NonNull
    private ID id;

    protected DomainEntityModel(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }
}
