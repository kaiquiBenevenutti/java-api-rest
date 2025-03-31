package med.volli.api.domain.medicos;

public record DadosListagemMedicos(Long id, String nome, String email, String crm, Especialidades especialidade) {
    public DadosListagemMedicos(Medicos medicos){
        this(medicos.getId(), medicos.getNome(), medicos.getEmail(), medicos.getCrm(), medicos.getEspecialidade());
    }
}
