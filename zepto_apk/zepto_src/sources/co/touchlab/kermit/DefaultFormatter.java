package co.touchlab.kermit;

import co.touchlab.kermit.MessageStringFormatter;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class DefaultFormatter implements MessageStringFormatter {

    /* renamed from: a, reason: collision with root package name */
    public static final DefaultFormatter f13843a = new DefaultFormatter();

    @Override // co.touchlab.kermit.MessageStringFormatter
    public final String a(Severity severity, String str, String str2) {
        return MessageStringFormatter.DefaultImpls.a(this, severity, str, str2);
    }

    @Override // co.touchlab.kermit.MessageStringFormatter
    public final String b(String str) {
        return MessageStringFormatter.DefaultImpls.c(str);
    }

    @Override // co.touchlab.kermit.MessageStringFormatter
    public final String c(Severity severity) {
        return MessageStringFormatter.DefaultImpls.b(severity);
    }
}
