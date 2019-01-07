package com.sura.productmodel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TermsDTO {

    @JsonProperty
    public String patternCode;
    @JsonProperty
    public String chosenTerm;
    @JsonProperty
    public String directValue;
    @JsonProperty
    public boolean required;
    @JsonProperty
    public boolean updated;

}
