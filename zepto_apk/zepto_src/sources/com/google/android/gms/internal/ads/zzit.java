package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public final class zzit extends zzau {

    /* renamed from: c, reason: collision with root package name */
    public final int f34967c;

    /* renamed from: d, reason: collision with root package name */
    public final String f34968d;

    /* renamed from: e, reason: collision with root package name */
    public final int f34969e;

    /* renamed from: f, reason: collision with root package name */
    public final zzv f34970f;

    /* renamed from: g, reason: collision with root package name */
    public final int f34971g;

    /* renamed from: h, reason: collision with root package name */
    public final zzwg f34972h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f34973i;

    public zzit(int i2, Exception exc, int i3) {
        this(i2, exc, i3, null, -1, null, 4, null, false);
    }

    public final zzit a(zzwg zzwgVar) {
        String message = getMessage();
        String str = zzfj.f31254a;
        return new zzit(message, getCause(), this.f24381a, this.f34967c, this.f34968d, this.f34969e, this.f34970f, this.f34971g, zzwgVar, this.f24382b, this.f34973i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzit(int i2, Exception exc, int i3, String str, int i4, zzv zzvVar, int i5, zzwg zzwgVar, boolean z) {
        String str2;
        int i6;
        String strS;
        String str3;
        if (i2 == 0) {
            str2 = str;
            i6 = i4;
            strS = "Source error";
        } else if (i2 != 1) {
            strS = "Unexpected runtime error";
            str2 = str;
            i6 = i4;
        } else {
            String strValueOf = String.valueOf(zzvVar);
            String str4 = zzfj.f31254a;
            if (i5 == 0) {
                str3 = "NO";
            } else if (i5 == 1) {
                str3 = "NO_UNSUPPORTED_TYPE";
            } else if (i5 == 2) {
                str3 = "NO_UNSUPPORTED_DRM";
            } else if (i5 == 3) {
                str3 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i5 != 4) {
                    throw new IllegalStateException();
                }
                str3 = "YES";
            }
            StringBuilder sb = new StringBuilder(str3.length() + strValueOf.length() + androidx.fragment.app.e.C(String.valueOf(str).length() + 14, 9, String.valueOf(i4)) + 19);
            str2 = str;
            sb.append(str2);
            sb.append(" error, index=");
            i6 = i4;
            sb.append(i6);
            sb.append(", format=");
            strS = android.support.v4.media.b.s(sb, strValueOf, ", format_supported=", str3);
        }
        this(TextUtils.isEmpty(null) ? strS : strS.concat(": null"), exc, i3, i2, str2, i6, zzvVar, i5, zzwgVar, SystemClock.elapsedRealtime(), z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzit(String str, Throwable th, int i2, int i3, String str2, int i4, zzv zzvVar, int i5, zzwg zzwgVar, long j2, boolean z) {
        int i6;
        boolean z2;
        super(i2, j2, str, th);
        Bundle bundle = Bundle.EMPTY;
        if (!z) {
            i6 = i3;
            z2 = true;
        } else if (i3 == 1) {
            i6 = 1;
            z2 = true;
        } else {
            i6 = i3;
            z2 = false;
        }
        zzgqa.a(z2);
        zzgqa.a(th != null);
        this.f34967c = i6;
        this.f34968d = str2;
        this.f34969e = i4;
        this.f34970f = zzvVar;
        this.f34971g = i5;
        this.f34972h = zzwgVar;
        this.f34973i = z;
    }
}
