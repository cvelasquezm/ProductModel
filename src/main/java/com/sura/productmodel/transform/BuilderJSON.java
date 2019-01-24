package com.sura.productmodel.transform;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.sura.productmodel.dto.BuildingCoverageDTO;
import com.sura.productmodel.dto.CoverageDTO;
import com.sura.productmodel.dto.TermsDTO;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuilderJSON {

    Gson gson = new Gson();

    public JsonElement xmlReader(String url, String file){
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( url + file );
        try {
            BuildingCoverageDTO buildingCoverageDTO = new BuildingCoverageDTO();
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            String publicId = rootNode.getAttributeValue("public-id");
            String coverageCategory = rootNode.getAttributeValue("coverageCategory");

            buildingCoverageDTO.coverageCategory = coverageCategory;

            List<Element> covTerms = rootNode.getChildren("CovTerms");
            List<CoverageDTO> listCoverageDTO = new ArrayList<CoverageDTO>();
            for (Element covTerm : covTerms) {
                CoverageDTO coverageDTO = new CoverageDTO();
                coverageDTO.updated = true;
                coverageDTO.selected = true;
                coverageDTO.publicID = publicId;

                List<Element> directCovTermPatterns = covTerm.getChildren("DirectCovTermPattern");
                List<Element> typekeyCovTermPatterns = covTerm.getChildren("TypekeyCovTermPattern");

                List<TermsDTO> listTermsDTO = new ArrayList<>();

                for (Element typekeyCovTermPattern : typekeyCovTermPatterns) {

                    boolean required = typekeyCovTermPattern.getAttributeValue("required").equals("true") ? true : false;
                    TermsDTO termsDTO = new TermsDTO();
                    if (true) {
                        termsDTO.required = true;
                        termsDTO.updated = true;
                        termsDTO.patternCode = typekeyCovTermPattern.getAttributeValue("codeIdentifier");
                        termsDTO.chosenTerm = typekeyCovTermPattern.getAttributeValue("defaultValue");
                        listTermsDTO.add(termsDTO);
                    }

                }


                for (Element directCovTermPattern : directCovTermPatterns) {
                    boolean required = directCovTermPattern.getAttributeValue("required").equals("true") ? true : false;
                    String defaultLimitValue = "";
                    List<Element> limitsSet = directCovTermPattern.getChildren("LimitsSet");
                    if (limitsSet.size() > 0) {
                        List<Element> covTermLimits = limitsSet.get(0).getChildren("CovTermLimits");
                        if (covTermLimits.size() > 0) {
                            defaultLimitValue = covTermLimits.get(0).getAttributeValue("defaultValue");
                            defaultLimitValue = defaultLimitValue == null ? "" : defaultLimitValue;
                        }
                    }

                    TermsDTO termsDTO = new TermsDTO();
                    if (true) {
                        termsDTO.required = true;
                        termsDTO.updated = true;
                        termsDTO.patternCode = directCovTermPattern.getAttributeValue("codeIdentifier");

                        String coverageColumn = directCovTermPattern.getAttributeValue("coverageColumn");
                        if (coverageColumn.startsWith("DirectTerm")) {
                            String valueType = directCovTermPattern.getAttributeValue("valueType");
                            termsDTO.directValue = defaultLimitValue.trim().equalsIgnoreCase("") ? getDefaultValue(valueType) : defaultLimitValue;
                        } else if (coverageColumn.startsWith("ChoiceTerm")) {
                            termsDTO.chosenTerm = directCovTermPattern.getAttributeValue("defaultValue");
                        }
                        listTermsDTO.add(termsDTO);
                    }
                }
                coverageDTO.terms = ListToArrayTermsDTO(listTermsDTO);
                listCoverageDTO.add(coverageDTO);
            }
            buildingCoverageDTO.coverages = ListToArrayCoverageDTO(listCoverageDTO);
            return gson.toJsonTree(buildingCoverageDTO);
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch ( IOException io ) {
            System.out.println( io.getMessage() );
        } catch ( JDOMException jdomex ) {
            System.out.println( jdomex.getMessage() );
        }
        return null;
    }


    public String toMoney(){
        return "100000";
    }

    public String toPercent(){
        return "10";
    }

    public String getDefaultValue(String valueType){
        String valueReturn;
        switch (valueType){
            case "money" : valueReturn = toMoney();
                break;
            case "percent" : valueReturn = toPercent();
                break;
            default: valueReturn = toMoney();
                break;
        }
        return valueReturn;
    }

    public TermsDTO[] ListToArrayTermsDTO(List<TermsDTO> listTerms){
        TermsDTO[] termsDTOS = new TermsDTO[listTerms.size()];
        for (int i = 0; i < listTerms.size(); i++){
            termsDTOS[i] = listTerms.get(i);
        }
        return termsDTOS;
    }

    public CoverageDTO[] ListToArrayCoverageDTO(List<CoverageDTO> listCoverage){
        CoverageDTO[] coverageDTO = new CoverageDTO[listCoverage.size()];
        for (int i = 0; i < listCoverage.size(); i++){
            coverageDTO[i] = listCoverage.get(i);
        }
        return coverageDTO;
    }

}
