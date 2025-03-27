package med.volli.api.controllers;


import jakarta.validation.Valid;
import med.volli.api.pacientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<DadosListagemPaciente> listarPacientes(@PageableDefault(sort = "nome") Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);
    }

    @Transactional
    @PutMapping
    public void atualizarPaciente(@RequestBody @Valid DadosAtualizaPaciente dados){
        var paciente = repository.getOne(dados.id());
        paciente.AtualizaDados(dados);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void excluirPaciente(@PathVariable Long id){
        var paciente = repository.getOne(id);
        paciente.ExcluirPaciente();
    }
}
