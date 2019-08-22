package simrn.programme.co.registrationformtask3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDetails,tvName,tvSap,tvAge,tvDob,tvGender,tvEmail,tvPhone;
    EditText etName,etSap,etAge,etDob,etEmail,etPhone;
    RadioGroup rgGender;
    RadioButton radioButton;
    Button btnSubmit;


    public static final String PREFERENCES = "simrn.programme.co.registrationformtask3.Name";
    public static final String MY_PREFS_FILENAME = "simrn.programme.co.registrationformtask3.Details";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkFirstOpen();
        tvDetails=findViewById(R.id.tvDetails);
        tvName=findViewById(R.id.tvName);
        tvSap=findViewById(R.id.tvSap);
        tvAge=findViewById(R.id.tvAge);
        tvDob=findViewById(R.id.tvDob);
        tvGender=findViewById(R.id.tvGender);
        tvEmail=findViewById(R.id.tvEmail);
        tvPhone=findViewById(R.id.tvPhone);

        etName=findViewById(R.id.etName);
        etSap=findViewById(R.id.etSap);
        etAge=findViewById(R.id.etAge);
        etDob=findViewById(R.id.etDob);
        etEmail=findViewById(R.id.etEmail);
        etPhone=findViewById(R.id.etPhone);

        rgGender=findViewById(R.id.rgGender);
        btnSubmit=findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,simrn.programme.co.registrationformtask3.Confirmation.class);

                String name=etName.getText().toString().trim();
                String sap=etSap.getText().toString().trim();
                String age=etAge.getText().toString().trim();
                String dob=etDob.getText().toString().trim();
                String email=etEmail.getText().toString().trim();
                String phone=etPhone.getText().toString().trim();


                int radioId=rgGender.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);
                String gender = radioButton.getText().toString();



                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_FILENAME,MODE_PRIVATE).edit();
                editor.putString("pName", name);
                editor.putString("pSap", sap);
                editor.putString("pAge", age);
                editor.putString("pDob", dob);
                editor.putString("pEmail", email);
                editor.putString("pPhone", phone);
                editor.putString("pGender",gender );
                editor.commit();





                if(name.isEmpty()||sap.isEmpty()||age.isEmpty()||dob.isEmpty()||email.isEmpty()||phone.isEmpty()||radioId==-1)
                {
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
                    intent.putExtra("name",name);
                    intent.putExtra("sap",sap);
                    intent.putExtra("age",age);
                    intent.putExtra("dob",dob);
                    intent.putExtra("email",email);
                    intent.putExtra("phone",phone);
                    intent.putExtra("gender",gender);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
    public void checkFirstOpen(){
        Boolean isFirstOpen = getSharedPreferences(PREFERENCES,MODE_PRIVATE).getBoolean("isFirstOpen",true);

        if(!isFirstOpen)
        {
            Intent intent = new Intent(MainActivity.this,simrn.programme.co.registrationformtask3.Confirmation.class);

            SharedPreferences prefs = getSharedPreferences(MY_PREFS_FILENAME,MODE_PRIVATE);
            String sname = prefs.getString("pName","");
            String ssap = prefs.getString("pSap","");
            String sage = prefs.getString("pAge","");
            String sdob = prefs.getString("pDob","");
            String semail = prefs.getString("pEmail","");
            String sphone = prefs.getString("pPhone","");
            String sgender = prefs.getString("pGender","");

            intent.putExtra("name",sname);
            intent.putExtra("sap",ssap);
            intent.putExtra("age",sage);
            intent.putExtra("dob",sdob);
            intent.putExtra("email",semail);
            intent.putExtra("phone",sphone);
            intent.putExtra("gender",sgender);
            startActivity(intent);



        }

        getSharedPreferences(PREFERENCES,MODE_PRIVATE).edit().putBoolean("isFirstOpen",false).apply();

    }



}
