package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class ArrayPoolsKt {

    /* renamed from: a, reason: collision with root package name */
    public static final int f56025a;

    static {
        Object objA;
        try {
            Result.Companion companion = Result.f53538b;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
            objA = StringsKt.toIntOrNull(property);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        Integer num = (Integer) objA;
        f56025a = num != null ? num.intValue() : 2097152;
    }
}
