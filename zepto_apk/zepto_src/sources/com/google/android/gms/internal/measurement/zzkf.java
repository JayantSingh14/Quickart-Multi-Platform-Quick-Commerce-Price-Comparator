package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* loaded from: classes.dex */
public final class zzkf {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f37025a;

    /* renamed from: b, reason: collision with root package name */
    public final String f37026b = "";

    /* renamed from: c, reason: collision with root package name */
    public final boolean f37027c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f37028d;

    public zzkf(Uri uri, boolean z, boolean z2) {
        this.f37025a = uri;
        this.f37027c = z;
        this.f37028d = z2;
    }

    public final zzkf a() {
        if (!this.f37026b.isEmpty()) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        return new zzkf(this.f37025a, true, this.f37028d);
    }

    public final zzkf b() {
        return new zzkf(this.f37025a, this.f37027c, true);
    }

    public final zzkl c(long j2, String str) {
        Long lValueOf = Long.valueOf(j2);
        Object obj = zzkl.f37031f;
        return new zzkb(this, str, lValueOf);
    }

    public final zzkl d(String str, boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        Object obj = zzkl.f37031f;
        return new zzkc(this, str, boolValueOf);
    }

    public final zzkl e(String str, String str2) {
        Object obj = zzkl.f37031f;
        return new zzke(this, str, str2);
    }
}
