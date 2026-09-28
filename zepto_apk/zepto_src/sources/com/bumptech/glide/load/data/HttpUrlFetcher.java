package com.bumptech.glide.load.data;

import android.os.SystemClock;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* loaded from: classes3.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public final GlideUrl f15835a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15836b;

    /* renamed from: c, reason: collision with root package name */
    public HttpURLConnection f15837c;

    /* renamed from: d, reason: collision with root package name */
    public InputStream f15838d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f15839e;

    public static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
    }

    public interface HttpUrlConnectionFactory {
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i2) {
        this.f15835a = glideUrl;
        this.f15836b = i2;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void b() throws IOException {
        InputStream inputStream = this.f15838d;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f15837c;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f15837c = null;
    }

    public final InputStream c(URL url, int i2, URL url2, Map map) throws IOException {
        if (i2 >= 5) {
            throw new HttpException("Too many (> 5) redirects!", null);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop", null);
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.f15837c = (HttpURLConnection) url.openConnection();
        for (Map.Entry entry : map.entrySet()) {
            this.f15837c.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        this.f15837c.setConnectTimeout(this.f15836b);
        this.f15837c.setReadTimeout(this.f15836b);
        this.f15837c.setUseCaches(false);
        this.f15837c.setDoInput(true);
        this.f15837c.setInstanceFollowRedirects(false);
        this.f15837c.connect();
        this.f15838d = this.f15837c.getInputStream();
        if (this.f15839e) {
            return null;
        }
        int responseCode = this.f15837c.getResponseCode();
        int i3 = responseCode / 100;
        if (i3 == 2) {
            HttpURLConnection httpURLConnection = this.f15837c;
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f15838d = new ContentLengthInputStream(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.f15838d = httpURLConnection.getInputStream();
            }
            return this.f15838d;
        }
        if (i3 != 3) {
            if (responseCode == -1) {
                throw new HttpException(b.f(responseCode, "Http request failed with status code: "), null);
            }
            throw new HttpException(this.f15837c.getResponseMessage(), null);
        }
        String headerField = this.f15837c.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            throw new HttpException("Received empty or null redirect url", null);
        }
        URL url3 = new URL(url, headerField);
        b();
        return c(url3, i2 + 1, url, map);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
        this.f15839e = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource d() {
        return DataSource.f15789b;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void e(Priority priority, DataFetcher.DataCallback dataCallback) {
        GlideUrl glideUrl = this.f15835a;
        int i2 = LogTime.f16520b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            try {
                dataCallback.f(c(glideUrl.d(), 0, null, glideUrl.f16146b.b()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.a(jElapsedRealtimeNanos));
                }
            } catch (IOException e2) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
                }
                dataCallback.c(e2);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.a(jElapsedRealtimeNanos));
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + LogTime.a(jElapsedRealtimeNanos));
            }
            throw th;
        }
    }
}
