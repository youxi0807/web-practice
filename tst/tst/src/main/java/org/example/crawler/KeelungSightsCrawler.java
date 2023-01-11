package org.example.crawler;

import org.example.sight.Sight;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
@Component
public class KeelungSightsCrawler {
    private String URL;
    private ArrayList<String> allSightsURL;
    private ArrayList<Sight> allSights;
    @PostConstruct
    public void init(){
        this.allSightsURL=new ArrayList<>();
        this.allSights=new ArrayList<>();
        this.URL="https://www.travelking.com.tw";
        getAllSightsURL();
        getAllSightsInfo();
        this.allSightsURL.clear();
    }
    private void getAllSightsURL(){
        try {
            final Document document = Jsoup.connect(URL + "/tourguide/taiwan/keelungcity/").get();
            for(Element e : document.select("div.box h4")){
                Element sight =e.nextElementSibling();
                assert sight != null;
                for(Element sightURL:sight.select("li a")){
                    this.allSightsURL.add(sightURL.attr("href"));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String getSightName(Document document){
        Element element = document.select("h1.h1").first();
        if(element == null) return "";
        return element.text();
    }
    private String getZone(Document document){
        Element element = document.select("li.bc_last a").first();
        if(element == null) return "";
        return element.text();
    }
    private String getCategory(Document document){
        Element element = document.select("cite span strong").first();
        if(element == null) return "";
        return element.text();
    }
    private String getPhotoURL(Document document){
        Element element = document.select("div.gpic img").first();
        if(element == null) return "";
        return element.attr("data-src");
    }
    private String getDescription(Document document){
        Element element = document.select("div.text").first();
        if(element == null) return "";
        return element.text();
    }
    private String getAddress(Document document){
        Element element = document.select("div.address p").first();
        if(element == null) return "";
        return element.text();
    }

    private void getAllSightsInfo(){
        int id = 1;
        for(String sightURL:this.allSightsURL){
            try{
                final Document document = Jsoup.connect(URL + sightURL).get();
                String sightName = getSightName(document);
                String zone = getZone(document);
                String category = getCategory(document);
                String photoURL = getPhotoURL(document);
                String description = getDescription(document);
                String address = getAddress(document);
                this.allSights.add(new Sight(id,sightName,zone,category,photoURL,description,address));
                id++;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Sight> getAllSights() {
        return this.allSights;
    }
    public void clearAllSights(){
        this.allSights.clear();
    }
}
