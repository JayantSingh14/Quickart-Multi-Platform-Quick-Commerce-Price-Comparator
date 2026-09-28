package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;

@Deprecated
/* loaded from: classes5.dex */
public class NumericEntityUnescaper extends CharSequenceTranslator {
    private final EnumSet<OPTION> options;

    public enum OPTION {
        semiColonRequired,
        semiColonOptional,
        errorIfNoSemiColon
    }

    public NumericEntityUnescaper(OPTION... optionArr) {
        if (optionArr.length > 0) {
            this.options = EnumSet.copyOf((Collection) Arrays.asList(optionArr));
        } else {
            this.options = EnumSet.copyOf((Collection) Arrays.asList(OPTION.semiColonRequired));
        }
    }

    public boolean isSet(OPTION option) {
        EnumSet<OPTION> enumSet = this.options;
        return enumSet != null && enumSet.contains(option);
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        int i3;
        int length = charSequence.length();
        if (charSequence.charAt(i2) == '&' && i2 < length - 2 && charSequence.charAt(i2 + 1) == '#') {
            int i4 = i2 + 2;
            char cCharAt = charSequence.charAt(i4);
            if (cCharAt == 'x' || cCharAt == 'X') {
                i4 = i2 + 3;
                if (i4 == length) {
                    return 0;
                }
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i5 = i4;
            while (i5 < length && ((charSequence.charAt(i5) >= '0' && charSequence.charAt(i5) <= '9') || ((charSequence.charAt(i5) >= 'a' && charSequence.charAt(i5) <= 'f') || (charSequence.charAt(i5) >= 'A' && charSequence.charAt(i5) <= 'F')))) {
                i5++;
            }
            int i6 = (i5 == length || charSequence.charAt(i5) != ';') ? 0 : 1;
            if (i6 == 0) {
                if (isSet(OPTION.semiColonRequired)) {
                    return 0;
                }
                if (isSet(OPTION.errorIfNoSemiColon)) {
                    throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                }
            }
            try {
                int i7 = i3 != 0 ? Integer.parseInt(charSequence.subSequence(i4, i5).toString(), 16) : Integer.parseInt(charSequence.subSequence(i4, i5).toString(), 10);
                if (i7 > 65535) {
                    char[] chars = Character.toChars(i7);
                    writer.write(chars[0]);
                    writer.write(chars[1]);
                } else {
                    writer.write(i7);
                }
                return ((i5 + 2) - i4) + i3 + i6;
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }
}
