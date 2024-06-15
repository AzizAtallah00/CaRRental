package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long>{
    Page<Agent> findByAgencyAddress (String agencyAddress, Pageable pageable);
    Agent findByAgencyName (String name);
    Page <Agent> findAll (Pageable pageable);
}
