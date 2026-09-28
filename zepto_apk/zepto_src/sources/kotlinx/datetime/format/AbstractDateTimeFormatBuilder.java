package kotlinx.datetime.format;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.internal.format.AlternativesParsingFormatStructure;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.ConcatenatedFormatStructure;
import kotlinx.datetime.internal.format.ConstantFormatStructure;
import kotlinx.datetime.internal.format.OptionalFormatStructure;

@Metadata
/* loaded from: classes3.dex */
public interface AbstractDateTimeFormatBuilder<Target, ActualSelf extends AbstractDateTimeFormatBuilder<Target, ActualSelf>> extends DateTimeFormatBuilder {

    @Metadata
    @SourceDebugExtension
    public static final class DefaultImpls {
        public static void a(AbstractDateTimeFormatBuilder abstractDateTimeFormatBuilder, Function1[] otherFormats, Function1 mainFormat) {
            Intrinsics.checkNotNullParameter(otherFormats, "otherFormats");
            Intrinsics.checkNotNullParameter(mainFormat, "mainFormat");
            ArrayList arrayList = new ArrayList(otherFormats.length);
            for (Function1 function1 : otherFormats) {
                AbstractDateTimeFormatBuilder abstractDateTimeFormatBuilderG = abstractDateTimeFormatBuilder.g();
                function1.invoke(abstractDateTimeFormatBuilderG);
                arrayList.add(new ConcatenatedFormatStructure(abstractDateTimeFormatBuilderG.a().f55528a));
            }
            AbstractDateTimeFormatBuilder abstractDateTimeFormatBuilderG2 = abstractDateTimeFormatBuilder.g();
            mainFormat.invoke(abstractDateTimeFormatBuilderG2);
            abstractDateTimeFormatBuilder.a().a(new AlternativesParsingFormatStructure(new ConcatenatedFormatStructure(abstractDateTimeFormatBuilderG2.a().f55528a), arrayList));
        }

        public static void b(AbstractDateTimeFormatBuilder abstractDateTimeFormatBuilder, String onZero, Function1 format) {
            Intrinsics.checkNotNullParameter(onZero, "onZero");
            Intrinsics.checkNotNullParameter(format, "format");
            AppendableFormatStructure appendableFormatStructureA = abstractDateTimeFormatBuilder.a();
            AbstractDateTimeFormatBuilder abstractDateTimeFormatBuilderG = abstractDateTimeFormatBuilder.g();
            format.invoke(abstractDateTimeFormatBuilderG);
            Unit unit = Unit.f53572a;
            appendableFormatStructureA.a(new OptionalFormatStructure(onZero, new ConcatenatedFormatStructure(abstractDateTimeFormatBuilderG.a().f55528a)));
        }

        public static CachedFormatStructure c(AbstractDateTimeFormatBuilder abstractDateTimeFormatBuilder) {
            ArrayList arrayList = abstractDateTimeFormatBuilder.a().f55528a;
            new ConcatenatedFormatStructure(arrayList);
            return new CachedFormatStructure(arrayList);
        }

        public static void d(AbstractDateTimeFormatBuilder abstractDateTimeFormatBuilder, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            abstractDateTimeFormatBuilder.a().a(new ConstantFormatStructure(value));
        }
    }

    AppendableFormatStructure a();

    void b(String str, Function1 function1);

    void d(Function1[] function1Arr, Function1 function1);

    AbstractDateTimeFormatBuilder g();
}
