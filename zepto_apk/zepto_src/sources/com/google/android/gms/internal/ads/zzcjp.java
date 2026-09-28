package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcjp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcju f26414a;

    public zzcjp(zzcju zzcjuVar) {
        Objects.requireNonNull(zzcjuVar);
        this.f26414a = zzcjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
