package com.log.loggitor.repository;

import org.springframework.data.repository.CrudRepository;

import com.log.loggitor.domain.LogFile;



public interface LogFileRepository extends CrudRepository<LogFile, Long>{

}
