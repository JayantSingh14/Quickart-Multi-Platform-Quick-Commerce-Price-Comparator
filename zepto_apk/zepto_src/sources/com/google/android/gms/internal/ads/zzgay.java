package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzgay {
    public static byte[] a(String str, boolean z) {
        zzgvy zzgvyVarI;
        if (z) {
            zzgvx zzgvxVar = (zzgvx) zzgvy.f33276b;
            Character ch2 = zzgvxVar.f33273e;
            zzgvyVarI = zzgvxVar;
            if (ch2 != null) {
                zzgvyVarI = zzgvxVar.i(zzgvxVar.f33272d, null);
            }
        } else {
            zzgvyVarI = zzgvy.f33275a;
        }
        byte[] bArrH = zzgvyVarI.h(str);
        if (bArrH.length != 0 || str.length() <= 0) {
            return bArrH;
        }
        throw new IllegalArgumentException("Unable to decode ".concat(str));
    }
}
