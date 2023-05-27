package com.example.dean;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.ImageView;


import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class GiaoDienActivity extends AppCompatActivity implements ShoeItemAdapter.ShoeClickedListeners {

DrawerLayout drawerLayout;
NavigationView navigationView;
ActionBarDrawerToggle actionBarDrawerToggle;


    private List<ShoeItem> shoeItemList;
    private ShoeItemAdapter adapter;
    private CartViewModel viewModel;
    private List<ShoeCart> shoeCartList;
 //   private CoordinatorLayout coordinatorLayout;

    private ImageView cartImageView;
    private RecyclerView recyclerView;

   // @Override
  //  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
   //     if(actionBarDrawerToggle.onOptionsItemSelected(item)){
    //        return true;
    //    }

//        return super.onOptionsItemSelected(item);
  //  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_giao_dien);
//drawerLayout = findViewById(R.id.coordinatorLayout);
drawerLayout = findViewById(R.id.drawerlayout);
navigationView = findViewById(R.id.nav_view);
actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);


 //actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
 drawerLayout.addDrawerListener(actionBarDrawerToggle);

actionBarDrawerToggle.syncState();
//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
 switch (item.getItemId()){
    case R.id.home:
        Log.i("Menu ","Home item id click");

        drawerLayout.closeDrawer(GravityCompat.START);
        break;
   //  case R.id.edit:
    //    Log.i("Menu ","Edit item id click");
    //     startActivity(new Intent(GiaoDienActivity.this, EditProfileActivity.class));
    //    drawerLayout.closeDrawer(GravityCompat.START);
    //    break;
     case R.id.product:
        Log.i("Menu ","Product item id click");
         startActivity(new Intent(GiaoDienActivity.this, ProductActivity.class));
        drawerLayout.closeDrawer(GravityCompat.START);
        break;
     case R.id.report:
         Log.i("Menu ","Report item id click");
         startActivity(new Intent(GiaoDienActivity.this, ReportActivity.class));
         drawerLayout.closeDrawer(GravityCompat.START);
         break;
    case R.id.logout:
        Log.i("Menu ","Logout item id click");
        drawerLayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent(GiaoDienActivity.this, MainActivity.class));
        break;
}

       return true;
    }
});




        initializeVariables();
        setUpList();

        //replaceFragment(new );

        adapter.setShoeItemList(shoeItemList);
        recyclerView.setAdapter(adapter);

       // binding = ActivityMainBinding.inflate(getLayoutInflater());

     //   binding.bottomnavi.setOnItemSelectedListener(item -> {
         //   switch (item.getItemId()) {
             //   case R.id.home:
             //       replaceFragment(new GiaoDienActivity());
              //      break;
            //    case R.id.about:
                    //replaceFragment(new AboutFragment());
           //         break;
          //      case R.id.setting:
          //          replaceFragment(new SettingFragment());
          //          break;
         //       case R.id.library:
          //          replaceFragment(new LibraryFragment());
          //          break;
        //    }
       //     return true;
    //    });


    }

    private void setUpList() {
        shoeItemList.add(new ShoeItem("Nike Revolution", "NIKE", R.drawable.nike_revolution_road, 15));
        shoeItemList.add(new ShoeItem("Nike Flex Run 2021", "NIKE", R.drawable.flex_run_road_running, 20));
        shoeItemList.add(new ShoeItem("Court Zoom Vapor", "NIKE", R.drawable.nikecourt_zoom_vapor_cage, 18));
        shoeItemList.add(new ShoeItem("EQ21 Run COLD.RDY", "ADIDAS", R.drawable.adidas_eq_run, 16.5));
        shoeItemList.add(new ShoeItem("Adidas Ozelia", "ADIDAS", R.drawable.adidas_ozelia_shoes_grey, 20));
        shoeItemList.add(new ShoeItem("Adidas Questar", "ADIDAS", R.drawable.adidas_questar_shoes, 22));
        shoeItemList.add(new ShoeItem("Nike Air Force 1 '07", "NIKE", R.drawable.img_7, 12));
        shoeItemList.add(new ShoeItem("FORUM MID SHOES", "ADIDAS", R.drawable.img_8, 14.5));
        shoeItemList.add(new ShoeItem("CRAZY 1 SHOES", "ADIDAS", R.drawable.img_9, 18));
        shoeItemList.add(new ShoeItem("D.O.N. ISSUE 4 SHOES", "ADIDAS", R.drawable.img_10, 22));
        shoeItemList.add(new ShoeItem("Nike Air Force 1 High By You", "NIKE", R.drawable.img_11, 37));
        shoeItemList.add(new ShoeItem("Adidas Ultraboost", "ADIDAS", R.drawable.adidas_ultraboost, 15));
    }

    @Override
    protected void onResume() {
        super.onResume();

        viewModel.getAllCartItems().observe(this, new Observer<List<ShoeCart>>() {
            @Override
            public void onChanged(List<ShoeCart> shoeCarts) {
                shoeCartList.addAll(shoeCarts);
            }
        });
    }

    private void initializeVariables() {
        cartImageView = findViewById(R.id.cartIv);
      //  coordinatorLayout = findViewById(R.id.coordinatorLayout);
        drawerLayout = findViewById(R.id.drawerlayout);

      //  drawerLayout = findViewById(R.id.coordinatorLayout);
        shoeCartList = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
        shoeItemList = new ArrayList<>();
        recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        adapter = new ShoeItemAdapter(this);
    }
    @Override
    public void onCardClicked(ShoeItem shoe) {

        Intent intent = new Intent(GiaoDienActivity.this, DetailedActivity.class);
        intent.putExtra("shoeItem", shoe);
        startActivity(intent);
    }

    @Override
    public void onAddToCartBtnClicked(ShoeItem shoeItem) {
        ShoeCart shoeCart = new ShoeCart();
        shoeCart.setShoeName(shoeItem.getShoeName());
        shoeCart.setShoeBrandName(shoeItem.getShoeBrandName());
        shoeCart.setShoePrice(shoeItem.getShoePrice());
        shoeCart.setShoeImage(shoeItem.getShoeImage());

        final int[] quantity = {1};
        final int[] id = new int[1];

        if (!shoeCartList.isEmpty()) {
            for (int i = 0; i < shoeCartList.size(); i++) {
                if (shoeCart.getShoeName().equals(shoeCartList.get(i).getShoeName())) {
                    quantity[0] = shoeCartList.get(i).getQuantity();
                    quantity[0]++;
                    id[0] = shoeCartList.get(i).getId();
                }
            }
        }

        Log.d("TAG", "onAddToCartBtnClicked: " + quantity[0]);

        if (quantity[0] == 1) {
            shoeCart.setQuantity(quantity[0]);
            shoeCart.setTotalItemPrice(quantity[0] * shoeCart.getShoePrice());
            viewModel.insertCartItem(shoeCart);
        } else {
            viewModel.updateQuantity(id[0], quantity[0]);
            viewModel.updatePrice(id[0], quantity[0] * shoeCart.getShoePrice());
        }

        makeSnackBar("Item Added To Cart");
    }

    private void makeSnackBar(String msg) {
     //   Snackbar.make(coordinatorLayout, msg, Snackbar.LENGTH_SHORT).setAction("Go to Cart", new View.OnClickListener() {
      //              @Override
         //           public void onClick(View view) {
         //               startActivity(new Intent(GiaoDienActivity.this, CartActivity.class));
       //            }
     //          }).show();

          Snackbar.make(drawerLayout, msg, Snackbar.LENGTH_SHORT).setAction("Go to Cart", new View.OnClickListener() {
                      @Override
                   public void onClick(View view) {
                      startActivity(new Intent(GiaoDienActivity.this, CartActivity.class));
                  }
                 }).show();



    }

   // private void replaceFragment(Fragment fragment)
   // {
     //   FragmentManager fragmentManager = getSupportFragmentManager();
       // FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       // fragmentTransaction.replace(R.id.frame_layout,fragment);
      //  fragmentTransaction.commit();
   // }
}