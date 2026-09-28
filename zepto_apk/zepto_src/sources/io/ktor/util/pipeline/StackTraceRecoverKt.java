package io.ktor.util.pipeline;

import io.ktor.utils.io.ExceptionUtilsJvmKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class StackTraceRecoverKt {
    public static final Throwable a(Throwable exception, Continuation continuation) {
        Throwable thB;
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        try {
            Throwable cause = exception.getCause();
            Intrinsics.checkNotNullParameter(exception, "<this>");
            if (cause != null && !Intrinsics.b(exception.getCause(), cause) && (thB = ExceptionUtilsJvmKt.b(exception, cause)) != null) {
                thB.setStackTrace(exception.getStackTrace());
                return thB;
            }
        } catch (Throwable unused) {
        }
        return exception;
    }
}
