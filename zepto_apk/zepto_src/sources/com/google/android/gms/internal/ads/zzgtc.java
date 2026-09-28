package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgtc extends zzgtd {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f33180c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f33181d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzgtd f33182e;

    public zzgtc(zzgtd zzgtdVar, int i2, int i3) {
        Objects.requireNonNull(zzgtdVar);
        this.f33182e = zzgtdVar;
        this.f33180c = i2;
        this.f33181d = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final Object[] d() {
        return this.f33182e.d();
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final int f() {
        return this.f33182e.f() + this.f33180c;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final int g() {
        return this.f33182e.f() + this.f33180c + this.f33181d;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzgqa.i(i2, this.f33181d);
        return this.f33182e.get(i2 + this.f33180c);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final boolean j() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgtd, java.util.List
    /* renamed from: m */
    public final zzgtd subList(int i2, int i3) {
        zzgqa.k(i2, i3, this.f33181d);
        int i4 = this.f33180c;
        return this.f33182e.subList(i2 + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f33181d;
    }
}
