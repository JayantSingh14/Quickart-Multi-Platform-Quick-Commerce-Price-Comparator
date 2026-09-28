package com.google.android.gms.internal.pal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class zzzp implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public zzzq f38172a;

    /* renamed from: b, reason: collision with root package name */
    public zzzq f38173b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f38174c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzzr f38175d;

    public zzzp(zzzr zzzrVar) {
        this.f38175d = zzzrVar;
        this.f38172a = zzzrVar.f38189e.f38179d;
        this.f38174c = zzzrVar.f38188d;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzzq next() {
        zzzq zzzqVar = this.f38172a;
        zzzr zzzrVar = this.f38175d;
        if (zzzqVar == zzzrVar.f38189e) {
            throw new NoSuchElementException();
        }
        if (zzzrVar.f38188d != this.f38174c) {
            throw new ConcurrentModificationException();
        }
        this.f38172a = zzzqVar.f38179d;
        this.f38173b = zzzqVar;
        return zzzqVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f38172a != this.f38175d.f38189e;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzzq zzzqVar = this.f38173b;
        if (zzzqVar == null) {
            throw new IllegalStateException();
        }
        zzzr zzzrVar = this.f38175d;
        zzzrVar.b(zzzqVar, true);
        this.f38173b = null;
        this.f38174c = zzzrVar.f38188d;
    }
}
