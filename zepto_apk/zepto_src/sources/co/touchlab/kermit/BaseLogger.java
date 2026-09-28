package co.touchlab.kermit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class BaseLogger {

    /* renamed from: a, reason: collision with root package name */
    public final LoggerConfig f13840a;

    public BaseLogger(LoggerConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f13840a = config;
    }
}
