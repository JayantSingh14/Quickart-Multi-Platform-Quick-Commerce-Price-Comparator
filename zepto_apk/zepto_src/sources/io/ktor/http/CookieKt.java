package io.ktor.http;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CookieKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f50160a;

    /* renamed from: b, reason: collision with root package name */
    public static final Regex f50161b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set f50162c;

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[CookieEncoding.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        String[] elements = {"max-age", "expires", "domain", "path", "secure", "httponly", "$x-enc"};
        Intrinsics.checkNotNullParameter(elements, "elements");
        f50160a = ArraysKt.H(elements);
        f50161b = new Regex("(^|;)\\s*([^;=\\{\\}\\s]+)\\s*(=\\s*(\"[^\"]*\"|[^;]*))?");
        Character[] elements2 = {';', ',', '\"'};
        Intrinsics.checkNotNullParameter(elements2, "elements");
        f50162c = ArraysKt.H(elements2);
    }

    public static final Map a(String cookiesHeader, final boolean z) {
        Intrinsics.checkNotNullParameter(cookiesHeader, "cookiesHeader");
        return MapsKt.m(SequencesKt.m(SequencesKt.g(SequencesKt.m(Regex.a(f50161b, cookiesHeader), CookieKt$parseClientCookiesHeader$1.f50163c), new Function1<Pair<? extends String, ? extends String>, Boolean>() { // from class: io.ktor.http.CookieKt$parseClientCookiesHeader$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Removed duplicated region for block: B:6:0x0018  */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invoke(java.lang.Object r3) {
                /*
                    r2 = this;
                    kotlin.Pair r3 = (kotlin.Pair) r3
                    java.lang.String r0 = "it"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    boolean r0 = r1
                    if (r0 == 0) goto L18
                    java.lang.Object r3 = r3.f53533a
                    java.lang.String r3 = (java.lang.String) r3
                    java.lang.String r0 = "$"
                    r1 = 0
                    boolean r3 = kotlin.text.StringsKt.O(r3, r0, r1)
                    if (r3 != 0) goto L19
                L18:
                    r1 = 1
                L19:
                    java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CookieKt$parseClientCookiesHeader$2.invoke(java.lang.Object):java.lang.Object");
            }
        }), CookieKt$parseClientCookiesHeader$3.f50165c));
    }
}
