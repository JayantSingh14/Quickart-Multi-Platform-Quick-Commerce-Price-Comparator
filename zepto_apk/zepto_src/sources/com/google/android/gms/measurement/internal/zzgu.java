package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.support.v4.media.b;

/* loaded from: classes.dex */
public final class zzgu {

    /* renamed from: a, reason: collision with root package name */
    public final String f38966a;

    /* renamed from: b, reason: collision with root package name */
    public final String f38967b;

    /* renamed from: c, reason: collision with root package name */
    public final long f38968c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f38969d;

    public zzgu(long j2, Bundle bundle, String str, String str2) {
        this.f38966a = str;
        this.f38967b = str2;
        this.f38969d = bundle;
        this.f38968c = j2;
    }

    public static zzgu a(zzbg zzbgVar) {
        String str = zzbgVar.f38769a;
        return new zzgu(zzbgVar.f38772d, zzbgVar.f38770b.A(), str, zzbgVar.f38771c);
    }

    public final zzbg b() {
        zzbe zzbeVar = new zzbe(new Bundle(this.f38969d));
        return new zzbg(this.f38966a, zzbeVar, this.f38967b, this.f38968c);
    }

    public final String toString() {
        String string = this.f38969d.toString();
        String str = this.f38967b;
        int length = String.valueOf(str).length();
        String str2 = this.f38966a;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + string.length());
        b.B(sb, "origin=", str, ",name=", str2);
        return b.r(sb, ",params=", string);
    }
}
