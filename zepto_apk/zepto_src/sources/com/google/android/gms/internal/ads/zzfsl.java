package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfsl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f31794a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f31795b;

    public zzfsl(zzfsm zzfsmVar, WebView webView, String str) {
        this.f31794a = webView;
        this.f31795b = str;
        Objects.requireNonNull(zzfsmVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfsm.b(this.f31794a, this.f31795b);
    }
}
