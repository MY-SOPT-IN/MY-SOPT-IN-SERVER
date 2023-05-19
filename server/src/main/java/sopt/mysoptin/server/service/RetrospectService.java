package sopt.mysoptin.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.mysoptin.server.controller.dto.response.RetrospectResponseDto;
import sopt.mysoptin.server.domain.Retrospect;
import sopt.mysoptin.server.exception.Error;
import sopt.mysoptin.server.exception.model.NotFoundException;
import sopt.mysoptin.server.infrastructure.RetrospectRepository;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RetrospectService {
    private final RetrospectRepository retrospectRepository;

    @Transactional
    public RetrospectResponseDto getOne(String date) {
        Date convertedDate = Date.valueOf(date);
        Retrospect retrospect = retrospectRepository.findByWrittenDate(convertedDate);
        if (retrospect == null) return null;
        return RetrospectResponseDto.of(retrospect.getRetrospectId(), retrospect.getDescRoutine(), retrospect.getDescBest(), retrospect.getDescSelf(), retrospect.isPublic(), retrospect.getWrittenDate().toString());
    }

    @Transactional
    public List<RetrospectResponseDto> getMonthList(int month) {
        Date firstDate = Date.valueOf(LocalDate.of(LocalDate.now().getYear(), month, 1).toString());
        int lastDay = LocalDate.of(LocalDate.now().getYear(), month, 1).lengthOfMonth();
        Date lastDate = Date.valueOf(LocalDate.of(LocalDate.now().getYear(), month, lastDay).toString());

        List<Retrospect> retrospectList = retrospectRepository.findByWrittenDateBetween(firstDate, lastDate)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_RETROSPECT_EXCEPTION, Error.NOT_FOUND_RETROSPECT_EXCEPTION.getMessage()));

        return retrospectList.stream()
                .map(retrospect -> RetrospectResponseDto.of(
                        retrospect.getRetrospectId(),
                        retrospect.getDescRoutine(),
                        retrospect.getDescBest(),
                        retrospect.getDescSelf(),
                        retrospect.isPublic(),
                        retrospect.getWrittenDate().toString()
                ))
                .collect(Collectors.toList());
    }
}
