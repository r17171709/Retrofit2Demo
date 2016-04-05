package com.example.renyu.retrofit2demo.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by RG on 2016/4/5.
 */
public class GsonUtils {

    public static ParameterizedType type(final Class<?> raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }

    public static Gson getGson() {
        GsonBuilder builder = new GsonBuilder();
        return builder.create();
    }

    public static <T>List<T> getModelListValue(String string, Class<T> class_) {
        ResponseList response;
        Type objectTypes= GsonUtils.type(ResponseList.class, class_);
        response=GsonUtils.getGson().fromJson(string, objectTypes);
        return response.getData();
    }
}
