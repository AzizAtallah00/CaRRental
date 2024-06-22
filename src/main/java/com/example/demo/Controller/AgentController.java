package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AgentDTO;
import com.example.demo.DTO.CarDTO;
import com.example.demo.Service.AgentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Agent", description = " Agent Api")
@RestController
@RequestMapping("/agent")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService agentService;

    @GetMapping()
    public Page<AgentDTO> getAllAgent(Pageable pageable){
        return agentService.getAllAgent(pageable);
    }

    @GetMapping("/{id}")
    public AgentDTO getAgentById (@PathVariable long id){
        return agentService.getAgentById( id);
    }
    
    @GetMapping("/agencyName/{name}")
    public AgentDTO getAgentByAgencyName (@PathVariable String name){
        return agentService.getAgentByAgencyName(name);
    }

    @GetMapping("/agencyAddress")
    public Page<AgentDTO> getAgentByAgentAddress (@RequestParam  String agencyAddress, Pageable pageable){
        return agentService.getAgentByAgentAddress(agencyAddress, pageable).get();
    }

    @PostMapping()
    public AgentDTO addAgent(@RequestBody AgentDTO agent){
        return agentService.addAgent(agent);
    }

    @DeleteMapping("/{id}")
    public void deleteAgent(@PathVariable long id){
        agentService.deleteAgent(id);
    }

    @PostMapping("/addCar/{id}")
    public AgentDTO addCar(@PathVariable long id, @RequestBody CarDTO car){
        return agentService.assignCarToAgent(id, car);
    }
    
}
