package com.robos.central_robos.controller;
import com.robos.central_robos.model.Robo;
import com.robos.central_robos.dto.RoboDTO;
import com.robos.central_robos.model.RoboAssistente;
import com.robos.central_robos.model.RoboCombatente;
import com.robos.central_robos.repository.RoboRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/robos")
public class RoboController {

    private final RoboRepository repository;

    public RoboController(RoboRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Robo> listarTodos() {
        return repository.findAll();
    }

    // COM DTO
    @PostMapping
    public Robo criar(@RequestBody RoboDTO dto) {
        Robo robo;

        if (dto.getTipo().equalsIgnoreCase("assistente")) {
            robo = new RoboAssistente(dto.getNome(), dto.getModelo());
        } else if (dto.getTipo().equalsIgnoreCase("combatente")) {
            robo = new RoboCombatente(dto.getNome(), dto.getModelo());
        } else {
            throw new RuntimeException("Tipo inválido");
        }

        return repository.save(robo);
    }

    @GetMapping("/{id}/acao")
    public String executarAcao(@PathVariable Long id) {
        return repository.findById(id)
                .map(Robo::executarAcao)
                .orElse("Robô não encontrado");
    }

    @PutMapping("/{id}")
    public Robo atualizar(@PathVariable Long id, @RequestBody Robo novoRobo) {
        return repository.findById(id)
                .map(robo -> {
                    robo.setNome(novoRobo.getNome());
                    robo.setModelo(novoRobo.getModelo());
                    return repository.save(robo);
                })
                .orElseThrow(() -> new RuntimeException("Robô não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
