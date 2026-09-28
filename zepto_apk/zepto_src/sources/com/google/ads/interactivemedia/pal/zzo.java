package com.google.ads.interactivemedia.pal;

import com.google.android.gms.internal.pal.zzhv;
import com.google.android.gms.internal.pal.zzhx;
import com.google.android.gms.internal.pal.zzhy;
import com.google.android.gms.internal.pal.zzic;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes3.dex */
final class zzo extends Thread {
    final /* synthetic */ String zza;

    public zzo(zzs zzsVar, String str) {
        this.zza = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str = this.zza;
        try {
            zzic zzicVar = new zzic();
            try {
                URL url = new URL(str);
                zzicVar.f37807a = new zzhy();
                zzhv zzhvVar = zzhx.f37805a;
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                zzicVar.f37808b = httpURLConnection;
                httpURLConnection.setConnectTimeout(zzat.zzb);
                httpURLConnection.setReadTimeout(zzat.zzc);
                httpURLConnection.setDoInput(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.getResponseCode();
                zzicVar.close();
            } catch (Throwable th) {
                try {
                    zzicVar.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
        }
    }
}
