package io.ktor.utils.io.core;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class CloseableJVMKt$AddSuppressedMethod$2 extends Lambda implements Function0<Method> {

    /* renamed from: c, reason: collision with root package name */
    public static final CloseableJVMKt$AddSuppressedMethod$2 f51191c = new CloseableJVMKt$AddSuppressedMethod$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        try {
            return Throwable.class.getMethod("addSuppressed", Throwable.class);
        } catch (Throwable unused) {
            return null;
        }
    }
}
