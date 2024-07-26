package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name: Ajit Saste","Hospital Address : Koramangala","Exp : 5yrs","Mobile No:9898989898","600"},
                    {"Doctor Name: Ashutosh","Hospital Address : Agara","Exp : 15yrs","Mobile No:9876543210","900"},
                    {"Doctor Name: Aritra","Hospital Address : Hebbal","Exp : 10yrs","Mobile No:8976543210","800"},
                    {"Doctor Name: Ajay A","Hospital Address : Arekere","Exp : 5yrs","Mobile No:7998989898","500"},
                    {"Doctor Name: Aditya R","Hospital Address : BTM","Exp : 7yrs","Mobile No:9087654321","700"}

            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name: Aniket S","Hospital Address : Koramangala","Exp : 5yrs","Mobile No:9898989898","600"},
                    {"Doctor Name: Ranjit Kumar","Hospital Address : Agara","Exp : 15yrs","Mobile No:9876543210","900"},
                    {"Doctor Name: Rohan J","Hospital Address : Hebbal","Exp : 10yrs","Mobile No:8976543210","800"},
                    {"Doctor Name: Nitya B","Hospital Address : Arekere","Exp : 5yrs","Mobile No:7998989898","500"},
                    {"Doctor Name: Harish R","Hospital Address : BTM","Exp : 7yrs","Mobile No:9087654321","700"}

            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name: Ananya G","Hospital Address : Koramangala","Exp : 5yrs","Mobile No:9898989898","600"},
                    {"Doctor Name: Kunal M","Hospital Address : Agara","Exp : 15yrs","Mobile No:9876543210","900"},
                    {"Doctor Name: Santosh R","Hospital Address : Hebbal","Exp : 10yrs","Mobile No:8976543210","800"},
                    {"Doctor Name: Darshan S","Hospital Address : Arekere","Exp : 5yrs","Mobile No:7998989898","500"},
                    {"Doctor Name: Akash B","Hospital Address : BTM","Exp : 7yrs","Mobile No:9087654321","700"}

            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name: Sujit S","Hospital Address : Koramangala","Exp : 5yrs","Mobile No:9898989898","600"},
                    {"Doctor Name: Aditya T","Hospital Address : Agara","Exp : 15yrs","Mobile No:9876543210","900"},
                    {"Doctor Name: Arun B","Hospital Address : Hebbal","Exp : 10yrs","Mobile No:8976543210","800"},
                    {"Doctor Name: Vijay D","Hospital Address : Arekere","Exp : 5yrs","Mobile No:7998989898","500"},
                    {"Doctor Name: Rahul N","Hospital Address : BTM","Exp : 7yrs","Mobile No:9087654321","700"}

            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name: Kiranmai S","Hospital Address : Koramangala","Exp : 5yrs","Mobile No:9898989898","600"},
                    {"Doctor Name: Krishna M","Hospital Address : Agara","Exp : 15yrs","Mobile No:9876543210","900"},
                    {"Doctor Name: Srinivas S","Hospital Address : Hebbal","Exp : 10yrs","Mobile No:8976543210","800"},
                    {"Doctor Name: Raj D","Hospital Address : Arekere","Exp : 5yrs","Mobile No:7998989898","500"},
                    {"Doctor Name: Prem R","Hospital Address : BTM","Exp : 7yrs","Mobile No:9087654321","700"}

            };

    TextView tv;
    Button btnBack;
    String[][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDTitle);
        btnBack = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Oncologist")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for (int i =0; i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Consultant Fees:" + doctor_details[i][4]+ "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list, R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it  = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}