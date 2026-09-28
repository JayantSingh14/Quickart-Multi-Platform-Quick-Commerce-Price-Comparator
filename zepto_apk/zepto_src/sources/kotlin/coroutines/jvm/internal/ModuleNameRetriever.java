package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ModuleNameRetriever {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ModuleNameRetriever f53705a = new ModuleNameRetriever();

    /* renamed from: b, reason: collision with root package name */
    public static final Cache f53706b = new Cache(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    public static Cache f53707c;

    @Metadata
    public static final class Cache {

        /* renamed from: a, reason: collision with root package name */
        public final Method f53708a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f53709b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f53710c;

        public Cache(Method method, Method method2, Method method3) {
            this.f53708a = method;
            this.f53709b = method2;
            this.f53710c = method3;
        }
    }
}
