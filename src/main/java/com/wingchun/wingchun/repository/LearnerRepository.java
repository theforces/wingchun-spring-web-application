package com.wingchun.wingchun.repository;

import com.wingchun.wingchun.model.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner, Long> {
}
