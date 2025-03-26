package med.volli.api.controllers;

import jakarta.validation.Valid;
import med.volli.api.medicos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping
    public void CadastrarMedico(@RequestBody @Valid DadosCadastroMedicos dados){
        repository.save(new Medicos(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicos> ListarMedicos(@PageableDefault(sort = {"nome"}) Pageable pageable){
        return repository.findAll(pageable).map(DadosListagemMedicos::new);
    }

    @Transactional
    @PutMapping
    public void AtualizarMedico(@RequestBody @Valid DadosAtualizaMedicos dados){
        var medico = repository.getOne(dados.id());
        medico.AtualizaDados(dados);
    }
}
