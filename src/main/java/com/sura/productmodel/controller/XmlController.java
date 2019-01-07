package com.sura.productmodel.controller;

import com.google.gson.JsonElement;
import com.sura.productmodel.transform.BuilderJSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class XmlController {

    @RequestMapping(value = "/transform")
    public String xmlReader(){
        BuilderJSON b = new BuilderJSON();
        return b.xmlReader().toString();
    }

}
