package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzbc {

    /* renamed from: a, reason: collision with root package name */
    public final String f38756a;

    /* renamed from: b, reason: collision with root package name */
    public final String f38757b;

    /* renamed from: c, reason: collision with root package name */
    public final long f38758c;

    /* renamed from: d, reason: collision with root package name */
    public final long f38759d;

    /* renamed from: e, reason: collision with root package name */
    public final long f38760e;

    /* renamed from: f, reason: collision with root package name */
    public final long f38761f;

    /* renamed from: g, reason: collision with root package name */
    public final long f38762g;

    /* renamed from: h, reason: collision with root package name */
    public final Long f38763h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f38764i;

    /* renamed from: j, reason: collision with root package name */
    public final Long f38765j;

    /* renamed from: k, reason: collision with root package name */
    public final Boolean f38766k;

    public zzbc(String str, String str2, long j2, long j3, long j4, long j5, long j6, Long l2, Long l3, Long l4, Boolean bool) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkArgument(j2 >= 0);
        Preconditions.checkArgument(j3 >= 0);
        Preconditions.checkArgument(j4 >= 0);
        Preconditions.checkArgument(j6 >= 0);
        this.f38756a = str;
        this.f38757b = str2;
        this.f38758c = j2;
        this.f38759d = j3;
        this.f38760e = j4;
        this.f38761f = j5;
        this.f38762g = j6;
        this.f38763h = l2;
        this.f38764i = l3;
        this.f38765j = l4;
        this.f38766k = bool;
    }

    public final zzbc a(long j2) {
        return new zzbc(this.f38756a, this.f38757b, this.f38758c, this.f38759d, this.f38760e, j2, this.f38762g, this.f38763h, this.f38764i, this.f38765j, this.f38766k);
    }

    public final zzbc b(Long l2, Long l3, Boolean bool) {
        return new zzbc(this.f38756a, this.f38757b, this.f38758c, this.f38759d, this.f38760e, this.f38761f, this.f38762g, this.f38763h, l2, l3, bool);
    }
}
