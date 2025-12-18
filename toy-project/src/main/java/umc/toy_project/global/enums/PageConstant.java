package umc.toy_project.global.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PageConstant {
    DEFAULT_LIMIT(10),
    ;

    private final int limit;
}
