package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
public final class zzgr {

    /* renamed from: a, reason: collision with root package name */
    public final int f38950a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f38951b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f38952c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgt f38953d;

    public zzgr(zzgt zzgtVar, int i2, boolean z, boolean z2) {
        Objects.requireNonNull(zzgtVar);
        this.f38953d = zzgtVar;
        this.f38950a = i2;
        this.f38951b = z;
        this.f38952c = z2;
    }

    public final void a(String str) {
        this.f38953d.p(this.f38950a, this.f38951b, this.f38952c, str, null, null, null);
    }

    public final void b(Object obj, String str) {
        this.f38953d.p(this.f38950a, this.f38951b, this.f38952c, str, obj, null, null);
    }

    public final void c(String str, Object obj, Object obj2) {
        this.f38953d.p(this.f38950a, this.f38951b, this.f38952c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.f38953d.p(this.f38950a, this.f38951b, this.f38952c, str, obj, obj2, obj3);
    }
}
