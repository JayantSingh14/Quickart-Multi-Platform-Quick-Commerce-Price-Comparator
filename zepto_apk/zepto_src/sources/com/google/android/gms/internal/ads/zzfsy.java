package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfsy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final WebView f31815a;

    public zzfsy(zzfsz zzfszVar) {
        Objects.requireNonNull(zzfszVar);
        this.f31815a = zzfszVar.f31816e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f31815a.destroy();
    }
}
