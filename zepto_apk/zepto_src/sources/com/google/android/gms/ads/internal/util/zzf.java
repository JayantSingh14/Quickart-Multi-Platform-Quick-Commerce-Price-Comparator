package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.Message;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.internal.ads.zzbit;
import com.google.android.gms.internal.ads.zzfxl;

/* loaded from: classes4.dex */
public final class zzf extends zzfxl {
    @Override // com.google.android.gms.internal.ads.zzfxl
    public final void a(Message message) {
        try {
            super.a(message);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            zzs zzsVar = zztVar.f21679c;
            Context context = zztVar.f21684h.f25935e;
            if (context != null) {
                try {
                    if (((Boolean) zzbit.f25214b.c()).booleanValue()) {
                        CrashUtils.addDynamiteErrorToDropBox(context, th);
                    }
                } catch (IllegalStateException unused) {
                }
            }
            throw th;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdMobHandler.handleMessage", e2);
        }
    }
}
