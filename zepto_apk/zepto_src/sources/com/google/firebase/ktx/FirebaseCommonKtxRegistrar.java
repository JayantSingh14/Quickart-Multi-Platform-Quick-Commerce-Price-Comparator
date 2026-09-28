package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata
@Deprecated
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @NotNull
    public List<Component<?>> getComponents() {
        Component.Builder builderA = Component.a(new Qualified(Background.class, CoroutineDispatcher.class));
        builderA.a(new Dependency(new Qualified(Background.class, Executor.class), 1, 0));
        builderA.c(new ComponentFactory() { // from class: com.google.firebase.ktx.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1
            @Override // com.google.firebase.components.ComponentFactory
            public final Object c(ComponentContainer componentContainer) {
                Object objE = componentContainer.e(new Qualified(Background.class, Executor.class));
                Intrinsics.checkNotNullExpressionValue(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return ExecutorsKt.a((Executor) objE);
            }
        });
        Component componentB = builderA.b();
        Intrinsics.checkNotNullExpressionValue(componentB, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Component.Builder builderA2 = Component.a(new Qualified(Lightweight.class, CoroutineDispatcher.class));
        builderA2.a(new Dependency(new Qualified(Lightweight.class, Executor.class), 1, 0));
        builderA2.c(new ComponentFactory() { // from class: com.google.firebase.ktx.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$2
            @Override // com.google.firebase.components.ComponentFactory
            public final Object c(ComponentContainer componentContainer) {
                Object objE = componentContainer.e(new Qualified(Lightweight.class, Executor.class));
                Intrinsics.checkNotNullExpressionValue(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return ExecutorsKt.a((Executor) objE);
            }
        });
        Component componentB2 = builderA2.b();
        Intrinsics.checkNotNullExpressionValue(componentB2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Component.Builder builderA3 = Component.a(new Qualified(Blocking.class, CoroutineDispatcher.class));
        builderA3.a(new Dependency(new Qualified(Blocking.class, Executor.class), 1, 0));
        builderA3.c(new ComponentFactory() { // from class: com.google.firebase.ktx.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3
            @Override // com.google.firebase.components.ComponentFactory
            public final Object c(ComponentContainer componentContainer) {
                Object objE = componentContainer.e(new Qualified(Blocking.class, Executor.class));
                Intrinsics.checkNotNullExpressionValue(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return ExecutorsKt.a((Executor) objE);
            }
        });
        Component componentB3 = builderA3.b();
        Intrinsics.checkNotNullExpressionValue(componentB3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Component.Builder builderA4 = Component.a(new Qualified(UiThread.class, CoroutineDispatcher.class));
        builderA4.a(new Dependency(new Qualified(UiThread.class, Executor.class), 1, 0));
        builderA4.c(new ComponentFactory() { // from class: com.google.firebase.ktx.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$4
            @Override // com.google.firebase.components.ComponentFactory
            public final Object c(ComponentContainer componentContainer) {
                Object objE = componentContainer.e(new Qualified(UiThread.class, Executor.class));
                Intrinsics.checkNotNullExpressionValue(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return ExecutorsKt.a((Executor) objE);
            }
        });
        Component componentB4 = builderA4.b();
        Intrinsics.checkNotNullExpressionValue(componentB4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return CollectionsKt.I(componentB, componentB2, componentB3, componentB4);
    }
}
