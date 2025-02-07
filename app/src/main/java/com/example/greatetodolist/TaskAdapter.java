package com.example.greatetodolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList; // danh sách task

    public TaskAdapter(List<Task> _taskList){ // khởi tạo adapter với danh sách task
        this.taskList = _taskList;
    }

    // ViewHolder sinh ra với nhiệm vụ tạo ra 1 thành phần giao diện từ xml tương ứng
    // Khởi tạo ViewHolder để hiển thị
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); // chuyển đổi xml sang view
        // chuyển đổi 1 thành phần xml (là 1 task) sang thành 1 dòng trong recycler view
        View view = inflater.inflate(R.layout.item_task, parent, false); // chuyển đổi xml sang view

        return new TaskViewHolder(view);
    }

    @Override // gán giá trị cho các thành phần giao diện trong ViewHolder
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position); // lấy ra 1 task
        holder.taskNameTextView.setText(task.taskName); // lấy ra tên của task
        holder.taskPriorityTextView.setText(String.valueOf(task.taskPriority)); // lấy ra độ ưu tiên của task
        holder.completedCheckBox.setChecked(task.isCompleted); // lấy ra trạng thái của task
    }

    @Override
    public int getItemCount() {
        return taskList.size(); // trả về số lượng task
    }

    // tham chiếu đến các thành phần giao diện trong item_task.xml
    class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView taskNameTextView;
//        private TextView taskDescriptionTextView; // TODO: xử lý sau
        private TextView taskPriorityTextView;
        private CheckBox completedCheckBox;

        public TaskViewHolder(View itemView) {
            super(itemView);
            taskNameTextView = itemView.findViewById(R.id.taskNameTextView);
//            taskDescriptionTextView = itemView.findViewById(R.id.taskDescriptionTextView); // TODO: xử lý sau
            taskPriorityTextView = itemView.findViewById(R.id.taskPriorityTextView);

            completedCheckBox = itemView.findViewById(R.id.completedCheckBox);

        }
    }

}
