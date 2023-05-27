package com.example.dean;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {



    FloatingActionButton fab;

    DatabaseReference databaseReference;
    ValueEventListener eventListener;
    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
  //  SearchView searchView;
    SearchView searchView;



//private ShoeAdapter myadapter;
// --    SearchView searchView ;
//--    private RecyclerView recyclerView;

 //--   ArrayList<ModelClass> arrayList = new ArrayList<>();
 //--   ArrayList<ModelClass> searchList ;

   // ArrayList<ModelClass> arrayList = new ArrayList<>();
//List<ShoeAdmin> shoeList = new ArrayList<ShoeAdmin>();
//--    String[] shoeList = new String[]{"Nike Revolution","Nike Flex Run 2021","Court Zoom Vapor",
  //--          "EQ21 Run COLD.RDY","Adidas Ozelia","Adidas Ultraboost","Nike Air Force 1 '07","FORUM MID SHOES","CRAZY 1 SHOES","D.O.N. ISSUE 4 SHOES",
 //--           "Nike Air Force 1 High By You"};
 //--   String[] shoeNum = new String[]{"NIKE","NIKE","NIKE","ADIDAS","ADIDAS","ADIDAS","NIKE","ADIDAS","ADIDAS","ADIDAS","NIKE"};
 //--   int[] imgList = new int[]{R.drawable.nike_revolution_road,R.drawable.flex_run_road_running,R.drawable.nikecourt_zoom_vapor_cage,
 //--           R.drawable.adidas_eq_run,R.drawable.adidas_ozelia_shoes_grey,R.drawable.adidas_ultraboost,R.drawable.img_7,R.drawable.img_8,R.drawable.img_9,
 //--           R.drawable.img_10,R.drawable.img_11};

  //  ArrayList<ModelClass> searchList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);



        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        searchView = findViewById(R.id.search);
        searchView.clearFocus();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(AdminActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        AlertDialog.Builder builder = new AlertDialog.Builder(AdminActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        final AlertDialog dialog = builder.create();
        dialog.show();
        dataList = new ArrayList<>();
        adapter = new MyAdapter(AdminActivity.this, dataList);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Sản phẩm sau khi tạo mới");
        dialog.show();

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for(DataSnapshot itemSnapshot:snapshot.getChildren()){
                    DataClass dataClass = itemSnapshot.getValue(DataClass.class);

                  dataClass.setKey(itemSnapshot.getKey());
                   dataList.add(dataClass);
                }
               adapter.notifyDataSetChanged();
               dialog.dismiss();
            }

           @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
       });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return false;
            }
       });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AddEditOne.class);
                startActivity(intent);
            }
        });

        //--      searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        //--        @Override
                    //--         public boolean onQueryTextSubmit(String query) {
        //--        searchList = new ArrayList<>();
        //--        if(query.length()>0){
        //--           for (int i = 0; i < arrayList.size(); i++) {
        //--                if(arrayList.get(i).getShoeName().toUpperCase().contains(query.toUpperCase()) || arrayList.get(i).getShoeNum().toUpperCase().contains(query.toUpperCase())){
        //--                     ModelClass modelClass = new ModelClass();
        //--                    modelClass.setShoeName(arrayList.get(i).getShoeName());
        //--                    modelClass.setShoeNum(arrayList.get(i).getShoeNum());
        //--                    modelClass.setImg(arrayList.get(i).getImg());
        //--                  searchList.add(modelClass);
        //--       }

                    }
    //--             RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(AdminActivity.this);
    //--             recyclerView.setLayoutManager(layoutManager);

    //--             ShoeAdapter shoeAdapter = new ShoeAdapter(AdminActivity.this,searchList);
    //--             recyclerView.setAdapter(shoeAdapter);
    //--           }
//--             else{
                        //--              RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(AdminActivity.this);
                        //--              recyclerView.setLayoutManager(layoutManager);

                        //--             ShoeAdapter shoeAdapter = new ShoeAdapter(AdminActivity.this,searchList);
                        //--              recyclerView.setAdapter(shoeAdapter);
                        //--          }
                        //--          return false;
                        //--       }

                        //--   @Override
//--   public boolean onQueryTextChange(String newText) {
        //--       searchList = new ArrayList<>();
        //--      if(newText.length()>0){
        //--        for (int i = 0; i < arrayList.size(); i++) {
        //--           if(arrayList.get(i).getShoeName().toUpperCase().contains(newText.toUpperCase()) || arrayList.get(i).getShoeNum().toUpperCase().contains(newText.toUpperCase())){
        //--               ModelClass modelClass = new ModelClass();
        //--              modelClass.setShoeName(arrayList.get(i).getShoeName());
        //--             modelClass.setShoeNum(arrayList.get(i).getShoeNum());
        //--              modelClass.setImg(arrayList.get(i).getImg());
        //--            searchList.add(modelClass);
        //--            }

        //--          }
        //--          RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(AdminActivity.this);
        //--           recyclerView.setLayoutManager(layoutManager);

        //--         ShoeAdapter shoeAdapter = new ShoeAdapter(AdminActivity.this,searchList);
        //--          recyclerView.setAdapter(shoeAdapter);
        //--        }
        //--          else{
        //--              RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(AdminActivity.this);
        //--              recyclerView.setLayoutManager(layoutManager);

        //--             ShoeAdapter shoeAdapter = new ShoeAdapter(AdminActivity.this,searchList);
        //--             recyclerView.setAdapter(shoeAdapter);
        //--         }
        //--          return false;
        //--      }
        //--   });

        //--   }

public void searchList(String text){
        ArrayList<DataClass> searchList = new ArrayList<>();
        for(DataClass dataClass:dataList){
            if(dataClass.getDataTitle().toLowerCase().contains(text.toLowerCase())){
                searchList.add(dataClass);
            }
        }
    adapter.searchDataList(searchList);
}



}