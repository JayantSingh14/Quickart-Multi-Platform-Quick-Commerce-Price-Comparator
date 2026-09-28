package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;

@SinceKotlin
@Metadata
/* loaded from: classes3.dex */
public final class PackageReference implements ClassBasedDeclarationContainer {

    /* renamed from: a, reason: collision with root package name */
    public final Class f53796a;

    public PackageReference(Class jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter("", "moduleName");
        this.f53796a = jClass;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class d() {
        return this.f53796a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PackageReference) {
            return Intrinsics.b(this.f53796a, ((PackageReference) obj).f53796a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f53796a.hashCode();
    }

    public final String toString() {
        return this.f53796a + " (Kotlin reflection is not available)";
    }
}
