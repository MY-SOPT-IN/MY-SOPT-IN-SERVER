package sopt.mysoptin.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.mysoptin.server.exception.Error;
import sopt.mysoptin.server.exception.model.NotFoundException;
import sopt.mysoptin.server.infrastructure.RoutineRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoutineService {
    private final RoutineRepository routineRepository;

    @Transactional
    public void deleteOne(Long routineId) {
        Long deletedCount = routineRepository.deleteByRoutineId(routineId);
        if (deletedCount == 0) {
            throw new NotFoundException(Error.NOT_FOUND_ROUTINE_EXCEPTION, Error.NOT_FOUND_ROUTINE_EXCEPTION.getMessage());
        }
    }

}
