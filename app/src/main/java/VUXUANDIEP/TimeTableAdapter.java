package VUXUANDIEP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anassert.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.ViewHolder> {
    Context context;
    ArrayList<TimeTable> listtimetable;

    public TimeTableAdapter(Context context, ArrayList<TimeTable> listtimetable) {
        this.context = context;
        this.listtimetable = listtimetable;
    }
    public void setFilteredList(ArrayList<TimeTable> filteredList){
        this.listtimetable=filteredList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // gán view
        View view = LayoutInflater.from(context).inflate(R.layout.item_timetable, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Gán dữ liêuk
        TimeTable timeTable = listtimetable.get(position);
        holder.txtDate.setText(timeTable.getDate());
        holder.txtDay.setText(timeTable.getDay());
        holder.txtSubject.setText(timeTable.getSubject());
        holder.txtTime.setText(timeTable.getTime());
        holder.txtTeacher.setText(timeTable.getTeacher());
        holder.txtLocation.setText(timeTable.getLocation());
        holder.txtRoom.setText(timeTable.getRoom());
    }

    @Override
    public int getItemCount() {
        return listtimetable.size(); // trả item tại vị trí postion
    }



    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtDate,txtDay,txtSubject,txtTeacher,txtLocation,txtTime,txtRoom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            txtDate = itemView.findViewById(R.id.txtDate);
            txtDay = itemView.findViewById(R.id.txtDay);
            txtSubject = itemView.findViewById(R.id.txtSubject);
            txtTeacher = itemView.findViewById(R.id.txtTeacher);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtRoom = itemView.findViewById(R.id.txtRoom);
        }
    }
}
