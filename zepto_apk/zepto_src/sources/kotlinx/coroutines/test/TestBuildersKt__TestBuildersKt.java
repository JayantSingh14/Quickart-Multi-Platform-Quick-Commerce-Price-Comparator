package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final /* synthetic */ class TestBuildersKt__TestBuildersKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f55272a;

    static {
        Object objA;
        String property;
        try {
            Result.Companion companion = Result.f53538b;
            TestBuildersKt__TestBuildersKt$DEFAULT_TIMEOUT$1$1 testBuildersKt__TestBuildersKt$DEFAULT_TIMEOUT$1$1 = new TestBuildersKt__TestBuildersKt$DEFAULT_TIMEOUT$1$1(1, Duration.f54014b, Duration.Companion.class, "parse", "parse-UwyO8pc(Ljava/lang/String;)J", 0);
            Object duration = new Duration(DurationKt.g(60, DurationUnit.f54022e));
            try {
                property = System.getProperty("kotlinx.coroutines.test.default_timeout");
            } catch (SecurityException unused) {
                property = null;
            }
            if (property != null) {
                duration = testBuildersKt__TestBuildersKt$DEFAULT_TIMEOUT$1$1.invoke(property);
            }
            objA = new Duration(((Duration) duration).f54017a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f53538b;
            objA = ResultKt.a(th);
        }
        f55272a = objA;
    }
}
