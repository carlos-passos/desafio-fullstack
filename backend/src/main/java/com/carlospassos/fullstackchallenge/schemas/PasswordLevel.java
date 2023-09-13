package com.carlospassos.fullstackchallenge.schemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public enum PasswordLevel {

    RUIM(1, "#de0000", 35),
    MEDIANA(2, "#e9bc00", 59),
    BOM(3, "#00e901", 71),
    FORTE(4, "#007a01", 85);

    private int level;
    private String hexColor;

    private int minimumPercentage;

    PasswordLevel(int level, String hexColor, int minimumPercentage) {
        this.level = level;
        this.hexColor = hexColor;
        this.minimumPercentage = minimumPercentage;
    }

}
