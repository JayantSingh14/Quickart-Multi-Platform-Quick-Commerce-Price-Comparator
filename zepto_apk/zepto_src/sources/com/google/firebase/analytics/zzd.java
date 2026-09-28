package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.internal.zzlj;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzd implements zzlj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfb f43554a;

    public zzd(zzfb zzfbVar) {
        this.f43554a = zzfbVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void a(String str, String str2, Bundle bundle) {
        this.f43554a.l(bundle, str, str2, true);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void b(String str, String str2, Bundle bundle) {
        this.f43554a.r(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final List c(String str, String str2) {
        return this.f43554a.s(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final int j(String str) {
        return this.f43554a.e(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void n0(Bundle bundle) {
        this.f43554a.q(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void u0(String str) {
        this.f43554a.A(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final void z0(String str) {
        this.f43554a.z(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final Map zzd(String str, String str2, boolean z) {
        return this.f43554a.c(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzh() {
        return this.f43554a.a();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzi() {
        return this.f43554a.b();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzj() {
        return this.f43554a.D();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final String zzk() {
        return this.f43554a.C();
    }

    @Override // com.google.android.gms.measurement.internal.zzlj
    public final long zzl() {
        return this.f43554a.E();
    }
}
