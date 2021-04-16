package com.example.easyfix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private int[] images = {R.drawable.maintenance, R.drawable.brakes, R.drawable.engines,
            R.drawable.batteries, R.drawable.tires, R.drawable.steering,
            R.drawable.cooling, R.drawable.transmission};
    private String[] name = {"Basic maintenance", "Brakes",
            "Engines", "Batteries", "Tires",
            "Steering", "Cooling", "Transmission"};

    private List<itemModal> itemModalList = new ArrayList<>();

    GridView gridView;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
      // bottomNav.setOnNavigationItemReselectedListener((BottomNavigationView.OnNavigationItemReselectedListener) navListener);


        for (int i = 0; i < name.length; i++) {

            itemModal itemModal = new itemModal(images[i], name[i]);
            itemModalList.add(itemModal);

            gridView = findViewById(R.id.gridview);

            customAdapter = new CustomAdapter(itemModalList, this);

            gridView.setAdapter(customAdapter);

        }


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_favorite:
                            selectedFragment = new favoriteFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();

                        case R.id.nav_location:
                            selectedFragment = new LocaitonFragment();


                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };



    public class CustomAdapter extends BaseAdapter {

        private List<itemModal> itemModalList;
        private Context context;

        public CustomAdapter(List<itemModal> itemModalList, Context context) {
            this.itemModalList = itemModalList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemModalList.size();
        }

        @Override
        public Object getItem(int i) {
            return itemModalList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = view;

            itemModal itemModal = itemModalList.get(i);

            if (view1 == null) {
                view1 = LayoutInflater.from(context).inflate(R.layout.row_data, viewGroup, false);
                ImageView imageView = view1.findViewById(R.id.tvimageName);
                TextView tvName = view1.findViewById(R.id.tvName);

                String name = itemModal.getName();
                int image = itemModal.getImage();

                imageView.setImageResource(image);
                tvName.setText(name);


            }

            return view1;

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
            case R.id.action_Login:
                Intent login = new Intent(this, Login.class);
                startActivity(login);
                Toast.makeText(this, "Login", Toast.LENGTH_LONG).show();
                 break;
                 case R.id.action_Settings:
                Intent settings = new Intent(this, SettingsActivity.class);
                startActivity(settings);
                Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();
                break;

            case R.id.action_signup:
                Intent signup = new Intent(this, SignUp.class);
               startActivity(signup);
                Toast.makeText(this, "Signup", Toast.LENGTH_LONG).show();
               break;
         default:

        }

       return super.onOptionsItemSelected(item);

   }


}
