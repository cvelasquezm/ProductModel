package com.sura.productmodel.controller;

import com.google.gson.JsonElement;
import com.sura.productmodel.dto.RequestDTO;
import com.sura.productmodel.transform.BuilderJSON;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class XmlController {

    @PostMapping(value = "/coverages", produces = MediaType.APPLICATION_JSON_VALUE)
    public String xmlReader(@RequestBody RequestDTO requestDTO){
        BuilderJSON b = new BuilderJSON();
        return b.xmlReader(requestDTO.url, requestDTO.file, requestDTO.onlyRequired).toString();
    }

}
