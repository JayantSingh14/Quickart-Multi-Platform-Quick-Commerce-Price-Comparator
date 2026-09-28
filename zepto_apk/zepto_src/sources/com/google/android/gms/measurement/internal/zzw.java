package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;

/* loaded from: classes4.dex */
public final class zzw extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final zzib f39664a;

    public zzw(zzib zzibVar) {
        this.f39664a = zzibVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzib r4 = r3.f39664a
            if (r5 != 0) goto L11
            com.google.android.gms.measurement.internal.zzgt r4 = r4.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r4)
            java.lang.String r5 = "App receiver called with null intent"
            com.google.android.gms.measurement.internal.zzgr r4 = r4.f38961i
            r4.a(r5)
            return
        L11:
            java.lang.String r5 = r5.getAction()
            if (r5 != 0) goto L24
            com.google.android.gms.measurement.internal.zzgt r4 = r4.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r4)
            java.lang.String r5 = "App receiver called with null action"
            com.google.android.gms.measurement.internal.zzgr r4 = r4.f38961i
            r4.a(r5)
            return
        L24:
            int r0 = r5.hashCode()
            r1 = -1928239649(0xffffffff8d1165df, float:-4.4804198E-31)
            r2 = 1
            if (r0 == r1) goto L3e
            r1 = 1279883384(0x4c497878, float:5.2814304E7)
            if (r0 == r1) goto L34
            goto L48
        L34:
            java.lang.String r0 = "com.google.android.gms.measurement.BATCHES_AVAILABLE"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L48
            r5 = r2
            goto L49
        L3e:
            java.lang.String r0 = "com.google.android.gms.measurement.TRIGGERS_AVAILABLE"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L48
            r5 = 0
            goto L49
        L48:
            r5 = -1
        L49:
            if (r5 == 0) goto L74
            if (r5 == r2) goto L5a
            com.google.android.gms.measurement.internal.zzgt r4 = r4.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r4)
            java.lang.String r5 = "App receiver called with unknown action"
            com.google.android.gms.measurement.internal.zzgr r4 = r4.f38961i
            r4.a(r5)
            return
        L5a:
            com.google.android.gms.measurement.internal.zzgt r5 = r4.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r5)
            java.lang.String r0 = "[sgtm] App Receiver notified batches are available"
            com.google.android.gms.measurement.internal.zzgr r5 = r5.n
            r5.a(r0)
            com.google.android.gms.measurement.internal.zzhy r4 = r4.f39090g
            com.google.android.gms.measurement.internal.zzib.l(r4)
            com.google.android.gms.measurement.internal.zzt r5 = new com.google.android.gms.measurement.internal.zzt
            r5.<init>()
            r4.p(r5)
            return
        L74:
            com.google.android.gms.internal.measurement.zzql.a()
            com.google.android.gms.measurement.internal.zzal r5 = r4.f39087d
            r0 = 0
            com.google.android.gms.measurement.internal.zzfw r1 = com.google.android.gms.measurement.internal.zzfx.Q0
            boolean r5 = r5.q(r0, r1)
            if (r5 != 0) goto L83
            return
        L83:
            com.google.android.gms.measurement.internal.zzgt r5 = r4.f39089f
            com.google.android.gms.measurement.internal.zzib.l(r5)
            java.lang.String r0 = "App receiver notified triggers are available"
            com.google.android.gms.measurement.internal.zzgr r5 = r5.n
            r5.a(r0)
            com.google.android.gms.measurement.internal.zzhy r5 = r4.f39090g
            com.google.android.gms.measurement.internal.zzib.l(r5)
            com.google.android.gms.measurement.internal.zzu r0 = new com.google.android.gms.measurement.internal.zzu
            r0.<init>()
            r5.p(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzw.onReceive(android.content.Context, android.content.Intent):void");
    }
}
