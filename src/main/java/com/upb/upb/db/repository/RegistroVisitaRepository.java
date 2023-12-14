package com.upb.upb.db.repository;

import com.upb.upb.db.model.RegistroVisita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistroVisitaRepository extends JpaRepository<RegistroVisita, Long> {

}
