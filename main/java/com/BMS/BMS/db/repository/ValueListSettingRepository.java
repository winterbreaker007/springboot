package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.ValueListSetting;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by samgi on 12/14/2020.
 */
@Repository
public interface ValueListSettingRepository extends JpaRepository<ValueListSetting, Long> {
  ValueListSetting findById(String id);
  List<ValueListSetting> findAllByListName(String listName);
}