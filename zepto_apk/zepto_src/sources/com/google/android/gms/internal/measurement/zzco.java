package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzco extends zzct {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f36829a = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    public boolean f36830b;

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
    
        r3 = r3.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object w1(android.os.Bundle r3, java.lang.Class r4) {
        /*
            if (r3 == 0) goto L2a
            java.lang.String r0 = "r"
            java.lang.Object r3 = r3.get(r0)
            if (r3 == 0) goto L2a
            java.lang.Object r3 = r4.cast(r3)     // Catch: java.lang.ClassCastException -> Lf
            return r3
        Lf:
            r0 = move-exception
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getCanonicalName()
            java.lang.String r1 = "Unexpected object type. Expected, Received: "
            java.lang.String r2 = ", "
            java.lang.String r3 = androidx.fragment.app.e.p(r1, r4, r2, r3)
            java.lang.String r4 = "AM"
            android.util.Log.w(r4, r3, r0)
            throw r0
        L2a:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzco.w1(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    @Override // com.google.android.gms.internal.measurement.zzcu
    public final void b0(Bundle bundle) {
        AtomicReference atomicReference = this.f36829a;
        synchronized (atomicReference) {
            try {
                try {
                    atomicReference.set(bundle);
                    this.f36830b = true;
                } finally {
                    this.f36829a.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bundle j1(long j2) {
        Bundle bundle;
        AtomicReference atomicReference = this.f36829a;
        synchronized (atomicReference) {
            if (!this.f36830b) {
                try {
                    atomicReference.wait(j2);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.f36829a.get();
        }
        return bundle;
    }

    public final String z0(long j2) {
        return (String) w1(j1(j2), String.class);
    }
}
