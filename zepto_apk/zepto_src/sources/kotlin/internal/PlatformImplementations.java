package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class PlatformImplementations {

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class ReflectThrowable {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final ReflectThrowable f53714a = new ReflectThrowable();

        /* renamed from: b, reason: collision with root package name */
        public static final Method f53715b;

        static {
            Method method;
            Method[] methods = Throwable.class.getMethods();
            Intrinsics.c(methods);
            int length = methods.length;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 >= length) {
                    break;
                }
                Method method2 = methods[i2];
                if (Intrinsics.b(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
                    Intrinsics.checkNotNullParameter(parameterTypes, "<this>");
                    if (Intrinsics.b(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                        method = method2;
                        break;
                    }
                }
                i2++;
            }
            f53715b = method;
            int length2 = methods.length;
            for (int i3 = 0; i3 < length2 && !Intrinsics.b(methods[i3].getName(), "getSuppressed"); i3++) {
            }
        }
    }

    public void a(Throwable cause, Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method method = ReflectThrowable.f53715b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }
}
