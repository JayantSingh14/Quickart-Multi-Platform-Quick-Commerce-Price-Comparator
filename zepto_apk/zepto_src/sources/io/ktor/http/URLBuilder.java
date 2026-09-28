package io.ktor.http;

import coil3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class URLBuilder {

    /* renamed from: k, reason: collision with root package name */
    public static final Url f50240k;

    /* renamed from: a, reason: collision with root package name */
    public URLProtocol f50241a;

    /* renamed from: b, reason: collision with root package name */
    public String f50242b;

    /* renamed from: c, reason: collision with root package name */
    public int f50243c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f50244d;

    /* renamed from: e, reason: collision with root package name */
    public String f50245e;

    /* renamed from: f, reason: collision with root package name */
    public String f50246f;

    /* renamed from: g, reason: collision with root package name */
    public String f50247g;

    /* renamed from: h, reason: collision with root package name */
    public List f50248h;

    /* renamed from: i, reason: collision with root package name */
    public ParametersBuilderImpl f50249i;

    /* renamed from: j, reason: collision with root package name */
    public UrlDecodedParametersBuilder f50250j;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    static {
        Intrinsics.checkNotNullParameter(new Companion(), "<this>");
        f50240k = URLUtilsKt.a("http://localhost");
    }

    public URLBuilder() {
        this(0);
    }

    public final void a() {
        if (this.f50242b.length() <= 0 && !Intrinsics.b(this.f50241a.f50257a, UtilsKt.SCHEME_FILE)) {
            Url url = f50240k;
            this.f50242b = url.f50261b;
            URLProtocol uRLProtocol = this.f50241a;
            URLProtocol uRLProtocol2 = URLProtocol.f50253c;
            if (Intrinsics.b(uRLProtocol, URLProtocol.f50253c)) {
                this.f50241a = url.f50260a;
            }
            if (this.f50243c == 0) {
                this.f50243c = url.f50262c;
            }
        }
    }

    public final Url b() {
        a();
        URLProtocol uRLProtocol = this.f50241a;
        String str = this.f50242b;
        int i2 = this.f50243c;
        List list = this.f50248h;
        ArrayList arrayList = new ArrayList(CollectionsKt.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.d((String) it.next()));
        }
        Parameters parametersA = UrlDecodedParametersBuilderKt.a(this.f50250j.f50279a);
        String strE = CodecsKt.e(0, 0, 15, this.f50247g);
        String str2 = this.f50245e;
        String strD = str2 != null ? CodecsKt.d(str2) : null;
        String str3 = this.f50246f;
        String strD2 = str3 != null ? CodecsKt.d(str3) : null;
        boolean z = this.f50244d;
        a();
        StringBuilder sb = new StringBuilder(256);
        URLBuilderKt.a(this, sb);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "appendTo(StringBuilder(256)).toString()");
        return new Url(uRLProtocol, str, i2, arrayList, parametersA, strE, strD, strD2, z, string);
    }

    public final void c(List list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f50248h = list;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f50242b = str;
    }

    public final void e(URLProtocol uRLProtocol) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "<set-?>");
        this.f50241a = uRLProtocol;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(256);
        URLBuilderKt.a(this, sb);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "appendTo(StringBuilder(256)).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public URLBuilder(int r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLBuilder.<init>(int):void");
    }
}
