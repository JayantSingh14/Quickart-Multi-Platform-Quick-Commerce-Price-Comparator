package com.google.android.gms.internal.ads;

import android.os.Trace;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzabs implements zzadj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzug f22674a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f22675b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzabw f22676c;

    public zzabs(zzabw zzabwVar, zzug zzugVar, int i2, long j2) {
        this.f22674a = zzugVar;
        this.f22675b = i2;
        Objects.requireNonNull(zzabwVar);
        this.f22676c = zzabwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadj
    public final void a(long j2) {
        this.f22676c.B0(this.f22674a, this.f22675b, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzadj
    public final void zzb() {
        zzabw zzabwVar = this.f22676c;
        zzabwVar.getClass();
        Trace.beginSection("dropVideoBuffer");
        this.f22674a.l(this.f22675b);
        Trace.endSection();
        zzabwVar.z0(0, 1);
    }
}
