package VUXUANDIEP;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anassert.R;

import java.util.ArrayList;

public class MainTimetable extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView rcv;
    private LinearLayoutManager linearLayoutManager;
    ArrayList<TimeTable > listtb;
    TimeTableAdapter timeTableAdapter;
    private SearchView searchView;
    private TimeTableAdapter adapter;
    private ArrayList<TimeTable> list ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        recyclerView = findViewById(R.id.recyclerview);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //vd4 set back button
        ActionBar actionBar = getSupportActionBar();
        String tab = "";
        for (int i = 0; i <8; i++) {
            tab += "\t";
        }
        actionBar.setTitle(tab+"Thời khoá biểu");
        actionBar.setDisplayHomeAsUpEnabled(true);
        fakeData();
    }
    private void FinterList(String text) {
        ArrayList<TimeTable> filteredList=new ArrayList<>();
        //     list=dao.getAll();
        for (TimeTable person: list){
            if (person.getDay().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(person);
            }

        }
        if (filteredList.isEmpty()){
            Toast.makeText(MainTimetable.this, "Không thấy dữ liệu", Toast.LENGTH_SHORT).show();
        }else {
            adapter.setFilteredList(filteredList);
        }
    }
    private void fakeData(){
        listtb = new ArrayList<>();
        String day[] = {"Thứ 2","Thứ 2","Thứ 5","Thứ 5","Thứ 6","Thứ 6","Thứ 7","Chủ nhật"};
        String date[] = {"2/10","2/10","5/10","5/10","6/10","6/10","7/10","8/10"};
        String subject[] = {"Thiết kế web","Tiếng Anh công nghệ thông tin 1","Phát triển ứng dụng trên thiết bị di động",
                "Tiếng Anh công nghệ thông tin 1","Trí tuệ nhân tạo","Thiết kế 2D",
                "Phát triển ứng dụng trên thiết bị di động", "Thực tập cơ sở ngành"};
        String teacher[] = {"Nguyễn Trung Phú(0902131386 - CNTT)","Bùi Phương Thảo(0389937161 - Trường NN-DL)",
                "Nguyễn Đức Lưu(097968010 - CNTT)","Bùi Phương Thảo(0389937161 - Trường NN-DL)",
                "Nguyễn Lan Anh(0399595054 - CNTT)","Đỗ Mạnh Hùng(0916113319 - CNTT)",
                "Vũ Thị Dương(0904755919 - CNTT)","Đoàn Văn Trung(0358218310 - CNTT)"};
        String room[] = {"701-A1","508-A9","305-A9","508-A9","609-A9","609-A9","401-A9","Phòng thực hành \nKhoa CNTT 06"};
        String time[] = {"1,2,3","7,8","1,2,3","7,8","3,4,5","9,10,11","7,8,9","1,2,3,4,5,\n7,8,9,10,11"};
        String location[] = {"Cơ sở 1 - Khu A"};
        for(int i = 0;i<day.length;i++) {
            listtb.add(new TimeTable(day[i],date[i],subject[i],teacher[i],room[i],time[i],location[0] ));
        }
        //listtb.add(new TimeTable("T2","2/10","Tieng Anh","Thao","508-A9","1,2","C1"));
        timeTableAdapter = new TimeTableAdapter(getApplicationContext(),listtb);
        recyclerView.setAdapter(timeTableAdapter);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudiep,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.action_report) {
            Toast.makeText(getApplicationContext(), "Chức năng đang trong quá trình phát triển",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id==R.id.action_close) {
            finish();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);
    }

}