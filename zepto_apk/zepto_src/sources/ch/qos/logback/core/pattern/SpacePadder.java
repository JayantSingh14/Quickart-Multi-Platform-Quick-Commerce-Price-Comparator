package ch.qos.logback.core.pattern;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class SpacePadder {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f13664a = {StringUtils.SPACE, "  ", "    ", "        ", "                ", "                                "};

    public static final void a(StringBuilder sb, int i2, String str) {
        int length = str.length();
        if (length < i2) {
            c(i2 - length, sb);
        }
        sb.append(str);
    }

    public static final void b(StringBuilder sb, int i2, String str) {
        int length = str.length();
        sb.append(str);
        if (length < i2) {
            c(i2 - length, sb);
        }
    }

    public static final void c(int i2, StringBuilder sb) {
        String[] strArr;
        while (true) {
            strArr = f13664a;
            if (i2 < 32) {
                break;
            }
            sb.append(strArr[5]);
            i2 -= 32;
        }
        for (int i3 = 4; i3 >= 0; i3--) {
            if (((1 << i3) & i2) != 0) {
                sb.append(strArr[i3]);
            }
        }
    }
}
