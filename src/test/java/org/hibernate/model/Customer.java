package org.hibernate.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.Random;

@Entity
public class Customer extends DomainEntityModel<Customer.CustomerId> {

    private Integer code;
    private String name;

    @Embeddable
    public static class CustomerId extends DomainEntityId {
        private int someDomainField;

        public CustomerId() {
            super();
            this.someDomainField = new Random().nextInt();
        }

        public int getSomeDomainField() {
            return someDomainField;
        }
    }

    public Customer(Integer code, String name) {
        this();
        this.code = code;
        this.name = name;
    }

    protected Customer() {
        super(new CustomerId());
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
