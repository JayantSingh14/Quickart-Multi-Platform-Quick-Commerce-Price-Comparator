package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgvc extends zzgtd {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f33241c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f33242d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f33243e;

    public zzgvc(Object[] objArr, int i2, int i3) {
        this.f33241c = objArr;
        this.f33242d = i2;
        this.f33243e = i3;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzgqa.i(i2, this.f33243e);
        Object obj = this.f33241c[i2 + i2 + this.f33242d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final boolean j() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f33243e;
    }
}
