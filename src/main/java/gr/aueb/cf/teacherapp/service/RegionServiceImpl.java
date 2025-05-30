package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.model.static_data.RegionEntity;
import gr.aueb.cf.teacherapp.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements IRegionService{
    private final RegionRepository regionRepository;

    @Override
    public List<RegionEntity> findAllRegions() {
        return regionRepository.findAll();
    }
}
