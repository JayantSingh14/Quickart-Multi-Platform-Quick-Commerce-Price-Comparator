package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.parser.TokenStream;
import ch.qos.logback.core.pattern.util.AsIsEscapeUtil;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class OptionTokenizer {

    /* renamed from: a, reason: collision with root package name */
    public final AsIsEscapeUtil f13674a;

    /* renamed from: b, reason: collision with root package name */
    public final TokenStream f13675b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13676c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13677d;

    /* renamed from: e, reason: collision with root package name */
    public char f13678e;

    /* renamed from: f, reason: collision with root package name */
    public int f13679f;

    public OptionTokenizer(TokenStream tokenStream) {
        AsIsEscapeUtil asIsEscapeUtil = new AsIsEscapeUtil();
        this.f13679f = 0;
        this.f13675b = tokenStream;
        this.f13676c = tokenStream.f13689a;
        this.f13677d = tokenStream.f13690b;
        this.f13674a = asIsEscapeUtil;
    }

    public final void a(ArrayList arrayList, ArrayList arrayList2) {
        arrayList.add(new Token(1006, arrayList2));
        this.f13675b.f13692d = TokenStream.TokenizerState.f13695a;
    }
}
