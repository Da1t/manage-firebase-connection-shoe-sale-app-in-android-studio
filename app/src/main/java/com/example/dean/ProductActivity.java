package com.example.dean;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
SearchView searchView ;
private RecyclerView recyclerView;

ArrayList<ModelClass> arrayList = new ArrayList<>();
ArrayList<ModelClass> searchList ;
String[] shoeList = new String[]{"Nike Revolution","Nike Flex Run 2021","Court Zoom Vapor",
        "EQ21 Run COLD.RDY","Adidas Ozelia","Adidas Ultraboost","Nike Air Force 1 '07","FORUM MID SHOES","CRAZY 1 SHOES","D.O.N. ISSUE 4 SHOES",
        "Nike Air Force 1 High By You"};
String[] shoeNum = new String[]{"NIKE","NIKE","NIKE","ADIDAS","ADIDAS","ADIDAS","NIKE","ADIDAS","ADIDAS","ADIDAS","NIKE"};
int[] imgList = new int[]{R.drawable.nike_revolution_road,R.drawable.flex_run_road_running,R.drawable.nikecourt_zoom_vapor_cage,
        R.drawable.adidas_eq_run,R.drawable.adidas_ozelia_shoes_grey,R.drawable.adidas_ultraboost,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9,
        R.drawable.img_10,R.drawable.img_11};
//DrawerLayout drawerLayout;
 //   NavigationView navigationView;
 //   ActionBarDrawerToggle actionBarDrawerToggle;


  //  private List<ShoeItem> shoeItemList;
 //   private ShoeItemAdapter adapter;
 //   private CartViewModel viewModel;
 //   private List<ShoeCart> shoeCartList;
    //   private CoordinatorLayout coordinatorLayout;

 //   private ImageView cartImageView;
 //   private RecyclerView recyclerView;
 //   private List<ShoeItem> shoelist;
  //  private ShoeItemAdapter itemadapter;


 //   private RecyclerView recyclerView;

    //  RecyclerView recyclerView;
    // ArrayList<ModelClass> arrayList=new ArrayList<>();

    //ArrayList<ShoeItem> arrayList = new ArrayList<>();
  //  String[] shoelist = new String[]{"Nike Revolution", "Nike Flex Run 2021", "Court Zoom Vapor", "EQ21 Run COLD.RDY", "Adidas Ozelia", "Adidas Questar", "Adidas Ultraboost"};

 //   String[] brandname = new String[]{"Nike ", "Nike ", "Nike", "ADIDAS", "Adidas ", "Adidas ", "Adidas "};

 //   int[] imglist = new int[]{R.drawable.nike_revolution_road, R.drawable.flex_run_road_running, R.drawable.nikecourt_zoom_vapor_cage, R.drawable.adidas_eq_run, R.drawable.adidas_ozelia_shoes_grey, R.drawable.adidas_questar_shoes, R.drawable.adidas_ultraboost};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
      //  shoelist = new ArrayList<>();
        //setUpList();
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchview);
        searchView.setIconified(false);
        for (int i = 0; i < shoeList.length; i++) {
            ModelClass modelClass = new ModelClass();
            modelClass.setShoeName(shoeList[i]);
            modelClass.setShoeNum(shoeNum[i]);
            modelClass.setImg(imgList[i]);
            arrayList.add(modelClass);
        }
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ProductActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        ShoeAdapter shoeAdapter = new ShoeAdapter(ProductActivity.this,arrayList);
        recyclerView.setAdapter(shoeAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList = new ArrayList<>();
                if(query.length()>0){
                    for (int i = 0; i < arrayList.size(); i++) {
                        if(arrayList.get(i).getShoeName().toUpperCase().contains(query.toUpperCase()) || arrayList.get(i).getShoeNum().toUpperCase().contains(query.toUpperCase())){
                            ModelClass modelClass = new ModelClass();
                            modelClass.setShoeName(arrayList.get(i).getShoeName());
                            modelClass.setShoeNum(arrayList.get(i).getShoeNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }

                    }
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ProductActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    ShoeAdapter shoeAdapter = new ShoeAdapter(ProductActivity.this,searchList);
                    recyclerView.setAdapter(shoeAdapter);
                }
                else{
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ProductActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    ShoeAdapter shoeAdapter = new ShoeAdapter(ProductActivity.this,searchList);
                    recyclerView.setAdapter(shoeAdapter);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList = new ArrayList<>();
                if(newText.length()>0){
                    for (int i = 0; i < arrayList.size(); i++) {
                        if(arrayList.get(i).getShoeName().toUpperCase().contains(newText.toUpperCase()) || arrayList.get(i).getShoeNum().toUpperCase().contains(newText.toUpperCase())){
                            ModelClass modelClass = new ModelClass();
                            modelClass.setShoeName(arrayList.get(i).getShoeName());
                            modelClass.setShoeNum(arrayList.get(i).getShoeNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }

                    }
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ProductActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    ShoeAdapter shoeAdapter = new ShoeAdapter(ProductActivity.this,searchList);
                    recyclerView.setAdapter(shoeAdapter);
                }
                else{
                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(ProductActivity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    ShoeAdapter shoeAdapter = new ShoeAdapter(ProductActivity.this,searchList);
                    recyclerView.setAdapter(shoeAdapter);
                }
                return false;
            }
        });

    }



}






