package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.concurrent.TimeUnit;

@ShowFirstParty
/* loaded from: classes4.dex */
public final class zzfuo {
    public static zzfvt a(Context context, zzbbq zzbbqVar, String str, String str2, zzfuf zzfufVar) {
        zzfvt zzfvtVar;
        zzfun zzfunVar = new zzfun(context, zzbbqVar, str, str2, zzfufVar);
        try {
            zzfvtVar = (zzfvt) zzfunVar.f31897e.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            zzfunVar.b(2009, zzfunVar.f31900h, e2);
            zzfvtVar = null;
        }
        zzfunVar.b(3004, zzfunVar.f31900h, null);
        if (zzfvtVar != null) {
            if (zzfvtVar.f31948c == 7) {
                zzfuf.f31872e = 3;
            } else {
                zzfuf.f31872e = 2;
            }
        }
        return zzfvtVar == null ? new zzfvt() : zzfvtVar;
    }
}
