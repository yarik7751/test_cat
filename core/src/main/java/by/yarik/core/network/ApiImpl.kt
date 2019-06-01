package by.yarik.core.network

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiImpl {

    const val REQUEST_TIME: Long = 60;

    public fun create(): Api {
        val client = initOkHttpClient()

        val retrofit = Retrofit.Builder()
            .baseUrl(ApiPaths.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(Api::class.java)
    }

    private fun initOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .callTimeout(REQUEST_TIME, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIME, TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIME, TimeUnit.SECONDS)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY;

        client.addInterceptor(loggingInterceptor)

        return client.build()
    }
}