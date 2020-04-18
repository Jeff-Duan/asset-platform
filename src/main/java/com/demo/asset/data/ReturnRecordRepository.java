package com.demo.asset.data;

import com.demo.asset.entity.ReturnRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRecordRepository extends JpaRepository<ReturnRecord, Long> {

}
