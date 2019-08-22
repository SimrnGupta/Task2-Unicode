package simrn.programme.co.registrationformfordjmun;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {

    TextView tvConfirm, tvCName, tvCSap, tvCAge, tvCDob, tvCGender, tvCEmail, tvCPhone, tvCom;
    Button btnContact,btnHelp;
    LinearLayout layout;
    int color1 = Color.parseColor("#0091ea");
    int color2=Color.parseColor("#b3e5fc");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        tvConfirm = findViewById(R.id.tvConfirm);
        tvCName = findViewById(R.id.tvCName);
        tvCSap = findViewById(R.id.tvCSap);
        tvCAge = findViewById(R.id.tvCAge);
        tvCDob = findViewById(R.id.tvCDob);
        tvCGender = findViewById(R.id.tvCGender);
        tvCEmail = findViewById(R.id.tvCEmail);
        tvCPhone = findViewById(R.id.tvCPhone);
        tvCom = findViewById(R.id.tvCom);

        btnContact = findViewById(R.id.btnContact);
        btnHelp=findViewById(R.id.btnHelp);
        layout=findViewById(R.id.layout);

        SharedPreferences preffs = getSharedPreferences("ChangeBkg",0);
        Boolean change = preffs.getBoolean("color",false);
        if(change==true)
        {
            layout.setBackgroundColor(Color.BLACK);
            tvConfirm.setTextColor(Color.WHITE);
            tvCGender.setTextColor(Color.WHITE);
            tvCName.setTextColor(Color.WHITE);
            tvCAge.setTextColor(Color.WHITE);
            tvCSap.setTextColor(Color.WHITE);
            tvCDob.setTextColor(Color.WHITE);
            tvCEmail.setTextColor(Color.WHITE);
            tvCPhone.setTextColor(Color.WHITE);
            tvCom.setTextColor(Color.WHITE);
            btnContact.setBackgroundColor(color1);
            btnHelp.setBackgroundColor(color1);
            btnHelp.setTextColor(Color.WHITE);
            btnContact.setTextColor(Color.WHITE);
        }
        else
        {
            tvConfirm.setTextColor(Color.BLACK);
            tvCGender.setTextColor(Color.BLACK);
            tvCName.setTextColor(Color.BLACK);
            tvCAge.setTextColor(Color.BLACK);
            tvCSap.setTextColor(Color.BLACK);
            tvCDob.setTextColor(Color.BLACK);
            tvCEmail.setTextColor(Color.BLACK);
            tvCPhone.setTextColor(Color.BLACK);
            tvCom.setTextColor(Color.BLACK);
            btnContact.setBackgroundColor(Color.BLACK);
            btnHelp.setBackgroundColor(Color.BLACK);
            btnHelp.setTextColor(Color.WHITE);
            btnContact.setTextColor(Color.WHITE);
        }

       Intent intent = getIntent();
        String sChoice = intent.getStringExtra("committee");




        SharedPreferences prefs = getSharedPreferences("Idvalue", 0);

        String sName = prefs.getString("name", "");
        String sSap = prefs.getString("sap", "");
        String sAge = prefs.getString("age", "");
        String sDob = prefs.getString("dob", "");
        String sEmail = prefs.getString("email", "");
        String sPhone = prefs.getString("phone", "");
        String sGender = prefs.getString("gender", "");

        tvCName.setText("Name : " + sName);

        tvCSap.setText("SAP Id : " + sSap);
        tvCAge.setText("Age : " + sAge + " years");
        tvCDob.setText("Date of birth : " + sDob);
        tvCEmail.setText("Email ID : " + sEmail);
        tvCPhone.setText("Phone number : " + sPhone);
        tvCGender.setText("Gender : " + sGender);
        tvCom.setText("Committee chosen : "+sChoice);

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel: 8779060173"));
                startActivity(intent);
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://mun.jyc.co.in/assets/procedure.pdf"));
                startActivity(intent);
            }
        });


        }





    }
