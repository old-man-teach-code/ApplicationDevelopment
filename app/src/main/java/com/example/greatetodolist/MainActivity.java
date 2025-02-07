package com.example.greatetodolist;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Ứng dụng được khởi chạy
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView); // tham chiếu đến recycler view trong activity_main.xml
        addButton = findViewById(R.id.button); // tham chiếu đến button trong activity_main.xml

        if (TempMemory.tasks == null){
            TempMemory.tasks = new ArrayList<>();
            // thêm 100 task vào danh sách
            for (int i = 0; i < 100; i++){
                TempMemory.tasks.add(new Task("Task " + i, "Description " + i, false, 3));
            }
        }

        taskAdapter = new TaskAdapter(TempMemory.tasks); // khởi tạo adapter với danh sách task
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // thiết lập layout cho recycler view
        recyclerView.setAdapter(taskAdapter); // thiết lập adapter cho recycler view

    }
}