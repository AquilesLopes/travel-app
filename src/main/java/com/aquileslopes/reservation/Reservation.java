package com.aquileslopes.reservation;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.aquileslopes.client.Client;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Reservation extends PanacheEntity {
    
    @ManyToOne(fetch = FetchType.EAGER)
    public Client client;

}
