package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class CloseGuard {

    /* renamed from: a, reason: collision with root package name */
    public final Method f56805a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f56806b;

    /* renamed from: c, reason: collision with root package name */
    public final Method f56807c;

    @Metadata
    public static final class Companion {
    }

    public CloseGuard(Method method, Method method2, Method method3) {
        this.f56805a = method;
        this.f56806b = method2;
        this.f56807c = method3;
    }
}
