package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

@Metadata
/* loaded from: classes3.dex */
final class KTypeWrapper implements KType {

    /* renamed from: a, reason: collision with root package name */
    public final KType f55833a;

    public KTypeWrapper(KType origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.f55833a = origin;
    }

    @Override // kotlin.reflect.KType
    public final boolean a() {
        return this.f55833a.a();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        KTypeWrapper kTypeWrapper = obj instanceof KTypeWrapper ? (KTypeWrapper) obj : null;
        KType kType = kTypeWrapper != null ? kTypeWrapper.f55833a : null;
        KType kType2 = this.f55833a;
        if (!Intrinsics.b(kType2, kType)) {
            return false;
        }
        KClassifier kClassifierF = kType2.f();
        if (!(kClassifierF instanceof KClass)) {
            return false;
        }
        KType kType3 = obj instanceof KType ? (KType) obj : null;
        KClassifier kClassifierF2 = kType3 != null ? kType3.f() : null;
        if (kClassifierF2 == null || !(kClassifierF2 instanceof KClass)) {
            return false;
        }
        return JvmClassMappingKt.a((KClass) kClassifierF).equals(JvmClassMappingKt.a((KClass) kClassifierF2));
    }

    @Override // kotlin.reflect.KType
    public final KClassifier f() {
        return this.f55833a.f();
    }

    public final int hashCode() {
        return this.f55833a.hashCode();
    }

    @Override // kotlin.reflect.KType
    public final List j() {
        return this.f55833a.j();
    }

    public final String toString() {
        return "KTypeWrapper: " + this.f55833a;
    }
}
