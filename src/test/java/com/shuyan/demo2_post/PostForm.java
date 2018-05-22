package com.shuyan.demo2_post;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

public class PostForm {
    private final OkHttpClient client = new OkHttpClient();

    @Test
    public void run() throws Exception {
        RequestBody formBody = new FormBody.Builder()
                .add("search", "Jurassic Park")
                .build();
        Request request = new Request.Builder()
                .url("https://en.wikipedia.org/w/index.php")
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        System.out.println(response.body().string());
    }
}
