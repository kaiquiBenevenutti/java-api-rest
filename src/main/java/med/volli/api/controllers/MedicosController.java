package med.volli.api.controllers;

import med.volli.api.medicos.DadosCadastroMedicos;
import med.volli.api.medicos.MedicoRepository;
import med.volli.api.medicos.Medicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void CadastrarMedico(@RequestBody DadosCadastroMedicos dados){
        repository.save(new Medicos(dados));
    }
}
