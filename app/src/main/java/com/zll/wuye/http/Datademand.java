package com.zll.wuye.http;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/3/17 19:18
 */
public class Datademand {
    public static <T> void getData( String url ,final Class<T> sueess ,final CallData callData){
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();
        final Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback()
        {
            @Override
            public void onFailure(Request request, IOException e)
            {
            }

            @Override
            public void onResponse(final Response response) throws IOException
            {
                String htmlStr =  response.body().string();
                Gson gson = new Gson();
                T t = gson.fromJson(htmlStr, sueess);
                callData.call(t);

            }
        });



    }
    public interface CallData<T>{
        void call(T t);
    }

}
