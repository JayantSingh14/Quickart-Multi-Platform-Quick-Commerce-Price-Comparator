package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: classes.dex */
public interface KProperty2<D, E, V> extends KProperty<V>, Function2<D, E, V> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public interface Getter<D, E, V> extends KProperty.Getter<V>, Function2<D, E, V> {
    }

    Getter b();
}
