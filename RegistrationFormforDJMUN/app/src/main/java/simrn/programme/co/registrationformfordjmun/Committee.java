package simrn.programme.co.registrationformfordjmun;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Committee extends AppCompatActivity {

    TextView tvChoose;
    ImageButton ibSc,ibUnesco,ibUnicef,ibWho;
    LinearLayout layoutCommittee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_committee);

        tvChoose=findViewById(R.id.tvChoose);
        ibSc=findViewById(R.id.ibSc);
        ibUnesco=findViewById(R.id.ibUnesco);
        ibUnicef=findViewById(R.id.ibUnicef);
        ibWho=findViewById(R.id.ibWho);
        layoutCommittee=findViewById(R.id.layoutCommittee);

        SharedPreferences preffs = getSharedPreferences("ChangeBkg",0);
        Boolean change=preffs.getBoolean("color",false);

        if(change==true)
        {
            layoutCommittee.setBackgroundColor(Color.BLACK);
            tvChoose.setTextColor(Color.WHITE);
        }
        else{
            tvChoose.setTextColor(Color.BLACK);
        }

        ibSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Committee.this,simrn.programme.co.registrationformfordjmun.SecurityCouncil.class);
                startActivity(intent);
                finish();


            }
        });

        ibUnicef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Committee.this,simrn.programme.co.registrationformfordjmun.Unicef.class);
                startActivity(intent);
                finish();


            }
        });

        ibUnesco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Committee.this,simrn.programme.co.registrationformfordjmun.Unesco.class);
                startActivity(intent);
                finish();

            }
        });

        ibWho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Committee.this,simrn.programme.co.registrationformfordjmun.WHO.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
