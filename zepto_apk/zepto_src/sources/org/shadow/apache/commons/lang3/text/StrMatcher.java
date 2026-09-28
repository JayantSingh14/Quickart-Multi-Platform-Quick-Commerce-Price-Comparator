package org.shadow.apache.commons.lang3.text;

import java.util.Arrays;

/* loaded from: classes5.dex */
public abstract class StrMatcher {

    /* renamed from: a, reason: collision with root package name */
    public static final StrMatcher f57766a = new CharMatcher(',');

    /* renamed from: b, reason: collision with root package name */
    public static final StrMatcher f57767b = new CharMatcher('\t');

    /* renamed from: c, reason: collision with root package name */
    public static final StrMatcher f57768c = new CharSetMatcher(" \t\n\r\f".toCharArray());

    /* renamed from: d, reason: collision with root package name */
    public static final StrMatcher f57769d = new TrimMatcher();

    /* renamed from: e, reason: collision with root package name */
    public static final StrMatcher f57770e = new CharMatcher('\"');

    /* renamed from: f, reason: collision with root package name */
    public static final StrMatcher f57771f;

    public static final class CharMatcher extends StrMatcher {

        /* renamed from: g, reason: collision with root package name */
        public final char f57772g;

        public CharMatcher(char c2) {
            this.f57772g = c2;
        }

        @Override // org.shadow.apache.commons.lang3.text.StrMatcher
        public final int a(char[] cArr, int i2, int i3) {
            return this.f57772g == cArr[i2] ? 1 : 0;
        }
    }

    public static final class CharSetMatcher extends StrMatcher {

        /* renamed from: g, reason: collision with root package name */
        public final char[] f57773g;

        public CharSetMatcher(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.f57773g = cArr2;
            Arrays.sort(cArr2);
        }

        @Override // org.shadow.apache.commons.lang3.text.StrMatcher
        public final int a(char[] cArr, int i2, int i3) {
            return Arrays.binarySearch(this.f57773g, cArr[i2]) >= 0 ? 1 : 0;
        }
    }

    public static final class NoMatcher extends StrMatcher {
        @Override // org.shadow.apache.commons.lang3.text.StrMatcher
        public final int a(char[] cArr, int i2, int i3) {
            return 0;
        }
    }

    public static final class StringMatcher extends StrMatcher {

        /* renamed from: g, reason: collision with root package name */
        public final char[] f57774g;

        public StringMatcher(String str) {
            this.f57774g = str.toCharArray();
        }

        @Override // org.shadow.apache.commons.lang3.text.StrMatcher
        public final int a(char[] cArr, int i2, int i3) {
            char[] cArr2 = this.f57774g;
            int length = cArr2.length;
            if (i2 + length <= i3) {
                int i4 = 0;
                while (i4 < cArr2.length) {
                    if (cArr2[i4] == cArr[i2]) {
                        i4++;
                        i2++;
                    }
                }
                return length;
            }
            return 0;
        }
    }

    public static final class TrimMatcher extends StrMatcher {
        @Override // org.shadow.apache.commons.lang3.text.StrMatcher
        public final int a(char[] cArr, int i2, int i3) {
            return cArr[i2] <= ' ' ? 1 : 0;
        }
    }

    static {
        new CharSetMatcher("'\"".toCharArray());
        f57771f = new NoMatcher();
    }

    public abstract int a(char[] cArr, int i2, int i3);
}
