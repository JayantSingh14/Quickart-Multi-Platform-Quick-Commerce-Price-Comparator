package kotlinx.serialization.internal;

import android.support.v4.media.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class MapLikeDescriptor implements SerialDescriptor {

    /* renamed from: a, reason: collision with root package name */
    public final String f55849a;

    /* renamed from: b, reason: collision with root package name */
    public final SerialDescriptor f55850b;

    /* renamed from: c, reason: collision with root package name */
    public final SerialDescriptor f55851c;

    public MapLikeDescriptor(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2) {
        this.f55849a = str;
        this.f55850b = serialDescriptor;
        this.f55851c = serialDescriptor2;
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
        throw new IllegalArgumentException(b.k(name, " is not a valid map index"));
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialKind d() {
        return StructureKind.MAP.f55767a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int e() {
        return 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapLikeDescriptor)) {
            return false;
        }
        MapLikeDescriptor mapLikeDescriptor = (MapLikeDescriptor) obj;
        return Intrinsics.b(this.f55849a, mapLikeDescriptor.f55849a) && Intrinsics.b(this.f55850b, mapLikeDescriptor.f55850b) && Intrinsics.b(this.f55851c, mapLikeDescriptor.f55851c);
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
        throw new IllegalArgumentException(b.r(b.u(i2, "Illegal index ", ", "), this.f55849a, " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getAnnotations() {
        return EmptyList.f53609a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor h(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(b.r(b.u(i2, "Illegal index ", ", "), this.f55849a, " expects only non-negative indices").toString());
        }
        int i3 = i2 % 2;
        if (i3 == 0) {
            return this.f55850b;
        }
        if (i3 == 1) {
            return this.f55851c;
        }
        throw new IllegalStateException("Unreached");
    }

    public final int hashCode() {
        return this.f55851c.hashCode() + ((this.f55850b.hashCode() + (this.f55849a.hashCode() * 31)) * 31);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String i() {
        return this.f55849a;
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
        throw new IllegalArgumentException(b.r(b.u(i2, "Illegal index ", ", "), this.f55849a, " expects only non-negative indices").toString());
    }

    public final String toString() {
        return this.f55849a + '(' + this.f55850b + ", " + this.f55851c + ')';
    }
}
