package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzhd {

    /* renamed from: a, reason: collision with root package name */
    public final String f39008a;

    /* renamed from: b, reason: collision with root package name */
    public final long f39009b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f39010c;

    /* renamed from: d, reason: collision with root package name */
    public long f39011d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzhg f39012e;

    public zzhd(zzhg zzhgVar, String str, long j2) {
        Objects.requireNonNull(zzhgVar);
        this.f39012e = zzhgVar;
        Preconditions.checkNotEmpty(str);
        this.f39008a = str;
        this.f39009b = j2;
    }

    public final long a() {
        if (!this.f39010c) {
            this.f39010c = true;
            this.f39011d = this.f39012e.k().getLong(this.f39008a, this.f39009b);
        }
        return this.f39011d;
    }

    public final void b(long j2) {
        SharedPreferences.Editor editorEdit = this.f39012e.k().edit();
        editorEdit.putLong(this.f39008a, j2);
        editorEdit.apply();
        this.f39011d = j2;
    }
}
