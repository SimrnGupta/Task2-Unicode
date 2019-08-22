package simrn.programme.co.registrationformfordjmun;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    TextView tvDetails, tvName, tvSap, tvAge, tvDob, tvGender, tvEmail, tvPhone;
    EditText etName, etSap, etAge, etDob, etEmail, etPhone;
    RadioGroup rgGender;
    RadioButton radioButton,rbFemale,rbMale;
    Button btnSubmit;
    Switch swMode;
    LinearLayout layout;

    public static final String MY_PREFS = "simrn.programme.co.registrationformfordjmun.Details";
    public static final String CHANGE_LAYOUT="simrn.programme.co.registrationformfordjmun.ChangeLayout";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetails = findViewById(R.id.tvDetails);
        tvName = findViewById(R.id.tvName);
        tvSap = findViewById(R.id.tvSap);
        tvAge = findViewById(R.id.tvAge);
        tvDob = findViewById(R.id.tvDob);
        tvGender = findViewById(R.id.tvGender);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);

        etName = findViewById(R.id.etName);
        etSap = findViewById(R.id.etSap);
        etAge = findViewById(R.id.etAge);
        etDob = findViewById(R.id.etDob);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);


        rgGender = findViewById(R.id.rgGender);
        rbFemale=findViewById(R.id.rbFemale);
        rbMale=findViewById(R.id.rbMale);
        btnSubmit = findViewById(R.id.btnSubmit);

        swMode = findViewById(R.id.swMode);
        layout = findViewById(R.id.layout);

        SharedPreferences prefss = getSharedPreferences("ChangeBkg",0);
        SharedPreferences.Editor editor = prefss.edit();
        Boolean bkg = false;
        editor.putBoolean("color",bkg);
        editor.commit();

        swMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (swMode.isChecked())
                {
                    layout.setBackgroundColor(Color.BLACK);
                    tvName.setTextColor(Color.WHITE);
                    tvSap.setTextColor(Color.WHITE);
                    tvAge.setTextColor(Color.WHITE);
                    tvDob.setTextColor(Color.WHITE);
                    tvDetails.setTextColor(Color.WHITE);
                    tvGender.setTextColor(Color.WHITE);
                    tvEmail.setTextColor(Color.WHITE);
                    tvPhone.setTextColor(Color.WHITE);
                    btnSubmit.setBackgroundColor(Color.WHITE);
                    btnSubmit.setTextColor(Color.BLACK);
                    etPhone.setTextColor(Color.WHITE);
                    etName.setTextColor(Color.WHITE);
                    etEmail.setTextColor(Color.WHITE);
                    etSap.setTextColor(Color.WHITE);
                    etDob.setTextColor(Color.WHITE);
                    etAge.setTextColor(Color.WHITE);
                    rbFemale.setTextColor(Color.WHITE);
                    rbMale.setTextColor(Color.WHITE);

                    etName.setHintTextColor(Color.WHITE);
                    etDob.setHintTextColor(Color.WHITE);
                    etEmail.setHintTextColor(Color.WHITE);





                    SharedPreferences prefss = getSharedPreferences("ChangeBkg",0);
                    SharedPreferences.Editor editor = prefss.edit();
                    editor.putBoolean("color",swMode.isChecked());
                    editor.commit();

                    swMode.setText("Light Mode");
                    swMode.setTextColor(Color.WHITE);

                }
                else {
                    layout.setBackgroundColor(Color.WHITE);
                    tvName.setTextColor(Color.BLACK);
                    tvSap.setTextColor(Color.BLACK);
                    tvAge.setTextColor(Color.BLACK);
                    tvDob.setTextColor(Color.BLACK);
                    tvDetails.setTextColor(Color.BLACK);
                    tvGender.setTextColor(Color.BLACK);
                    tvEmail.setTextColor(Color.BLACK);
                    tvPhone.setTextColor(Color.BLACK);
                    btnSubmit.setBackgroundColor(Color.WHITE);
                    btnSubmit.setTextColor(Color.BLACK);
                    etPhone.setTextColor(Color.BLACK);
                    etName.setTextColor(Color.BLACK);
                    etEmail.setTextColor(Color.BLACK);
                    etSap.setTextColor(Color.BLACK);
                    etDob.setTextColor(Color.BLACK);
                    etAge.setTextColor(Color.BLACK);
                    rbFemale.setTextColor(Color.BLACK);
                    rbMale.setTextColor(Color.BLACK);

                    etName.setHintTextColor(Color.BLACK);
                    etDob.setHintTextColor(Color.BLACK);
                    etEmail.setHintTextColor(Color.BLACK);

                    SharedPreferences prefss = getSharedPreferences("ChangeBkg",0);
                    SharedPreferences.Editor editor = prefss.edit();
                    editor.putBoolean("color",swMode.isChecked());
                    editor.commit();
                    swMode.setText("Dark Mode");
                    swMode.setTextColor(Color.BLACK);
                }
            }
        });




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = etName.getText().toString().trim();
                String sap = etSap.getText().toString().trim();
                String age = etAge.getText().toString().trim();
                String dob = etDob.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();

                int radioId = rgGender.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                if(radioId!=-1) {
                    String gender = radioButton.getText().toString();


                    SharedPreferences prefs = getSharedPreferences("Idvalue", 0);

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("name", name);
                    editor.putString("sap", sap);
                    editor.putString("age", age);
                    editor.putString("dob", dob);
                    editor.putString("email", email);
                    editor.putString("phone", phone);
                    editor.putString("gender", gender);
                    editor.commit();
                }

                if (name.isEmpty() || sap.isEmpty() || age.isEmpty() || dob.isEmpty() || email.isEmpty() || phone.isEmpty() || radioId == -1) {
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }

                else if(sap.length()!=11)
                {
                    Toast.makeText(MainActivity.this, "Invalid SAP Id", Toast.LENGTH_SHORT).show();
                }
                else if(dob.length()!=10)
                {
                    Toast.makeText(MainActivity.this, "Invalid date of birth entry", Toast.LENGTH_SHORT).show();
                }


                else if(dob.length()==10&&(dob.charAt(2)!='/' || dob.charAt(5)!='/'))
                    {
                        Toast.makeText(MainActivity.this, "Invalid date of birth entry", Toast.LENGTH_SHORT).show();
                    }


                else if(!email.contains("@"))
                {
                    Toast.makeText(MainActivity.this, "Invalid email entry", Toast.LENGTH_SHORT).show();
                }
                else if(phone.length()!=10)
                {
                    Toast.makeText(MainActivity.this, "Invalid phone number", Toast.LENGTH_SHORT).show();
                }

                else
                    {

                    Intent intent = new Intent(MainActivity.this, simrn.programme.co.registrationformfordjmun.Committee.class);
                    startActivity(intent);

                }


            }
        });
    }
}



