package net.devcamp.animewatch;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_nav);
        navigation.setOnNavigationItemSelectedListener(this);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_hari_ini);
//        setSupportActionBar(toolbar);
//
//        Objects.requireNonNull(getSupportActionBar()).setTitle("Hari Ini");
        navigation.setSelectedItemId(R.id.btm_beranda);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_utama, fragment)
                    .commit();

            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()){

            case R.id.btm_jadwal:
                fragment = new JadwalFragment();
                break;
            case R.id.btm_beranda:
                fragment = new BerandaFragment();
                break;
            case R.id.btm_genre:
                fragment = new GenreFragment();
                break;
        }

        return loadFragment(fragment);
    }
}
