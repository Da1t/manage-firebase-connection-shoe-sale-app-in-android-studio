package com.example.dean;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    public CartViewModel(@NonNull Application application) {
        super(application);
        cartRepo= new CartRepo(application);
    }
    private CartRepo cartRepo;
    public LiveData<List<ShoeCart>> getAllCartItems(){
        return cartRepo.getAllCartItemsLiveData();
    }

    public void insertCartItem(ShoeCart shoeCart){
        cartRepo.insertCartItem(shoeCart);
    }
    public void updatePrice(int id,double price){
        cartRepo.updatePrice(id, price);
    }
    public void updateQuantity(int id,int quantity){
        cartRepo.updateQuantity(id, quantity);
    }
    public void deleteCartItem(ShoeCart shoeCart){
        cartRepo.deleteCartItem(shoeCart);
    }
    public void deleteAllCartItems( ){
        cartRepo.deleteAllCartItems();
    }
}
