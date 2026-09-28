package kotlinx.datetime.internal.format.parser;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.format.Accessor;
import org.apache.commons.lang3.StringUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ParserOperationKt {
    public static final ParserStructure a(Integer num, Integer num2, Integer num3, Accessor setter, String name, boolean z) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(name, "name");
        int iIntValue2 = num.intValue() + (z ? 1 : 0);
        if (num2 != null) {
            iIntValue = num2.intValue();
            if (z) {
                iIntValue++;
            }
        } else {
            iIntValue = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        int iIntValue3 = num3 != null ? num3.intValue() : 0;
        int iMin = Math.min(iIntValue, iIntValue3);
        if (iIntValue2 >= iMin) {
            return b(z, setter, name, iIntValue2, iIntValue);
        }
        ParserStructure parserStructureB = b(z, setter, name, iIntValue2, iIntValue2);
        while (iIntValue2 < iMin) {
            EmptyList emptyList = EmptyList.f53609a;
            iIntValue2++;
            parserStructureB = new ParserStructure(emptyList, CollectionsKt.I(b(z, setter, name, iIntValue2, iIntValue2), ParserKt.a(CollectionsKt.I(new ParserStructure(CollectionsKt.H(new PlainStringParserOperation(StringUtils.SPACE)), emptyList), parserStructureB))));
        }
        return iIntValue3 > iIntValue ? ParserKt.a(CollectionsKt.I(new ParserStructure(CollectionsKt.H(new PlainStringParserOperation(StringsKt.I(StringUtils.SPACE, iIntValue3 - iIntValue))), EmptyList.f53609a), parserStructureB)) : iIntValue3 == iIntValue ? parserStructureB : new ParserStructure(EmptyList.f53609a, CollectionsKt.I(b(z, setter, name, iIntValue3 + 1, iIntValue), parserStructureB));
    }

    public static final ParserStructure b(boolean z, Accessor accessor, String str, int i2, int i3) {
        if (i3 < (z ? 1 : 0) + 1) {
            throw new IllegalStateException("Check failed.");
        }
        ListBuilder builder = CollectionsKt.u();
        if (z) {
            builder.add(new PlainStringParserOperation("-"));
        }
        builder.add(new NumberSpanParserOperation(CollectionsKt.H(new UnsignedIntConsumer(Integer.valueOf(i2 - (z ? 1 : 0)), Integer.valueOf(i3 - (z ? 1 : 0)), accessor, str, z))));
        Intrinsics.checkNotNullParameter(builder, "builder");
        return new ParserStructure(builder.j(), EmptyList.f53609a);
    }
}
