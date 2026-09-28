package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public interface zzfne {
    static zzfne e(Context context, int i2, int i3, com.google.android.gms.ads.internal.client.zzm zzmVar) {
        boolean zMatches;
        zzfne zzfneVarF = f(i2, context);
        if (zzfneVarF instanceof zzfng) {
            zzfneVarF.zza();
            zzfneVarF.h(i3);
            zzfneVarF.g(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.c(zzmVar.f21266m));
            String str = zzmVar.p;
            if (TextUtils.isEmpty(str)) {
                zMatches = false;
            } else {
                zMatches = Pattern.matches((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.O9), str);
            }
            if (zMatches) {
                zzfneVarF.q(str);
            }
        }
        return zzfneVarF;
    }

    static zzfne f(int i2, Context context) {
        boolean zBooleanValue;
        if (zzfnr.a()) {
            int i3 = i2 - 2;
            if (i3 == 20 || i3 == 21) {
                zBooleanValue = ((Boolean) zzbid.f25135e.c()).booleanValue();
            } else if (i3 != 110) {
                switch (i3) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        zBooleanValue = ((Boolean) zzbid.f25133c.c()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        zBooleanValue = ((Boolean) zzbid.f25134d.c()).booleanValue();
                        break;
                    case 5:
                        zBooleanValue = ((Boolean) zzbid.f25132b.c()).booleanValue();
                        break;
                }
            } else {
                zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.W9)).booleanValue();
            }
            if (zBooleanValue) {
                return new zzfng(context, i2);
            }
        }
        return new zzfof();
    }

    zzfne a(boolean z);

    zzfne b(String str);

    zzfne c(Throwable th);

    zzfne d(com.google.android.gms.ads.internal.client.zze zzeVar);

    zzfne g(zzfnt zzfntVar);

    zzfne h(int i2);

    zzfne i(zzfib zzfibVar);

    zzfne q(String str);

    zzfne zza();

    boolean zzb();

    zzfne zzc();

    zzfne zzi(String str);

    boolean zzl();

    zzfnh zzm();
}
