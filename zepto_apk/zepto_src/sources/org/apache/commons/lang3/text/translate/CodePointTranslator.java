package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: classes5.dex */
public abstract class CodePointTranslator extends CharSequenceTranslator {
    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public final int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        return translate(Character.codePointAt(charSequence, i2), writer) ? 1 : 0;
    }

    public abstract boolean translate(int i2, Writer writer) throws IOException;
}
