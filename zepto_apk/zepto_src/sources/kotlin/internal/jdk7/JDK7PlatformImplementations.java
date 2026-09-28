package kotlin.internal.jdk7;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public class JDK7PlatformImplementations extends PlatformImplementations {

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class ReflectSdkVersion {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final ReflectSdkVersion f53720a = new ReflectSdkVersion();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f53721b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            f53721b = num;
        }
    }

    @Override // kotlin.internal.PlatformImplementations
    public final void a(Throwable cause, Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Integer num = ReflectSdkVersion.f53721b;
        if (num == null || num.intValue() >= 19) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
