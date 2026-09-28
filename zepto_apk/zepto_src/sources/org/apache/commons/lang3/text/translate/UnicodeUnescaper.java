package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: classes5.dex */
public class UnicodeUnescaper extends CharSequenceTranslator {
    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        int i3;
        int i4;
        if (charSequence.charAt(i2) != '\\' || (i3 = i2 + 1) >= charSequence.length() || charSequence.charAt(i3) != 'u') {
            return 0;
        }
        int i5 = 2;
        while (true) {
            i4 = i2 + i5;
            if (i4 >= charSequence.length() || charSequence.charAt(i4) != 'u') {
                break;
            }
            i5++;
        }
        if (i4 < charSequence.length() && charSequence.charAt(i4) == '+') {
            i5++;
        }
        int i6 = i2 + i5;
        int i7 = i6 + 4;
        if (i7 > charSequence.length()) {
            throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + ((Object) charSequence.subSequence(i2, charSequence.length())) + "' due to end of CharSequence");
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(i6, i7);
        try {
            writer.write((char) Integer.parseInt(charSequenceSubSequence.toString(), 16));
            return i5 + 4;
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unable to parse unicode value: " + ((Object) charSequenceSubSequence), e2);
        }
    }
}
