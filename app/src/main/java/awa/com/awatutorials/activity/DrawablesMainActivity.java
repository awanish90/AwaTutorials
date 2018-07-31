package awa.com.awatutorials.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import awa.com.awatutorials.R;

public class DrawablesMainActivity extends AppCompatActivity implements View.OnClickListener {
private ImageView toggleImage;
Button stateDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawables_main);
        getView();
        useOfTransitionDrawables();
    }

    private void getView() {
        toggleImage = findViewById(R.id.toggleImage);
        stateDrawable = findViewById(R.id.stateDrawableButton);
        stateDrawable.setOnClickListener(this);
    }
    private void useOfTransitionDrawables(){

        Resources res = this.getResources();
        TransitionDrawable transition =
                (TransitionDrawable) res.getDrawable(R.drawable.expand_collapse);
        toggleImage.setImageDrawable(transition);
        transition.startTransition(3000);
        //transition.reverseTransition(3000);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.stateDrawableButton:
                break;
                default:
                    break;
        }
    }
}
