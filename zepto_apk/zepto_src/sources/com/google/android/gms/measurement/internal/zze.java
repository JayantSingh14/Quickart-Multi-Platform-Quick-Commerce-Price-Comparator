package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* loaded from: classes.dex */
final class zze {

    /* renamed from: a, reason: collision with root package name */
    public final zzjh f38847a;

    public zze(zzjh zzjhVar) {
        this.f38847a = zzjhVar;
    }

    public static zze a(String str) {
        return new zze((TextUtils.isEmpty(str) || str.length() > 1) ? zzjh.UNINITIALIZED : zzjk.e(str.charAt(0)));
    }
}
