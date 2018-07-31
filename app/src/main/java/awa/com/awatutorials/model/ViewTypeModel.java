package awa.com.awatutorials.model;

public class ViewTypeModel {
    public static final int TEXT_TYPE=0;
    public static final int IMAGE_TYPE=1;
    public static final int AUDIO_TYPE=2;


    public int type;
    public int data;
    public String text;

    public ViewTypeModel(int type, String text, int data)
    {
        this.type=type;
        this.data=data;
        this.text=text;
    }

    public int getType() {
        return type;
    }

    public int getData() {
        return data;
    }

    public String getText() {
        return text;
    }
}
