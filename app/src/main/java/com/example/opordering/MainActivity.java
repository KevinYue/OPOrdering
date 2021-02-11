package com.example.opordering;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavController navController;
    private BottomNavigationView bottomNavigationView;
    //private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up navigation drawer
        setupNavigationDrawer();

        // Set up bottom navigation
        setupBottomNavigation();
    }

    private void setupBottomNavigation() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Getting the navigation host fragment
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.navHostFragment);

        // Set up the bottom navigation view with the navigation controller
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());
    }

    // Set up the navigation drawer
    private void setupNavigationDrawer() {
        Toolbar toolbar = findViewById(R.id.toolbar);

        // Tell to use the toolbar as the actionbar
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.navigationView);

        drawerLayout = findViewById(R.id.drawer_layout);
        navController = Navigation.findNavController(this, R.id.navHostFragment);

        // Create a set with the top-level destinations
        Set<Integer> topLevelDestination = new HashSet<>();
        topLevelDestination.add(R.id.menu_dest);
        topLevelDestination.add(R.id.news_dest);
        topLevelDestination.add(R.id.order_dest);
        topLevelDestination.add(R.id.addnews_dest);

        // Set the "UP"-navigation away between top-level destination
        AppBarConfiguration configuration = new AppBarConfiguration
                .Builder(topLevelDestination)
                .setOpenableLayout(drawerLayout)
                .build();

        // Sets up the toolbar together with the drawer, with top-level config (enables click on toolbar to show drawer)
        NavigationUI.setupWithNavController(toolbar, navController, configuration);

        // navController with the navigation drawer
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    // Control the navigation selection for each we should choose in the navigation drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Sets the item to checked
        item.isChecked();

        // Close the drawer
        drawerLayout.closeDrawers();

        // Getting which destination item we are pressed
        switch (item.getItemId()) {
            case R.id.news_dest:
                Toast.makeText(this, "nyheter liste", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_dest:
                Toast.makeText(this, "menu liste", Toast.LENGTH_SHORT).show();
                break;
            case R.id.order_dest:
                Toast.makeText(this, "operasjon liste", Toast.LENGTH_SHORT).show();
                break;
            case R.id.addnews_dest:
                Toast.makeText(this, "legg til nyheter liste", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}