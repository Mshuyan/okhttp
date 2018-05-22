package com.shuyan.demo1_get;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;

public class SyncGet {
    //创建客户端对象
    private final OkHttpClient client = new OkHttpClient();

    @Test
    public void run() throws Exception {
        /*
         * 创建请求对象
         * Request类中属性：
         *      public final class Request {
         *          final HttpUrl url;     //请求的url
         *          final String method;    //请求方式，默认GET
         *          final Headers headers;  //请求头对象，默认为“”
         *          final @Nullable RequestBody body;   //请求体，默认为null
         *          final Object tag;   //取消请求标志（先不管）
         */
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();
        /*
         * 通过客户端对象发送请求对象，并同步等待GET请求的响应
         *      public final class Response implements Closeable {
                    final Request request;
                    final Protocol protocol;                //协议
                    final int code;                         //状态码
                    final String message;                   //描述信息
                    final @Nullable Handshake handshake;
                    final Headers headers;                  //响应头
                    final @Nullable ResponseBody body;      //响应体
                    final @Nullable Response networkResponse;
                    final @Nullable Response cacheResponse;
                    final @Nullable Response priorResponse;
                    final long sentRequestAtMillis;
                    final long receivedResponseAtMillis;

                    private volatile CacheControl cacheControl; // Lazily initialized.
         */
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }

        System.out.println(response.body().string());
    }
}
