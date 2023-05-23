package sopt.mysoptin.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.mysoptin.server.controller.dto.response.RoutineResponseDto;
import sopt.mysoptin.server.domain.Repeats;
import sopt.mysoptin.server.domain.Routine;
import sopt.mysoptin.server.infrastructure.RepeatsRepository;
import sopt.mysoptin.server.infrastructure.RoutineRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoutineService {
    private final RepeatsRepository repeatsRepository;
    private final RoutineRepository routineRepository;
//    private final RoutineRepository routineRepository;
//    private final RepeatsRepository repeatsRepository;

    @Transactional
    public List<RoutineResponseDto> getAllRoutineOf(String targetDate) {

        LocalDate dateValue = LocalDate.parse(targetDate);
        DayOfWeek dayOfWeek = dateValue.getDayOfWeek();
        log.info("dayOfWeek : {}", dayOfWeek);
        log.info("dayOfWeek-Integer : {}",  dayOfWeek.getValue());

        List<Repeats> repeats = repeatsRepository.findRepeatsByDayOfRoutine(dayOfWeek.getValue());
        // forEach 로 변환해서 삽입하기
        List<Routine> routines = new ArrayList<>();
        List<RoutineResponseDto> result = new ArrayList<>();
        repeats.forEach(repeat -> routines.add(
                routineRepository.findById(repeat.getRoutine().getRoutineId()).get()
        ));
        for (Routine routine : routines) {
            result.add(
                    RoutineResponseDto.of(
                            routine.getRoutineId()
                            , routine.getRoutineName()
                            , routine.getRoutineAt()
                    )
            );
        }
        return result;
    }

    @Transactional
    public boolean deleteOne(Long routineId) {
        repeatsRepository.deleteAllByRoutineRoutineId(routineId);
        Long cnt = routineRepository.deleteByRoutineId(routineId);
        if (cnt == 0) return false;
        else return true;
    }
}
