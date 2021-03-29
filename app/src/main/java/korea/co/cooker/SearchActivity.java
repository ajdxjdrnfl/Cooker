package korea.co.cooker;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button deleteButton;
    SearchTextAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = findViewById(R.id.recycler_search);
        deleteButton = findViewById(R.id.back_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SearchTextAdapter(getApplicationContext());

        recyclerView.setAdapter(adapter);

        adapter.addItem(new SearchText("박보영"));
        adapter.addItem(new SearchText("박보영 프로필"));
        adapter.addItem(new SearchText("박보영 나이"));
        adapter.addItem(new SearchText("박보영 소속사"));

        adapter.setOnItemClickListener(new SearchTextListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("text", adapter.getItem(position).getText());
                startActivity(intent);
            }
        });


    }
}
