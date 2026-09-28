package com.google.android.gms.internal.auth;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
final class zzdw extends zzdy {

    /* renamed from: a, reason: collision with root package name */
    public int f36331a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f36332b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzef f36333c;

    public zzdw(zzef zzefVar) {
        this.f36333c = zzefVar;
        this.f36332b = zzefVar.f();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f36331a < this.f36332b;
    }

    public final byte zza() {
        int i2 = this.f36331a;
        if (i2 >= this.f36332b) {
            throw new NoSuchElementException();
        }
        this.f36331a = i2 + 1;
        return this.f36333c.d(i2);
    }
}
