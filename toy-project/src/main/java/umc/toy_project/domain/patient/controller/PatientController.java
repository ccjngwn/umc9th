package umc.toy_project.domain.patient.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.toy_project.domain.patient.dto.req.PatientReqDTO;
import umc.toy_project.domain.patient.dto.res.PatientResDTO;
import umc.toy_project.domain.patient.exception.code.PatientSuccessCode;
import umc.toy_project.domain.patient.service.command.PatientCommandService;
import umc.toy_project.domain.patient.service.query.PatientQueryService;
import umc.toy_project.global.apiPayload.ApiResponse;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientCommandService patientCommandService;
    private final PatientQueryService patientQueryService;

    // 환자 등록
    @PostMapping
    public ApiResponse<PatientResDTO.JoinDTO> join(@RequestBody @Valid PatientReqDTO.JoinDTO dto) {
        return ApiResponse.onSuccess(PatientSuccessCode.CREATED, patientCommandService.join(dto));
    }

    // 환자 조회
    @GetMapping("/{patientId}")
    public ApiResponse<PatientResDTO.PatientInfoDTO> findPatient(@PathVariable Long patientId) {
        return ApiResponse.onSuccess(PatientSuccessCode.SUCCESS_CODE, patientQueryService.getPatientInfo(patientId));
    }

    // 환자 정보 수정
    @PutMapping("/{patientId}")
    public ApiResponse<PatientResDTO.JoinDTO> update(@PathVariable Long patientId, @RequestBody @Valid PatientReqDTO.JoinDTO dto) {
        return ApiResponse.onSuccess(PatientSuccessCode.SUCCESS_CODE, patientCommandService.update(patientId, dto));
    }

    // 환자 삭제
    @DeleteMapping("/{patientId}")
    public ApiResponse<Void> deletePatient(@PathVariable Long patientId) {
        patientCommandService.delete(patientId);
        return ApiResponse.onSuccess(PatientSuccessCode.NO_CONTENT, null);
    }
}
