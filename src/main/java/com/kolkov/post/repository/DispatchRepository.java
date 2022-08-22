package com.kolkov.post.repository;

import com.kolkov.post.entity.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DispatchRepository extends JpaRepository<Dispatch, Long> {
}
