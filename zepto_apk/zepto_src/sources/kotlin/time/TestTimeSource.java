package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.AbstractLongTimeSource;

@SinceKotlin
@Metadata
@WasExperimental
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    public TestTimeSource() {
        super(DurationUnit.f54019b);
        long jLongValue = 0 - ((Number) this.f54010b.getValue()).longValue();
        Duration.f54014b.getClass();
        new AbstractLongTimeSource.LongTimeMark(jLongValue, this, 0L, null);
    }

    @Override // kotlin.time.AbstractLongTimeSource
    public final long a() {
        return 0L;
    }
}
