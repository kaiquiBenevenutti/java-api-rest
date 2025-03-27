package med.volli.api.medicos;

import med.volli.api.enderecos.Enderecos;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidades especialidade, Enderecos endereco) {

    public DadosDetalhamentoMedico(Medicos medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }

}
