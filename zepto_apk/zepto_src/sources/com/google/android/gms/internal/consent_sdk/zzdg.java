package com.google.android.gms.internal.consent_sdk;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
final class zzdg extends zzdk {

    /* renamed from: a, reason: collision with root package name */
    public final Object f36552a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f36553b;

    public zzdg(Object obj) {
        this.f36552a = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f36553b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f36553b) {
            throw new NoSuchElementException();
        }
        this.f36553b = true;
        return this.f36552a;
    }
}
