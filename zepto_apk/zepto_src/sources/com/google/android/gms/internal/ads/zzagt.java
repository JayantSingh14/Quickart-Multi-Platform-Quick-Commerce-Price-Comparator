package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
public final class zzagt implements zzaeo {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23057a = new zzer(4);

    /* renamed from: b, reason: collision with root package name */
    public final zzaft f23058b = new zzaft(-1, -1, "image/avif");

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        this.f23058b.a(j2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23058b.b(zzaerVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) throws EOFException, InterruptedIOException {
        ((zzaef) zzaepVar).f(4, false);
        zzaef zzaefVar = (zzaef) zzaepVar;
        zzer zzerVar = this.f23057a;
        zzerVar.y(4);
        zzaefVar.t(zzerVar.f30144a, 0, 4, false);
        if (zzerVar.P() == 1718909296) {
            zzerVar.y(4);
            zzaefVar.t(zzerVar.f30144a, 0, 4, false);
            if (zzerVar.P() == 1635150182) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final int d(zzaep zzaepVar, zzafo zzafoVar) {
        return this.f23058b.d(zzaepVar, zzafoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }
}
