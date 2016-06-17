package com.example.renyu.retrofit2demo.common;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by RG on 2016/4/5.
 */
public class ListGsonResponseBodyConverter<T> implements Converter<ResponseBody, List<T>> {
    private final Gson gson;
    Class<T> class_;

    ListGsonResponseBodyConverter(Gson gson, Class<T> class_) {
        this.gson = gson;
        this.class_=class_;
    }

    @Override public List<T> convert(ResponseBody value) throws IOException {
        List<T> models=GsonUtils.getModelListValue2(value.string(), class_);
        value.close();
        return models;
    }
}
