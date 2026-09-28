package com.google.android.gms.internal.ads;

import android.os.Handler;

/* loaded from: classes4.dex */
public final class zzfsn implements zzfsg {

    /* renamed from: d, reason: collision with root package name */
    public static zzfsn f31797d;

    /* renamed from: a, reason: collision with root package name */
    public float f31798a;

    /* renamed from: b, reason: collision with root package name */
    public zzfsb f31799b;

    /* renamed from: c, reason: collision with root package name */
    public zzfsf f31800c;

    public static zzfsn b() {
        if (f31797d == null) {
            new zzfry();
            new zzfsc();
            zzfsn zzfsnVar = new zzfsn();
            zzfsnVar.f31798a = 0.0f;
            f31797d = zzfsnVar;
        }
        return f31797d;
    }

    @Override // com.google.android.gms.internal.ads.zzfsg
    public final void a(boolean z) {
        if (z) {
            zzftp.f31840g.getClass();
            zzftp.b();
            return;
        }
        zzftp.f31840g.getClass();
        Handler handler = zzftp.f31842i;
        if (handler != null) {
            handler.removeCallbacks(zzftp.f31844k);
            zzftp.f31842i = null;
        }
    }
}
