package sopt.mysoptin.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Retrospect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long retrospectId;

    @Column(nullable = false)
    private String descRoutine;

    @Column(nullable = false)
    private String descBest;

    @Column(nullable = false)
    private String descSelf;

    @Column(nullable = false)
    private boolean isPublic;

    @Column(nullable = false)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private Date writtenDate;

    private Retrospect(String descRoutine, String descBest, String descSelf, boolean isPublic, Date writtenDate) {
        this.descRoutine = descRoutine;
        this.descBest = descBest;
        this.descSelf = descSelf;
        this.isPublic = isPublic;
        this.writtenDate = writtenDate;
    }

    public static Retrospect newInstance(String descRoutine, String descBest, String descSelf, boolean isPublic, Date writtenDate) {
        return new Retrospect(descRoutine, descBest, descSelf, isPublic, writtenDate);
    }
}


