package med.volli.api.controllers;


import jakarta.validation.Valid;
import med.volli.api.pacientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacienteRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity CadastrarPaciente(@RequestBody @Valid DadosCadastroPacientes dados, UriComponentsBuilder uriBuilder){
        var paciente = new Pacientes(dados);
        repository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listarPacientes(@PageableDefault(sort = "nome") Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity atualizarPaciente(@RequestBody @Valid DadosAtualizaPaciente dados){
        var paciente = repository.getOne(dados.id());
        paciente.AtualizaDados(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity excluirPaciente(@PathVariable Long id){
        var paciente = repository.getOne(id);
        paciente.ExcluirPaciente();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPacientesById(@PathVariable Long id){
        var paciente = repository.getOne(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}
