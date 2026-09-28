package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzbnt implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final Context f25357a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f25358b;

    public zzbnt(Context context, HashMap map) {
        this.f25357a = context;
        this.f25358b = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    @Override // com.google.android.gms.internal.ads.zzbnn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r10, java.util.Map r11) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r9 = this;
            com.google.android.gms.ads.internal.zzt r10 = com.google.android.gms.ads.internal.zzt.C
            com.google.android.gms.internal.ads.zzcbw r0 = r10.y
            android.content.Context r1 = r9.f25357a
            boolean r0 = r0.a(r1)
            if (r0 != 0) goto Ld
            return
        Ld:
            java.lang.String r0 = "eventName"
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "eventId"
            java.lang.Object r11 = r11.get(r2)
            java.lang.String r11 = (java.lang.String) r11
            int r2 = r0.hashCode()
            java.lang.String r3 = "_ai"
            java.lang.String r4 = "_ac"
            r5 = 94399(0x170bf, float:1.32281E-40)
            r6 = 2
            java.lang.String r7 = "_aa"
            r8 = 1
            if (r2 == r5) goto L49
            r5 = 94401(0x170c1, float:1.32284E-40)
            if (r2 == r5) goto L41
            r5 = 94407(0x170c7, float:1.32292E-40)
            if (r2 == r5) goto L39
            goto L51
        L39:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L51
            r0 = r8
            goto L52
        L41:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L51
            r0 = 0
            goto L52
        L49:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L51
            r0 = r6
            goto L52
        L51:
            r0 = -1
        L52:
            com.google.android.gms.internal.ads.zzcbw r10 = r10.y
            java.util.HashMap r2 = r9.f25358b
            if (r0 == 0) goto L7a
            if (r0 == r8) goto L69
            if (r0 == r6) goto L64
            int r10 = com.google.android.gms.ads.internal.util.zze.f21576b
            java.lang.String r10 = "logScionEvent gmsg contained unsupported eventName"
            com.google.android.gms.ads.internal.util.client.zzo.c(r10)
            return
        L64:
            r0 = 0
            r10.h(r1, r7, r11, r0)
            return
        L69:
            java.lang.Object r0 = r2.get(r3)
            java.util.Map r0 = (java.util.Map) r0
            r10.getClass()
            android.os.Bundle r0 = com.google.android.gms.internal.ads.zzcbw.f(r0)
            r10.h(r1, r3, r11, r0)
            return
        L7a:
            java.lang.Object r0 = r2.get(r4)
            java.util.Map r0 = (java.util.Map) r0
            r10.getClass()
            android.os.Bundle r0 = com.google.android.gms.internal.ads.zzcbw.f(r0)
            r10.h(r1, r4, r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnt.a(java.lang.Object, java.util.Map):void");
    }
}
