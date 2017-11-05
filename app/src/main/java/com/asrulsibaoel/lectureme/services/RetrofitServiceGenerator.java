package com.asrulsibaoel.lectureme.services;

import com.pixplicity.easyprefs.library.Prefs;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asrulsibaoel on 9/6/16.
 */
public class RetrofitServiceGenerator {

    public static final String API_BASE_URL = "http://api.tawar.in/";

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS);

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass){
        return createService(serviceClass, null, null);
    }

    public static <S> S createService(Class<S> serviceClass, String username, String password){
        String token = Prefs.getString("token","");

        if(!token.equals("")){
//            String credentials = username + ":" + password;
            final String basic =
                    "Bearer " + token;
//            final String basic =
//                    "a";

            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Accept", "application/json")
                            .header("Authorization", basic)
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = httpClient.addInterceptor(interceptor).build();

        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }

}
