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

public class WHO extends AppCompatActivity {

    TextView tvWho,tvWAgenda,tvWTopic;
    ImageView ivWho;
    Button btnWRes,btnWBack,btnWConfirm;
    LinearLayout layout;

    int color1 = Color.parseColor("#0091ea");
    int color2=Color.parseColor("#b3e5fc");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who);

        tvWho=findViewById(R.id.tvWho);
        tvWAgenda=findViewById(R.id.tvWAgenda);
        tvWTopic=findViewById(R.id.tvWTopic);
        ivWho=findViewById(R.id.ivWho);
        btnWRes=findViewById(R.id.btnWRes);
        btnWBack=findViewById(R.id.btnWBack);
        btnWConfirm=findViewById(R.id.btnWConfirm);


        layout=findViewById(R.id.layout);

        SharedPreferences preffs = getSharedPreferences("ChangeBkg",0);
        Boolean change = preffs.getBoolean("color",false);
        if(change==true)
        {
            layout.setBackgroundColor(Color.BLACK);
            tvWho.setTextColor(Color.WHITE);
            btnWConfirm.setBackgroundColor(color1);
            btnWBack.setBackgroundColor(color1);
            btnWRes.setBackgroundColor(color1);
            tvWTopic.setTextColor(Color.WHITE);
            tvWAgenda.setTextColor(Color.WHITE);
            btnWBack.setTextColor(Color.WHITE);
            btnWRes.setTextColor(Color.WHITE);
            btnWConfirm.setTextColor(Color.WHITE);
        }
        else
        {
            tvWho.setTextColor(color2);
            tvWho.setBackgroundColor(Color.BLACK);
            btnWConfirm.setBackgroundColor(Color.BLACK);
            btnWBack.setBackgroundColor(Color.BLACK);
            btnWRes.setBackgroundColor(Color.BLACK);
            tvWTopic.setTextColor(Color.BLACK);
            tvWAgenda.setTextColor(Color.BLACK);
            btnWBack.setTextColor(color2);
            btnWRes.setTextColor(color2);
            btnWConfirm.setTextColor(color2);

        }




        btnWRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/docs/default-source/primary-health/vision.pdf"));
                startActivity(intent);
            }
        });

        btnWBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(WHO.this,simrn.programme.co.registrationformfordjmun.Committee.class);
                startActivity(intent);
                finish();
            }
        });

        btnWConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WHO.this,simrn.programme.co.registrationformfordjmun.Confirmation.class);
                intent.putExtra("committee","World Health Organisation");
                startActivity(intent);
                finish();

            }
        });
    }


    }

