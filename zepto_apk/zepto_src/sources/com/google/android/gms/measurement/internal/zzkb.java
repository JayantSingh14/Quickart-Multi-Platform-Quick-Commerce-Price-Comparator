package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzkb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39236a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39237b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f39238c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Bundle f39239d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f39240e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f39241f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f39242g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzli f39243h;

    public zzkb(zzli zzliVar, String str, String str2, long j2, Bundle bundle, boolean z, boolean z2, boolean z3) {
        this.f39236a = str;
        this.f39237b = str2;
        this.f39238c = j2;
        this.f39239d = bundle;
        this.f39240e = z;
        this.f39241f = z2;
        this.f39242g = z3;
        Objects.requireNonNull(zzliVar);
        this.f39243h = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f39243h.q(this.f39236a, this.f39237b, this.f39238c, this.f39239d, this.f39240e, this.f39241f, this.f39242g);
    }
}
