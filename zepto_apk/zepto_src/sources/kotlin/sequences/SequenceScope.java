package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@SinceKotlin
@RestrictsSuspension
@Metadata
/* loaded from: classes3.dex */
public abstract class SequenceScope<T> {
    public abstract void a(Object obj, Continuation continuation);

    public abstract Object b(Iterator it, RestrictedSuspendLambda restrictedSuspendLambda);
}
