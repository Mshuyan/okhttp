package com.shuyan.demo2_post;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

public class PostStringTestLogin {
    public static final MediaType MEDIA_TYPE_JSON
            = MediaType.parse("application/json");

    private final OkHttpClient client = new OkHttpClient();


    @Test
    public void run() throws Exception {
        String postBody = ""
                + "{\n" +
                "\t\"email\":\"shuyan434224591@gmail.com\",\n" +
                "\t\"password\":123456\n" +
                "}";

        Request request = new Request.Builder()
                .url("http://localhost:8080/login")
                .post(RequestBody.create(MEDIA_TYPE_JSON, postBody))
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        JSONObject jsonObject = JSON.parseObject(response.body().string());
        System.out.println(jsonObject.get("token"));
    }
}

class TokenEntity{
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
