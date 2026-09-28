package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes4.dex */
abstract class zzgsg implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f33146a;

    /* renamed from: b, reason: collision with root package name */
    public int f33147b;

    /* renamed from: c, reason: collision with root package name */
    public int f33148c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgsk f33149d;

    public zzgsg(zzgsk zzgskVar) {
        Objects.requireNonNull(zzgskVar);
        this.f33149d = zzgskVar;
        this.f33146a = zzgskVar.f33160e;
        this.f33147b = zzgskVar.isEmpty() ? -1 : 0;
        this.f33148c = -1;
    }

    public abstract Object a(int i2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f33147b >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzgsk zzgskVar = this.f33149d;
        if (zzgskVar.f33160e != this.f33146a) {
            throw new ConcurrentModificationException();
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f33147b;
        this.f33148c = i2;
        Object objA = a(i2);
        int i3 = this.f33147b + 1;
        if (i3 >= zzgskVar.f33161f) {
            i3 = -1;
        }
        this.f33147b = i3;
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzgsk zzgskVar = this.f33149d;
        if (zzgskVar.f33160e != this.f33146a) {
            throw new ConcurrentModificationException();
        }
        zzgqa.g("no calls to next() since the last call to remove()", this.f33148c >= 0);
        this.f33146a += 32;
        zzgskVar.remove(zzgskVar.b()[this.f33148c]);
        this.f33147b--;
        this.f33148c = -1;
    }
}
