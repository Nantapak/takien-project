package suwuttipoj.nantapak.takienfloatingmarket;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {


    //Explicit
    private EditText userEditText, passwordEditText, password2EditText, nameEditText, idEditText, hbdEditText, addressEditText,
            telEditText, emailEditText, namestoreEditText, descriptionEditText;
    private String userString, passwordString, password2String, nameString, idString,
            hbdString, addressString, telString, emailString, namestoreString, descriptionString;


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


    } // Main Method

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
        builder.setMessage("User = " + userString + "\n" + 
                "Password = " + passwordString + "\n" + 
                "Name = " + nameString + "\n" + 
                "ID = " + idString + "\n" +
                "HBD = " + hbdString + "\n" + 
                "Address = " + addressString + "\n" +
                "Tel = " + telString + "\n" +
                "E-mail = " + emailString + "\n" +
                "NameStore = " + namestoreString + "\n" +
                "Description = " + descriptionString + "\n");
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
    }

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
