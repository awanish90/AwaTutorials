package awa.com.awatutorials.model;

/**
 * Created by ${Awanish} on 03/01/18.
 */

public class SimpleTextModel {
    private String simpleText;

    public SimpleTextModel(String simpleText) {
      setSimpleText(simpleText);
    }

    public String getSimpleText() {
        return simpleText;
    }

    public void setSimpleText(String simpleText) {
        this.simpleText = simpleText;
    }
}
