package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public final class zzbbg {

    /* renamed from: a, reason: collision with root package name */
    public final zzazt f24663a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24664b;

    /* renamed from: c, reason: collision with root package name */
    public final String f24665c;

    /* renamed from: e, reason: collision with root package name */
    public final Class[] f24667e;

    /* renamed from: d, reason: collision with root package name */
    public volatile Method f24666d = null;

    /* renamed from: f, reason: collision with root package name */
    public final CountDownLatch f24668f = new CountDownLatch(1);

    public zzbbg(zzazt zzaztVar, String str, String str2, Class... clsArr) {
        this.f24663a = zzaztVar;
        this.f24664b = str;
        this.f24665c = str2;
        this.f24667e = clsArr;
        zzaztVar.f24559b.submit(new zzbbf(this));
    }
}
