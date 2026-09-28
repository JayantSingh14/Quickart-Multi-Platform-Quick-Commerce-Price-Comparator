package com.google.ads.interactivemedia.v3.impl;

import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import com.google.ads.interactivemedia.v3.internal.zzeo;
import com.google.ads.interactivemedia.v3.internal.zzsn;

/* loaded from: classes3.dex */
final class zzbf implements zzsn {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbk zzb;

    public zzbf(zzbk zzbkVar, String str) {
        this.zza = str;
        this.zzb = zzbkVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsn
    public final void zza(Throwable th) {
        zzeo.zzb("Failure to make Native-layer network request", th);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsn
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzb.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.nativeXhr, JavaScriptMessage.MsgType.nativeResponse, this.zza, (zzck) obj));
    }
}
