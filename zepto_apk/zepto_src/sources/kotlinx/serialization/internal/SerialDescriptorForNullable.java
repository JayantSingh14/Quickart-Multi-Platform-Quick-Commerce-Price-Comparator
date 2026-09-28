package kotlinx.serialization.internal;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

@Metadata
/* loaded from: classes3.dex */
public final class SerialDescriptorForNullable implements SerialDescriptor, CachedNames {

    /* renamed from: a, reason: collision with root package name */
    public final SerialDescriptor f55894a;

    /* renamed from: b, reason: collision with root package name */
    public final String f55895b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f55896c;

    public SerialDescriptorForNullable(SerialDescriptor original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.f55894a = original;
        this.f55895b = original.i() + '?';
        this.f55896c = Platform_commonKt.a(original);
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public final Set a() {
        return this.f55896c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean b() {
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f55894a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialKind d() {
        return this.f55894a.d();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int e() {
        return this.f55894a.e();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorForNullable) {
            return Intrinsics.b(this.f55894a, ((SerialDescriptorForNullable) obj).f55894a);
        }
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String f(int i2) {
        return this.f55894a.f(i2);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List g(int i2) {
        return this.f55894a.g(i2);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getAnnotations() {
        return this.f55894a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor h(int i2) {
        return this.f55894a.h(i2);
    }

    public final int hashCode() {
        return this.f55894a.hashCode() * 31;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String i() {
        return this.f55895b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isInline() {
        return this.f55894a.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean j(int i2) {
        return this.f55894a.j(i2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f55894a);
        sb.append('?');
        return sb.toString();
    }
}
