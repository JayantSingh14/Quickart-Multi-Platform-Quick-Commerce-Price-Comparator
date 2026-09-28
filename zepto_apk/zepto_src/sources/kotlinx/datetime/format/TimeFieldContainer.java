package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.DecimalFraction;

@Metadata
/* loaded from: classes3.dex */
public interface TimeFieldContainer {

    @Metadata
    @SourceDebugExtension
    public static final class DefaultImpls {
    }

    void B(Integer num);

    Integer D();

    void a(AmPmMarker amPmMarker);

    Integer c();

    void h(DecimalFraction decimalFraction);

    Integer i();

    void k(Integer num);

    AmPmMarker o();

    void p(Integer num);

    Integer s();

    void t(Integer num);

    DecimalFraction w();
}
