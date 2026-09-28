package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;

@Metadata
/* loaded from: classes3.dex */
public interface AbstractWithTimeBuilder extends DateTimeFormatBuilder.WithTime {

    @Metadata
    public static final class DefaultImpls {
        public static void a(AbstractWithTimeBuilder abstractWithTimeBuilder, int i2, int i3) {
            abstractWithTimeBuilder.k(new BasicFormatStructure(new FractionalSecondDirective(i2, i3)));
        }
    }

    void k(FormatStructure formatStructure);
}
