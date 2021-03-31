package korea.co.cooker;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class SearchActivity extends AppCompatActivity {
    FragmentManager manager = getSupportFragmentManager();

    FragmentSearchText textFragment = new FragmentSearchText();
    FragmentSearchResult resultFragment = new FragmentSearchResult();
    Button deleteButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        deleteButton = findViewById(R.id.back_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        manager.beginTransaction().add(R.id.container, textFragment).commit();


    }
    public void replaceResultFragment(){
        if(manager!=null){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.container, resultFragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }
    }


}
