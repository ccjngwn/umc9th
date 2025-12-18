package umc.toy_project.domain.hospital.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DepartmentName {
    INTERNAL_MEDICINE("내과"),
    SURGERY("외과"),
    PEDIATRICS("소아청소년과"),
    OBSTETRICS_GYNECOLOGY("산부인과"),
    ORTHOPEDICS("정형외과"),
    DERMATOLOGY("피부과"),
    OPHTHALMOLOGY("안과"),
    OTOLARYNGOLOGY("이비인후과"),
    PSYCHIATRY("정신건강의학과"),
    NEUROLOGY("신경과"),
    NEUROSURGERY("신경외과"),
    UROLOGY("비뇨기과"),
    CARDIOLOGY("심장내과"),
    RADIOLOGY("영상의학과"),
    ANESTHESIOLOGY("마취통증의학과"),
    REHABILITATION("재활의학과"),
    FAMILY_MEDICINE("가정의학과"),
    EMERGENCY_MEDICINE("응급의학과"),
    DENTISTRY("치과");

    private final String description;
}
