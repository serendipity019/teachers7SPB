package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.core.exceptions.EntityAlreadyExistException;
import gr.aueb.cf.teacherapp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacherapp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherapp.model.TeacherEntity;
import org.springframework.data.domain.Page;


public interface ITeacherService {
    TeacherEntity saveTeacher(TeacherInsertDTO dto)
        throws EntityAlreadyExistException, EntityInvalidArgumentException;

    Page<TeacherReadOnlyDTO> getPaginatedTeachers(int page, int size);
}
