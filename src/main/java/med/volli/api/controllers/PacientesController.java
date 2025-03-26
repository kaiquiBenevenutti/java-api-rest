package med.volli.api.controllers;

import jakarta.validation.Valid;
import med.volli.api.pacientes.DadosCadastroPacientes;
import med.volli.api.pacientes.PacienteRepository;
import med.volli.api.pacientes.Pacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacienteRepository repository;

    @Transactional
    @PostMapping
    public void CadastrarPaciente(@RequestBody @Valid DadosCadastroPacientes dados){
        repository.save(new Pacientes(dados));
    }
}
