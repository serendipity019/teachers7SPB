package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.core.exceptions.EntityAlreadyExistException;
import gr.aueb.cf.teacherapp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacherapp.dto.TeacherInsertDTO;
import gr.aueb.cf.teacherapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherapp.mapper.Mapper;
import gr.aueb.cf.teacherapp.model.TeacherEntity;
import gr.aueb.cf.teacherapp.model.static_data.RegionEntity;
import gr.aueb.cf.teacherapp.repository.RegionRepository;
import gr.aueb.cf.teacherapp.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //This is from lombok. When we have this then not need @Autowired constructor below.
public class TeacherServiceImpl implements ITeacherService {
    private final TeacherRepository teacherRepository;
    private final RegionRepository regionRepository;
    private final Mapper mapper;

//    @Autowired // This is from Spring. Without this need to make new TeacherRepository e.t.c
//    public TeacherServiceImpl(TeacherRepository teacherRepository, RegionRepository regionRepository, Mapper mapper) {
//        this.teacherRepository = teacherRepository;
//        this.regionRepository = regionRepository;
//        this.mapper = mapper;
//    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public TeacherEntity saveTeacher(TeacherInsertDTO dto)
            throws EntityAlreadyExistException, EntityInvalidArgumentException {
        // We can check this and inside the controller but and here is good
        if (teacherRepository.findByVat(dto.vat()).isPresent()) {
            throw new EntityAlreadyExistException("Teacher", "Teacher with vat " + dto.vat() + " already exists");
        }

        TeacherEntity teacher = mapper.mapToTeacherEntity(dto);

        RegionEntity region = regionRepository.findById(dto.regionId())
                .orElseThrow(() -> new EntityInvalidArgumentException("Region", "Invalid region id"));

        region.addTeacher(teacher);

        return teacherRepository.save(teacher);
    }

    @Override
    public Page<TeacherReadOnlyDTO> getPaginatedTeachers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size); // need this to can page
        Page<TeacherEntity> teacherEntityPage = teacherRepository.findAll(pageable);
        return teacherEntityPage.map(mapper::mapToTeacherReadOnlyDTO);
    }
}
