package com.google.android.gms.internal.ads;

import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
final class zzieg implements zziax {

    /* renamed from: a, reason: collision with root package name */
    public static final zziax f34809a = new zzieg();

    @Override // com.google.android.gms.internal.ads.zziax
    public final boolean zza(int i2) {
        if (i2 != 0 && i2 != 1 && i2 != 2 && i2 != 1999) {
            switch (i2) {
                case 1000:
                case DateUtils.SEMI_MONTH /* 1001 */:
                case 1002:
                case 1003:
                case 1004:
                case 1005:
                case 1006:
                case 1007:
                case 1008:
                case 1009:
                case 1010:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
