package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
public final class zzaqi implements zzaeo {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f24160a = new zzer(4);

    /* renamed from: b, reason: collision with root package name */
    public final zzaft f24161b = new zzaft(-1, -1, "image/webp");

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        this.f24161b.a(j2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f24161b.b(zzaerVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) throws EOFException, InterruptedIOException {
        zzer zzerVar = this.f24160a;
        zzerVar.y(4);
        zzaef zzaefVar = (zzaef) zzaepVar;
        zzaefVar.t(zzerVar.f30144a, 0, 4, false);
        if (zzerVar.P() == 1380533830) {
            zzaefVar.f(4, false);
            zzerVar.y(4);
            zzaefVar.t(zzerVar.f30144a, 0, 4, false);
            if (zzerVar.P() == 1464156752) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final int d(zzaep zzaepVar, zzafo zzafoVar) {
        return this.f24161b.d(zzaepVar, zzafoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }
}
