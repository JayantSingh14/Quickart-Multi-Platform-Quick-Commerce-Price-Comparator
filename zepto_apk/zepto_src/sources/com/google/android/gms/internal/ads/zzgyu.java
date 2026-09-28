package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* loaded from: classes4.dex */
final class zzgyu {

    /* renamed from: a, reason: collision with root package name */
    public final zzgqz f33383a = new zzgqz();

    /* renamed from: b, reason: collision with root package name */
    public final String f33384b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Logger f33385c;

    public zzgyu(Class cls) {
        this.f33384b = cls.getName();
    }

    public final Logger a() {
        Logger logger = this.f33385c;
        if (logger != null) {
            return logger;
        }
        synchronized (this.f33383a) {
            try {
                Logger logger2 = this.f33385c;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.f33384b);
                this.f33385c = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
