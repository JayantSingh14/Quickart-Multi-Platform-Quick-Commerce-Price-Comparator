package org.apache.commons.lang3.text.translate;

import com.google.android.gms.common.api.Api;

@Deprecated
/* loaded from: classes5.dex */
public class JavaUnicodeEscaper extends UnicodeEscaper {
    public JavaUnicodeEscaper(int i2, int i3, boolean z) {
        super(i2, i3, z);
    }

    public static JavaUnicodeEscaper above(int i2) {
        return outsideOf(0, i2);
    }

    public static JavaUnicodeEscaper below(int i2) {
        return outsideOf(i2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static JavaUnicodeEscaper between(int i2, int i3) {
        return new JavaUnicodeEscaper(i2, i3, true);
    }

    public static JavaUnicodeEscaper outsideOf(int i2, int i3) {
        return new JavaUnicodeEscaper(i2, i3, false);
    }

    @Override // org.apache.commons.lang3.text.translate.UnicodeEscaper
    public String toUtf16Escape(int i2) {
        char[] chars = Character.toChars(i2);
        return "\\u" + CharSequenceTranslator.hex(chars[0]) + "\\u" + CharSequenceTranslator.hex(chars[1]);
    }
}
