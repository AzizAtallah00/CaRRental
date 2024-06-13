package com.example.demo.Mapper;

import org.modelmapper.ModelMapper;

import com.example.demo.DTO.AgentDTO;
import com.example.demo.Entity.Agent;

public class AgentMapper {
    private static final ModelMapper modelMapper= new ModelMapper();

	public static AgentDTO convertToDto(Agent agent)
	{
		return modelMapper.map(agent, AgentDTO.class);
	}
	public static Agent convertToEntity(AgentDTO agentDTO)
	{
		return modelMapper.map(agentDTO, Agent.class);
	}
    
}
