package VUXUANDIEP;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anassert.R;

import java.util.ArrayList;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.ViewHolder> {
    Context context;
    private ArrayList<Document> list;
    ArrayList<Document> listdocument;

    public DocumentAdapter(Context context, ArrayList<Document> listdocment) {
        this.context = context;
        this.listdocument = listdocment;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // gán view
        View view = LayoutInflater.from(context).inflate(R.layout.item_docment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Gán dữ liêuk
        Document document = listdocument.get(position);
        holder.txtSubjectId.setText(document.getSubjectid());
        holder.txtSubject.setText(document.getSubject());
        holder.txtDecrible.setText(document.getDescribe());
        holder.txtUrl.setText(document.getUrl());
        holder.btnWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }

        });
        holder.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Chức năng đang trong qúa trình phát triển",Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Chức năng đang trong qúa trình phát triển",Toast.LENGTH_SHORT).show();
            }
        });
    }

        @Override
    public int getItemCount() {
        return listdocument.size(); // trả item tại vị trí postion
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtSubject,txtSubjectId,txtUrl,txtDecrible;
        Button btnWatch,btnSave,btnReport;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            txtSubject = itemView.findViewById(R.id.txtSubject);
            txtSubjectId = itemView.findViewById(R.id.txtSubjectId);
            txtUrl = itemView.findViewById(R.id.txtUrl);
            txtDecrible = itemView.findViewById(R.id.txtDescribe);
            btnWatch = itemView.findViewById(R.id.btnWatch);
            btnSave = itemView.findViewById(R.id.btnSave);
            btnReport = itemView.findViewById(R.id.btnReport);
        }
    }

}
