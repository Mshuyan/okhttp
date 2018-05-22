package com.shuyan.demo1_get;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class AsyncGet {
    private final OkHttpClient client = new OkHttpClient();

    @Test
    public void run() throws Exception {
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        /*
         * 发送Get请求并注册回调类
         *
         */
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("call = [" + call + "], response = [" + response + "]");
                System.out.println();
                if (!response.isSuccessful()) {
                    throw new IOException("" + response);
                }

                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    System.out.println(headers.name(i) + ": " + headers.value(i));
                }

                System.out.println();
                System.out.println(response.body().string());
            }
        });
        System.out.println("异步GET");
        sleep(100000);
    }
}
