package med.volli.api.domain.medicos;

import med.volli.api.domain.enderecos.DadosCadastroEnderecos;

public record DadosAtualizaMedicos(Long id, String nome, String telefone, DadosCadastroEnderecos endereco) {
}
