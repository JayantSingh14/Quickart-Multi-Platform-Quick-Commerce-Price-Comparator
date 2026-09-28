package com.google.android.gms.internal.maps;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
final class zzbb extends zzbf {

    /* renamed from: a, reason: collision with root package name */
    public boolean f36724a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f36725b;

    public zzbb(Object obj) {
        this.f36725b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f36724a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f36724a) {
            throw new NoSuchElementException();
        }
        this.f36724a = true;
        return this.f36725b;
    }
}
