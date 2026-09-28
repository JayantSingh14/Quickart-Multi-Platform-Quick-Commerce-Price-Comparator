package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzbnq {

    /* renamed from: a, reason: collision with root package name */
    public boolean f25352a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f25353b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f25354c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f25355d = new AtomicBoolean(false);

    public final synchronized boolean a(boolean z) {
        if (!this.f25355d.get()) {
            return z;
        }
        return this.f25352a;
    }
}
