package kotlin.reflect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KMutableProperty;

@Metadata
/* loaded from: classes3.dex */
public interface KMutableProperty0<V> extends KProperty0<V>, KMutableProperty<V> {

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public interface Setter<V> extends KMutableProperty.Setter<V>, Function1<V, Unit> {
    }

    Setter c();

    void set(Object obj);
}
