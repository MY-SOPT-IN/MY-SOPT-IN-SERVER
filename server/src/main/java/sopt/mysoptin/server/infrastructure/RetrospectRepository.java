package sopt.mysoptin.server.infrastructure;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import sopt.mysoptin.server.domain.Retrospect;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface RetrospectRepository extends Repository<Retrospect, Long> {
    // CREATE
    Retrospect save(Retrospect retrospect);

    // READ
    Retrospect findByWrittenDate(Date writtenDate);

    Retrospect findByRetrospectId(Long retrospectId);
    Optional<List<Retrospect>> findByWrittenDateBetween(Date fromDate, Date toDate);

    // UPDATE
    @Modifying
    @Query("update Retrospect r set r.descRoutine = :descRoutine where  r.retrospectId = :retroId")
    void updateDescRoutine(@Param("retroId") Long retroId, @Param("descRoutine") String descRoutine);

    @Modifying
    @Query("update Retrospect r set r.descBest = :descBest where  r.retrospectId = :retroId")
    void updateDescBest(@Param("retroId") Long retroId, @Param("descBest") String descBest);

    @Modifying
    @Query("update Retrospect r set r.descSelf = :descSelf where  r.retrospectId = :retroId")
    void updateDescSelf(@Param("retroId") Long retroId, @Param("descSelf") String descSelf);

    @Modifying
    @Query("update Retrospect r set r.isPublic = :isPublic where  r.retrospectId = :retroId")
    void updateIsPublic(@Param("retroId") Long retroId, @Param("isPublic") boolean isPublic);

    // DELETE
}
