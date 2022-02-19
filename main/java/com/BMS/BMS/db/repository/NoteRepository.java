package com.blackwater.blackwaterbillingmanagementsystem.db.repository;

import org.springframework.stereotype.Repository;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Note;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
    
  List<Note> findByClientId(String clientId);
  Optional<Note> findById(String clientId);
  List<Note> findByClientIdOrderByDateEnteredDesc(String clientId);
    
}
