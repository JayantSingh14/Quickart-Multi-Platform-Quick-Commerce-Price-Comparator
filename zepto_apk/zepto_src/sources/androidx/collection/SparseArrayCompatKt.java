package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SparseArrayCompatKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f1609a = new Object();

    public static final Object a(SparseArrayCompat sparseArrayCompat, int i2) {
        Object obj;
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int iA = ContainerHelpersKt.a(sparseArrayCompat.f1608c, i2, sparseArrayCompat.f1606a);
        if (iA < 0 || (obj = sparseArrayCompat.f1607b[iA]) == f1609a) {
            return null;
        }
        return obj;
    }
}
