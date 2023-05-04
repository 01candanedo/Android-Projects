package com.example.todopractice.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.todopractice.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Tasks> {
    private List<Tasks> tasks = new ArrayList<>();

    public MyAdapter(Context context, List<Tasks> datos) {
        super(context, R.layout.todo_template, datos);
        this.tasks = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.todo_template, null);

        TextView txttitle = (TextView)item.findViewById(R.id.txtTaskTitle);
        txttitle.setText(tasks.get(position).getTitle());

        TextView txtpriority = (TextView)item.findViewById(R.id.txtPriorityLevel);
        txtpriority.setText(tasks.get(position).getPriority());

        TextView txtdescription = (TextView)item.findViewById(R.id.txtDescription);
        txtdescription.setText(tasks.get(position).getDescription());

        return(item);
    }
}
