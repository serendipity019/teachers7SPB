package gr.aueb.cf.teacherapp.model;

import gr.aueb.cf.teacherapp.model.static_data.RegionEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "teachers")
public class TeacherEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(unique = true, nullable = false)
    private String vat;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private RegionEntity region;

    public void initializeUUID() {
        if (uuid == null) uuid = UUID.randomUUID().toString();
    }
}
