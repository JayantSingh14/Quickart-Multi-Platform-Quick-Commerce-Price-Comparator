package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;

/* loaded from: classes3.dex */
final class zzcq implements Runnable {
    final /* synthetic */ zzcr zza;
    private final WebView zzb;

    public zzcq(zzcr zzcrVar) {
        this.zza = zzcrVar;
        this.zzb = zzcrVar.zza;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.destroy();
    }
}
