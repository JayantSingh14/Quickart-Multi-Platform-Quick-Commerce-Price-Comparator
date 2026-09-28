package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zziiv extends zziiy {

    /* renamed from: a, reason: collision with root package name */
    public final Logger f34860a;

    public zziiv(String str) {
        this.f34860a = Logger.getLogger(str);
    }

    @Override // com.google.android.gms.internal.ads.zziiy
    public final void a(String str) {
        this.f34860a.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
