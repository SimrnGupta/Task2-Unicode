package simrn.programme.co.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {

    TextView tvConfirm,tvCName,tvCSap,tvCAge,tvCDob,tvCGender,tvCEmail,tvCPhone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        tvConfirm=findViewById(R.id.tvConfirm);
        tvCName=findViewById(R.id.tvCName);
        tvCSap=findViewById(R.id.tvCSap);
        tvCAge=findViewById(R.id.tvCAge);
        tvCDob=findViewById(R.id.tvCDob);
        tvCGender=findViewById(R.id.tvCGender);
        tvCEmail=findViewById(R.id.tvCEmail);
        tvCPhone=findViewById(R.id.tvCPhone);

        String sName=getIntent().getStringExtra("name");
        tvCName.setText("Name : "+sName);
        String sSap=getIntent().getStringExtra("sap");
        tvCSap.setText("SAP Id : "+sSap);
        String sAge=getIntent().getStringExtra("age");
        tvCAge.setText("Age : "+sAge+" years");

        String sDob=getIntent().getStringExtra("dob");
        tvCDob.setText("Date of birth : "+sDob);

        String sEmail=getIntent().getStringExtra("email");
        tvCEmail.setText("Email ID : "+sEmail);

        String sPhone=getIntent().getStringExtra("phone");
        tvCPhone.setText("Phone number : "+sPhone);

        String sGender=getIntent().getStringExtra("gender");
        tvCGender.setText("Gender : "+sGender);







    }
}
