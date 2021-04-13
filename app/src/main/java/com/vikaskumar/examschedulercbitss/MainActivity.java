package com.vikaskumar.examschedulercbitss;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.vikaskumar.examschedulercbitss.Adapters.CategoryAdapter;
import com.vikaskumar.examschedulercbitss.Models.CategoryModel;
import com.vikaskumar.examschedulercbitss.Utility.NeTWorkChange;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    FirebaseAuth firebaseAuth;
    private RecyclerView recyclerView;
    NeTWorkChange neTWorkChange = new NeTWorkChange();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        firebaseAuth = FirebaseAuth.getInstance();
        recyclerView = findViewById(R.id.recycler_view);

        List<CategoryModel> list = new ArrayList<>();
        list.add(new CategoryModel("IT Cources", R.drawable.cbitss));
        list.add(new CategoryModel("Accounting", R.drawable.cbitss));
        list.add(new CategoryModel("English", R.drawable.cbitss));
        list.add(new CategoryModel("Project", R.drawable.cbitss));
        list.add(new CategoryModel("Certification", R.drawable.cbitss));
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);

        CategoryAdapter categoryAdapter = new CategoryAdapter(list, getApplicationContext());
        recyclerView.setAdapter(categoryAdapter);

        recyclerView = findViewById(R.id.recycler_view);

        List<CategoryModel> list = new ArrayList<>();
        list.add(new CategoryModel("IT Cources", R.drawable.cbitss));
        list.add(new CategoryModel("Accounting", R.drawable.cbitss));
        list.add(new CategoryModel("English", R.drawable.cbitss));
        list.add(new CategoryModel("Project", R.drawable.cbitss));
        list.add(new CategoryModel("Certification", R.drawable.cbitss));
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);

        CategoryAdapter categoryAdapter = new CategoryAdapter(list, getApplicationContext());
        recyclerView.setAdapter(categoryAdapter);

        // RecyclerView
        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
<<<<<<< HEAD
        // Set its Properties
=======
// Set its Properties
>>>>>>> b50da9c57b53ec83b3a1a4750d0d6fba80a094c4
        //grid view with 2 columns in each row
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // Adapter

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void layoutAnimation(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_right);

        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_logout)
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Logout");
            builder.setIcon(R.drawable.exit_to_app_24);
            builder.setMessage("Are You Sure Want to Logout?")
                    .setNegativeButton("No", null)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            firebaseAuth.signOut();
                            Intent intent = new Intent(MainActivity.this ,RegisterActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }).show();
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

     int id = item.getItemId();

     if (id== R.id.nav_status)
     {
         Intent intent =  new Intent(MainActivity.this, StatusActivity.class);
         startActivity(intent);
         finish();

     }
        if (id == R.id.share) {
            try
            {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Share Texting");
                String shareMsg = "https://play.google.com/store/apps/details?id="+ BuildConfig.APPLICATION_ID+"\n";
                intent.putExtra(Intent.EXTRA_TEXT, shareMsg);
                startActivity(Intent.createChooser(intent, "ShareVia"));
            }
            catch (Exception e)
            {
                Toast.makeText(MainActivity.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        if (id == R.id.contactUs)
        {
            String[] TO_EMAILS = {"counselor.cbitss@gmail.com"};
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, TO_EMAILS);

            intent.putExtra(Intent.EXTRA_SUBJECT, "this is the subject");
            intent.putExtra(Intent.EXTRA_TEXT, "this is the body of email");

            startActivity(Intent.createChooser(intent, "Choose one Application"));

        }
        if (id == R.id.qrCode)
        {
            Intent intent =  new Intent(MainActivity.this, QRActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.info)
        {
            Intent intent =  new Intent(MainActivity.this, InfoActivity.class);
            startActivity(intent);
            finish();
        }
        if (id == R.id.privacy_policy)
        {
            Intent intent =  new Intent(MainActivity.this, PrivacyPolicy.class);
            startActivity(intent);
            finish();
        }

        if (id == R.id.logout)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Logout");
            builder.setIcon(R.drawable.exit_to_app_24);
            builder.setMessage("Are You Sure Want to Logout?")
                    .setNegativeButton("No", null)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            firebaseAuth.signOut();
                            Intent intent = new Intent(MainActivity.this ,RegisterActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("EXIT");
        builder.setIcon(R.drawable.exit_to_app_24);
        builder.setMessage("Are You Sure Want to Exit?")
                .setNegativeButton("No", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                }).show();
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(neTWorkChange, intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(neTWorkChange);
        super.onStop();
    }
}