package org.xbill.DNS;

import java.io.IOException;

/* loaded from: classes5.dex */
public class TextParseException extends IOException {
    public TextParseException() {
    }

    public TextParseException(String str) {
        super(str);
    }

    public TextParseException(String str, String str2) {
        super(androidx.fragment.app.e.p("'", str, "': ", str2));
    }

    public TextParseException(String str, String str2, Exception exc) {
        super(androidx.fragment.app.e.p("'", str, "': ", str2), exc);
    }
}
