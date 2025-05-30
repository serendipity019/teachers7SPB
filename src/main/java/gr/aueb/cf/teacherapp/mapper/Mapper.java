package gr.aueb.cf.teacherapp.mapper;

import gr.aueb.cf.teacherapp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherapp.model.TeacherEntity;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    // Here we get the data that the user typed in form
    public TeacherEntity mapToTeacherEntity(TeacherInsertDTO teacherInsertDTO) {
        TeacherEntity teacher = new TeacherEntity();
        teacher.setFirstname(teacherInsertDTO.firstname());
        teacher.setLastname(teacherInsertDTO.lastname());
        teacher.setVat(teacherInsertDTO.vat());
        return teacher;
    }

    // Here we send all the data there where need.
    public TeacherReadOnlyDTO mapToTeacherReadOnlyDTO(TeacherEntity teacher) {
        return new TeacherReadOnlyDTO(teacher.getId(), teacher.getCreatedAt(),
                teacher.getUpdatedAt(), teacher.getUuid(), teacher.getFirstname(),
                teacher.getLastname(), teacher.getVat(), teacher.getRegion().getName());
    }
}
