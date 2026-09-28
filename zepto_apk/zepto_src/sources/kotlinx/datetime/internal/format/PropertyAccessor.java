package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;

@Metadata
/* loaded from: classes3.dex */
public final class PropertyAccessor<Object, Field> implements Accessor<Object, Field> {

    /* renamed from: a, reason: collision with root package name */
    public final KMutableProperty1 f55554a;

    public PropertyAccessor(KMutableProperty1 property) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.f55554a = property;
    }

    @Override // kotlinx.datetime.internal.format.Accessor
    public final Object a(Object obj) {
        return this.f55554a.get(obj);
    }

    @Override // kotlinx.datetime.internal.format.Accessor
    public final Object b(Object obj) {
        KMutableProperty1 kMutableProperty1 = this.f55554a;
        Object obj2 = kMutableProperty1.get(obj);
        if (obj2 != null) {
            return obj2;
        }
        throw new IllegalStateException("Field " + kMutableProperty1.getName() + " is not set");
    }

    @Override // kotlinx.datetime.internal.format.parser.AssignableField
    public final Object c(Object obj, Object obj2) {
        KMutableProperty1 kMutableProperty1 = this.f55554a;
        Object obj3 = kMutableProperty1.get(obj);
        if (obj3 == null) {
            kMutableProperty1.g(obj, obj2);
            return null;
        }
        if (obj3.equals(obj2)) {
            return null;
        }
        return obj3;
    }

    @Override // kotlinx.datetime.internal.format.parser.AssignableField
    public final String getName() {
        return this.f55554a.getName();
    }
}
