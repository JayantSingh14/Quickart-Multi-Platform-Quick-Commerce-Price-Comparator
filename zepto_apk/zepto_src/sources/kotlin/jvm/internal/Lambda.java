package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public abstract class Lambda<R> implements FunctionBase<R>, Serializable {
    private final int arity;

    public Lambda(int i2) {
        this.arity = i2;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @NotNull
    public String toString() {
        Reflection.f53802a.getClass();
        String strA = ReflectionFactory.a(this);
        Intrinsics.checkNotNullExpressionValue(strA, "renderLambdaToString(...)");
        return strA;
    }
}
