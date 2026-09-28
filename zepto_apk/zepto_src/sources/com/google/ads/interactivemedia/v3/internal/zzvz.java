package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzvz {
    private static final int zza;

    static {
        int i2;
        String property = System.getProperty("java.version");
        try {
            String[] strArrSplit = property.split("[._]", 3);
            i2 = Integer.parseInt(strArrSplit[0]);
            if (i2 == 1) {
                i2 = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 1;
            }
        } catch (NumberFormatException unused) {
            i2 = -1;
        }
        if (i2 == -1) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < property.length(); i3++) {
                    char cCharAt = property.charAt(i3);
                    if (!Character.isDigit(cCharAt)) {
                        break;
                    }
                    sb.append(cCharAt);
                }
                i2 = Integer.parseInt(sb.toString());
            } catch (NumberFormatException unused2) {
                i2 = -1;
            }
        }
        if (i2 == -1) {
            i2 = 6;
        }
        zza = i2;
    }

    public static boolean zza() {
        return zza >= 9;
    }
}
