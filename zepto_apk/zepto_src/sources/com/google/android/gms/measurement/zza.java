package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzd;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzli;
import com.google.android.gms.measurement.internal.zzpo;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zza extends zzc {

    /* renamed from: a, reason: collision with root package name */
    public final zzib f39678a;

    /* renamed from: b, reason: collision with root package name */
    public final zzli f39679b;

    public zza(zzib zzibVar) {
        Preconditions.checkNotNull(zzibVar);
        this.f39678a = zzibVar;
        zzli zzliVar = zzibVar.f39096m;
        zzib.k(zzliVar);
        this.f39679b = zzliVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void a(String str, String str2, Bundle bundle) {
        this.f39679b.l(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void b(String str, String str2, Bundle bundle) {
        zzli zzliVar = this.f39678a.f39096m;
        zzib.k(zzliVar);
        zzliVar.y(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final List c(String str, String str2) {
        return this.f39679b.z(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final int j(String str) {
        this.f39679b.v(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void n0(Bundle bundle) {
        this.f39679b.w(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void u0(String str) {
        zzib zzibVar = this.f39678a;
        zzd zzdVar = zzibVar.n;
        zzib.i(zzdVar);
        zzdVar.i(zzibVar.f39094k.elapsedRealtime(), str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void z0(String str) {
        zzib zzibVar = this.f39678a;
        zzd zzdVar = zzibVar.n;
        zzib.i(zzdVar);
        zzdVar.h(zzibVar.f39094k.elapsedRealtime(), str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final Map zzd(String str, String str2, boolean z) {
        return this.f39679b.t(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzh() {
        return this.f39679b.A();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzi() {
        return this.f39679b.B();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzj() {
        return (String) this.f39679b.f39319g.get();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzk() {
        return (String) this.f39679b.f39319g.get();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final long zzl() {
        zzpo zzpoVar = this.f39678a.f39092i;
        zzib.j(zzpoVar);
        return zzpoVar.b0();
    }
}
