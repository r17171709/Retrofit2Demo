package com.example.renyu.retrofit2demo.common;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * Created by renyu on 2017/11/24.
 */

public class KuaidiInterceptor1 implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl.Builder url = request.url().newBuilder();
        if (request.method().equals("GET")) {
            for (String s : request.url().queryParameterNames()) {
                Log.d("KuaidiInterceptor1", request.url().queryParameter(s));
            }
            url.addQueryParameter("key", "value");
        }
        else if (request.method().equals("POST")) {
            RequestBody requestBody = request.body();
            if (requestBody instanceof FormBody) {
                FormBody.Builder formBuilder = new FormBody.Builder();
                for (int i = 0; i < ((FormBody) requestBody).size(); i++) {
                    Log.d("KuaidiInterceptor1", ((FormBody) requestBody).encodedName(i) + " " + ((FormBody) requestBody).encodedValue(i));
                    formBuilder.addEncoded(((FormBody) requestBody).encodedName(i), ((FormBody) requestBody).encodedValue(i));
                }
                formBuilder.addEncoded("key", "value");
                request = request.newBuilder().method(request.method(), formBuilder.build()).build();
            }
            else {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                String oldParamsJson = buffer.readUtf8();
                Gson gson = new Gson();
                HashMap map = gson.fromJson(oldParamsJson, HashMap.class);
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Log.d("KuaidiInterceptor1", entry.getKey() + " " + entry.getValue());
                }
                map.put("key", "value");
                String newParams = gson.toJson(map);
                request = request.newBuilder().post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), newParams)).build();
            }
        }
        Request.Builder newRequestBuilder = request.newBuilder()
                .addHeader("version", "version")
                .addHeader("access-token", "access-token")
                .addHeader("user-token", "user-token")
                .url(url.build());
        Request newRequest = newRequestBuilder.build();

        Response response = chain.proceed(newRequest);
        if (response.body()!=null) {
            MediaType mediaType=response.body().contentType();
            String body=response.body().string();
            Log.d("KuaidiInterceptor1", "response.code():" + response.code()+" "+body);
            return response.newBuilder().body(ResponseBody.create(mediaType, body)).build();
        }
        return response;
    }
}
