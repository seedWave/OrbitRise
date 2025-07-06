package com.orbitRise.backend.repository;


import com.orbitRise.backend.entity.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsrRepository extends JpaRepository<Usr, String> {
}
