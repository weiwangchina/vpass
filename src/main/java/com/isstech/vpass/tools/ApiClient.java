package com.isstech.vpass.tools;

import com.isstech.vpass.cookies.DefaultCookieJar;
import com.isstech.vpass.cookies.MemoryCookieStore;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class ApiClient {

    private static SSLContexts.SSLConfig sslConfig = SSLContexts.defualtParse(null);

    private static MemoryCookieStore cookieStore = new MemoryCookieStore();

    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .hostnameVerifier(sslConfig.getHostnameVerifier())
            .connectTimeout(CommonContext.DEFAULT_CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(CommonContext.DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
            .sslSocketFactory(sslConfig.getSslSocketFactory(), sslConfig.getX509TrustManager())
            .cookieJar(new DefaultCookieJar(cookieStore)).build();


    private static final OkHttpClient okHttpClientForUpload = new OkHttpClient.Builder()
            .hostnameVerifier(sslConfig.getHostnameVerifier())
            .sslSocketFactory(sslConfig.getSslSocketFactory(), sslConfig.getX509TrustManager())
            .connectTimeout(CommonContext.FILE_UPLOAD_TIME_OUT, TimeUnit.SECONDS)
            .cookieJar(new DefaultCookieJar(cookieStore)).build();

    public static OkHttpClient getInstance() {
        return okHttpClient;
    }

    public static OkHttpClient getInstanceForUpload() {
        return okHttpClientForUpload;
    }
}
