package sopt.mysoptin.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Repeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repeatsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Routine routine;

    @Column(nullable = false)
    private String day;

    public Repeats(Routine routine, String day) {
        this.routine = routine;
        this.day = day;
    }

    public static Repeats newInstance(Routine routine, String day) {
        return new Repeats(routine, day);
    }
}
