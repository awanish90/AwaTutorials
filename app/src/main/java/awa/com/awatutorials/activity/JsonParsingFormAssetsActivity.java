package awa.com.awatutorials.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

import awa.com.awatutorials.R;
import awa.com.awatutorials.model.EmpAddress;
import awa.com.awatutorials.model.EmployeeDetail;

public class JsonParsingFormAssetsActivity extends AppCompatActivity {

    public static final String TAG = JsonParsingFormAssetsActivity.class.getName();
    private String employeeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parsing_formassets);
        readJsonTxtFileFromAssets();
        getEmployee();

    }

    private void getEmployee() {
        try {
            JSONObject jObject = new JSONObject(employeeText);
            EmployeeDetail employeeDetail = new EmployeeDetail();
            employeeDetail.setEmpId(jObject.getInt("id"));
            employeeDetail.setEmpName(jObject.getString("name"));
            employeeDetail.setPermanent(jObject.getBoolean("permanent"));
            employeeDetail.setRole(jObject.getString("role"));
            JSONObject innerJsonObject  = jObject.getJSONObject("address");
            EmpAddress empAddress = new EmpAddress();
            empAddress.setCity(innerJsonObject.getString("city"));
            empAddress.setStreet(innerJsonObject.getString("street"));
            empAddress.setZipCode(innerJsonObject.getInt("zipcode"));
            employeeDetail.setEmpAddress(empAddress);
            JSONArray jsonArray = jObject.getJSONArray("phoneNumbers");
            long[] numbers = new long[jsonArray.length()];
            for (int i = 0 ; i<jsonArray.length();i++){
                numbers[i] = Long.parseLong(jsonArray.get(i).toString());
            }
            employeeDetail.setEmpContactNumbers(numbers);
            Log.d(TAG, " employee class detail   "+employeeDetail);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void readJsonTxtFileFromAssets(){
        try {


            InputStream is = this.getResources().openRawResource(R.raw.employee);
            byte[] buffer = new byte[is.available()];
            while (is.read(buffer) != -1);
            String jsontext = new String(buffer);





            Log.d(TAG, jsontext);

           employeeText = jsontext;
            //tv.setText(jsontext);

        } catch (Exception e) {

            Log.e(TAG, ""+e.toString());
        }
    }
}
