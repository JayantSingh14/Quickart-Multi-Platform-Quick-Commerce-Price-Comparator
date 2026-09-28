package kotlinx.datetime.internal.format.parser;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ParserKt$formatError$1 extends Lambda implements Function1<ParseError, CharSequence> {

    /* renamed from: c, reason: collision with root package name */
    public static final ParserKt$formatError$1 f55609c = new ParserKt$formatError$1(1);

    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ParseError it = (ParseError) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        StringBuilder sb = new StringBuilder("position ");
        sb.append(it.f55603a);
        sb.append(": '");
        return e.t(sb, (String) it.f55604b.invoke(), '\'');
    }
}
