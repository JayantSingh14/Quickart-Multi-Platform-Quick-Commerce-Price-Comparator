package io.sentry.android.replay;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class WindowManagerSpy$windowManagerInstance$2 extends Lambda implements Function0<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final WindowManagerSpy$windowManagerInstance$2 f52498c = new WindowManagerSpy$windowManagerInstance$2(0);

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Method method;
        Class cls = (Class) WindowManagerSpy.f52493a.getValue();
        if (cls == null || (method = cls.getMethod("getInstance", null)) == null) {
            return null;
        }
        return method.invoke(null, null);
    }
}
