package VUXUANDIEP;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.anassert.R;
import java.util.ArrayList;
import android.view.Menu;
import android.view.MenuItem;

public class MainDocument extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView txtUrl;
    Button btnWatch,btnSave,btnReport;
    private LinearLayoutManager linearLayoutManager;
    ArrayList<Document > listdc;
    DocumentAdapter documentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        //vd4 set back button
        ActionBar actionBar = getSupportActionBar();
        String tab = "";
        for (int i = 0; i < 8; i++) {
            tab += "\t";
        }
        actionBar.setTitle(tab+"Tài liệu tham khảo");
        actionBar.setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.recyclerview);
        fackeData();

    }

    private void fackeData(){
        listdc = new ArrayList<>();
        String subjectid[] = {"LP6010","LP6011","LP6004","LP6013","LP6012"};
        String subject[] = {"Triết học","Kinh Tế Chính Trị","Tư tưởng Hồ Chí Minh",
                "Lịch Sử Đảng cộng sản Việt Nam", "Chủ nghĩa xã hội khoa học"};
        String url[] ={"https://lps.haui.edu.vn/vn"};
        String decrible[] = {"Thuộc khoa chính trị - pháp luật"};
        for(int i = 0;i<subjectid.length;i++) {
            listdc.add(new Document("Mã học phần:"+subjectid[i],"Tên học phần:"+subject[i],url[0],decrible[0] ));
        }
        //listtb.add(new TimeTable("T2","2/10","Tieng Anh","Thao","508-A9","1,2","C1"));
        documentAdapter = new DocumentAdapter(getApplicationContext(),listdc);
        recyclerView.setAdapter(documentAdapter);
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