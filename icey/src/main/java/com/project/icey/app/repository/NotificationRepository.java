package com.project.icey.app.repository;

import com.project.icey.app.domain.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    List<NotificationEntity> findAllByUserIdAndReadFalseOrderByCreatedAtDesc(Long userId);

    void deleteAllByUserId(Long userId);

    @Modifying
    @Transactional
    @Query("UPDATE NotificationEntity n SET n.read = true WHERE n.userId = :userId AND n.read = false")
    void markAllAsReadByUserId(@Param("userId") Long userId);
}
