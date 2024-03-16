package com.tonero.church_detail.repository;

import com.tonero.church_detail.entity.ChurchDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChurchDetailRepository extends JpaRepository<ChurchDetail, Long> {

}
