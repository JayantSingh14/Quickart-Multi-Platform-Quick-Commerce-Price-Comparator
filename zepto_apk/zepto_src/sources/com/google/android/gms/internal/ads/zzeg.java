package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class zzeg {

    /* renamed from: a, reason: collision with root package name */
    public int f29264a;

    /* renamed from: b, reason: collision with root package name */
    public int f29265b;

    /* renamed from: c, reason: collision with root package name */
    public int f29266c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f29267d;

    /* renamed from: e, reason: collision with root package name */
    public int f29268e;

    public zzeg() {
        throw null;
    }

    public final long a() {
        int i2 = this.f29266c;
        if (i2 == 0) {
            throw new NoSuchElementException();
        }
        long[] jArr = this.f29267d;
        int i3 = this.f29264a;
        long j2 = jArr[i3];
        this.f29264a = this.f29268e & (i3 + 1);
        this.f29266c = i2 - 1;
        return j2;
    }
}
