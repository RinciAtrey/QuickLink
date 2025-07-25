package com.quickLink.url.repository;

import com.quickLink.url.models.ClickEvent;
import com.quickLink.url.models.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClickEventRepository extends JpaRepository<ClickEvent, Long> {
    List<ClickEvent> findByUrlMappingAndClickDateBetween(UrlMapping mapping,
                                                         LocalDateTime startDate, LocalDateTime endDate);
    List<ClickEvent> findByUrlMappingInAndClickDateBetween(List<UrlMapping> urlMappings,
                                                           LocalDateTime startDate, LocalDateTime endDate);
}
