package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class zzvm implements zzwl {
    final /* synthetic */ Class zza;

    public zzvm(zzvw zzvwVar, Class cls) {
        this.zza = cls;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzwl
    public final Object zza() {
        try {
            return zzww.zzc.zza(this.zza);
        } catch (Exception e2) {
            throw new RuntimeException(b.D("Unable to create instance of ", String.valueOf(this.zza), ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem."), e2);
        }
    }
}
