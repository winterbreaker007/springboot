package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by samgi on 12/14/2020.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findAllByIdIn(List<String> ids);
  @Query("select c from Client c inner join Job j on c.id = j.clientId where j.companyId in ?1")
  List<Client> findAllByCompanyIds(List<String> companyIds);
  
  
  
  Client findById(String id);
}
