package io.ktor.http.content;

import io.ktor.utils.io.jvm.javaio.PollersKt;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class BlockingBridgeKt$isParkingAllowedFunction$2 extends Lambda implements Function0<Method> {

    /* renamed from: c, reason: collision with root package name */
    public static final BlockingBridgeKt$isParkingAllowedFunction$2 f50282c = new BlockingBridgeKt$isParkingAllowedFunction$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        try {
            ThreadLocal threadLocal = PollersKt.f51329a;
            return PollersKt.class.getMethod("isParkingAllowed", null);
        } catch (Throwable unused) {
            return null;
        }
    }
}
