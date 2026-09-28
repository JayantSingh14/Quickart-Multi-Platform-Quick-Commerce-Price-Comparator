package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class ObjectList<E> {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f1551a;

    public final boolean equals(Object obj) {
        if (!(obj instanceof ObjectList)) {
            return false;
        }
        ObjectList objectList = (ObjectList) obj;
        objectList.getClass();
        Object[] objArr = this.f1551a;
        Object[] objArr2 = objectList.f1551a;
        IntRange intRangeF = RangesKt.f(0, 0);
        int i2 = intRangeF.f53838a;
        int i3 = intRangeF.f53839b;
        if (i2 > i3) {
            return true;
        }
        while (Intrinsics.b(objArr[i2], objArr2[i2])) {
            if (i2 == i3) {
                return true;
            }
            i2++;
        }
        return false;
    }

    public final int hashCode() {
        Object[] objArr = this.f1551a;
        int iHashCode = 0;
        for (int i2 = 0; i2 < 0; i2++) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final String toString() {
        Function1<Object, CharSequence> function1 = new Function1<Object, CharSequence>() { // from class: androidx.collection.ObjectList.toString.1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return obj == ObjectList.this ? "(this)" : String.valueOf(obj);
            }
        };
        Intrinsics.checkNotNullParameter(", ", "separator");
        Intrinsics.checkNotNullParameter("[", "prefix");
        Intrinsics.checkNotNullParameter("]", "postfix");
        Intrinsics.checkNotNullParameter("...", "truncated");
        StringBuilder sb = new StringBuilder("[");
        Object[] objArr = this.f1551a;
        int i2 = 0;
        while (true) {
            if (i2 >= 0) {
                sb.append((CharSequence) "]");
                break;
            }
            Object obj = objArr[i2];
            if (i2 == -1) {
                sb.append((CharSequence) "...");
                break;
            }
            if (i2 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append((CharSequence) function1.invoke(obj));
            i2++;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
