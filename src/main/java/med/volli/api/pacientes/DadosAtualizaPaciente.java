package med.volli.api.pacientes;

import med.volli.api.enderecos.DadosCadastroEnderecos;

public record DadosAtualizaPaciente(Long id, String nome, String telefone, DadosCadastroEnderecos endereco) {
}
