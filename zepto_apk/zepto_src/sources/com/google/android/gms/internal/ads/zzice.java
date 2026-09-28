package com.google.android.gms.internal.ads;

import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzice {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f34704a;

    static {
        char[] cArr = new char[80];
        f34704a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void a(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i2, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i2, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        c(i2, sb);
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
            zzhzl zzhzlVar = zzhzl.f34557b;
            sb.append(zzidd.a(new zzhzj(((String) obj).getBytes(zzibe.f34660a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzhzl) {
            sb.append(": \"");
            sb.append(zzidd.a((zzhzl) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zziar) {
            sb.append(" {");
            b((zziar) obj, sb, i2 + 2);
            sb.append(StringUtils.LF);
            c(i2, sb);
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
        a(sb, i4, "key", entry.getKey());
        a(sb, i4, CLConstants.FIELD_PAY_INFO_VALUE, entry.getValue());
        sb.append(StringUtils.LF);
        c(i2, sb);
        sb.append("}");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(com.google.android.gms.internal.ads.zziar r19, java.lang.StringBuilder r20, int r21) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzice.b(com.google.android.gms.internal.ads.zziar, java.lang.StringBuilder, int):void");
    }

    public static void c(int i2, StringBuilder sb) {
        while (i2 > 0) {
            int i3 = 80;
            if (i2 <= 80) {
                i3 = i2;
            }
            sb.append(f34704a, 0, i3);
            i2 -= i3;
        }
    }
}
