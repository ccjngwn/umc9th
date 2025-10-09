package com.example.umc9th.domain.users.enums;

public enum FoodName {
    CHICKEN("치킨"),
    PIZZA("피자"),
    HAMBURGER("햄버거"),
    KOREAN_BBQ("한국식 바베큐"),
    RAMEN("라면"),
    SUSHI("초밥"),
    PASTA("파스타"),
    TACO("타코"),
    BIBIMBAP("비빔밥"),
    FRIED_RICE("볶음밥"),
    SALAD("샐러드"),
    SANDWICH("샌드위치");

    private final String koreanName;

    FoodName(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}