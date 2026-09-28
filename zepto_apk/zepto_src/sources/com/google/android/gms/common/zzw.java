package com.google.android.gms.common;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
final class zzw {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    public /* synthetic */ zzw(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, byte[] bArr) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z4;
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final zzp zzb(Context context) {
        return new zzp(this.zza, this.zzb, false, new ObjectWrapper(context), false, true, false);
    }
}
