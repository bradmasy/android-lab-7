package brad.masciotra.lab7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import brad.masciotra.lab7.fragments.FruitFragment;
import brad.masciotra.lab7.fragments.SeafoodFragment;
import brad.masciotra.lab7.fragments.VeggiesFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
   // FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
       // fm = getSupportFragmentManager();

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new VeggiesFragment()).commit();




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch(item.getItemId())  {
            case R.id.vegg:
                fragment = new VeggiesFragment();
                Log.d("Veggies", ": here");
                break;
            case R.id.seafood:
                fragment = new SeafoodFragment();
                break;
            case R.id.fruit:
                fragment = new FruitFragment();
                break;
            default:
        }

        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
            Log.d("fragment not null", ": here");

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}