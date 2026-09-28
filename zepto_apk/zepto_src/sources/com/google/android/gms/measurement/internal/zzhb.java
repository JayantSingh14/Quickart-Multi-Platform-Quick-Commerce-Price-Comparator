package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzhb {

    /* renamed from: a, reason: collision with root package name */
    public final String f38999a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f39000b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f39001c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39002d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzhg f39003e;

    public zzhb(zzhg zzhgVar, String str, boolean z) {
        Objects.requireNonNull(zzhgVar);
        this.f39003e = zzhgVar;
        Preconditions.checkNotEmpty(str);
        this.f38999a = str;
        this.f39000b = z;
    }

    public final boolean a() {
        if (!this.f39001c) {
            this.f39001c = true;
            this.f39002d = this.f39003e.k().getBoolean(this.f38999a, this.f39000b);
        }
        return this.f39002d;
    }

    public final void b(boolean z) {
        SharedPreferences.Editor editorEdit = this.f39003e.k().edit();
        editorEdit.putBoolean(this.f38999a, z);
        editorEdit.apply();
        this.f39002d = z;
    }
}
