package coil3.util;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CollectionsKt {
    /* renamed from: component1-wuMLFU8, reason: not valid java name */
    public static final int m44component1wuMLFU8(long j2) {
        return IntPair.m51getFirstimpl(j2);
    }

    /* renamed from: component2-wuMLFU8, reason: not valid java name */
    public static final int m45component2wuMLFU8(long j2) {
        return IntPair.m52getSecondimpl(j2);
    }

    @Nullable
    public static final <R, T> T firstNotNullOfOrNullIndices(@NotNull List<? extends R> list, @NotNull Function1<? super R, ? extends T> function1) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            T t = (T) function1.invoke(list.get(i2));
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    @NotNull
    public static final <T, R> List<R> flatMapIndices(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends List<? extends R>> function1) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            kotlin.collections.CollectionsKt.i(arrayList, (Iterable) function1.invoke(list.get(i2)));
        }
        return arrayList;
    }

    public static final <T, R> R foldIndices(@NotNull List<? extends T> list, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            r = (R) function2.invoke(r, list.get(i2));
        }
        return r;
    }

    public static final <T> void forEachIndexedIndices(@NotNull List<? extends T> list, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            function2.invoke(Integer.valueOf(i2), list.get(i2));
        }
    }

    public static final <T> void forEachIndices(@NotNull List<? extends T> list, @NotNull Function1<? super T, Unit> function1) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            function1.invoke(list.get(i2));
        }
    }

    @NotNull
    public static final <T, R> List<R> mapNotNullIndices(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends R> function1) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object objInvoke = function1.invoke(list.get(i2));
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
        }
        return arrayList;
    }

    public static final <T> void removeIfIndices(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> function1) {
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = i3 - i2;
            if (((Boolean) function1.invoke(list.get(i4))).booleanValue()) {
                list.remove(i4);
                i2++;
            }
        }
    }
}
