package com.neusoft.neu23.service;

import com.neusoft.neu23.entity.Guest;

import java.util.List;

public interface GuestService {
    public Integer addGuest(Guest guest);
    List<Guest> listByLastName( String lastName );
}
