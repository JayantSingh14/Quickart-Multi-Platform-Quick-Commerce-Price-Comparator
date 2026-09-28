package kotlinx.coroutines.test.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ExceptionCollector extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final ExceptionCollector f55329a = new ExceptionCollector(CoroutineExceptionHandler.Key.f54075a);

    /* renamed from: b, reason: collision with root package name */
    public static final Object f55330b = new Object();

    static {
        new ArrayList();
        new LinkedHashMap();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ExceptionCollector) || (obj instanceof ExceptionCollectorAsService);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
        synchronized (f55330b) {
        }
    }
}
