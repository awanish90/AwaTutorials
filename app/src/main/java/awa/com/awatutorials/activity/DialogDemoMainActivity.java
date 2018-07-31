package awa.com.awatutorials.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import awa.com.awatutorials.R;
import awa.com.awatutorials.dialogs.BasicDialogFragment;
import awa.com.awatutorials.dialogs.CustomDialogUIFragment;
import awa.com.awatutorials.dialogs.DialogInteractionFragment;
import awa.com.awatutorials.dialogs.ListDialogFragment;
import awa.com.awatutorials.interfaces.DialogClickListener;

public class DialogDemoMainActivity extends AppCompatActivity implements View.OnClickListener,DialogClickListener {
Button alertDialog,styledAlertDialog,multipleChoiceDialog,listDialog,timePickerDialog,
        dialogInteraction,basicDialogfFragment,customLayoutDialog;
    public static final String TAG = BasicDialogFragment.class.getName();
    public static final String TAG1 = ListDialogFragment.class.getName();
    public static final String TAG2 = CustomDialogUIFragment.class.getName();
    public static final String TAG3 = DialogInteractionFragment.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_demo_main);
        getViews();
        setOnClickListeners();
    }

    private void getViews() {
        alertDialog = (Button)findViewById(R.id.AlertDialog);
        styledAlertDialog = (Button)findViewById(R.id.AlertDialogStyle);
        multipleChoiceDialog = (Button)findViewById(R.id.multipleChoiceDialog);
        listDialog = (Button)findViewById(R.id.listDialogFragment);
        dialogInteraction = (Button)findViewById(R.id.dialogInteraction);
        timePickerDialog = (Button)findViewById(R.id.TimePickerDialog);
        basicDialogfFragment = (Button)findViewById(R.id.basicDialogFragment);
        customLayoutDialog = (Button)findViewById(R.id.customLayoutDialog);

    }
    private void setOnClickListeners(){
        alertDialog.setOnClickListener(this);
        styledAlertDialog.setOnClickListener(this);
        multipleChoiceDialog.setOnClickListener(this);
        listDialog.setOnClickListener(this);
        dialogInteraction.setOnClickListener(this);
        timePickerDialog.setOnClickListener(this);
        basicDialogfFragment.setOnClickListener(this);
        customLayoutDialog.setOnClickListener(this);
    }
    private void createAlertDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(" Default Alert Dialog Title")
        .setMessage(" Dialog Message")
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        //Creating dialog box
     /*   AlertDialog alert = */alertDialogBuilder.create().show();
        //Setting the title manually
        //alert.setTitle("AlertDialogExample");
      //  alert.show();

    }
    private void createStyledAlertDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this,R.style.customDialogTheme);
        dialogBuilder.setTitle(" Default Alert Dialog Title")
                .setMessage(" Dialog Message")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogBuilder.create().show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.AlertDialog:
                createAlertDialog();
                break;
            case R.id.AlertDialogStyle:
                createStyledAlertDialog();
                break;
            case R.id.multipleChoiceDialog:
                createMultipleChoiceAlertDialog();
                break;
            case R.id.listDialogFragment:
                createListDialogFragment();
                break;
            case R.id.basicDialogFragment:
                createBasicDialogFragment();
                break;
            case R.id.customLayoutDialog:
                createCustomUIDialogFragment();
                break;
            case R.id.dialogInteraction:
               createInteractiveDialog();
                break;
            case R.id.TimePickerDialog:
                createStyledAlertDialog();
                break;
            default:
                break;
        }
    }

    private void createInteractiveDialog() {
        DialogInteractionFragment dialogInteractionFragment = new DialogInteractionFragment();
        dialogInteractionFragment.show(getSupportFragmentManager(),TAG3);

    }

    private void createListDialogFragment() {
        ListDialogFragment listDialogFragment = new ListDialogFragment();
        listDialogFragment.show(getSupportFragmentManager(),TAG1);
    }
    private void createCustomUIDialogFragment(){
        CustomDialogUIFragment customDialogUIFragment = new CustomDialogUIFragment();
        customDialogUIFragment.show(getSupportFragmentManager(),TAG2);
    }

    private void createBasicDialogFragment() {
        BasicDialogFragment basicDialogFragment = new BasicDialogFragment();
        basicDialogFragment.show(getSupportFragmentManager(),TAG);
    }

    private void createMultipleChoiceAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final  String[] teamChoice = getResources().getStringArray(R.array.team_choice);
        boolean[] checkedItems = {false,false,false,false,false};
        alertDialogBuilder.setTitle(" Choose your favourite Team")
                .setIcon(R.drawable.celebration_box_2)
        .setMultiChoiceItems(teamChoice, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getBaseContext()," your fav team is "+teamChoice[which],Toast.LENGTH_LONG).show();
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();



    }


    @Override
    public void onPositiveButtonClick(DialogFragment dialogFragment) {
        dialogFragment.dismiss();

    }

    @Override
    public void onNegativeButtonClick(DialogFragment dialogFragment) {
        dialogFragment.dismiss();

    }
}
