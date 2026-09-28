package io.sentry.android.replay;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WindowSpy$windowField$2 extends Lambda implements Function0<Field> {

    /* renamed from: c, reason: collision with root package name */
    public static final WindowSpy$windowField$2 f52515c = new WindowSpy$windowField$2(0);

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws NoSuchFieldException, SecurityException {
        Class cls = (Class) WindowSpy.f52512a.getValue();
        if (cls == null) {
            return null;
        }
        try {
            Field declaredField = cls.getDeclaredField("mWindow");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e2) {
            Log.d("WindowSpy", "Unexpected exception retrieving " + cls + "#mWindow on API " + Build.VERSION.SDK_INT, e2);
            return null;
        }
    }
}
