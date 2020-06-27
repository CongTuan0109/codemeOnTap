package com.example.listsv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SVadapter extends ArrayAdapter<SinhVien> {
    private Context context;
    private int layoutid;
    private List<SinhVien> sinhViens;
    public SVadapter(@NonNull Context context, int resource, @NonNull List<SinhVien> objects) {
        super(context, resource, objects);
        this.context=context;
        layoutid=resource;
        sinhViens=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null)
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutdong,parent,false);

        TextView txtten=convertView.findViewById(R.id.txtTen);
        txtten.setText(sinhViens.get(position).getTen());

        return convertView;
    }
}
