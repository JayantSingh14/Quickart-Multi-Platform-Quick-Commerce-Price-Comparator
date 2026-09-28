package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxf;
import java.util.Set;
import java.util.logging.Level;

/* loaded from: classes4.dex */
abstract class zzgxs extends zzgxf.zzf {

    /* renamed from: j, reason: collision with root package name */
    public static final zzgxp f33354j;

    /* renamed from: k, reason: collision with root package name */
    public static final zzgyu f33355k = new zzgyu(zzgxs.class);

    /* renamed from: h, reason: collision with root package name */
    public volatile Set f33356h;

    /* renamed from: i, reason: collision with root package name */
    public volatile int f33357i;

    static {
        Throwable th;
        zzgxp zzgxrVar;
        try {
            zzgxrVar = new zzgxq();
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzgxrVar = new zzgxr();
        }
        Throwable th3 = th;
        f33354j = zzgxrVar;
        if (th3 != null) {
            f33355k.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th3);
        }
    }
}
