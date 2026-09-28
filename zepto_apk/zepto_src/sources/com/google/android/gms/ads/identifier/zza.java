package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.ads_identifier.zzh;
import com.google.android.gms.internal.ads_identifier.zzi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/* loaded from: classes4.dex */
final class zza extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap f21072a;

    public zza(HashMap map) {
        this.f21072a = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        HashMap map = this.f21072a;
        for (String str : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        String string = builderBuildUpon.build().toString();
        try {
            try {
                zzh zzhVar = zzi.f36007a;
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 200 || responseCode >= 300) {
                        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 65);
                        sb.append("Received non-success response code ");
                        sb.append(responseCode);
                        sb.append(" from pinging URL: ");
                        sb.append(string);
                        Log.w("HttpUrlPinger", sb.toString());
                    }
                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (IOException e2) {
                e = e2;
                String message = e.getMessage();
                StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 27 + String.valueOf(message).length());
                sb2.append("Error while pinging URL: ");
                sb2.append(string);
                sb2.append(". ");
                sb2.append(message);
                Log.w("HttpUrlPinger", sb2.toString(), e);
                zzh zzhVar2 = zzi.f36007a;
            } catch (IndexOutOfBoundsException e3) {
                String message2 = e3.getMessage();
                StringBuilder sb3 = new StringBuilder(String.valueOf(string).length() + 32 + String.valueOf(message2).length());
                sb3.append("Error while parsing ping URL: ");
                sb3.append(string);
                sb3.append(". ");
                sb3.append(message2);
                Log.w("HttpUrlPinger", sb3.toString(), e3);
                zzh zzhVar22 = zzi.f36007a;
            } catch (RuntimeException e4) {
                e = e4;
                String message3 = e.getMessage();
                StringBuilder sb22 = new StringBuilder(String.valueOf(string).length() + 27 + String.valueOf(message3).length());
                sb22.append("Error while pinging URL: ");
                sb22.append(string);
                sb22.append(". ");
                sb22.append(message3);
                Log.w("HttpUrlPinger", sb22.toString(), e);
                zzh zzhVar222 = zzi.f36007a;
            }
        } catch (Throwable th) {
            zzh zzhVar3 = zzi.f36007a;
            throw th;
        }
    }
}
