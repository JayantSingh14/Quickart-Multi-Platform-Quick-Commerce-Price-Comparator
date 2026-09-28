package com.google.android.gms.maps;

/* loaded from: classes4.dex */
final class zzt extends com.google.android.gms.maps.internal.zzj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationSource f38642a;

    public zzt(LocationSource locationSource) {
        this.f38642a = locationSource;
    }

    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
    public final void deactivate() {
        this.f38642a.deactivate();
    }

    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
    public final void m7(com.google.android.gms.maps.internal.zzaj zzajVar) {
        this.f38642a.a(new zzl(zzajVar));
    }
}
