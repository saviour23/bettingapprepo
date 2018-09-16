package com.tc.app.betsapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.tc.app.betsapplication.data.BettingData;

public interface BettingRepository extends CrudRepository<BettingData, Long> {

}
