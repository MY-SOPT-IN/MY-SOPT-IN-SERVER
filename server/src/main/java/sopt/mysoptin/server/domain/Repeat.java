package sopt.mysoptin.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Repeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repeatId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Routine routine;

    @Column(nullable = false)
    private String day;

    public Repeat(Routine routine, String day) {
        this.routine = routine;
        this.day = day;
    }

    public static Repeat newInstance(Routine routine, String day) {
        return new Repeat(routine, day);
    }
}
