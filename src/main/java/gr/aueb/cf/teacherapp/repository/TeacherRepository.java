package gr.aueb.cf.teacherapp.repository;

import gr.aueb.cf.teacherapp.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>,
        JpaSpecificationExecutor<TeacherEntity> {
    List<TeacherEntity> findByRegionId(Long id);
    Optional<TeacherEntity> findByUuid(String uuid);
    Optional<TeacherEntity> findByVat(String vat);
}
