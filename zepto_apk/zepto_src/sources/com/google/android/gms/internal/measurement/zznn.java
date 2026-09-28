package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zznn {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f37143a;

    static {
        char[] cArr = new char[80];
        f37143a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String a(zzme zzmeVar, String str) throws SecurityException {
        StringBuilder sbX = b.x("# ", str);
        c(zzmeVar, sbX, 0);
        return sbX.toString();
    }

    public static void b(StringBuilder sb, int i2, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                b(sb, i2, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                b(sb, i2, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        d(i2, sb);
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
            zzlg zzlgVar = zzlg.f37073b;
            sb.append(zzof.a(new zzlf(((String) obj).getBytes(zzmo.f37112a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzlg) {
            sb.append(": \"");
            sb.append(zzof.a((zzlg) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzme) {
            sb.append(" {");
            c((zzme) obj, sb, i2 + 2);
            sb.append(StringUtils.LF);
            d(i2, sb);
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
        b(sb, i4, "key", entry.getKey());
        b(sb, i4, CLConstants.FIELD_PAY_INFO_VALUE, entry.getValue());
        sb.append(StringUtils.LF);
        d(i2, sb);
        sb.append("}");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(com.google.android.gms.internal.measurement.zzme r19, java.lang.StringBuilder r20, int r21) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zznn.c(com.google.android.gms.internal.measurement.zzme, java.lang.StringBuilder, int):void");
    }

    public static void d(int i2, StringBuilder sb) {
        while (i2 > 0) {
            int i3 = 80;
            if (i2 <= 80) {
                i3 = i2;
            }
            sb.append(f37143a, 0, i3);
            i2 -= i3;
        }
    }
}
