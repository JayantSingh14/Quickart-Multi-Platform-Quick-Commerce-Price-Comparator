package com.google.android.gms.internal.pal;

import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public final class zzff {

    /* renamed from: a, reason: collision with root package name */
    public final zzdu f37717a;

    /* renamed from: b, reason: collision with root package name */
    public final String f37718b;

    /* renamed from: c, reason: collision with root package name */
    public final String f37719c;

    /* renamed from: e, reason: collision with root package name */
    public final Class[] f37721e;

    /* renamed from: d, reason: collision with root package name */
    public volatile Method f37720d = null;

    /* renamed from: f, reason: collision with root package name */
    public final CountDownLatch f37722f = new CountDownLatch(1);

    public zzff(zzdu zzduVar, String str, String str2, Class... clsArr) {
        this.f37717a = zzduVar;
        this.f37718b = str;
        this.f37719c = str2;
        this.f37721e = clsArr;
        zzduVar.f37635b.submit(new zzfe(this));
    }
}
