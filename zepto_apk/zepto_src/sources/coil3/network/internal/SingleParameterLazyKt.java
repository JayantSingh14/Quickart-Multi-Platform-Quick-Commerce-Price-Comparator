package coil3.network.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class SingleParameterLazyKt {
    @NotNull
    public static final <P, T> SingleParameterLazy<P, T> singleParameterLazy(@NotNull Function1<? super P, ? extends T> function1) {
        return new SingleParameterLazy<>(function1);
    }
}
