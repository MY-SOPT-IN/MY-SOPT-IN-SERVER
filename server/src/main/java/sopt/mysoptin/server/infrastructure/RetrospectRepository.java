package sopt.mysoptin.server.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.mysoptin.server.domain.Retrospect;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface RetrospectRepository extends Repository<Retrospect, Long> {
    // CREATE
    void save(Retrospect user);

    // READ
    Retrospect findByWrittenDate(Date writtenDate);
    Optional<List<Retrospect>> findByWrittenDateBetween(Date fromDate, Date toDate);

    // UPDATE

    // DELETE
}
