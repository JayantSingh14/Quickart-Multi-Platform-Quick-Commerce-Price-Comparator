package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* loaded from: classes.dex */
public final class zzgy extends zzor {
    public final boolean k() {
        h();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f39180a.f39084a.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final void l(String str, zzos zzosVar, com.google.android.gms.internal.measurement.zzib zzibVar, zzgv zzgvVar) {
        String str2;
        URL url;
        byte[] bArrF;
        zzhy zzhyVar;
        zzib zzibVar2 = this.f39180a;
        g();
        h();
        try {
            url = new URI(zzosVar.a()).toURL();
            this.f39551b.i0();
            bArrF = zzibVar.f();
            zzhyVar = zzibVar2.f39090g;
            zzib.l(zzhyVar);
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            str2 = str;
        }
        try {
            zzhyVar.s(new zzgx(this, str2, url, bArrF, zzosVar.b(), zzgvVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            zzgt zzgtVar = zzibVar2.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.c("Failed to parse URL. Not uploading MeasurementBatch. appId", zzgt.o(str2), zzosVar.a());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    public final void j() {
    }
}
