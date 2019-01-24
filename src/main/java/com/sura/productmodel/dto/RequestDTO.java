package com.sura.productmodel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDTO {

    @JsonProperty
    public String url;
    @JsonProperty
    public String file;
    @JsonProperty
    public boolean onlyRequired;
}
