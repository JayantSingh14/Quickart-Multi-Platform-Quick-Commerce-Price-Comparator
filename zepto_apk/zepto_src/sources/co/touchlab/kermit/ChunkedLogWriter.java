package co.touchlab.kermit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public final class ChunkedLogWriter extends LogWriter {
    @Override // co.touchlab.kermit.LogWriter
    public final void a(String message, String tag) {
        Severity severity = Severity.f13850b;
        Intrinsics.checkNotNullParameter(severity, "severity");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (message.length() <= 0) {
            throw null;
        }
        String strSubstring = message.substring(0, 0);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        int iB = StringsKt.B(strSubstring, '\n', 0, 6);
        if (iB < 0) {
            throw null;
        }
        Intrinsics.checkNotNullExpressionValue(strSubstring.substring(0, iB), "substring(...)");
        throw null;
    }
}
