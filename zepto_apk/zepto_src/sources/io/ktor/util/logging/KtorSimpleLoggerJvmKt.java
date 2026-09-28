package io.ktor.util.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Metadata
/* loaded from: classes.dex */
public final class KtorSimpleLoggerJvmKt {
    public static final Logger a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Logger loggerC = LoggerFactory.c(name);
        Intrinsics.checkNotNullExpressionValue(loggerC, "getLogger(name)");
        return loggerC;
    }
}
