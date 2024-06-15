package com.example.demo.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.DTO.AgentDTO;
import com.example.demo.DTO.CarDTO;

public interface AgentService {
    public Page<AgentDTO> getAllAgent (Pageable pageable);
    public AgentDTO getAgentById (long id);
    public AgentDTO getAgentByAgencyName (String name);
    public Optional <Page <AgentDTO> > getAgentByAgentAddress (String agencyAddress, Pageable pageable);
    public AgentDTO addAgent (AgentDTO agent);
    public void deleteAgent (long id);
    public AgentDTO assignCarToAgent (long id , CarDTO car);
    
}
