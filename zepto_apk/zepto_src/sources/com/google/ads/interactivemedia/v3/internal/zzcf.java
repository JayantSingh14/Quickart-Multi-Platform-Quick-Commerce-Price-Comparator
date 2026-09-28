package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;

/* loaded from: classes3.dex */
final class zzcf implements Runnable {
    final /* synthetic */ WebView zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcg zzc;

    public zzcf(zzcg zzcgVar, WebView webView, String str) {
        this.zza = webView;
        this.zzb = str;
        this.zzc = zzcgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcg.zzj(this.zza, this.zzb);
    }
}
