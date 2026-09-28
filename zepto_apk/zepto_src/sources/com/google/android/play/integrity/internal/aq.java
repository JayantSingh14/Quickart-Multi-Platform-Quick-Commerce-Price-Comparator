package com.google.android.play.integrity.internal;

/* loaded from: classes4.dex */
final class aq extends ar {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f42174c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f42175d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ar f42176e;

    public aq(ar arVar, int i2, int i3) {
        this.f42176e = arVar;
        this.f42174c = i2;
        this.f42175d = i3;
    }

    @Override // com.google.android.play.integrity.internal.ao
    public final int d() {
        return this.f42176e.f() + this.f42174c + this.f42175d;
    }

    @Override // com.google.android.play.integrity.internal.ao
    public final int f() {
        return this.f42176e.f() + this.f42174c;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        al.a(i2, this.f42175d);
        return this.f42176e.get(i2 + this.f42174c);
    }

    @Override // com.google.android.play.integrity.internal.ao
    public final Object[] i() {
        return this.f42176e.i();
    }

    @Override // com.google.android.play.integrity.internal.ar, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final ar subList(int i2, int i3) {
        al.b(i2, i3, this.f42175d);
        int i4 = this.f42174c;
        return this.f42176e.subList(i2 + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f42175d;
    }
}
