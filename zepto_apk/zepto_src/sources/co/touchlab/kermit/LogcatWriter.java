package co.touchlab.kermit;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class LogcatWriter extends LogWriter {

    /* renamed from: a, reason: collision with root package name */
    public final MessageStringFormatter f13846a;

    /* renamed from: b, reason: collision with root package name */
    public final CommonWriter f13847b;

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[Severity.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Severity severity = Severity.f13849a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Severity severity2 = Severity.f13849a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Severity severity3 = Severity.f13849a;
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Severity severity4 = Severity.f13849a;
                iArr[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Severity severity5 = Severity.f13849a;
                iArr[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public LogcatWriter() {
        this(0);
    }

    @Override // co.touchlab.kermit.LogWriter
    public final void a(String message, String tag) {
        Severity severity = Severity.f13850b;
        Intrinsics.checkNotNullParameter(severity, "severity");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Message.a(message);
        try {
            Log.i(tag, this.f13846a.a(null, null, message));
        } catch (Exception unused) {
            this.f13847b.a(message, tag);
        }
    }

    public LogcatWriter(int i2) {
        DefaultFormatter messageStringFormatter = DefaultFormatter.f13843a;
        Intrinsics.checkNotNullParameter(messageStringFormatter, "messageStringFormatter");
        this.f13846a = messageStringFormatter;
        this.f13847b = new CommonWriter(0);
    }
}
