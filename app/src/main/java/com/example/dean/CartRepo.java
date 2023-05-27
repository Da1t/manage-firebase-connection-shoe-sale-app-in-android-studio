package com.example.dean;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CartRepo {


    private CartDAO cartDAO;
    private LiveData<List<ShoeCart>> allCartItemsLiveData;

    private Executor executor = Executors.newSingleThreadExecutor();

    public LiveData<List<ShoeCart>> getAllCartItemsLiveData() {
        return allCartItemsLiveData;
    }

    public CartRepo(Application application){

        cartDAO= CartDatabase.getInstance(application).cartDAO();
        allCartItemsLiveData = cartDAO.getAllCartItems();


    }
    public void insertCartItem(final ShoeCart shoeCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.insertCartItem(shoeCart);

            }
        });
    }
    public void deleteCartItem(final ShoeCart shoeCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.deleteCartItem(shoeCart);
            }
        });
    }
    public void updateQuantity(final int id, final int quantity){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.updateQuantity(id, quantity);
            }
        });
    }
    public void updatePrice(final int id, final double price){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.updatePrice(id, price);
            }
        });
    }

    public void deleteAllCartItems(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.deleteAllItems();
            }
        });
    }

}
