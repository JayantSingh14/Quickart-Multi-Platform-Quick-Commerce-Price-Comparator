package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.signals.SecureSignalsInitializeCallback;

/* loaded from: classes3.dex */
final class zzet implements SecureSignalsInitializeCallback {
    final /* synthetic */ zzev zza;

    public zzet(zzev zzevVar) {
        this.zza = zzevVar;
    }

    @Override // com.google.ads.interactivemedia.v3.api.signals.SecureSignalsInitializeCallback
    public final void onFailure(Exception exc) {
        this.zza.zzd.c(exc);
    }

    @Override // com.google.ads.interactivemedia.v3.api.signals.SecureSignalsInitializeCallback
    public final void onSuccess() {
        this.zza.zzd.d(null);
    }
}
