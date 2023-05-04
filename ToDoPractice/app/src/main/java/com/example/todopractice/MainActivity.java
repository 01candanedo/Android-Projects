package com.example.todopractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todopractice.utils.MyAdapter;
import com.example.todopractice.utils.Tasks;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView todolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeControls();

        this.InitializeControls();
        this.LoadListViewTemplate();
    }

    private void InitializeControls(){
        todolist = (ListView) findViewById(R.id.lstTasks);
        todolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String taskselected = ((TextView)view.findViewById(R.id.txtTaskTitle)).getText().toString();
                Toast.makeText(MainActivity.this, "To-Do Selected: "+taskselected, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void LoadListViewTemplate()
    {
        List<Tasks> data = this.GetElementsToListViewTemplate();

        MyAdapter adapter = new MyAdapter(this, data);

        todolist.setAdapter(adapter);
    }

    private List<Tasks> GetElementsToListViewTemplate(){
        List<Tasks> todo = new ArrayList<Tasks>();
        todo.add(new Tasks("Practicar ds6", "maxima", "practicar mucho"));
        todo.add(new Tasks("Practicar Administracion", "intensa", "y practicar mucho"));
        return todo;
    }

}