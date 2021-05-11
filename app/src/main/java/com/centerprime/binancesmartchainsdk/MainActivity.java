package com.centerprime.binancesmartchainsdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.centerprime.binance_smart_chain_sdk.BinanceManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    BinanceManager binanceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binanceManager = BinanceManager.getInstance();
        binanceManager.init("https://data-seed-prebsc-1-s1.binance.org:8545");
       // binanceManager.init("https://bsc-dataseed1.binance.org:443");

        binanceManager.createWallet("12345", this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    String walletAddress = wallet.getAddress();
                    String keystore = wallet.getKeystore();
                    System.out.println("*** ***"+walletAddress);
                    Toast.makeText(this, walletAddress, Toast.LENGTH_SHORT).show();
                }, error -> {
                    System.out.println(error);
                });

        binanceManager.searchTokenByContractAddress("0xb1c65a356d5e26e44301891475e9480786e0904a",
                "0xf7d5b330ab0fbbb86e872d7e3a888ee56e33b10e",
                "12345",
                this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    String decimals = wallet.getDecimals();
                    String symbol = wallet.getSymbol();
                    System.out.println("*** ***"+symbol);
                    System.out.println("*** ***"+decimals);
                }, error -> {
                    System.out.println(error);
                });

        binanceManager.getTokenBalance("0xf7d5b330ab0fbbb86e872d7e3a888ee56e33b10e", "12345", "0x2170ed0880ac9a755fd29b2688956bd959f933f8", this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    System.out.println(wallet.toString());
                }, error -> {
                    System.out.println(error);
                });
    }
}