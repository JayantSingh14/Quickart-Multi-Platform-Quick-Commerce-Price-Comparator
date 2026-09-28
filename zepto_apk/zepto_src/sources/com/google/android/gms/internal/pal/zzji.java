package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzji extends zziz {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f37841c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f37842d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f37843e;

    public zzji(Object[] objArr, int i2, int i3) {
        this.f37841c = objArr;
        this.f37842d = i2;
        this.f37843e = i3;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzip.a(i2, this.f37843e);
        Object obj = this.f37841c[i2 + i2 + this.f37842d];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37843e;
    }
}
