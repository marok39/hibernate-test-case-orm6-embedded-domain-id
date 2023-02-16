package org.hibernate.model;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
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
