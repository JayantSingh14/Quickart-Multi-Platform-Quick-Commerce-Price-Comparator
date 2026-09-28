package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TypeParameterReference implements KTypeParameter {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Companion f53806b = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public volatile List f53807a;

    @Metadata
    public static final class Companion {

        @Metadata
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[KVariance.values().length];
                try {
                    iArr[0] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    KVariance[] kVarianceArr = KVariance.f53878a;
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    KVariance[] kVarianceArr2 = KVariance.f53878a;
                    iArr[2] = 3;
                } catch (NoSuchFieldError unused3) {
                }
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TypeParameterReference)) {
            return false;
        }
        TypeParameterReference typeParameterReference = (TypeParameterReference) obj;
        typeParameterReference.getClass();
        typeParameterReference.getClass();
        return true;
    }

    @Override // kotlin.reflect.KTypeParameter
    public final List getUpperBounds() {
        List list = this.f53807a;
        if (list != null) {
            return list;
        }
        List listH = CollectionsKt.H(Reflection.b(Object.class));
        this.f53807a = listH;
        return listH;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        f53806b.getClass();
        Intrinsics.checkNotNullParameter(this, "typeParameter");
        throw null;
    }
}
