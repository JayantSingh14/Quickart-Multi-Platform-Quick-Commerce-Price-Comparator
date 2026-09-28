package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
final class zzaeb {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zzadz zzadzVar, String str) throws SecurityException {
        StringBuilder sbX = b.x("# ", str);
        zzd(zzadzVar, sbX, 0);
        return sbX.toString();
    }

    public static void zzb(StringBuilder sb, int i2, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i2, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i2, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i2, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i3 = 1; i3 < str.length(); i3++) {
                char cCharAt = str.charAt(i3);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append(Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzafi.zza(new zzabk(((String) obj).getBytes(zzacx.zzb))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzabn) {
            sb.append(": \"");
            sb.append(zzafi.zza((zzabn) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzacq) {
            sb.append(" {");
            zzd((zzacq) obj, sb, i2 + 2);
            sb.append(StringUtils.LF);
            zzc(i2, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i4 = i2 + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i4, "key", entry.getKey());
        zzb(sb, i4, CLConstants.FIELD_PAY_INFO_VALUE, entry.getValue());
        sb.append(StringUtils.LF);
        zzc(i2, sb);
        sb.append("}");
    }

    private static void zzc(int i2, StringBuilder sb) {
        while (i2 > 0) {
            int i3 = 80;
            if (i2 <= 80) {
                i3 = i2;
            }
            sb.append(zza, 0, i3);
            i2 -= i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzd(com.google.ads.interactivemedia.v3.internal.zzadz r18, java.lang.StringBuilder r19, int r20) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 555
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzaeb.zzd(com.google.ads.interactivemedia.v3.internal.zzadz, java.lang.StringBuilder, int):void");
    }
}
