package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import java.util.List;

/**
 * Created by samgi on 12/14/2020.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

  User findUserById(String userId);
  User findUserByUsername(String userName);
  User findUserBySystemEmailAddress(String userEmail);

  @Query("select u from User u join Membership m on u.id = m.user.id where m.company.id = ?1")
  List<User> findUsersByCompanyId(String companyId);

  @Query("select u from User u join Membership m on u.id = m.user.id where m.company.id = ?1 and u.contact = ?2")
  List<User> findIsContactUsersByCompanyIdAnsIsContact(String companyId, Boolean contact);
}
