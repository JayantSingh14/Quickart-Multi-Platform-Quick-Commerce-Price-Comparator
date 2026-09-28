package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes4.dex */
abstract class zzhxy implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public zzhxz f34479a;

    /* renamed from: b, reason: collision with root package name */
    public zzhxz f34480b;

    /* renamed from: c, reason: collision with root package name */
    public int f34481c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzhya f34482d;

    public zzhxy(zzhya zzhyaVar) {
        Objects.requireNonNull(zzhyaVar);
        this.f34482d = zzhyaVar;
        this.f34479a = zzhyaVar.f34501f.f34486d;
        this.f34480b = null;
        this.f34481c = zzhyaVar.f34500e;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzhxz next() {
        zzhxz zzhxzVar = this.f34479a;
        zzhya zzhyaVar = this.f34482d;
        if (zzhxzVar == zzhyaVar.f34501f) {
            throw new NoSuchElementException();
        }
        if (zzhyaVar.f34500e != this.f34481c) {
            throw new ConcurrentModificationException();
        }
        this.f34479a = zzhxzVar.f34486d;
        this.f34480b = zzhxzVar;
        return zzhxzVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f34479a != this.f34482d.f34501f;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzhxz zzhxzVar = this.f34480b;
        if (zzhxzVar == null) {
            throw new IllegalStateException();
        }
        zzhya zzhyaVar = this.f34482d;
        zzhyaVar.b(zzhxzVar, true);
        this.f34480b = null;
        this.f34481c = zzhyaVar.f34500e;
    }
}
