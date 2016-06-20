package com.example.renyu.retrofit2demo.common;

import android.util.Log;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * Created by RG on 2016/3/27.
 */
public class RequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request oldRequest = chain.request();
        Request.Builder requestBuilder = oldRequest.newBuilder();

        // 添加head
        Headers.Builder headBuilder=oldRequest.headers().newBuilder();
        headBuilder.add("apikey", "a7802d983b3d58ed6e70ed71bb0c7f14");
        requestBuilder.headers(headBuilder.build());

        // 重新组成新的请求
        Request newRequest=null;
        if (oldRequest.method().equals("POST")) {
            //添加Post参数
            Log.d("RequestInterceptor", oldRequest.body().contentType().subtype());
            if (oldRequest.body().contentType().subtype().equals("x-www-form-urlencoded")) {
                FormBody old= (FormBody) oldRequest.body();
                FormBody.Builder formBodyBuilder = new FormBody.Builder();
                for (int i=0;i<old.size();i++) {
                    formBodyBuilder.addEncoded(old.encodedName(i), old.encodedValue(i));
                }
                formBodyBuilder.addEncoded("platform", "1");
                newRequest=requestBuilder.method(oldRequest.method(), formBodyBuilder.build()).build();
            }
            else {
                newRequest=oldRequest;
            }
        }
        else {
            //添加Get参数
            HttpUrl.Builder authorizedUrlBuilder = oldRequest.url().newBuilder();
            authorizedUrlBuilder.addQueryParameter("cityname", "南京");
            newRequest = requestBuilder.url(authorizedUrlBuilder.build()).build();
        }
        Response response=chain.proceed(newRequest);

        if (response.body()!=null) {
            MediaType mediaType=response.body().contentType();
            String body=response.body().string();
            Log.d("RequestInterceptor", "response.code():" + response.code()+" "+body);
            return response.newBuilder().body(ResponseBody.create(mediaType, body)).build();
        }
        return response;
    }

    private static String bodyToString(final RequestBody request){
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if(copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        }
        catch (final IOException e) {
            return "did not work";
        }
    }
}
