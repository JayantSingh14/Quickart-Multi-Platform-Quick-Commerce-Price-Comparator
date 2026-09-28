package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzani {

    /* renamed from: f, reason: collision with root package name */
    public int f23752f;

    /* renamed from: h, reason: collision with root package name */
    public int f23754h;
    public float n;

    /* renamed from: a, reason: collision with root package name */
    public String f23747a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f23748b = "";

    /* renamed from: c, reason: collision with root package name */
    public Set f23749c = Collections.EMPTY_SET;

    /* renamed from: d, reason: collision with root package name */
    public String f23750d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f23751e = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean f23753g = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f23755i = false;

    /* renamed from: j, reason: collision with root package name */
    public int f23756j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f23757k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f23758l = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f23759m = -1;
    public int o = -1;
    public boolean p = false;

    public static int a(int i2, int i3, String str, String str2) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }
}
