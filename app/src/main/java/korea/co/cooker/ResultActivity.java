package korea.co.cooker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String text =getIntent().getStringExtra("text");
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }
}
