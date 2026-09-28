package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzaej implements zzaer {

    /* renamed from: a, reason: collision with root package name */
    public final zzaef f37452a;

    /* renamed from: b, reason: collision with root package name */
    public final zzafi f37453b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f37454c;

    /* renamed from: d, reason: collision with root package name */
    public final zzacn f37455d;

    public zzaej(zzafi zzafiVar, zzacn zzacnVar, zzaef zzaefVar) {
        this.f37453b = zzafiVar;
        this.f37454c = zzacnVar.e(zzaefVar);
        this.f37455d = zzacnVar;
        this.f37452a = zzaefVar;
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final void a(Object obj, byte[] bArr, int i2, int i3, zzabl zzablVar) {
        zzacz zzaczVar = (zzacz) obj;
        if (zzaczVar.zzc == zzafj.f37488f) {
            zzaczVar.zzc = zzafj.b();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final void b(zzacz zzaczVar, zzacz zzaczVar2) {
        Class cls = zzaet.f37467a;
        zzafi zzafiVar = this.f37453b;
        zzafiVar.o(zzaczVar, zzafiVar.e(zzafiVar.d(zzaczVar), zzafiVar.d(zzaczVar2)));
        if (this.f37454c) {
            this.f37455d.a(zzaczVar2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final void c(Object obj, zzaga zzagaVar) {
        this.f37455d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final boolean d(zzacz zzaczVar, zzacz zzaczVar2) {
        zzafi zzafiVar = this.f37453b;
        if (!zzafiVar.d(zzaczVar).equals(zzafiVar.d(zzaczVar2))) {
            return false;
        }
        if (!this.f37454c) {
            return true;
        }
        this.f37455d.a(zzaczVar);
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final void e(Object obj, zzacd zzacdVar, zzacm zzacmVar) {
        this.f37453b.c(obj);
        this.f37455d.b(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final int f(zzacz zzaczVar) {
        int iHashCode = this.f37453b.d(zzaczVar).hashCode();
        if (!this.f37454c) {
            return iHashCode;
        }
        this.f37455d.a(zzaczVar);
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final int zza(Object obj) {
        zzafi zzafiVar = this.f37453b;
        int iB = zzafiVar.b(zzafiVar.d(obj));
        if (!this.f37454c) {
            return iB;
        }
        this.f37455d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final Object zze() {
        return this.f37452a.B().j();
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final void zzf(Object obj) {
        this.f37453b.m(obj);
        this.f37455d.d(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzaer
    public final boolean zzl(Object obj) {
        this.f37455d.a(obj);
        throw null;
    }
}
