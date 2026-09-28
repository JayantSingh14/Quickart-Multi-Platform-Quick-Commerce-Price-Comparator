package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
final class zzaej {

    /* renamed from: a, reason: collision with root package name */
    public final zzaei f22878a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f22879b = new AtomicBoolean(false);

    public zzaej(zzaei zzaeiVar) {
        this.f22878a = zzaeiVar;
    }

    public final zzaeo a(Object... objArr) {
        Constructor constructorZza;
        AtomicBoolean atomicBoolean = this.f22879b;
        synchronized (atomicBoolean) {
            if (!atomicBoolean.get()) {
                try {
                    constructorZza = this.f22878a.zza();
                } catch (ClassNotFoundException unused) {
                    this.f22879b.set(true);
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating extension", e2);
                }
            }
            constructorZza = null;
        }
        if (constructorZza == null) {
            return null;
        }
        try {
            return (zzaeo) constructorZza.newInstance(objArr);
        } catch (Exception e3) {
            throw new IllegalStateException("Unexpected error creating extractor", e3);
        }
    }
}
