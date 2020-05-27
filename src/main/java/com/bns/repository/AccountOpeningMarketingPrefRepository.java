package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bns.model.AccountOpeningMarketingPref;
@Repository
public interface AccountOpeningMarketingPrefRepository extends JpaRepository<AccountOpeningMarketingPref, Long>  {

}
