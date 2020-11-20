# Binance SmartChain Client SDK 


## Table of Contents

- [Getting Started](#getting-started)
  - [Adding Binance SmartChain SDK as a Maven Dependency](#adding-binance-smartchain-sdk-as-a-maven-dependency)
  - [Basic Usage](#basic-usage)
- [Features at a Glance](#features-at-a-glance)
  - [Create Wallet](#create-wallet)
  - [Import Wallet By Keystore](#import-wallet-by-keystore)
  - [Import Wallet By Private Key](#import-wallet-by-private-key)
  - [BNB Balance](#bnb-balance)
  - [BEP20 token balance](#bep20-token-balance)
  - [Send BNB](#send-bnb)
  - [Send BEP20 Token](#send-bep20-token)

## Getting Started

### Adding Binance SmartChain Client SDK as a Maven Dependency

Maven:

```xml
<dependency>
	    <groupId>com.github.centerprime</groupId>
	    <artifactId>Binance-Chain-Client-SDK</artifactId>
	    <version>1.0.7</version>
</dependency>
```

Gradle:

```groovy
dependencies {
    implementation 'com.github.centerprime:Binance-Chain-Client-SDK:1.0.9'
}
```

### Basic Usage

Once you have the dependencies set up you can start using *CenterPrime* by creating a `Binance SmartChain Wallet`:

```java

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
                    String walletAddress = wallet.getAddress();
                    String keystore = wallet.getKeystore();
                }, error -> {
                    System.out.println(error);
                });
    }
}
```

*Congratulations!* Now you are a *CenterPrime* user.

## Features at a Glance

### Create Wallet

> You can create Binance SmartChian Wallet.
```java
BinanceManager binanceManager = BinanceManager.getInstance();

binanceManager.createWallet("12345", this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    String walletAddress = wallet.getAddress();
                    String keystore = wallet.getKeystore();
                }, error -> {
                    System.out.println(error);
                });

```

### Import Wallet By Keystore

> Import Binance SmartChain Wallet by Keystore.

```java
BinanceManager binanceManager = BinanceManager.getInstance();
String password = "xxxx12345";
String keystore = "JSON_FORMAT";
binanceManager.importFromKeystore(keystore, password, this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(walletAddress -> {

                    Toast.makeText(this, "Wallet Address : " + walletAddress, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```
### Import Wallet By Private Key

> Import Wallet By Private Key.

```java
BinanceManager binanceManager = BinanceManager.getInstance();
String privateKey = "PRIVATE_KEY";
binanceManager.importFromPrivateKey(privateKey, this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(walletAddress -> {

                    Toast.makeText(this, "Wallet Address : " + walletAddress, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```


### BNB Balance

> BNB Balance.

```java
BinanceManager binanceManager = BinanceManager.getInstance();
binanceManager.init("https://data-seed-prebsc-1-s1.binance.org:8545");
String walletAddress = "WALLET_ADDRESS";
binanceManager.getBNBBalance(walletAddress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(balance -> {

                    Toast.makeText(this, "Eth Balance : " + balance, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```
### BEP20 token balance

> BEP20 token balance.

```java
BinanceManager binanceManager = BinanceManager.getInstance();
binanceManager.init("https://data-seed-prebsc-1-s1.binance.org:8545");
String walletAddress = "WALLET_ADDRESS";
String password = "WALLET_PASSWORD";
String bep20TokenContractAddress = "BEP_20_TOKEN_CONTRACT_ADDRESS";
binanceManager.getTokenBalance(walletAddress, password, bep20TokenContractAddress, this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(balance -> {

                    Toast.makeText(this, "Token Balance : " + balance, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```

### Send BNB

> Send BNB.

```java
BinanceManager binanceManager = BinanceManager.getInstance();
binanceManager.init("https://data-seed-prebsc-1-s1.binance.org:8545");
String walletAddress = "WALLET_ADDRESS";
String password = "WALLET_PASSWORD";
BigInteger gasPrice = new BigInteger("GAS_PRICE");
BigInteger gasLimit = new BigInteger("GAS_LIMIT");
BigDecimal bnbAmount = new BigDecimal("BNB_AMOUNT");
String receiverAddress = "RECEIVER_WALLET_ADDRESS";
binanceManager.sendBNB(walletAddress, password,gasPrice,gasLimit,bnbAmount, receiverAddress, this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tx -> {

                    Toast.makeText(this, "TX : " + tx, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```
### Send BEP20 token

> Send BEP20 token.

```java
BinanceManager binanceManager = BinanceManager.getInstance();
binanceManager.init("https://data-seed-prebsc-1-s1.binance.org:8545");
String walletAddress = "WALLET_ADDRESS";
String password = "WALLET_PASSWORD";
BigInteger gasPrice = new BigInteger("GAS_PRICE");
BigInteger gasLimit = new BigInteger("GAS_LIMIT");
BigDecimal tokenAmount = new BigDecimal("TOKEN_AMOUNT");
String receiverAddress = "RECEIVER_WALLET_ADDRESS";
String bep20TokenContractAddress = "BEP20_TOKEN_CONTRACT_ADDRESS";
ethManager.sendToken(walletAddress, password, gasPrice, gasLimit, tokenAmount, receiverAddress, bep20TokenContractAddress, this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tx -> {

                    Toast.makeText(this, "TX : " + tx, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```

