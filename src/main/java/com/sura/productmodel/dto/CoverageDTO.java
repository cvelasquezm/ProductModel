package com.sura.productmodel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoverageDTO {
    @JsonProperty
    public boolean updated = true;
    @JsonProperty
    public boolean selected = true;
    @JsonProperty
    public String publicID;
    @JsonProperty
    public TermsDTO[] terms;

}
