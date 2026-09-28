package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.Spanned;

/* loaded from: classes4.dex */
final class zzda {

    /* renamed from: a, reason: collision with root package name */
    public static final String f27535a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f27536b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f27537c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f27538d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f27539e;

    static {
        String str = zzfj.f31254a;
        f27535a = Integer.toString(0, 36);
        f27536b = Integer.toString(1, 36);
        f27537c = Integer.toString(2, 36);
        f27538d = Integer.toString(3, 36);
        f27539e = Integer.toString(4, 36);
    }

    public static Bundle a(Spanned spanned, Object obj, int i2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f27535a, spanned.getSpanStart(obj));
        bundle2.putInt(f27536b, spanned.getSpanEnd(obj));
        bundle2.putInt(f27537c, spanned.getSpanFlags(obj));
        bundle2.putInt(f27538d, i2);
        if (bundle != null) {
            bundle2.putBundle(f27539e, bundle);
        }
        return bundle2;
    }
}
