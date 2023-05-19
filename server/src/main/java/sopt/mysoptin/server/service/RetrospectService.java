package sopt.mysoptin.server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.mysoptin.server.controller.dto.request.RetrospectRequestCreateDto;
import sopt.mysoptin.server.controller.dto.request.RetrospectRequestUpdateDto;
import sopt.mysoptin.server.controller.dto.response.RetrospectResponseDto;
import sopt.mysoptin.server.domain.Retrospect;
import sopt.mysoptin.server.infrastructure.RetrospectRepository;

import java.sql.Date;


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


}
