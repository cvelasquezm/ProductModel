package com.sura.productmodel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingCoverageDTO {

    @JsonProperty
    public String coverageCategory;
    @JsonProperty
    public CoverageDTO[] coverages;

}
