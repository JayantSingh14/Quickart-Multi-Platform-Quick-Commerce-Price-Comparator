package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzeg implements zzef {
    @Override // com.google.ads.interactivemedia.v3.internal.zzef
    public final boolean zza(zzee zzeeVar, Context context, boolean z, boolean z2) {
        String packageName = context.getApplicationContext().getPackageName();
        List list = zzeeVar.zzd;
        return (list == null || !list.contains(packageName)) && !z && z2;
    }
}
