package co.touchlab.kermit;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class Logger extends BaseLogger {

    /* renamed from: b, reason: collision with root package name */
    public final String f13848b;

    @Metadata
    @SourceDebugExtension
    public static final class Companion extends Logger {
    }

    static {
        DefaultFormatter messageStringFormatter = DefaultFormatter.f13843a;
        Intrinsics.checkNotNullParameter(messageStringFormatter, "messageStringFormatter");
        List logWriters = CollectionsKt.H(new LogcatWriter(0));
        Intrinsics.checkNotNullParameter(logWriters, "logWriters");
        Intrinsics.checkNotNullParameter(logWriters, "logWriters");
        JvmMutableLoggerConfig jvmMutableLoggerConfig = new JvmMutableLoggerConfig();
        jvmMutableLoggerConfig.f13844a = BaseLoggerKt.f13841a;
        jvmMutableLoggerConfig.f13845b = logWriters;
        new Companion(jvmMutableLoggerConfig, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Logger(LoggerConfig config, String tag) {
        super(config);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.f13848b = tag;
    }
}
