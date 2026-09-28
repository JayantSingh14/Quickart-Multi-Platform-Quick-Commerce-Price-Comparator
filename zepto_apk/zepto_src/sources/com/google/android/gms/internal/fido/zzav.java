package com.google.android.gms.internal.fido;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
final class zzav extends zzaz {

    /* renamed from: a, reason: collision with root package name */
    public boolean f36586a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f36587b;

    public zzav(Object obj) {
        this.f36587b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f36586a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f36586a) {
            throw new NoSuchElementException();
        }
        this.f36586a = true;
        return this.f36587b;
    }
}
