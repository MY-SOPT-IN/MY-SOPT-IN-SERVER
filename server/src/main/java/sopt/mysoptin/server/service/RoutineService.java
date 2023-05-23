package sopt.mysoptin.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.mysoptin.server.domain.Routine;
import sopt.mysoptin.server.exception.Error;
import sopt.mysoptin.server.exception.model.NotFoundException;
import sopt.mysoptin.server.infrastructure.RepeatsRepository;
import sopt.mysoptin.server.infrastructure.RoutineRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoutineService {
    private final RoutineRepository routineRepository;
    private final RepeatsRepository repeatsRepository;

    @Transactional
    public boolean deleteOne(Long routineId) {
        repeatsRepository.deleteAllByRoutineRoutineId(routineId);
        Long cnt = routineRepository.deleteByRoutineId(routineId);
        if (cnt == 0) return false;
        else return true;
    }
}
