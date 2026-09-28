package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FastServiceLoaderKt {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f55077a = 0;

    static {
        Object objA;
        try {
            Result.Companion companion = Result.f53538b;
            objA = Class.forName("android.os.Build");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        boolean z = objA instanceof Result.Failure;
    }
}
