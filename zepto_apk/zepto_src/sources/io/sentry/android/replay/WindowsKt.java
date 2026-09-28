package io.sentry.android.replay;

import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class WindowsKt {
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, kotlin.Lazy] */
    public static final Window a(View view) throws IllegalAccessException, IllegalArgumentException {
        Field field;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object obj = WindowSpy.f52512a;
        View maybeDecorView = view.getRootView();
        Intrinsics.checkNotNullExpressionValue(maybeDecorView, "rootView");
        Intrinsics.checkNotNullParameter(maybeDecorView, "maybeDecorView");
        Class cls = (Class) WindowSpy.f52512a.getValue();
        if (cls == null || !cls.isInstance(maybeDecorView) || (field = (Field) WindowSpy.f52513b.getValue()) == null) {
            return null;
        }
        Object obj2 = field.get(maybeDecorView);
        Intrinsics.d(obj2, "null cannot be cast to non-null type android.view.Window");
        return (Window) obj2;
    }
}
