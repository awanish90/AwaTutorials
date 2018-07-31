package awa.com.awatutorials.model;

public class GridDataModel {
    private String gridText;
    private int drawableId;
    private String colorCode;

    public GridDataModel(String text, int id, String color){
        gridText = text;
        drawableId = id;
        colorCode =color;

    }
    public String getGridText() {
        return gridText;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public String getColorCode() {
        return colorCode;
    }
}
