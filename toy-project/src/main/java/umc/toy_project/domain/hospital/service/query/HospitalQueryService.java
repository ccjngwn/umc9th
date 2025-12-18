package umc.toy_project.domain.hospital.service.query;

import umc.toy_project.domain.hospital.dto.res.HospitalResDTO;

public interface HospitalQueryService {
    HospitalResDTO.HospitalInfoListDTO getHospitalsByAddress(Integer page, String address);

    HospitalResDTO.HospitalInfoListDTO getAllHospitals(Integer page);
}
