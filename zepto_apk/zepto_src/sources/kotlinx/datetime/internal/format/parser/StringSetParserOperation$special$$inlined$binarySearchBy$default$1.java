package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class StringSetParserOperation$special$$inlined$binarySearchBy$default$1 extends Lambda implements Function1<Pair<? extends String, ? extends StringSetParserOperation.TrieNode>, Integer> {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f55628c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringSetParserOperation$special$$inlined$binarySearchBy$default$1(String str) {
        super(1);
        this.f55628c = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Integer.valueOf(ComparisonsKt.a((String) ((Pair) obj).f53533a, this.f55628c));
    }
}
