package com.google.android.gms.internal.atv_ads_framework;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
final class zzbj extends zzbu {

    /* renamed from: a, reason: collision with root package name */
    public boolean f36056a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f36057b;

    public zzbj(Object obj) {
        this.f36057b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f36056a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f36056a) {
            throw new NoSuchElementException();
        }
        this.f36056a = true;
        return this.f36057b;
    }
}
