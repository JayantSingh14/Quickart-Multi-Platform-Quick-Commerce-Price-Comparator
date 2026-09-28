package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.jvm.internal.DefaultConstructorMarker;

@SinceKotlin
@Metadata
@RestrictsSuspension
@WasExperimental
/* loaded from: classes3.dex */
public abstract class DeepRecursiveScope<T, R> {
    public DeepRecursiveScope(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public abstract void a(Unit unit, Continuation continuation);
}
