package com.isstech.vpass.tools;

import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Date;

/**
 * @author rWX538130
 */
public class ContextMethod {
    private static final MediaType XML = MediaType.parse("application/x-www-form-urlencoded");

    private static final MediaType TEXT = MediaType.parse("text");

    private static final OkHttpClient client = ApiClient.getInstance();

    private static final OkHttpClient clientForUpload = ApiClient.getInstanceForUpload();

    /**
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String post(String url, String json) throws IOException {
        System.out.println(url);
        System.out.println(json);
        RequestBody body = RequestBody.create(XML, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (e instanceof SocketTimeoutException){

                } if (e instanceof ConnectException){

                }
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
        Response response = call.execute();
        String result = response.body().string();
        System.out.println(result);
        return result;
    }

    public static String delete(String url, String json)
            throws IOException {
        System.out.println(url);
        System.out.println(json);
        RequestBody body = RequestBody.create(XML, json);
        Request request = new Request.Builder().url(url).delete(body).build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);
        return result;
    }

    public static String put(String url, String json)
            throws IOException {
        System.out.println(url);
        System.out.println(json);
        RequestBody body = RequestBody.create(XML, json);
        Request request = new Request.Builder().url(url).put(body).build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);
        return result;
    }

    public static String patch(String url, String json)
            throws IOException {
        System.out.println(url);
        System.out.println(json);
        RequestBody body = RequestBody.create(XML, json);
        Request request = new Request.Builder().url(url).patch(body).build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);
        return result;
    }

    public static String form(String url, String pwd, String nPwd)
            throws IOException {
        System.out.println(url);
        FormBody formBody = new FormBody.Builder()
                .add("OLD_PASSWORD", pwd)
                .add("NEW_PASSWORD", nPwd)
                .build();

        Request request = new Request.Builder().url(url).post(formBody).build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);
        return result;
    }

    public static String login_post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(XML, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return result;
    }

    public static String sendPost(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(XML, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return result;
    }

    public static byte[] postStream(String url, String json)
            throws IOException {
        RequestBody body = RequestBody.create(TEXT, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();

        String contentType = response.headers().get("Content-Type");
        if (contentType != null && contentType.indexOf("text") == 0) {
            response.body().string();
        }
        byte[] rawdata = response.body().bytes();
        return rawdata;
    }

    /**
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String post_text(String url, String json)
            throws IOException {
        System.out.println(url);
        System.out.println(json);
        RequestBody body = RequestBody.create(TEXT, json);
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);
        return result;
    }

    /**
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url)
            throws IOException {
        Request request = new Request.Builder().url(url).get().build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return result;
    }

    /**
     * @param url
     * @return
     * @throws IOException
     */
    public static byte[] stream(String url)
            throws IOException {
        url = url.replace("#", "%23");
        System.out.println(url);
        Request request = new Request.Builder().url(url).get().build();
        Response response = client.newCall(request).execute();
        byte[] rawdata = response.body().bytes();
        return rawdata;
    }

    public static byte[] postStream(String url)
            throws IOException {
        System.out.println(url);
        RequestBody body = RequestBody.create(TEXT, "");
        Request request = new Request.Builder().url(url).post(body).build();
        Response response = client.newCall(request).execute();
        byte[] rawdata = response.body().bytes();
        return rawdata;
    }

    /**
     * @param file
     * @param url
     * @return
     * @throws Exception
     */
    public static String upload(File file, String url, String fildId)
            throws Exception {
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("imgInput", file.getName(), fileBody)
                .addFormDataPart("begin", "0")
                .addFormDataPart("length", "" + file.length())
                .build();

        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = clientForUpload.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);
        return result;
    }

    public static String uploadBatch(File file, String url)
            throws Exception {
        System.out.println("url:" + url);
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("imgInput", file.getName(), fileBody)
                .addFormDataPart("name", file.getName())
                .addFormDataPart("modify-time", DateUtil.formatDate(new Date(), CommonContext.DATE_FORMAT))
                .addFormDataPart("source-system-id", "0")
                .build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = clientForUpload.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);
        return result;
    }
}
