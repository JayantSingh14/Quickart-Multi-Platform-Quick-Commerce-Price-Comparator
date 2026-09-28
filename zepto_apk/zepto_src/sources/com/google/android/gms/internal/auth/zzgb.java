package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
final class zzgb implements zzgi {

    /* renamed from: a, reason: collision with root package name */
    public final zzfx f36382a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgz f36383b;

    /* renamed from: c, reason: collision with root package name */
    public final zzem f36384c;

    public zzgb(zzgz zzgzVar, zzem zzemVar, zzfx zzfxVar) {
        this.f36383b = zzgzVar;
        this.f36384c = zzemVar;
        this.f36382a = zzfxVar;
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void a(Object obj) {
        this.f36383b.e(obj);
        this.f36384c.b(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean b(zzev zzevVar, zzev zzevVar2) {
        zzgz zzgzVar = this.f36383b;
        return zzgzVar.b(zzevVar).equals(zzgzVar.b(zzevVar2));
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final int c(zzev zzevVar) {
        return this.f36383b.b(zzevVar).hashCode();
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void d(Object obj, byte[] bArr, int i2, int i3, zzdt zzdtVar) {
        zzev zzevVar = (zzev) obj;
        if (zzevVar.zzc == zzha.f36415e) {
            zzevVar.zzc = zzha.a();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void e(Object obj, Object obj2) {
        Class cls = zzgk.f36395a;
        zzgz zzgzVar = this.f36383b;
        zzgzVar.f(obj, zzgzVar.c(zzgzVar.b(obj), zzgzVar.b(obj2)));
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean f(Object obj) {
        this.f36384c.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final zzev zzd() {
        zzfx zzfxVar = this.f36382a;
        if (zzfxVar instanceof zzev) {
            return (zzev) ((zzev) zzfxVar).g(4);
        }
        zzet zzetVar = (zzet) ((zzev) zzfxVar).g(5);
        if (!zzetVar.f36352b.f()) {
            return zzetVar.f36352b;
        }
        zzev zzevVar = zzetVar.f36352b;
        zzevVar.getClass();
        zzgf.f36386c.a(zzevVar.getClass()).a(zzevVar);
        zzevVar.c();
        return zzetVar.f36352b;
    }
}
