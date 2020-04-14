package com.demo.asset.data;

import com.demo.asset.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findByName(String name);

    List<Device> findByLevel(long level);

}
