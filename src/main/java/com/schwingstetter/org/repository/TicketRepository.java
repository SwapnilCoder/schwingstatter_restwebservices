package com.schwingstetter.org.repository;

import org.springframework.data.repository.CrudRepository;

import com.schwingstetter.org.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, String> {

}
