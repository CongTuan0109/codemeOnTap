package com.example.listsv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    Button btngetjson;
    EditText edittext;
    SinhVien sinhvien;
    ArraylistSV arraylistSV=new ArraylistSV();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            InputStream inputStream =getAssets().open("son.json");
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder=new StringBuilder();
            String line=bufferedReader.readLine();

            while(line!=null)
            {
                stringBuilder.append(line);
                line=bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            //edittext.setText(stringBuilder.toString());

            //Qua trinh dua file thanh danh sach
            JSONObject jsonObject=new JSONObject(stringBuilder.toString());
            JSONArray jsonArray=jsonObject.getJSONArray("Sinhviens");
            JSONObject obj;
            for(int i=0;i<jsonArray.length();i++)
            {
                obj=jsonArray.getJSONObject(i);
                sinhvien=new SinhVien(
                        obj.getString("ten"),
                        obj.getInt("namsinh"),
                        obj.getString("lop")
                );
                arraylistSV.addSinhVien(sinhvien);
            }

            ListView lv=findViewById(R.id.listDSSV);
            SVadapter sVadapter=new SVadapter(this,R.layout.layoutdong,arraylistSV.dssv);
            lv.setAdapter(sVadapter);



        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
