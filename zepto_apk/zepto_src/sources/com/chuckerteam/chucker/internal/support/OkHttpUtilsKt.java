package com.chuckerteam.chucker.internal.support;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okio.GzipSource;
import okio.Okio;
import okio.RealBufferedSource$inputStream$1;
import okio.Source;
import org.brotli.dec.BrotliInputStream;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OkHttpUtilsKt {

    /* renamed from: a, reason: collision with root package name */
    public static final List f16784a = CollectionsKt.I("identity", "gzip", "br");

    public static final Headers a(Headers headers, LinkedHashSet names) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(names, "names");
        Headers.Builder builderI = headers.i();
        for (String str : headers.g()) {
            if (!names.isEmpty()) {
                Iterator it = names.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (StringsKt.t((String) it.next(), str, true)) {
                        builderI.h(str, "**");
                        break;
                    }
                }
            }
        }
        return builderI.e();
    }

    public static final Source b(Source source, Headers headers) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return StringsKt.t(headers.d("Content-Encoding"), "gzip", true) ? new GzipSource(source) : StringsKt.t(headers.d("Content-Encoding"), "br", true) ? Okio.m(new BrotliInputStream(new RealBufferedSource$inputStream$1(Okio.d(source)))) : source;
    }
}
