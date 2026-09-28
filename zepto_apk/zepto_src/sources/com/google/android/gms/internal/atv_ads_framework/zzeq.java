package com.google.android.gms.internal.atv_ads_framework;

import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzeq {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f36153a;

    static {
        char[] cArr = new char[80];
        f36153a = cArr;
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
        b(i2, sb);
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
            sb.append(zzfn.a(new zzck(((String) obj).getBytes(zzdp.f36125a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzcn) {
            sb.append(": \"");
            sb.append(zzfn.a((zzcn) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzdh) {
            sb.append(" {");
            c((zzdh) obj, sb, i2 + 2);
            sb.append(StringUtils.LF);
            b(i2, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i2 + 2;
        a(sb, i4, "key", entry.getKey());
        a(sb, i4, CLConstants.FIELD_PAY_INFO_VALUE, entry.getValue());
        sb.append(StringUtils.LF);
        b(i2, sb);
        sb.append("}");
    }

    public static void b(int i2, StringBuilder sb) {
        while (i2 > 0) {
            int i3 = 80;
            if (i2 <= 80) {
                i3 = i2;
            }
            sb.append(f36153a, 0, i3);
            i2 -= i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(com.google.android.gms.internal.atv_ads_framework.zzdh r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzeq.c(com.google.android.gms.internal.atv_ads_framework.zzdh, java.lang.StringBuilder, int):void");
    }
}
