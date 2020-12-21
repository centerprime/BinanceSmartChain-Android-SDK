package com.centerprime.binance_smart_chain_sdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.BigInteger;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    BinanceManager binanceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binanceManager = BinanceManager.getInstance();
        //binanceManager.init("https://data-seed-prebsc-1-s1.binance.org:8545");
        binanceManager.init("https://bsc-dataseed1.binance.org:443");



/*        binanceManager.createWallet("12345", this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    String walletAddress = wallet.getAddress();

                    String keystore = wallet.getKeystore();
                    System.out.println("*** ***"+walletAddress);
                }, error -> {
                    System.out.println(error);
                });*/



    }


}