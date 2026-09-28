package kotlin;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes3.dex */
public final class DeepRecursiveFunction<T, R> {

    /* renamed from: a, reason: collision with root package name */
    public final Function3 f53513a;

    public DeepRecursiveFunction(Function3 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.f53513a = block;
    }
}
