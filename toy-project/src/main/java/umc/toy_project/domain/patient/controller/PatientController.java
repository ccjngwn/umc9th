package umc.toy_project.domain.patient.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.toy_project.domain.patient.dto.req.PatientReqDTO;
import umc.toy_project.domain.patient.dto.res.PatientResDTO;
import umc.toy_project.domain.patient.exception.code.PatientSuccessCode;
import umc.toy_project.domain.patient.service.command.PatientCommandService;
import umc.toy_project.global.apiPayload.ApiResponse;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientCommandService patientCommandService;

    // 회원가입
    @PostMapping
    public ApiResponse<PatientResDTO.JoinDTO> join(@RequestBody @Valid PatientReqDTO.JoinDTO dto) {
        return ApiResponse.onSuccess(PatientSuccessCode.CREATED, patientCommandService.join(dto));
    }
}
