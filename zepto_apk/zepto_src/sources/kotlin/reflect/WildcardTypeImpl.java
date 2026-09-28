package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
@ExperimentalStdlibApi
/* loaded from: classes3.dex */
final class WildcardTypeImpl implements WildcardType, TypeImpl {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Companion f53888c = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final WildcardTypeImpl f53889d = new WildcardTypeImpl(null, null);

    /* renamed from: a, reason: collision with root package name */
    public final Type f53890a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f53891b;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static WildcardTypeImpl a() {
            return WildcardTypeImpl.f53889d;
        }
    }

    public WildcardTypeImpl(Type type, Type type2) {
        this.f53890a = type;
        this.f53891b = type2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType = (WildcardType) obj;
        return Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds());
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f53891b;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        Type type = this.f53891b;
        if (type != null) {
            return "? super " + TypesJVMKt.a(type);
        }
        Type type2 = this.f53890a;
        if (type2 == null || Intrinsics.b(type2, Object.class)) {
            return "?";
        }
        return "? extends " + TypesJVMKt.a(type2);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        Type type = this.f53890a;
        if (type == null) {
            type = Object.class;
        }
        return new Type[]{type};
    }

    public final int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    public final String toString() {
        return getTypeName();
    }
}
