package kotlinx.datetime.internal.format;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.OffsetFields$sign$1;

@Metadata
/* loaded from: classes3.dex */
public final class UnsignedFieldSpec<Target> extends AbstractFieldSpec<Target, Integer> {

    /* renamed from: a, reason: collision with root package name */
    public final PropertyAccessor f55563a;

    /* renamed from: b, reason: collision with root package name */
    public final int f55564b;

    /* renamed from: c, reason: collision with root package name */
    public final int f55565c;

    /* renamed from: d, reason: collision with root package name */
    public final String f55566d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f55567e;

    /* renamed from: f, reason: collision with root package name */
    public final FieldSign f55568f;

    /* renamed from: g, reason: collision with root package name */
    public final int f55569g;

    public UnsignedFieldSpec(PropertyAccessor accessor, int i2, int i3, OffsetFields$sign$1 offsetFields$sign$1, int i4) {
        int i5;
        String name = accessor.f55554a.getName();
        Integer num = (i4 & 16) != 0 ? null : 0;
        offsetFields$sign$1 = (i4 & 32) != 0 ? null : offsetFields$sign$1;
        Intrinsics.checkNotNullParameter(accessor, "accessor");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f55563a = accessor;
        this.f55564b = i2;
        this.f55565c = i3;
        this.f55566d = name;
        this.f55567e = num;
        this.f55568f = offsetFields$sign$1;
        if (i3 < 10) {
            i5 = 1;
        } else if (i3 < 100) {
            i5 = 2;
        } else {
            if (i3 >= 1000) {
                throw new IllegalArgumentException(b.g(i3, "Max value ", " is too large"));
            }
            i5 = 3;
        }
        this.f55569g = i5;
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public final Accessor a() {
        return this.f55563a;
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public final FieldSign b() {
        return this.f55568f;
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public final Object c() {
        return this.f55567e;
    }

    @Override // kotlinx.datetime.internal.format.FieldSpec
    public final String getName() {
        return this.f55566d;
    }
}
