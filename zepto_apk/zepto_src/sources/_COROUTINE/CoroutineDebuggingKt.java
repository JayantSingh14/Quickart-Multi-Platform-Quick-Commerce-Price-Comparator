package _COROUTINE;

import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CoroutineDebuggingKt {
    public static final StackTraceElement a(String str, Exception exc) {
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        return new StackTraceElement("_COROUTINE.".concat(str), Attributes.PREDEFINED_ATTRIBUTE_PREFIX, stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}
