package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ReflectionFactory;

@SinceKotlin
@Metadata
/* loaded from: classes3.dex */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements FunctionBase<Object>, SuspendFunction {

    /* renamed from: a, reason: collision with root package name */
    private final int f53711a;

    public RestrictedSuspendLambda(int i2, Continuation continuation) {
        super(continuation);
        this.f53711a = i2;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return this.f53711a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        Reflection.f53802a.getClass();
        String strA = ReflectionFactory.a(this);
        Intrinsics.checkNotNullExpressionValue(strA, "renderLambdaToString(...)");
        return strA;
    }
}
