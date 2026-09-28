package org.shadow.apache.commons.lang3.time;

import org.shadow.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class DurationFormatUtils {

    public static class Token {

        /* renamed from: a, reason: collision with root package name */
        public final Object f57800a;

        /* renamed from: b, reason: collision with root package name */
        public int f57801b = 1;

        public Token(Object obj) {
            this.f57800a = obj;
        }

        public static boolean a(Token[] tokenArr, String str) {
            for (Token token : tokenArr) {
                if (token.f57800a == str) {
                    return true;
                }
            }
            return false;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Token) {
                Token token = (Token) obj;
                Object obj2 = this.f57800a;
                if (obj2.getClass() != token.f57800a.getClass() || this.f57801b != token.f57801b) {
                    return false;
                }
                boolean z = obj2 instanceof StringBuilder;
                Object obj3 = token.f57800a;
                if (z) {
                    return obj2.toString().equals(obj3.toString());
                }
                if (obj2 instanceof Number) {
                    return obj2.equals(obj3);
                }
                if (obj2 == obj3) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f57800a.hashCode();
        }

        public final String toString() {
            String string = this.f57800a.toString();
            int i2 = this.f57801b;
            if (string == null) {
                return null;
            }
            if (i2 <= 0) {
                return "";
            }
            int length = string.length();
            if (i2 == 1 || length == 0) {
                return string;
            }
            if (length == 1 && i2 <= 8192) {
                return StringUtils.c(string.charAt(0), i2);
            }
            int i3 = length * i2;
            if (length == 1) {
                return StringUtils.c(string.charAt(0), i2);
            }
            if (length != 2) {
                StringBuilder sb = new StringBuilder(i3);
                for (int i4 = 0; i4 < i2; i4++) {
                    sb.append(string);
                }
                return sb.toString();
            }
            char cCharAt = string.charAt(0);
            char cCharAt2 = string.charAt(1);
            char[] cArr = new char[i3];
            for (int i5 = (i2 * 2) - 2; i5 >= 0; i5 -= 2) {
                cArr[i5] = cCharAt;
                cArr[i5 + 1] = cCharAt2;
            }
            return new String(cArr);
        }
    }

    public static String a(int i2, long j2) {
        return StringUtils.b(Long.toString(j2), i2, '0');
    }
}
