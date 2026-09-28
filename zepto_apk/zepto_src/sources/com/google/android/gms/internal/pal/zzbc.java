package com.google.android.gms.internal.pal;

import android.util.Log;
import com.google.ads.interactivemedia.pal.NonceLoaderException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzbc extends zzbg {
    public static zzkm d() throws Throwable {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL("https://imasdk.googleapis.com/pal/key/public.json").openConnection();
                try {
                    try {
                        httpURLConnection2.setConnectTimeout(com.google.ads.interactivemedia.pal.zzat.zzb);
                        httpURLConnection2.setReadTimeout(com.google.ads.interactivemedia.pal.zzat.zzc);
                        httpURLConnection2.setDoInput(true);
                        httpURLConnection2.setUseCaches(false);
                        httpURLConnection2.connect();
                        if (httpURLConnection2.getResponseCode() != 200) {
                            Log.w("NonceGenerator", "Failed keystore response: " + httpURLConnection2.getResponseCode());
                            throw NonceLoaderException.zzb(202);
                        }
                        InputStream inputStream = httpURLConnection2.getInputStream();
                        try {
                            zzkm zzkmVarA = zzkm.a(new zzjz(inputStream));
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            httpURLConnection2.disconnect();
                            return zzkmVarA;
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th2) {
                                    try {
                                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (IOException | GeneralSecurityException e2) {
                    e = e2;
                    Log.e("NonceGenerator", "Failed to read keyset handle: " + e.toString());
                    throw new NonceLoaderException(203, e);
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (GeneralSecurityException e4) {
            e = e4;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzbg
    public final zzil a() throws NonceLoaderException {
        try {
            zznn.a();
            return new zziq(new zzbb((zzjy) d().b()));
        } catch (GeneralSecurityException e2) {
            Log.e("NonceGenerator", "Can't access the cryptography library.", e2);
            throw new NonceLoaderException(201, e2);
        }
    }
}
