package kotlin.reflect;

import kotlin.Function;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface KFunction<R> extends KCallable<R>, Function<R> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();
}
