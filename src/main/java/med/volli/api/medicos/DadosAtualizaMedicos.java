package med.volli.api.medicos;

import med.volli.api.enderecos.DadosCadastroEnderecos;
import med.volli.api.enderecos.Enderecos;

public record DadosAtualizaMedicos(Long id, String nome, String telefone, DadosCadastroEnderecos endereco) {
}
