package com.kolkov.post.repository;

import com.kolkov.post.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    @Query("select s from Status s left join fetch s.office where s.dispatch.id = ?1 order by current_timestamp asc")
    Collection<Status> getStatusByDispatchId(Long id);

    @Modifying
    @Query(nativeQuery = true, value = "insert into status (dispatch_id, office_id, status) " +
            "VALUES (?1, ?2, ?3)")
    void registerDispatchStatus(Long dispatchId, Long officeId, String status);
}
