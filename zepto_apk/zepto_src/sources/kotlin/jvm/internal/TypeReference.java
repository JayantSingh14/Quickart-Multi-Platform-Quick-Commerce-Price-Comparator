package kotlin.jvm.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.brentvatne.react.c;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
/* loaded from: classes.dex */
public final class TypeReference implements KType {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Companion f53808d = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final ClassReference f53809a;

    /* renamed from: b, reason: collision with root package name */
    public final List f53810b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53811c;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                KVariance[] kVarianceArr = KVariance.f53878a;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KVariance[] kVarianceArr2 = KVariance.f53878a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KVariance[] kVarianceArr3 = KVariance.f53878a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public TypeReference(ClassReference classifier, boolean z) {
        List arguments = Collections.EMPTY_LIST;
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.f53809a = classifier;
        this.f53810b = arguments;
        this.f53811c = z ? 1 : 0;
    }

    @Override // kotlin.reflect.KType
    public final boolean a() {
        return (this.f53811c & 1) != 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TypeReference)) {
            return false;
        }
        TypeReference typeReference = (TypeReference) obj;
        if (!this.f53809a.equals(typeReference.f53809a)) {
            return false;
        }
        List list = Collections.EMPTY_LIST;
        return Intrinsics.b(list, list) && this.f53811c == typeReference.f53811c;
    }

    @Override // kotlin.reflect.KType
    public final KClassifier f() {
        return this.f53809a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f53811c) + e.f(this.f53809a.hashCode() * 31, 31, Collections.EMPTY_LIST);
    }

    @Override // kotlin.reflect.KType
    public final List j() {
        return this.f53810b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Class clsA = JvmClassMappingKt.a(this.f53809a);
        String name = clsA.isArray() ? clsA.equals(boolean[].class) ? "kotlin.BooleanArray" : clsA.equals(char[].class) ? "kotlin.CharArray" : clsA.equals(byte[].class) ? "kotlin.ByteArray" : clsA.equals(short[].class) ? "kotlin.ShortArray" : clsA.equals(int[].class) ? "kotlin.IntArray" : clsA.equals(float[].class) ? "kotlin.FloatArray" : clsA.equals(long[].class) ? "kotlin.LongArray" : clsA.equals(double[].class) ? "kotlin.DoubleArray" : "kotlin.Array" : clsA.getName();
        List list = Collections.EMPTY_LIST;
        sb.append(b.l(name, list.isEmpty() ? "" : CollectionsKt.E(list, ", ", "<", ">", new c(this, 10), 24), a() ? "?" : ""));
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }
}
