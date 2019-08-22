package simrn.programme.co.registrationformfordjmun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecurityCouncil extends AppCompatActivity {

    TextView tvSc,tvAgenda,tvTopic;
    ImageView ivSc;
    Button btnRes,btnBack,btnScConfirm;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_council);

        int color1 = Color.parseColor("#0091ea");
        int color2=Color.parseColor("#b3e5fc");

        tvSc=findViewById(R.id.tvSc);
        tvAgenda=findViewById(R.id.tvAgenda);
        tvTopic=findViewById(R.id.tvTopic);
        ivSc=findViewById(R.id.ivSc);
        btnRes=findViewById(R.id.btnRes);
        btnBack=findViewById(R.id.btnBack);
        btnScConfirm=findViewById(R.id.btnScConfirm);
        layout= findViewById(R.id.layout);
        SharedPreferences preffs = getSharedPreferences("ChangeBkg",0);
        Boolean change = preffs.getBoolean("color",false);
        if(change==true)
        {

            layout.setBackgroundColor(Color.BLACK);
            tvSc.setTextColor(Color.WHITE);
            btnScConfirm.setBackgroundColor(color1);
            btnBack.setBackgroundColor(color1);
            btnRes.setBackgroundColor(color1);
            tvTopic.setTextColor(Color.WHITE);
            tvAgenda.setTextColor(Color.WHITE);
            btnBack.setTextColor(Color.WHITE);
            btnRes.setTextColor(Color.WHITE);
            btnScConfirm.setTextColor(Color.WHITE);

        }
        else
        {
            tvSc.setTextColor(color2);
            tvSc.setBackgroundColor(Color.BLACK);
            btnScConfirm.setBackgroundColor(Color.BLACK);
            btnBack.setBackgroundColor(Color.BLACK);
            btnRes.setBackgroundColor(Color.BLACK);
            tvTopic.setTextColor(Color.BLACK);
            tvAgenda.setTextColor(Color.BLACK);
            btnBack.setTextColor(color2);
            btnRes.setTextColor(color2);
            btnScConfirm.setTextColor(color2);

        }

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.securitycouncilreport.org/monthly-forecast/2019-08/dprk-north-korea-3.php"));
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SecurityCouncil.this,simrn.programme.co.registrationformfordjmun.Committee.class);
                startActivity(intent);
                finish();
            }
        });

        btnScConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecurityCouncil.this,simrn.programme.co.registrationformfordjmun.Confirmation.class);
                intent.putExtra("committee","Security Council");
                startActivity(intent);
                finish();
            }
        });
    }
}
