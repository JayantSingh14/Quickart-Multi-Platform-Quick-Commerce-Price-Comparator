package kotlin.reflect;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface KProperty<V> extends KCallable<V> {

    @Metadata
    /* loaded from: classes3.dex */
    public interface Accessor<V> {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public interface Getter<V> extends Accessor<V>, KFunction<V> {
    }
}
