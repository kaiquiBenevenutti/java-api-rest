package med.volli.api.medicos;

import med.volli.api.enderecos.Enderecos;

public record DadosCadastroMedicos(String nome, String Email, String crm, Especialidades especialidade, Enderecos endereco) {
}
