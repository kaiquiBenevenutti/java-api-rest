package med.volli.api.domain.pacientes;

import med.volli.api.domain.enderecos.DadosCadastroEnderecos;

public record DadosAtualizaPaciente(Long id, String nome, String telefone, DadosCadastroEnderecos endereco) {
}
