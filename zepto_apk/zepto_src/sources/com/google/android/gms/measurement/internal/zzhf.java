package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzhf {

    /* renamed from: a, reason: collision with root package name */
    public final String f39018a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f39019b;

    /* renamed from: c, reason: collision with root package name */
    public String f39020c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzhg f39021d;

    public zzhf(zzhg zzhgVar, String str) {
        Objects.requireNonNull(zzhgVar);
        this.f39021d = zzhgVar;
        Preconditions.checkNotEmpty(str);
        this.f39018a = str;
    }

    public final String a() {
        if (!this.f39019b) {
            this.f39019b = true;
            this.f39020c = this.f39021d.k().getString(this.f39018a, null);
        }
        return this.f39020c;
    }

    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.f39021d.k().edit();
        editorEdit.putString(this.f39018a, str);
        editorEdit.apply();
        this.f39020c = str;
    }
}
