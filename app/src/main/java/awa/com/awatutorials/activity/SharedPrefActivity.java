package awa.com.awatutorials.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import awa.com.awatutorials.R;

public class SharedPrefActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name,password;
    Button save,retrieve,clear;
    public static String PACKAGE_NAME;
    private String sharedPrefKey;
    private SharedPreferences sharedPref;
    private String nameKey,passwordKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        PACKAGE_NAME  = getApplicationContext().getPackageName();
        sharedPrefKey = PACKAGE_NAME+"myPref";
        getViews();
        setOnClickListeners();
    }
    private void getViews() {
        name = (EditText)findViewById(R.id.sharedPrefName);
        password = (EditText)findViewById(R.id.sharedPrefPassword);
        save = (Button)findViewById(R.id.SharedPrefSave);
        retrieve = (Button)findViewById(R.id.SharedPrefRetrieve);
        clear = (Button)findViewById(R.id.SharedPrefClear);

    }
    private void setOnClickListeners() {
        save.setOnClickListener(this);
        retrieve.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.SharedPrefSave:
                saveValueToSharedPref();
                break;
            case R.id.SharedPrefRetrieve:
                retrieveValueFromSharedPref();
                break;
            case R.id.SharedPrefClear:
                clearValueFromSharedPref();
                break;
             default:
                break;
        }
    }

    private void clearValueFromSharedPref() {
        sharedPref = getSharedPreferences(sharedPrefKey, Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPref.edit();
        sharedPrefEditor.putString(nameKey, "");
        sharedPrefEditor.putString(passwordKey,"");
        sharedPrefEditor.apply();
    }

    private void retrieveValueFromSharedPref() {
        sharedPref = getSharedPreferences(sharedPrefKey, Context.MODE_PRIVATE);
        String nameSaved = sharedPref.getString(nameKey,"daulut name");
        String passwordSaved = sharedPref.getString(passwordKey,"dafault");
        name.setText(nameSaved);
        password.setText(passwordSaved);
    }

    private void saveValueToSharedPref() {
        sharedPref = getSharedPreferences(sharedPrefKey, Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefEditor = sharedPref.edit();
        String nameSaved = name.getText().toString();
        String passwordSaved = password.getText().toString();
        if((nameSaved != null && !nameSaved.equals("") && (passwordSaved != null && !passwordSaved.equals("")))){
            sharedPrefEditor.putString(nameKey, nameSaved);
            sharedPrefEditor.putString(passwordKey,passwordSaved);
            sharedPrefEditor.apply();
            name.getText().clear();
            password.getText().clear();
        }else{
            Toast.makeText(this,"Please enter vlaues to save ",Toast.LENGTH_LONG).show();
        }

    }
}
