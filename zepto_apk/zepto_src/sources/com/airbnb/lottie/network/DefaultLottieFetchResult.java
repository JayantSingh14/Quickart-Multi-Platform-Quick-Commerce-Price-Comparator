package com.airbnb.lottie.network;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.apache.commons.lang3.StringUtils;

@RestrictTo
/* loaded from: classes3.dex */
public class DefaultLottieFetchResult implements LottieFetchResult {

    /* renamed from: a, reason: collision with root package name */
    public final HttpURLConnection f14665a;

    public DefaultLottieFetchResult(HttpURLConnection httpURLConnection) {
        this.f14665a = httpURLConnection;
    }

    public final String a() throws IOException {
        HttpURLConnection httpURLConnection = this.f14665a;
        try {
            if (b()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to fetch ");
            sb.append(httpURLConnection.getURL());
            sb.append(". Failed with ");
            sb.append(httpURLConnection.getResponseCode());
            sb.append(StringUtils.LF);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb2.append(line);
                        sb2.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } finally {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused2) {
                    }
                }
            }
            sb.append(sb2.toString());
            return sb.toString();
        } catch (IOException e2) {
            Logger.c("get error failed ", e2);
            return e2.getMessage();
        }
    }

    public final boolean b() {
        try {
            return this.f14665a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f14665a.disconnect();
    }
}
