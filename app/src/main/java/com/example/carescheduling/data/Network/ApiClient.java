package com.example.carescheduling.data.Network;

import android.content.Context;
import android.widget.Toast;

import com.example.carescheduling.Utils.Constants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    private static int REQUEST_TIMEOUT = 100;
    private static OkHttpClient okHttpClient;

    public static Retrofit getClient(Context context) {
        try {
            if (okHttpClient == null)
                initOkHttp(context);

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .client(okHttpClient)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

        return retrofit;
    }

    private static void initOkHttp(final Context context) {

        try {
            OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            httpClient.addInterceptor(interceptor);

            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) {
                    try {
                        Request original = chain.request();
                        Request.Builder requestBuilder = original.newBuilder()
                                .addHeader("Accept", "application/json")
                                .addHeader("Content-Type", "application/json");

                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    } catch (IOException e) {
                        Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
                        return null;
                    }
                }
            });

            okHttpClient = httpClient.build();
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
