package simrn.programme.co.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





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

                Intent intent=new Intent(MainActivity.this,simrn.programme.co.registrationform.Confirmation.class);

                String name=etName.getText().toString().trim();
                String sap=etSap.getText().toString().trim();
                String age=etAge.getText().toString().trim();
                String dob=etDob.getText().toString().trim();
                String email=etEmail.getText().toString().trim();
                String phone=etPhone.getText().toString().trim();

                int radioId=rgGender.getCheckedRadioButtonId();
                radioButton=findViewById(radioId);

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
                    intent.putExtra("gender",radioButton.getText());
                    startActivity(intent);
                    finish();
                }




            }
        });

    }



}
