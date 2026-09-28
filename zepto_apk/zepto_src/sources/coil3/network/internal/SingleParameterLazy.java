package coil3.network.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class SingleParameterLazy<P, T> {

    @Nullable
    private Object _value = UNINITIALIZED.INSTANCE;

    @Nullable
    private Function1<? super P, ? extends T> initializer;

    public SingleParameterLazy(@NotNull Function1<? super P, ? extends T> function1) {
        this.initializer = function1;
    }

    public final T get(P p) {
        T t;
        T t2 = (T) this._value;
        UNINITIALIZED uninitialized = UNINITIALIZED.INSTANCE;
        if (t2 != uninitialized) {
            return t2;
        }
        synchronized (this) {
            t = (T) this._value;
            if (t == uninitialized) {
                Function1<? super P, ? extends T> function1 = this.initializer;
                Intrinsics.c(function1);
                t = (T) function1.invoke(p);
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }
}
