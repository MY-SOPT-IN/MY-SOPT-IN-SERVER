package sopt.mysoptin.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "REPEATS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Repeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repeatsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id",nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Routine routine;

    // TODO : String day; 관련 로직 해결 필요
    @Column(nullable = false)
//    private String dayOfRoutine;
    private Integer dayOfRoutine;

    public Repeats(Routine routine, Integer day) {
        this.routine = routine;
        this.dayOfRoutine = day;
    }

    public static Repeats newInstance(Routine routine, Integer day) {
        return new Repeats(routine, day);
    }
}
