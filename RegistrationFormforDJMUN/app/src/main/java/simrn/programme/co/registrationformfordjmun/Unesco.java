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

public class Unesco extends AppCompatActivity {

    TextView tvUnesco,tvUOAgenda,tvUOTopic;
    ImageView ivUnesco;
    Button btnUORes,btnUOBack,btnUOConfirm;
    LinearLayout layout;
    int color1 = Color.parseColor("#0091ea");
    int color2=Color.parseColor("#b3e5fc");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unesco);

        tvUnesco=findViewById(R.id.tvUnesco);
        tvUOAgenda=findViewById(R.id.tvUOAgenda);
        tvUOTopic=findViewById(R.id.tvUOTopic);
        ivUnesco=findViewById(R.id.ivUnesco);
        btnUORes=findViewById(R.id.btnUORes);
        btnUOBack=findViewById(R.id.btnUOBack);
        btnUOConfirm=findViewById(R.id.btnUOConfirm);
        layout=findViewById(R.id.layout);

        SharedPreferences preffs = getSharedPreferences("ChangeBkg",0);
        Boolean change = preffs.getBoolean("color",false);
        if(change==true)
        {
            layout.setBackgroundColor(Color.BLACK);
            tvUnesco.setTextColor(Color.WHITE);
            btnUOConfirm.setBackgroundColor(color1);
            btnUOBack.setBackgroundColor(color1);
            btnUORes.setBackgroundColor(color1);
            tvUOTopic.setTextColor(Color.WHITE);
            tvUOAgenda.setTextColor(Color.WHITE);
            btnUOBack.setTextColor(Color.WHITE);
            btnUORes.setTextColor(Color.WHITE);
            btnUOConfirm.setTextColor(Color.WHITE);
        }
        else
        {
            tvUnesco.setTextColor(color2);
            tvUnesco.setBackgroundColor(Color.BLACK);
            btnUOConfirm.setBackgroundColor(Color.BLACK);
            btnUOBack.setBackgroundColor(Color.BLACK);
            btnUORes.setBackgroundColor(Color.BLACK);
            tvUOTopic.setTextColor(Color.BLACK);
            tvUOAgenda.setTextColor(Color.BLACK);
            btnUOBack.setTextColor(color2);
            btnUORes.setTextColor(color2);
            btnUOConfirm.setTextColor(color2);

        }

        btnUORes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.unesco.org/new/en/social-and-human-sciences/resources/periodicals/diversities/current-issue/multiculturalism-or-hybridisation-cultural-mixing-and-politics/"));
                startActivity(intent);
            }
        });

        btnUOBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Unesco.this,simrn.programme.co.registrationformfordjmun.Committee.class);
                startActivity(intent);
                finish();
            }
        });

        btnUOConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Unesco.this,simrn.programme.co.registrationformfordjmun.Confirmation.class);
                intent.putExtra("committee","UNESCO");
                startActivity(intent);
                finish();
            }
        });
    }
}
