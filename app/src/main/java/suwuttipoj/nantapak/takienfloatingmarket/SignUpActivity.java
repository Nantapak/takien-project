package suwuttipoj.nantapak.takienfloatingmarket;

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
        }


    }   // clickSaveData

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
