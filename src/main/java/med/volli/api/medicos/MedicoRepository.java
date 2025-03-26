package med.volli.api.medicos;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medicos, Long> {
    Page<Medicos> findAllByAtivoTrue(Pageable pageable);
}
