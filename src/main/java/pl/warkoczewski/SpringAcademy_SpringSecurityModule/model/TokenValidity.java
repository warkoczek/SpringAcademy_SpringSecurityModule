package pl.warkoczewski.SpringAcademy_SpringSecurityModule.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TokenValidity {
    @JsonProperty("ONE WEEK")ONE_WEEK(604800l),
    @JsonProperty("THREE WEEKS")THREE_WEEKS(1814400L),
    @JsonProperty("FOUR WEEKS")FOUR_WEEKS(2419200L);

    private Long seconds;

    public Long getSeconds() {
        return seconds;
    }

    TokenValidity(Long seconds) {
    }
}
