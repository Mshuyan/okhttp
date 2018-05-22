package com.shuyan.demo3_header;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;

public class demo1 {
    private final OkHttpClient client = new OkHttpClient();

    @Test
    public void run() throws Exception {
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/square/okhttp/issues")
                //设置单值请求头，同名请求头使用header方法设置2次，前面的将被覆盖
                .header("User-Agent", "OkHttp Headers.java")
                //设置多值请求头，同名请求头使用addHeader方法设置2次，2个值都将被保留
                .addHeader("Accept", "application/json; q=0.5")
                .addHeader("Accept", "application/vnd.github.v3+json")
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        //获取单值的响应头的值
        System.out.println("Server: " + response.header("Server"));
        System.out.println("Date: " + response.header("Date"));
        //获取多值的响应头的值列表
        System.out.println("Vary: " + response.headers("Vary"));
    }
}
