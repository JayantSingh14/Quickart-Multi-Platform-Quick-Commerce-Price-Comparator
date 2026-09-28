package co.touchlab.kermit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public class CommonWriter extends LogWriter {

    /* renamed from: a, reason: collision with root package name */
    public final MessageStringFormatter f13842a;

    public CommonWriter() {
        this(0);
    }

    @Override // co.touchlab.kermit.LogWriter
    public final void a(String message, String tag) {
        Severity severity = Severity.f13850b;
        Intrinsics.checkNotNullParameter(severity, "severity");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Tag.a(tag);
        Message.a(message);
        System.out.println((Object) this.f13842a.a(severity, tag, message));
    }

    public CommonWriter(int i2) {
        DefaultFormatter messageStringFormatter = DefaultFormatter.f13843a;
        Intrinsics.checkNotNullParameter(messageStringFormatter, "messageStringFormatter");
        this.f13842a = messageStringFormatter;
    }
}
