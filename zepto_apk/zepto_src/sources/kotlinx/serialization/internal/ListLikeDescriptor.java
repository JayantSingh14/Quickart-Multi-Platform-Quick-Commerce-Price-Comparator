package kotlinx.serialization.internal;

import android.support.v4.media.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

@Metadata
@ExperimentalSerializationApi
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class ListLikeDescriptor implements SerialDescriptor {

    /* renamed from: a, reason: collision with root package name */
    public final SerialDescriptor f55838a;

    public ListLikeDescriptor(SerialDescriptor serialDescriptor) {
        this.f55838a = serialDescriptor;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean b() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer intOrNull = StringsKt.toIntOrNull(name);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throw new IllegalArgumentException(b.k(name, " is not a valid list index"));
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialKind d() {
        return StructureKind.LIST.f55766a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int e() {
        return 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListLikeDescriptor)) {
            return false;
        }
        ListLikeDescriptor listLikeDescriptor = (ListLikeDescriptor) obj;
        return Intrinsics.b(this.f55838a, listLikeDescriptor.f55838a) && Intrinsics.b(i(), listLikeDescriptor.i());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String f(int i2) {
        return String.valueOf(i2);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List g(int i2) {
        if (i2 >= 0) {
            return EmptyList.f53609a;
        }
        StringBuilder sbU = b.u(i2, "Illegal index ", ", ");
        sbU.append(i());
        sbU.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbU.toString().toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getAnnotations() {
        return EmptyList.f53609a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor h(int i2) {
        if (i2 >= 0) {
            return this.f55838a;
        }
        StringBuilder sbU = b.u(i2, "Illegal index ", ", ");
        sbU.append(i());
        sbU.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbU.toString().toString());
    }

    public final int hashCode() {
        return i().hashCode() + (this.f55838a.hashCode() * 31);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isInline() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean j(int i2) {
        if (i2 >= 0) {
            return false;
        }
        StringBuilder sbU = b.u(i2, "Illegal index ", ", ");
        sbU.append(i());
        sbU.append(" expects only non-negative indices");
        throw new IllegalArgumentException(sbU.toString().toString());
    }

    public final String toString() {
        return i() + '(' + this.f55838a + ')';
    }
}
