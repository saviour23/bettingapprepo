package com.tabcorp.app.betsapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.tabcorp.app.betsapplication.data.BettingData;

public interface BettingRepository extends CrudRepository<BettingData, Long> {

}
