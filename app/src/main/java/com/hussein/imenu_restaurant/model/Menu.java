package com.hussein.imenu_restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hamed on 3/19/16.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class Menu implements Serializable{
    private long id;
    private ArrayList<Section> sections;


    public Menu (){
        sections = new ArrayList<Section>();
    }

    public Menu(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void addSection (Section section) {
        sections.add(section);
        // call the service
    }
    public void removeSection (int sectionId) {
        ArrayList<Section> temp = new ArrayList<Section>();
        for (int i=0;i<sections.size();i++){
            if (sections.get(i).getId()!=sectionId){
                temp.add(sections.get(i));
            }
        }
        sections = temp;
        // call the service
    }
}
