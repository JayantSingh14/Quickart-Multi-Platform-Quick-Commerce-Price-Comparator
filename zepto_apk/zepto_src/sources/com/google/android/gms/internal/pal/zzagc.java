package com.google.android.gms.internal.pal;

import java.io.Serializable;

/* loaded from: classes4.dex */
public final class zzagc extends zzagf implements Serializable, zzagd {

    /* renamed from: b, reason: collision with root package name */
    public static final zzagc f37519b = new zzagc(0);

    public zzagc(long j2) {
        this.f37520a = j2;
    }

    public static zzagc a(long j2) {
        return j2 == 0 ? f37519b : new zzagc(j2);
    }

    public static zzagc b(long j2) {
        return new zzagc(zzagg.a(3600000, j2));
    }
}
