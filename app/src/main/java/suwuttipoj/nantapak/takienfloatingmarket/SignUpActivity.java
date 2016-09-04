package suwuttipoj.nantapak.takienfloatingmarket;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class SignUpActivity extends AppCompatActivity {


    //Explicit
    private EditText userEditText, passwordEditText, password2EditText, nameEditText, idEditText, hbdEditText, addressEditText,
            telEditText, emailEditText, namestoreEditText, descriptionEditText;
    private String userString, passwordString, password2String, nameString, idString,
            hbdString, addressString, telString, emailString, namestoreString, descriptionString
            ;
    private DatePicker datePicker;
    private static final String urlPHP = "http://swiftcodingthai.com/ton/php_add_user.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);
        password2EditText = (EditText) findViewById(R.id.editText3);
        nameEditText = (EditText) findViewById(R.id.editText4);
        idEditText = (EditText) findViewById(R.id.editText5);
        hbdEditText = (EditText) findViewById(R.id.editText6);
        addressEditText = (EditText) findViewById(R.id.editText7);
        telEditText = (EditText) findViewById(R.id.editText8);
        emailEditText = (EditText) findViewById(R.id.editText9);
        namestoreEditText = (EditText) findViewById(R.id.editText10);
        descriptionEditText = (EditText) findViewById(R.id.editText11);
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        //Setup datePicker
        datePicker.setSpinnersShown(false);


    } // Main Method

    public void clickBackSignUp(View view) {
        finish();
    }




    public void clickSetDate(View view) {
        int intDate = datePicker.getDayOfMonth();
        int intMouth = datePicker.getMonth() + 1;
        int intYear = datePicker.getYear();
        String strBorn = Integer.toString(intDate) + "/" +
                Integer.toString(intMouth) + "/" +
                Integer.toString(intYear);
        hbdEditText.setText(strBorn);
    }

    public void clickSaveData(View view) {
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();
        password2String = password2EditText.getText().toString().trim();
        nameString = nameEditText.getText().toString().trim();
        idString = idEditText.getText().toString().trim();
        hbdString = hbdEditText.getText().toString().trim();
        addressString = addressEditText.getText().toString().trim();
        telString = telEditText.getText().toString().trim();
        emailString = emailEditText.getText().toString().trim();
        namestoreString = namestoreEditText.getText().toString().trim();
        descriptionString = descriptionEditText.getText().toString().trim();

        // Check Space
        if (checkSpace()) {
            // Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกให้ครบทุกช่องครับ");
        } else if (passwordString.equals(password2String)) {
            // Password Map

            confirmData();

        } else { 

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "รหัสผ่านไม่ตรงกัน",
                    "กรุณากรอกรหัสผ่านให้ตรงกันครับ");

        }
        
        


    }   // clickSaveData

    private void confirmData() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.nobita48);
        builder.setTitle("โปรดตรวจสอบข้อมูล");
        builder.setMessage("ชื่อผู้ใช้งาน = " + userString + "\n" +
                "รหัสผ่าน = " + passwordString + "\n" +
                "ชื่อ-นามสกุล = " + nameString + "\n" +
                "เลขประจำตัวประชาชน = " + idString + "\n" +
                "วัน/เดือน/ปีเกิด = " + hbdString + "\n" +
                "ที่อยู่ = " + addressString + "\n" +
                "เบอร์โทรศัพท์ = " + telString + "\n" +
                "อีเมลล์ = " + emailString + "\n" +
                "ชื่อร้านค้า = " + namestoreString + "\n" +
                "รายละเอียดร้านค้า = " + descriptionString + "\n");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                uploadToServer();
                dialog.dismiss();
            }
        });
        builder.show();

    }

    private void uploadToServer() {

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("User", userString)
                .add("Password", passwordString)
                .add("Name", nameString)
                .add("Idcard", idString)
                .add("Born", hbdString)
                .add("Address", addressString)
                .add("Tel", telString)
                .add("Email", emailString)
                .add("Namestore", namestoreString)
                .add("Description", descriptionString)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(urlPHP).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.d("4SepV1", "e ==> " + e.toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.d("4SepV1", "Result ==> " + response.body().string());

            }
        });

    } // uploadToServer

    private boolean checkSpace() {
        return userString.equals("") ||
                passwordString.equals("") ||
                password2String.equals("") ||
                nameString.equals("") ||
                idString.equals("") ||
                hbdString.equals("") ||
                addressString.equals("") ||
                telString.equals("") ||
                emailString.equals("") ||
                namestoreString.equals("") ||
                descriptionString.equals("");
    }


} // Main Class
