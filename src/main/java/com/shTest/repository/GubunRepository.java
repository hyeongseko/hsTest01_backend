package com.shTest.repository;

import com.shTest.entity.ComDetailCd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GubunRepository extends JpaRepository<ComDetailCd, String> {
    List<ComDetailCd> findByComClsfCdIdContaining(String comClsfCdId);

}
