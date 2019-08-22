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

public class Unicef extends AppCompatActivity {

    TextView tvUnicef,tvUAgenda,tvUTopic;
    ImageView ivUnicef;
    Button btnURes,btnUBack,btnUConfirm;
    LinearLayout layout;
    int color1 = Color.parseColor("#0091ea");
    int color2=Color.parseColor("#b3e5fc");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unicef);

        tvUnicef=findViewById(R.id.tvUnicef);
        tvUAgenda=findViewById(R.id.tvUAgenda);
        tvUTopic=findViewById(R.id.tvUTopic);
        ivUnicef=findViewById(R.id.ivUnicef);
        btnURes=findViewById(R.id.btnURes);
        btnUBack=findViewById(R.id.btnUBack);
        btnUConfirm=findViewById(R.id.btnUConfirm);
        layout=findViewById(R.id.layout);


        SharedPreferences preffs = getSharedPreferences("ChangeBkg",0);
        Boolean change = preffs.getBoolean("color",false);
        if(change==true)
        {
            layout.setBackgroundColor(Color.BLACK);
            tvUnicef.setTextColor(Color.WHITE);
            btnUConfirm.setBackgroundColor(color1);
            btnUBack.setBackgroundColor(color1);
            btnURes.setBackgroundColor(color1);
            tvUTopic.setTextColor(Color.WHITE);
            tvUAgenda.setTextColor(Color.WHITE);
            btnUBack.setTextColor(Color.WHITE);
            btnURes.setTextColor(Color.WHITE);
            btnUConfirm.setTextColor(Color.WHITE);
        }
        else
        {
            tvUnicef.setTextColor(color2);
            tvUnicef.setBackgroundColor(Color.BLACK);
            btnUConfirm.setBackgroundColor(Color.BLACK);
            btnUBack.setBackgroundColor(Color.BLACK);
            btnURes.setBackgroundColor(Color.BLACK);
            tvUTopic.setTextColor(Color.BLACK);
            tvUAgenda.setTextColor(Color.BLACK);
            btnUBack.setTextColor(color2);
            btnURes.setTextColor(color2);
            btnUConfirm.setTextColor(color2);

        }



        btnURes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.unicef.org/media/files/Current_Issues_Paper-_Financing_Sanitation.pdf"));
                startActivity(intent);
            }
        });

        btnUBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Unicef.this,simrn.programme.co.registrationformfordjmun.Committee.class);
                startActivity(intent);
                finish();
            }
        });

        btnUConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Unicef.this,simrn.programme.co.registrationformfordjmun.Confirmation.class);
                intent.putExtra("committee","UNICEF");
                startActivity(intent);
                finish();
            }
        });
    }
}
