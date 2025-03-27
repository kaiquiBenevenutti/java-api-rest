package med.volli.api.pacientes;

import med.volli.api.enderecos.Enderecos;
import med.volli.api.medicos.Medicos;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String telefone, String cpf, Enderecos endereco) {

    public DadosDetalhamentoPaciente(Pacientes paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
