package com.demo.asset.data;

import com.demo.asset.entity.UseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRecordRepository extends JpaRepository<UseRecord, Long> {

}
