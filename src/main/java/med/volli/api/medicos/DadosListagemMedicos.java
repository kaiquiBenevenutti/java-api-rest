package med.volli.api.medicos;

public record DadosListagemMedicos(String nome, String email, String crm, Especialidades especialidade) {
    public DadosListagemMedicos(Medicos medicos){
        this(medicos.getNome(), medicos.getEmail(), medicos.getCrm(), medicos.getEspecialidade());
    }
}
