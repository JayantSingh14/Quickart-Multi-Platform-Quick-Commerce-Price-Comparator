package com.google.android.gms.measurement.internal;

import android.util.Log;

/* loaded from: classes.dex */
final class zzjq implements zzgl {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzib f39211a;

    public zzjq(zzib zzibVar, zzjr zzjrVar) {
        this.f39211a = zzibVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zza() {
        zzgt zzgtVar = this.f39211a.f39089f;
        zzib.l(zzgtVar);
        return Log.isLoggable(zzgtVar.q(), 3);
    }
}
