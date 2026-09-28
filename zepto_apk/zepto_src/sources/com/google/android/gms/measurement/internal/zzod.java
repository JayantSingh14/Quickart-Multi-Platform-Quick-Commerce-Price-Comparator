package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@VisibleForTesting
/* loaded from: classes4.dex */
final class zzod {

    /* renamed from: a, reason: collision with root package name */
    public static final zzod f39538a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzod f39539b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ zzod[] f39540c;

    static {
        zzod zzodVar = new zzod("CONSENT", 0);
        f39538a = zzodVar;
        zzod zzodVar2 = new zzod("LEGITIMATE_INTEREST", 1);
        zzod zzodVar3 = new zzod("FLEXIBLE_CONSENT", 2);
        zzod zzodVar4 = new zzod("FLEXIBLE_LEGITIMATE_INTEREST", 3);
        f39539b = zzodVar4;
        f39540c = new zzod[]{zzodVar, zzodVar2, zzodVar3, zzodVar4};
    }

    public static zzod[] values() {
        return (zzod[]) f39540c.clone();
    }
}
