package io.ktor.utils.io.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class CloseableJVMKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f51190a = LazyKt.b(CloseableJVMKt$AddSuppressedMethod$2.f51191c);

    public static final void a(Throwable th, Throwable other) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Method method = (Method) f51190a.getValue();
        if (method != null) {
            method.invoke(th, other);
        }
    }
}
