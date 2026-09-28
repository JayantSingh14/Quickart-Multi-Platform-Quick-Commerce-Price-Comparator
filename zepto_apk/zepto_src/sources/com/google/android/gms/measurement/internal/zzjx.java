package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzjx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f39225a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39226b;

    public zzjx(zzli zzliVar, boolean z) {
        this.f39225a = z;
        Objects.requireNonNull(zzliVar);
        this.f39226b = zzliVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.zzli r0 = r9.f39226b
            com.google.android.gms.measurement.internal.zzib r1 = r0.f39180a
            boolean r2 = r1.a()
            java.lang.Boolean r3 = r1.y
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L18
            java.lang.Boolean r3 = r1.y
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L18
            r3 = r5
            goto L19
        L18:
            r3 = r4
        L19:
            boolean r6 = r9.f39225a
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            r1.y = r7
            if (r3 != r6) goto L33
            com.google.android.gms.measurement.internal.zzgt r3 = r1.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r3)
            com.google.android.gms.measurement.internal.zzgr r3 = r3.n
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            java.lang.String r8 = "Default data collection state already set to"
            r3.b(r7, r8)
        L33:
            boolean r3 = r1.a()
            if (r3 == r2) goto L4c
            boolean r3 = r1.a()
            java.lang.Boolean r7 = r1.y
            if (r7 == 0) goto L4a
            java.lang.Boolean r7 = r1.y
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L4a
            r4 = r5
        L4a:
            if (r3 == r4) goto L60
        L4c:
            com.google.android.gms.measurement.internal.zzgt r1 = r1.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r1)
            com.google.android.gms.measurement.internal.zzgr r1 = r1.f38963k
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r6)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r4 = "Default data collection is different than actual status"
            r1.c(r4, r3, r2)
        L60:
            r0.E()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjx.run():void");
    }
}
