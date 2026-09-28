package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhkk extends RuntimeException {
    public static Object a(zzhkj zzhkjVar) {
        try {
            return zzhkjVar.zza();
        } catch (Exception e2) {
            throw new zzhkk(e2);
        }
    }
}
