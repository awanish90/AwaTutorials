package awa.com.awatutorials.model;

/**
 * Created by ${Awanish} on 17/04/18.
 */

public class Player {
    private int id,height;
    private String name,position;



    public void setPosition(String position) {
        this.position = position;
    }

    public Player(){

    }

    public Player(int id,  String name, String position,int height) {
        this.id = id;
        this.height = height;
        this.name = name;
        this.position = position;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }
    public String toString(){
        return name+" - "+position+" - "+height;
    }
}
