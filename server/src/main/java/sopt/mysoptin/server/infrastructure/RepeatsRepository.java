package sopt.mysoptin.server.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.mysoptin.server.domain.Repeats;

import java.util.List;

public interface RepeatsRepository extends JpaRepository<Repeats, Long> {
    // CREATE

    // READ
    List<Repeats> findRepeatsByDayOfRoutine(int dayValue);
    // UPDATE

    // DELETE
    Long deleteAllByRoutineRoutineId(Long routineId);
}
