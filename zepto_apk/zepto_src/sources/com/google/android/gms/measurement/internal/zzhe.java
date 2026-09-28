package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzhe {

    /* renamed from: a, reason: collision with root package name */
    public final String f39013a;

    /* renamed from: b, reason: collision with root package name */
    public final String f39014b;

    /* renamed from: c, reason: collision with root package name */
    public final String f39015c;

    /* renamed from: d, reason: collision with root package name */
    public final long f39016d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzhg f39017e;

    public /* synthetic */ zzhe(zzhg zzhgVar, long j2) {
        Objects.requireNonNull(zzhgVar);
        this.f39017e = zzhgVar;
        Preconditions.checkNotEmpty("health_monitor");
        Preconditions.checkArgument(j2 > 0);
        this.f39013a = "health_monitor:start";
        this.f39014b = "health_monitor:count";
        this.f39015c = "health_monitor:value";
        this.f39016d = j2;
    }

    public final void a() {
        zzhg zzhgVar = this.f39017e;
        zzhgVar.g();
        long jCurrentTimeMillis = zzhgVar.f39180a.f39094k.currentTimeMillis();
        SharedPreferences.Editor editorEdit = zzhgVar.k().edit();
        editorEdit.remove(this.f39014b);
        editorEdit.remove(this.f39015c);
        editorEdit.putLong(this.f39013a, jCurrentTimeMillis);
        editorEdit.apply();
    }
}
