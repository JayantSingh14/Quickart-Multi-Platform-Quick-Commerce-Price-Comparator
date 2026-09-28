package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class StackTraceRecoveryKt {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f55106a = 0;

    static {
        Object objA;
        Object objA2;
        new ArtificialStackFrames();
        ArtificialStackFrames.a();
        try {
            Result.Companion companion = Result.f53538b;
            objA = BaseContinuationImpl.class.getCanonicalName();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        if (Result.a(objA) != null) {
            objA = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objA2 = StackTraceRecoveryKt.class.getCanonicalName();
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.f53538b;
            objA2 = ResultKt.a(th2);
        }
        if (Result.a(objA2) != null) {
            objA2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
