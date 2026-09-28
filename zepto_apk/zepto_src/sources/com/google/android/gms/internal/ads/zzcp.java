package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
public abstract class zzcp implements zzco {

    /* renamed from: b, reason: collision with root package name */
    public zzcl f26854b;

    /* renamed from: c, reason: collision with root package name */
    public zzcl f26855c;

    /* renamed from: d, reason: collision with root package name */
    public zzcl f26856d;

    /* renamed from: e, reason: collision with root package name */
    public zzcl f26857e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f26858f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f26859g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f26860h;

    public zzcp() {
        ByteBuffer byteBuffer = zzco.f26781a;
        this.f26858f = byteBuffer;
        this.f26859g = byteBuffer;
        zzcl zzclVar = zzcl.f26484e;
        this.f26856d = zzclVar;
        this.f26857e = zzclVar;
        this.f26854b = zzclVar;
        this.f26855c = zzclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcl c(zzcl zzclVar) {
        this.f26856d = zzclVar;
        this.f26857e = e(zzclVar);
        return zzc() ? this.f26857e : zzcl.f26484e;
    }

    public final ByteBuffer d(int i2) {
        if (this.f26858f.capacity() < i2) {
            this.f26858f = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.f26858f.clear();
        }
        ByteBuffer byteBuffer = this.f26858f;
        this.f26859g = byteBuffer;
        return byteBuffer;
    }

    public zzcl e(zzcl zzclVar) {
        throw null;
    }

    public void f() {
    }

    public void g() {
    }

    public void h() {
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public boolean zzc() {
        return this.f26857e != zzcl.f26484e;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zze() {
        this.f26860h = true;
        f();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public ByteBuffer zzf() {
        ByteBuffer byteBuffer = this.f26859g;
        this.f26859g = zzco.f26781a;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public boolean zzg() {
        return this.f26860h && this.f26859g == zzco.f26781a;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzh() {
        zzcm zzcmVar = zzcm.f26529b;
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzi() {
        this.f26859g = zzco.f26781a;
        this.f26860h = false;
        this.f26854b = this.f26856d;
        this.f26855c = this.f26857e;
        g();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzj() {
        ByteBuffer byteBuffer = zzco.f26781a;
        this.f26859g = byteBuffer;
        this.f26860h = false;
        this.f26858f = byteBuffer;
        zzcl zzclVar = zzcl.f26484e;
        this.f26856d = zzclVar;
        this.f26857e = zzclVar;
        this.f26854b = zzclVar;
        this.f26855c = zzclVar;
        h();
    }
}
