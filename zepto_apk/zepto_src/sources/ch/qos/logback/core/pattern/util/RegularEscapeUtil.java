package ch.qos.logback.core.pattern.util;

import android.support.v4.media.b;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public class RegularEscapeUtil implements IEscapeUtil {
    @Override // ch.qos.logback.core.pattern.util.IEscapeUtil
    public final void a(String str, StringBuffer stringBuffer, char c2, int i2) {
        if (str.indexOf(c2) >= 0) {
            stringBuffer.append(c2);
            return;
        }
        if (c2 == '\\') {
            stringBuffer.append(c2);
            return;
        }
        if (c2 != '_') {
            if (c2 == 'n') {
                stringBuffer.append('\n');
                return;
            }
            if (c2 == 'r') {
                stringBuffer.append(CharUtils.CR);
                return;
            }
            if (c2 == 't') {
                stringBuffer.append('\t');
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < str.length(); i3++) {
                sb.append(", \\");
                sb.append(str.charAt(i3));
            }
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder("Illegal char '");
            sb2.append(c2);
            sb2.append(" at column ");
            sb2.append(i2);
            sb2.append(". Only \\\\, \\_");
            throw new IllegalArgumentException(b.r(sb2, string, ", \\t, \\n, \\r combinations are allowed as escape characters."));
        }
    }
}
