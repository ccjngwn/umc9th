package com.example.umc9th.domain.users.enums;

import lombok.Getter;

@Getter
public enum Address {
    // 강남구
    YEOKSAM_DONG("역삼동"),
    SAMSUNG_DONG("삼성동"),
    DAECHI_DONG("대치동"),
    SINSA_DONG("신사동"),
    NONHYEON_DONG("논현동"),
    APGUJEONG_DONG("압구정동"),
    CHEONGDAM_DONG("청담동"),
    GAEPO_DONG("개포동"),

    // 강서구
    HWAGOK_DONG("화곡동"),
    DEUNGCHON_DONG("등촌동"),
    YEOMCHANG_DONG("염창동"),
    BALSAN_DONG("발산동"),
    UJANGSAN_DONG("우장산동"),
    GAYANG_DONG("가양동"),
    MAGOK_DONG("마곡동"),

    // 관악구
    BONGCHEON_DONG("봉천동"),
    SILLIM_DONG("신림동"),
    NAMHYEON_DONG("남현동"),
    SEOWON_DONG("서원동"),

    // 광진구
    HWAYANG_DONG("화양동"),
    GUNJA_DONG("군자동"),
    JUNGGOK_DONG("중곡동"),
    GUUI_DONG("구의동"),
    GWANGJANG_DONG("광장동"),

    // 구로구
    SINDORIM_DONG("신도림동"),
    GURO_DONG("구로동"),
    GARIBONG_DONG("가리봉동"),
    DOKSAN_DONG("독산동"),
    ORYU_DONG("오류동"),
    CHEONWANG_DONG("천왕동"),

    // 금천구
    GASAN_DONG("가산동"),
    GEUMCHEON_DOKSAN_DONG("독산동"),
    SIHEUNG_DONG("시흥동"),

    // 노원구
    SANGGYE_DONG("상계동"),
    JUNGGYE_DONG("중계동"),
    HAGYE_DONG("하계동"),
    GONGNEUNG_DONG("공릉동"),
    WOLGYE_DONG("월계동"),

    // 도봉구
    SSANGMUN_DONG("쌍문동"),
    BANGHAK_DONG("방학동"),
    CHANG_DONG("창동"),
    DOBONG_DONG("도봉동"),

    // 동대문구
    SINSEOL_DONG("신설동"),
    YONGDU_DONG("용두동"),
    JEGI_DONG("제기동"),
    JEONNONG_DONG("전농동"),
    DAPSIMNI_DONG("답십리동"),
    JANGAN_DONG("장안동"),
    CHEONGNYANGNI_DONG("청량리동"),
    HOEGI_DONG("회기동"),
    HWIGYEONG_DONG("휘경동"),

    // 동작구
    NORYANGJIN_DONG("노량진동"),
    SANGDO_DONG("상도동"),
    HEUKSEOK_DONG("흑석동"),
    DONGJAK_DONG("동작동"),
    SADANG_DONG("사당동"),
    DAEBANG_DONG("대방동"),
    SINDAEBANG_DONG("신대방동"),

    // 마포구
    GONGDEOK_DONG("공덕동"),
    AHYEON_DONG("아현동"),
    YONGGANG_DONG("용강동"),
    DAEHEUNG_DONG("대흥동"),
    YEOMNI_DONG("염리동"),
    SINSU_DONG("신수동"),
    SEOGANG_DONG("서강동"),
    SEOGYO_DONG("서교동"),
    HAPJEONG_DONG("합정동"),
    MANGWON_DONG("망원동"),
    YEONNAM_DONG("연남동"),
    SEONGSAN_DONG("성산동"),
    SANGAM_DONG("상암동"),

    // 서대문구
    CHUNGJEONGNO_DONG("충정로동"),
    MIGEUN_DONG("미근동"),
    CHEONYEON_DONG("천연동"),
    SINCHON_DONG("신촌동"),
    YEONHUI_DONG("연희동"),
    HONGJE_DONG("홍제동"),
    HONGEUN_DONG("홍은동"),
    NAMGAJWA_DONG("남가좌동"),
    BUKGAJWA_DONG("북가좌동"),

    // 서초구
    SEOCHO_DONG("서초동"),
    JAMWON_DONG("잠원동"),
    BANPO_DONG("반포동"),
    BANGBAE_DONG("방배동"),
    YANGJAE_DONG("양재동"),
    NAEGOK_DONG("내곡동"),

    // 성동구
    WANGSIMNI_DONG("왕십리동"),
    MAJANG_DONG("마장동"),
    SAGEUN_DONG("사근동"),
    HAENGDANG_DONG("행당동"),
    EUNGBONG_DONG("응봉동"),
    GEUMNAM_DONG("금남동"),
    OKSU_DONG("옥수동"),
    SEONGSU_DONG("성수동"),

    // 성북구
    SEONGBUK_DONG("성북동"),
    SAMSEON_DONG("삼선동"),
    DONGSEON_DONG("동선동"),
    DONAM_DONG("돈암동"),
    ANAM_DONG("안암동"),
    BOMUN_DONG("보문동"),
    JEONGNEUNG_DONG("정릉동"),
    GIREUM_DONG("길음동"),
    JONGAM_DONG("종암동"),
    SEOKGWAN_DONG("석관동"),

    // 송파구
    PUNGNAP_DONG("풍납동"),
    GEOYEO_DONG("거여동"),
    MACHEON_DONG("마천동"),
    BANGI_DONG("방이동"),
    OGEUM_DONG("오금동"),
    SONGPA_DONG("송파동"),
    SEOKCHON_DONG("석촌동"),
    SAMJEON_DONG("삼전동"),
    GARAK_DONG("가락동"),
    MUNJEONG_DONG("문정동"),
    JANGJI_DONG("장지동"),

    // 양천구
    MOK_DONG("목동"),
    SINJEONG_DONG("신정동"),

    // 영등포구
    YEONGDEUNGPO_DONG("영등포동"),
    YEOUIDO_DONG("여의도동"),
    DANGSAN_DONG("당산동"),
    DORIM_DONG("도림동"),
    MULLAE_DONG("문래동"),
    YANGPYEONG_DONG("양평동"),
    SINGIL_DONG("신길동"),
    DAERIM_DONG("대림동"),

    // 용산구
    HUAM_DONG("후암동"),
    YONGSAN_DONG("용산동"),
    NAMYEONG_DONG("남영동"),
    CHEONGPA_DONG("청파동"),
    WONHYORO_DONG("원효로동"),
    HYOCHANG_DONG("효창동"),
    YONGMUN_DONG("용문동"),
    HANNAM_DONG("한남동"),
    ICHON_DONG("이촌동"),
    ITAEWON_DONG("이태원동"),
    HANGANGRO_DONG("한강로동"),

    // 은평구
    EUNPYEONG_DONG("은평동"),
    NOKBEON_DONG("녹번동"),
    BULGWANG_DONG("불광동"),
    GALHYEON_DONG("갈현동"),
    GUSAN_DONG("구산동"),
    DAEJO_DONG("대조동"),
    EUNPYEONG_SINSA_DONG("신사동"),
    JEUNGSAN_DONG("증산동"),
    SUSAEK_DONG("수색동"),
    EUNPYEONG_UJANGSAN_DONG("우장산동"),

    // 종로구
    CHEONGUN_DONG("청운동"),
    HYOJA_DONG("효자동"),
    SAJIK_DONG("사직동"),
    SAMCHEONG_DONG("삼청동"),
    BUAM_DONG("부암동"),
    PYEONGCHANG_DONG("평창동"),
    MUAK_DONG("무악동"),
    GYONAM_DONG("교남동"),
    GAHOE_DONG("가회동"),
    JONGNO1GA_DONG("종로1가동"),
    JONGNO2GA_DONG("종로2가동"),
    JONGNO3GA_DONG("종로3가동"),
    JONGNO4GA_DONG("종로4가동"),
    JONGNO5GA_DONG("종로5가동"),
    JONGNO6GA_DONG("종로6가동"),
    IHWA_DONG("이화동"),
    HYEHWA_DONG("혜화동"),
    MYEONGNYUN3GA_DONG("명륜3가동"),
    CHANGSIN_DONG("창신동"),
    SUNGIN_DONG("숭인동"),

    // 중구
    SOGONG_DONG("소공동"),
    HOEHYEON_DONG("회현동"),
    MYEONG_DONG("명동"),
    PIL_DONG("필동"),
    JANGCHUNG_DONG("장충동"),
    GWANGHUI_DONG("광희동"),
    EULJIRO_DONG("을지로동"),
    SINDANG_DONG("신당동"),
    DASAN_DONG("다산동"),
    YAKSU_DONG("약수동"),
    CHEONGGU_DONG("청구동"),
    SINDANG5_DONG("신당5동"),
    DONGHWA_DONG("동화동"),
    HWANGHAK_DONG("황학동"),
    JUNGNIM_DONG("중림동"),

    // 중랑구
    MYEONMOK_DONG("면목동"),
    SANGBONG_DONG("상봉동"),
    JUNGHWA_DONG("중화동"),
    MUK_DONG("묵동"),
    MANGWOO_DONG("망우동"),
    SINNAE_DONG("신내동");

    private final String koreanName;

    Address(String koreanName) {
        this.koreanName = koreanName;
    }

}
