package gr.aueb.cf.teacherapp.model.static_data;

import gr.aueb.cf.teacherapp.model.TeacherEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = " regions")
public class RegionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Getter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "region")
    private Set<TeacherEntity> teachers = new HashSet<>();

    public Set<TeacherEntity> getAllTeachers() {
        if (teachers == null) teachers = new HashSet<>();
        return Collections.unmodifiableSet(teachers);
    }

    public void addTeacher(TeacherEntity teacher) {
        if (teachers == null) teachers = new HashSet<>();
        teachers.add(teacher);
        teacher.setRegion(this);
    }
}
