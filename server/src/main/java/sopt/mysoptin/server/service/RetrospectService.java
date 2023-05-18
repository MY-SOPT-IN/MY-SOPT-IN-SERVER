package sopt.mysoptin.server.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.mysoptin.server.controller.dto.response.RetrospectResponseDto;
import sopt.mysoptin.server.domain.Retrospect;
import sopt.mysoptin.server.exception.Success;
import sopt.mysoptin.server.exception.model.NoContentException;
import sopt.mysoptin.server.infrastructure.RetrospectRepository;

import java.sql.Date;
import java.text.SimpleDateFormat;

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
}
