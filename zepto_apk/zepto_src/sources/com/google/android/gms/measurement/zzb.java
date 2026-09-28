package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzlj;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzb extends zzc {

    /* renamed from: a, reason: collision with root package name */
    public final zzlj f39680a;

    public zzb(zzlj zzljVar) {
        Preconditions.checkNotNull(zzljVar);
        this.f39680a = zzljVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void a(String str, String str2, Bundle bundle) {
        this.f39680a.a(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void b(String str, String str2, Bundle bundle) {
        this.f39680a.b(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final List c(String str, String str2) {
        return this.f39680a.c(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final int j(String str) {
        return this.f39680a.j(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void n0(Bundle bundle) {
        this.f39680a.n0(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void u0(String str) {
        this.f39680a.u0(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void z0(String str) {
        this.f39680a.z0(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final Map zzd(String str, String str2, boolean z) {
        return this.f39680a.zzd(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzh() {
        return this.f39680a.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzi() {
        return this.f39680a.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzj() {
        return this.f39680a.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzk() {
        return this.f39680a.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final long zzl() {
        return this.f39680a.zzl();
    }
}
