package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bns.model.MarketingPref;
@Repository
public interface MarketingPrefRepository extends JpaRepository<MarketingPref, Long>  {

}
