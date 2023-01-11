package org.example.sight;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Sight")
public class Sight implements java.io.Serializable{
    @Id
    private int id;
    private String sightName;
    private String zone;
    private String category;
    private String photoURL;
    private String description;
    private String address;

    public Sight(int id,String sightName,String zone,String category,String photoURL,String description,String address){
        this.id=id;
        this.sightName=sightName;
        this.zone=zone;
        this.category=category;
        this.photoURL=photoURL;
        this.description=description;
        this.address=address;
    }
    public String getSightName(){return this.sightName;}
    public String getZone(){return this.zone;}
    public String getCategory(){return this.category;}
    public String getPhotoURL(){return this.photoURL;}
    public String getDescription(){return this.description;}
    public String getAddress(){return this.address;}

    @Override
    public String toString(){
        return "SightName: " + getSightName() + "\n" +
                "Zone: " + getZone() + "\n" +
                "Category: " + getCategory() + "\n" +
                "PhotoURL: " + getPhotoURL() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Address: " + getAddress();
    }
}
