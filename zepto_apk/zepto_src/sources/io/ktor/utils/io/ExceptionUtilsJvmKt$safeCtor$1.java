package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ExceptionUtilsJvmKt$safeCtor$1 extends Lambda implements Function1<Throwable, Throwable> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Throwable e2 = (Throwable) obj;
        Intrinsics.checkNotNullParameter(e2, "e");
        try {
            Result.Companion companion = Result.f53538b;
            throw null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            ResultKt.a(th);
            return null;
        }
    }
}
