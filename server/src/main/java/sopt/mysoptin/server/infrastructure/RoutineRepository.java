package sopt.mysoptin.server.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.mysoptin.server.domain.Routine;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    // CREATE

    // READ
    Routine readByRoutineId(Long routineId);

    // UPDATE

    // DELETE
    Long deleteByRoutineId(Long routineId);
}
