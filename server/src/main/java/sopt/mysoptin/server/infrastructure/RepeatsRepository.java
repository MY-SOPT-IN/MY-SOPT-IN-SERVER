package sopt.mysoptin.server.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import sopt.mysoptin.server.domain.Repeats;
import sopt.mysoptin.server.domain.Routine;

public interface RepeatsRepository extends JpaRepository<Repeats, Long> {
    // CREATE

    // READ

    // UPDATE

    // DELETE
    Long deleteAllByRoutineRoutineId(Long routineId);
}
