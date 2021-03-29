package korea.co.cooker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public FragmentWrite fragmentWrite = new FragmentWrite();
    public FragmentBest fragmentBest = new FragmentBest();
    public FragmentHome fragmentHome = new FragmentHome();
    public FragmentLike fragmentLike = new FragmentLike();
    public FragmentStory fragmentStory = new FragmentStory();
    public Toolbar toolbar;
    FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =  (Toolbar)findViewById(R.id.appbar_toolbar);
        setSupportActionBar(toolbar);



        manager.beginTransaction().add(R.id.container, fragmentHome).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavigationview);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()) {
                    case R.id.menu1:
                        manager.beginTransaction().replace(R.id.container, fragmentHome).commit();
                        toolbar.setTitle("Home");
                        break;

                    case R.id.menu2:
                        manager.beginTransaction().replace(R.id.container, fragmentBest).commit();
                        toolbar.setTitle("Best");
                        break;

                    case R.id.menu3:
                        manager.beginTransaction().replace(R.id.container, fragmentWrite).commit();
                        toolbar.setTitle("Write");
                        break;

                    case R.id.menu4:
                        manager.beginTransaction().replace(R.id.container, fragmentLike).commit();
                        toolbar.setTitle("Like");
                        break;

                    case R.id.menu5:
                        manager.beginTransaction().replace(R.id.container, fragmentStory).commit();
                        toolbar.setTitle("Story");
                        break;
                }
                return true;
                }
            });


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_refresh:
                break;
        }
        return true;
    }

}

