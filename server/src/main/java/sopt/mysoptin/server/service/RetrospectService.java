package sopt.mysoptin.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sopt.mysoptin.server.controller.dto.request.RetrospectRequestCreateDto;
import sopt.mysoptin.server.controller.dto.request.RetrospectRequestUpdateDto;
import sopt.mysoptin.server.controller.dto.response.RetrospectResponseDto;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.mysoptin.server.domain.Retrospect;
import sopt.mysoptin.server.exception.Error;
import sopt.mysoptin.server.exception.model.NotFoundException;
import sopt.mysoptin.server.infrastructure.RetrospectRepository;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;

@Service
@RequiredArgsConstructor
@Slf4j
public class RetrospectService {
    private final RetrospectRepository retrospectRepository;

    @Transactional
    public RetrospectResponseDto createRetrospect(RetrospectRequestCreateDto createDto){
        log.info(Boolean.toString(createDto.isPublic()));
        Retrospect createdRetrospect = retrospectRepository.save(Retrospect.newInstance(
                createDto.getDescRoutine(),
                createDto.getDescBest(),
                createDto.getDescSelf(),
                createDto.isPublic(),
                Date.valueOf(createDto.getWrittenDate())
        ));
        log.info(Boolean.toString(createDto.isPublic()));
        return RetrospectResponseDto.of(
                createdRetrospect.getRetrospectId(),
                createdRetrospect.getDescRoutine(),
                createdRetrospect.getDescBest(),
                createdRetrospect.getDescSelf(),
                createdRetrospect.isPublic(),
                createdRetrospect.getWrittenDate().toString()
        );
    }

    @Transactional
    public RetrospectResponseDto updateRetrospect(Long targetId, RetrospectRequestUpdateDto updateDto){
        retrospectRepository.updateDescRoutine(targetId, updateDto.getDescRoutine());
        retrospectRepository.updateDescBest(targetId, updateDto.getDescBest());
        retrospectRepository.updateDescSelf(targetId, updateDto.getDescSelf());
        retrospectRepository.updateIsPublic(targetId, updateDto.isPublic());

        Retrospect updatedRetrospect = retrospectRepository.findByRetrospectId(targetId);
        return RetrospectResponseDto.of(
                updatedRetrospect.getRetrospectId(),
                updatedRetrospect.getDescRoutine(),
                updatedRetrospect.getDescBest(),
                updatedRetrospect.getDescSelf(),
                updatedRetrospect.isPublic(),
                updatedRetrospect.getWrittenDate().toString()
        );
    }

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
        Sort sort = sortByWrittenDate();
        List<Retrospect> retrospectList = retrospectRepository.findByWrittenDateBetweenOrderByWrittenDateDesc(firstDate, lastDate, sort)
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

    private Sort sortByWrittenDate() {
        return Sort.by(Sort.Direction.DESC, "writtenDate");
    }
}
