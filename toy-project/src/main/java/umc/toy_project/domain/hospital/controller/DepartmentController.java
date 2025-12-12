package umc.toy_project.domain.hospital.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.toy_project.domain.hospital.dto.req.DepartmentReqDTO;
import umc.toy_project.domain.hospital.dto.res.DepartmentResDTO;
import umc.toy_project.domain.hospital.exception.code.DepartmentSuccessCode;
import umc.toy_project.domain.hospital.service.command.DepartmentCommandService;
import umc.toy_project.domain.hospital.service.query.DepartmentQueryService;
import umc.toy_project.global.apiPayload.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentCommandService departmentCommandService;
    private final DepartmentQueryService departmentQueryService;

    @PostMapping
    public ApiResponse<DepartmentResDTO.DepartmentInfoDTO> create(
            @RequestBody @Valid DepartmentReqDTO.DepartmentInfoDTO dto
    ) {
        return ApiResponse.onSuccess(DepartmentSuccessCode.CREATED, departmentCommandService.create(dto));
    }

    @GetMapping
    public ApiResponse<DepartmentResDTO.DepartmentInfoListDTO> getAllDepartments(
            @RequestParam(defaultValue = "0") Integer page
    ) {
        return ApiResponse.onSuccess(DepartmentSuccessCode.SUCCESS_CODE, departmentQueryService.getAllDepartments(page));
    }

    @DeleteMapping("/{departmentId}")
    public ApiResponse<Void> delete(
            @PathVariable Long departmentId
    ) {
        departmentCommandService.delete(departmentId);
        return ApiResponse.onSuccess(DepartmentSuccessCode.NO_CONTENT, null);
    }
}
