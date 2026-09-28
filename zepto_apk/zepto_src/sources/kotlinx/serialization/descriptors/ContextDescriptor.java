package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class ContextDescriptor implements SerialDescriptor {

    /* renamed from: a, reason: collision with root package name */
    public final SerialDescriptorImpl f55727a;

    /* renamed from: b, reason: collision with root package name */
    public final ClassReference f55728b;

    /* renamed from: c, reason: collision with root package name */
    public final String f55729c;

    public ContextDescriptor(SerialDescriptorImpl original, ClassReference kClass) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        this.f55727a = original;
        this.f55728b = kClass;
        this.f55729c = original.f55741a + '<' + kClass.i() + '>';
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean b() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f55727a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialKind d() {
        return this.f55727a.f55742b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int e() {
        return this.f55727a.f55743c;
    }

    public final boolean equals(Object obj) {
        ContextDescriptor contextDescriptor = obj instanceof ContextDescriptor ? (ContextDescriptor) obj : null;
        return contextDescriptor != null && this.f55727a.equals(contextDescriptor.f55727a) && Intrinsics.b(contextDescriptor.f55728b, this.f55728b);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String f(int i2) {
        return this.f55727a.f55746f[i2];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List g(int i2) {
        return this.f55727a.f55748h[i2];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final List getAnnotations() {
        return this.f55727a.f55744d;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor h(int i2) {
        return this.f55727a.f55747g[i2];
    }

    public final int hashCode() {
        return this.f55729c.hashCode() + (this.f55728b.hashCode() * 31);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final String i() {
        return this.f55729c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isInline() {
        return false;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean j(int i2) {
        return this.f55727a.f55749i[i2];
    }

    public final String toString() {
        return "ContextDescriptor(kClass: " + this.f55728b + ", original: " + this.f55727a + ')';
    }
}
