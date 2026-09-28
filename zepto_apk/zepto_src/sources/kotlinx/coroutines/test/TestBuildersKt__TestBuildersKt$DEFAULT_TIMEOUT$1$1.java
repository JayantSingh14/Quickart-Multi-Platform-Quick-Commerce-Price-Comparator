package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;

@Metadata
/* loaded from: classes3.dex */
public /* synthetic */ class TestBuildersKt__TestBuildersKt$DEFAULT_TIMEOUT$1$1 extends FunctionReferenceImpl implements Function1<String, Duration> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String value = (String) obj;
        ((Duration.Companion) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            return new Duration(DurationKt.a(value, false));
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(android.support.v4.media.b.D("Invalid duration string format: '", value, "'."), e2);
        }
    }
}
