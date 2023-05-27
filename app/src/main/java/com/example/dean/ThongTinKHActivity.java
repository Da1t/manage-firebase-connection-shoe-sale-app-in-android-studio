package com.example.dean;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class ThongTinKHActivity extends AppCompatActivity {
    EditText Name, Sex, Phone, Address;

    Button xacnhanBTN;
//private AppCompatButton xacnhanBTN;

    SearchView searchView;

    FirebaseDatabase database;
    DatabaseReference reference;
  //  private CardView cardViewTT;
 //   private CartAdapter cartAdapterTT;
//    private CartViewModel cartViewModelTT;
//    private CardView cardView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khactivity);
        initializeVariables();
        Name = findViewById(R.id.namehehe);
        Sex = findViewById(R.id.sex);
        Phone = findViewById(R.id.phone);
        Address = findViewById(R.id.address);
        xacnhanBTN = findViewById(R.id.XacnhanButton);

        xacnhanBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //      cardView.setVisibility(View.VISIBLE);
          //      cartViewModelTT.deleteAllCartItems();
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Thông tin khách hàng");
                String name = Name.getText().toString();
                String sex = Sex.getText().toString();
                String phone = Phone.getText().toString();
                String address = Address.getText().toString();

                HelpKH helpKH = new HelpKH(name,sex,phone,address);
                reference.child(name).setValue(helpKH);
                Intent intent = new Intent(ThongTinKHActivity.this, GiaoDienActivity.class);
                startActivity(intent);

              //  checkCrededentials();
            }
        });
    }


    @SuppressLint("WrongViewCast")
    private void initializeVariables() {
       // cardView = findViewById(R.id.cartActivityCardViewTT);
    xacnhanBTN = findViewById(R.id.XacnhanButton);
    }


}
