package kotlin.internal.jdk8;

import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {

    @Metadata
    @SourceDebugExtension
    public static final class ReflectSdkVersion {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final ReflectSdkVersion f53722a = new ReflectSdkVersion();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f53723b;

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
            f53723b = num;
        }
    }

    public final Random b() {
        Integer num = ReflectSdkVersion.f53723b;
        return (num == null || num.intValue() >= 34) ? new PlatformThreadLocalRandom() : new FallbackThreadLocalRandom();
    }
}
