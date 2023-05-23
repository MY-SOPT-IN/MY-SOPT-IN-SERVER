package sopt.mysoptin.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routineId;

    @Column(nullable = false)
    private String routineName;

    @Column(nullable = false)
    private String routineAt;

    public Routine(String routineName, String routineAt) {
        this.routineName = routineName;
        this.routineAt = routineAt;
    }

    public static Routine newInstance(String routineName, String routineAt) {
        return new Routine(routineName, routineAt);
    }
}
