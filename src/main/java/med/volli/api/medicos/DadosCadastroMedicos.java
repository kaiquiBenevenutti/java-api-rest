package med.volli.api.medicos;

import med.volli.api.enderecos.DadosCadastroEnderecos;

public record DadosCadastroMedicos(String nome, String Email, String crm, Especialidades especialidade, DadosCadastroEnderecos endereco) {
}
