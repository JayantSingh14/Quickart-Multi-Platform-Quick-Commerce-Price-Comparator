package io.sentry.android.replay;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WindowManagerSpy$mViewsField$2 extends Lambda implements Function0<Field> {

    /* renamed from: c, reason: collision with root package name */
    public static final WindowManagerSpy$mViewsField$2 f52496c = new WindowManagerSpy$mViewsField$2(0);

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws NoSuchFieldException, SecurityException {
        Class cls = (Class) WindowManagerSpy.f52493a.getValue();
        if (cls == null) {
            return null;
        }
        Field declaredField = cls.getDeclaredField("mViews");
        declaredField.setAccessible(true);
        return declaredField;
    }
}
