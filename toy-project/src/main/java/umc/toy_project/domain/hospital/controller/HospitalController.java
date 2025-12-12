package umc.toy_project.domain.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.toy_project.domain.hospital.dto.req.HospitalReqDTO;
import umc.toy_project.domain.hospital.dto.res.HospitalResDTO;
import umc.toy_project.domain.hospital.exception.code.HospitalSuccessCode;
import umc.toy_project.domain.hospital.service.command.HospitalCommandService;
import umc.toy_project.domain.hospital.service.query.HospitalQueryService;
import umc.toy_project.global.apiPayload.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hospitals")
public class HospitalController {

    private final HospitalCommandService hospitalCommandService;
    private final HospitalQueryService hospitalQueryService;

    @PostMapping
    public ApiResponse<HospitalResDTO.HospitalInfoDTO> create(
            @RequestBody @Valid HospitalReqDTO.HospitalInfoDTO dto
    ) {
        return ApiResponse.onSuccess(HospitalSuccessCode.CREATED, hospitalCommandService.create(dto));
    }

    @GetMapping
    public ApiResponse<HospitalResDTO.HospitalInfoListDTO> getAllHospitals(
            @RequestParam(defaultValue = "0") Integer page
    ) {
        return ApiResponse.onSuccess(HospitalSuccessCode.SUCCESS_CODE, hospitalQueryService.getAllHospitals(page));
    }

    @GetMapping("/search")
    public ApiResponse<HospitalResDTO.HospitalInfoListDTO> getHospitalsByAddress(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam String address
    ) {
        return ApiResponse.onSuccess(HospitalSuccessCode.SUCCESS_CODE, hospitalQueryService.getHospitalsByAddress(page, address));
    }

    @PutMapping("/{hospitalId}")
    public ApiResponse<HospitalResDTO.HospitalInfoDTO> update(
            @PathVariable Long hospitalId,
            @RequestBody @Valid HospitalReqDTO.HospitalInfoDTO dto
    ) {
       return ApiResponse.onSuccess(HospitalSuccessCode.SUCCESS_CODE, hospitalCommandService.update(hospitalId, dto));
    }
}
