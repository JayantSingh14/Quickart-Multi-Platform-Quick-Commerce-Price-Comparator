package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes3.dex */
public final class RegexKt$fromInt$1$1 implements Function1<Enum<Object>, Boolean> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(Enum<Object> r1) {
        FlagEnum flagEnum = (FlagEnum) r1;
        flagEnum.getClass();
        return Boolean.valueOf(flagEnum.getValue() == 0);
    }
}
