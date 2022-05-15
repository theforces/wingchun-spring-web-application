package com.wingchun.wingchun.repository;

import com.wingchun.wingchun.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
