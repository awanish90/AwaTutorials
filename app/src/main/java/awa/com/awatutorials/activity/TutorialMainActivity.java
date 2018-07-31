package awa.com.awatutorials.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.ShortDynamicLink;

import java.util.ArrayList;
import java.util.List;

import awa.com.awatutorials.adapter.MainTutorialAdapter;
import awa.com.awatutorials.R;
import awa.com.awatutorials.interfaces.MainTutorialAdapterClickListener;
import awa.com.awatutorials.model.SimpleTextModel;

public class TutorialMainActivity extends AppCompatActivity implements MainTutorialAdapterClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_main);
       /* MainTutorialAdapterClickListener listener = (view, position) -> {
            Toast.makeText(this, "Position " + position, Toast.LENGTH_SHORT).show();
        };
        MainTutorialAdapterClickListener listener =*/
        MainTutorialAdapter adapter = new MainTutorialAdapter(generateSimpleList(), this);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.mainRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
      /*  createShortURLFirebase();
        createShortLinkFirebaseDynamic();*/
    }
    private List<SimpleTextModel> generateSimpleList() {
        List<SimpleTextModel> simpleViewModelList = new ArrayList<>();

        /*for (int i = 0; i < 100; i++) {
            simpleViewModelList.add(new SimpleTextModel(String.format(Locale.US, "This is item %d", i)));
        }*/

        simpleViewModelList.add(new SimpleTextModel("RecyclerViewTypes"));
        simpleViewModelList.add(new SimpleTextModel("Activity LifeCycle"));
        simpleViewModelList.add(new SimpleTextModel("SharedPreferences"));
        simpleViewModelList.add(new SimpleTextModel("PersistenceTutorials"));
        simpleViewModelList.add(new SimpleTextModel("Dialogs"));
        simpleViewModelList.add(new SimpleTextModel("LayoutTutorials"));
        simpleViewModelList.add(new SimpleTextModel("ServicesTutorial"));
        simpleViewModelList.add(new SimpleTextModel("ContentProvider"));
        simpleViewModelList.add(new SimpleTextModel("Drawables"));
        simpleViewModelList.add(new SimpleTextModel("Working With Json"));


        return simpleViewModelList;
    }

    @Override
    public void onClick(View view, int position) {

    }

    public void createShortLinkFirebaseDynamic(){
        Task<ShortDynamicLink> shortLinkTask = FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLongLink(Uri.parse("https://nsh9k.app.goo.gl/?link=http://uat.pampers.co.uk.pgsitecore.com/registration?origin=referFriend&returnUrl=http://uat.pampers.co.uk.pgsitecore.com/pampers-club&userReferrer=4ZAyxA7bwRbI5%2F2H%2Fl3p0w%3D%3D&utm_source=pampers_loyalty_app&utm_medium=mobile&utm_campaign=refer_a_friend/&apn=com.pg.clubpampers.android.uk"))
                .buildShortDynamicLink()
                .addOnCompleteListener(this, new OnCompleteListener<ShortDynamicLink>() {
                    @Override
                    public void onComplete(@NonNull Task<ShortDynamicLink> task) {
                        if (task.isSuccessful()) {
                            // Short link created
                            Uri shortLink = task.getResult().getShortLink();
                            Uri flowchartLink = task.getResult().getPreviewLink();
                            Log.d("Awa" , "   short link   "+shortLink);
                        } else {
                            // Error
                            // ...
                            Log.d("Awa" , "failure");
                        }
                    }
                });
    }



    public void createShortURLFirebase(){

        Task<ShortDynamicLink> shortLinkTask = FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLongLink(Uri.parse("https://nsh9k.app.goo.gl/?link=https://stackoverflow.com/questions/47238199/can-i-use-firebase-dynamic-link-as-url-shortener/&apn=awa.com.awatutorials"))
                .buildShortDynamicLink()
                .addOnCompleteListener(this, new OnCompleteListener<ShortDynamicLink>() {
                    @Override
                    public void onComplete(@NonNull Task<ShortDynamicLink> task) {
                        if (task.isSuccessful()) {
                            // Short link created
                            Uri shortLink = task.getResult().getShortLink();
                            Uri flowchartLink = task.getResult().getPreviewLink();
                            Log.d("Awa" , "   short link   "+shortLink);
                        } else {
                            // Error
                            // ...
                            Log.d("Awa" , "failure");
                        }
                    }
                });
        Log.d("Awa" , "  inside   ");
     /*   Task<ShortDynamicLink> shortLinkTask = FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLongLink(Uri.parse("https://stackoverflow.com/questions/47238199/can-i-use-firebase-dynamic-link-as-url-shortener"))
                .setDynamicLinkDomain("https://nsh9k.app.goo.gl")
                .setAndroidParameters(
                        new DynamicLink.AndroidParameters.Builder("awa.com.awatutorials")
                                .setMinimumVersion(1)
                                .build())
                .buildShortDynamicLink()
                .addOnCompleteListener(this, new OnCompleteListener<ShortDynamicLink>() {
                    @Override
                    public void onComplete(@NonNull Task<ShortDynamicLink> task) {
                        if (task.isSuccessful()) {
                            // Short link created
                            Uri shortLink = task.getResult().getShortLink();
                            Log.d("Awa" , "   short link   "+shortLink);
                            Uri flowchartLink = task.getResult().getPreviewLink();
                        } else {
                            // Error
                            // ...
                           // Uri shortLink = task.getResult().getShortLink();
                           // Log.d("Awa" , "   short link   "+shortLink);
                            Log.d("Awa" , "failure");
                        }
                    }
                });*/

    }
}
