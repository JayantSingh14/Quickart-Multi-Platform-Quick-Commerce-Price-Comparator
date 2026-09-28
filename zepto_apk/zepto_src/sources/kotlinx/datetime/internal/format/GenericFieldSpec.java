package kotlinx.datetime.internal.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DecimalFraction;

@Metadata
/* loaded from: classes3.dex */
public final class GenericFieldSpec<Target, Type> extends AbstractFieldSpec<Target, Type> {

    /* renamed from: a, reason: collision with root package name */
    public final PropertyAccessor f55541a;

    /* renamed from: b, reason: collision with root package name */
    public final String f55542b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f55543c;

    public GenericFieldSpec(PropertyAccessor accessor, DecimalFraction decimalFraction, int i2) {
        String name = accessor.f55554a.getName();
        decimalFraction = (i2 & 4) != 0 ? null : decimalFraction;
        Intrinsics.checkNotNullParameter(accessor, "accessor");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f55541a = accessor;
        this.f55542b = name;
        this.f55543c = decimalFraction;
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public final Accessor a() {
        return this.f55541a;
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public final FieldSign b() {
        return null;
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public final Object c() {
        return this.f55543c;
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public final String getName() {
        return this.f55542b;
    }
}
