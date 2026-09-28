package co.touchlab.kermit;

import co.touchlab.kermit.MessageStringFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class NoTagFormatter implements MessageStringFormatter {
    @Override // co.touchlab.kermit.MessageStringFormatter
    public final String a(Severity severity, String str, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return MessageStringFormatter.DefaultImpls.a(this, severity, null, message);
    }

    @Override // co.touchlab.kermit.MessageStringFormatter
    public final String b(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return "";
    }

    @Override // co.touchlab.kermit.MessageStringFormatter
    public final String c(Severity severity) {
        return MessageStringFormatter.DefaultImpls.b(severity);
    }
}
