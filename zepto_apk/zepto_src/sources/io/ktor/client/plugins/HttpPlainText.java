package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.text.Charsets;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HttpPlainText {

    /* renamed from: d, reason: collision with root package name */
    public static final Plugin f49538d = new Plugin();

    /* renamed from: e, reason: collision with root package name */
    public static final AttributeKey f49539e = new AttributeKey("HttpPlainText");

    /* renamed from: a, reason: collision with root package name */
    public final Charset f49540a;

    /* renamed from: b, reason: collision with root package name */
    public final Charset f49541b;

    /* renamed from: c, reason: collision with root package name */
    public final String f49542c;

    @KtorDsl
    @Metadata
    @SourceDebugExtension
    public static final class Config {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashSet f49543a = new LinkedHashSet();

        /* renamed from: b, reason: collision with root package name */
        public final LinkedHashMap f49544b = new LinkedHashMap();

        /* renamed from: c, reason: collision with root package name */
        public final Charset f49545c = Charsets.UTF_8;
    }

    @Metadata
    public static final class Plugin implements HttpClientPlugin<Config, HttpPlainText> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) {
            HttpPlainText plugin = (HttpPlainText) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.f49262e.g(HttpRequestPipeline.f50020j, new HttpPlainText$Plugin$install$1(plugin, null));
            scope.f49263f.g(HttpResponsePipeline.f50071i, new HttpPlainText$Plugin$install$2(plugin, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpPlainText(config.f49543a, config.f49544b, config.f49545c);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return HttpPlainText.f49539e;
        }
    }

    public HttpPlainText(LinkedHashSet charsets, LinkedHashMap charsetQuality, Charset responseCharsetFallback) {
        Iterable iterableH;
        Intrinsics.checkNotNullParameter(charsets, "charsets");
        Intrinsics.checkNotNullParameter(charsetQuality, "charsetQuality");
        Intrinsics.checkNotNullParameter(responseCharsetFallback, "responseCharsetFallback");
        this.f49540a = responseCharsetFallback;
        Intrinsics.checkNotNullParameter(charsetQuality, "<this>");
        if (charsetQuality.size() == 0) {
            iterableH = EmptyList.f53609a;
        } else {
            Iterator it = charsetQuality.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (it.hasNext()) {
                    ArrayList arrayList = new ArrayList(charsetQuality.size());
                    arrayList.add(new Pair(entry.getKey(), entry.getValue()));
                    do {
                        Map.Entry entry2 = (Map.Entry) it.next();
                        arrayList.add(new Pair(entry2.getKey(), entry2.getValue()));
                    } while (it.hasNext());
                    iterableH = arrayList;
                } else {
                    iterableH = CollectionsKt.H(new Pair(entry.getKey(), entry.getValue()));
                }
            } else {
                iterableH = EmptyList.f53609a;
            }
        }
        List<Pair> listY = CollectionsKt.Y(new Comparator() { // from class: io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.a((Float) ((Pair) obj2).f53534b, (Float) ((Pair) obj).f53534b);
            }
        }, iterableH);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : charsets) {
            if (!charsetQuality.containsKey((Charset) obj)) {
                arrayList2.add(obj);
            }
        }
        List<Charset> listY2 = CollectionsKt.Y(new Comparator() { // from class: io.ktor.client.plugins.HttpPlainText$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return ComparisonsKt.a(CharsetJVMKt.d((Charset) obj2), CharsetJVMKt.d((Charset) obj3));
            }
        }, arrayList2);
        StringBuilder sb = new StringBuilder();
        for (Charset charset : listY2) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(CharsetJVMKt.d(charset));
        }
        for (Pair pair : listY) {
            Charset charset2 = (Charset) pair.f53533a;
            float fFloatValue = ((Number) pair.f53534b).floatValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            double d2 = fFloatValue;
            if (0.0d > d2 || d2 > 1.0d) {
                throw new IllegalStateException("Check failed.");
            }
            sb.append(CharsetJVMKt.d(charset2) + ";q=" + (MathKt.b(100 * fFloatValue) / 100.0d));
        }
        if (sb.length() == 0) {
            sb.append(CharsetJVMKt.d(this.f49540a));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        this.f49542c = string;
        Charset charset3 = (Charset) CollectionsKt.firstOrNull(listY2);
        if (charset3 == null) {
            Pair pair2 = (Pair) CollectionsKt.firstOrNull(listY);
            charset3 = pair2 != null ? (Charset) pair2.f53533a : null;
            if (charset3 == null) {
                charset3 = Charsets.UTF_8;
            }
        }
        this.f49541b = charset3;
    }
}
