package com.example.demo.Service.Impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.AgentDTO;
import com.example.demo.DTO.CarDTO;
import com.example.demo.Entity.Agent;
import com.example.demo.Entity.Car;
import com.example.demo.Mapper.AgentMapper;
import com.example.demo.Mapper.CarMapper;
import com.example.demo.Repository.AgentRepository;
import com.example.demo.Repository.CarRepository;
import com.example.demo.Service.AgentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService{

    private final AgentRepository agentRepository;
    private final CarRepository carRepository;

    @Override
    public Page<AgentDTO> getAllAgent(Pageable pageable) {
        Page <Agent> agents =agentRepository.findAll(pageable);
        return agents.map(AgentMapper::convertToDto);
    }

    @Override
    public AgentDTO getAgentById(long id) {
        Agent agent = agentRepository.findById(id).get();
        return AgentMapper.convertToDto(agent);
    }

    @Override
    public AgentDTO getAgentByAgencyName(String name) {
        Agent agent = agentRepository.findByAgencyName(name);
        return AgentMapper.convertToDto(agent);

    }

    @Override
    public Optional<Page<AgentDTO>> getAgentByAgentAddress(String agencyAddress, Pageable pageable) {
        Page <Agent> agents = agentRepository.findByAgencyAddress(agencyAddress, pageable);
        if (agents.isEmpty())
            return Optional.empty();
        else
        {   Page<AgentDTO> agentDTOs = agents.map(AgentMapper::convertToDto);
            return Optional.of(agentDTOs);
        }    
    }

    @Override
    public AgentDTO addAgent(AgentDTO agent) {
        Agent agent1 = AgentMapper.convertToEntity(agent);
        return AgentMapper.convertToDto (agentRepository.save(agent1));
    }

    @Override
    public void deleteAgent(long id) {
        agentRepository.deleteById(id);
    }

    @Override
    public AgentDTO assignCarToAgent (long id, CarDTO car) {
        Agent agent = agentRepository.findById(id).orElse(null);
        if (agent == null)
            return null;
        else
        {
            Car car1 = CarMapper.convertToEntity(car);
            car1.setAgent(agent);
            carRepository.save(car1);
            return (AgentMapper.convertToDto(agent));
        }
    }
    
}
