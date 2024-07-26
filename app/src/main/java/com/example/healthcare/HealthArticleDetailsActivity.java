package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticleDetailsActivity extends AppCompatActivity {
    TextView tv;
    ImageView img;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article_details);
        btnBack =findViewById(R.id.buttonHADBack);
        tv = findViewById(R.id.textViewHADTitle);
        img = findViewById(R.id.imageView);
        Intent it = getIntent();
        tv.setText(it.getStringExtra("text1"));
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            int resID = bundle.getInt("text2");
            img.setImageResource(resID);

        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticleDetailsActivity.this, HealthArticlesActivity.class));
            }
        });
    }
}