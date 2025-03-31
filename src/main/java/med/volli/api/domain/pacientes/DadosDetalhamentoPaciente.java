package med.volli.api.domain.pacientes;

import med.volli.api.domain.enderecos.Enderecos;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String telefone, String cpf, Enderecos endereco) {

    public DadosDetalhamentoPaciente(Pacientes paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
