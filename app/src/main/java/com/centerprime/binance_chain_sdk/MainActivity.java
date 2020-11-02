package com.centerprime.binance_chain_sdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BinanceManager binanceManager = BinanceManager.getInstance();

        binanceManager.createWallet("12345", this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    System.out.println(wallet);
                }, error -> {
                    System.out.println(error);
                });

        binanceManager.getBNBBalance("0x8902dab5179D5B91F8c1ed8329501374a78A0B4d")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(balance->{
                    System.out.println(balance);
                }, error -> {
                   error.printStackTrace();
                });

    }
}