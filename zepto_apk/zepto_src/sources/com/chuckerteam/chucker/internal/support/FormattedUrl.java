package com.chuckerteam.chucker.internal.support;

import androidx.fragment.app.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;

@Metadata
/* loaded from: classes3.dex */
public final class FormattedUrl {

    /* renamed from: a, reason: collision with root package name */
    public final String f16760a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16761b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16762c;

    /* renamed from: d, reason: collision with root package name */
    public final String f16763d;

    /* renamed from: e, reason: collision with root package name */
    public final String f16764e;

    @Metadata
    public static final class Companion {
        public static FormattedUrl a(HttpUrl httpUrl, boolean z) {
            String string;
            Intrinsics.checkNotNullParameter(httpUrl, "httpUrl");
            if (z) {
                String strE = CollectionsKt.E(httpUrl.c(), "/", null, null, null, 62);
                String strConcat = !StringsKt.z(strE) ? "/".concat(strE) : "";
                String strD = httpUrl.d();
                return new FormattedUrl(httpUrl.f56259a, httpUrl.f56262d, httpUrl.f56263e, strConcat, strD == null ? "" : strD);
            }
            String strE2 = CollectionsKt.E(httpUrl.f56264f, "/", null, null, null, 62);
            String strConcat2 = !StringsKt.z(strE2) ? "/".concat(strE2) : "";
            ArrayList arrayList = httpUrl.f56265g;
            if (arrayList == null) {
                string = null;
            } else {
                StringBuilder sb = new StringBuilder();
                HttpUrl.Companion.g(arrayList, sb);
                string = sb.toString();
            }
            return new FormattedUrl(httpUrl.f56259a, httpUrl.f56262d, httpUrl.f56263e, strConcat2, string == null ? "" : string);
        }
    }

    public FormattedUrl(String str, String str2, int i2, String str3, String str4) {
        this.f16760a = str;
        this.f16761b = str2;
        this.f16762c = i2;
        this.f16763d = str3;
        this.f16764e = str4;
    }

    public final String a() {
        String str = this.f16764e;
        boolean z = StringsKt.z(str);
        String str2 = this.f16763d;
        return z ? str2 : android.support.v4.media.b.l(str2, "?", str);
    }

    public final String b() {
        String str = this.f16760a;
        boolean zB = Intrinsics.b(str, "https");
        String str2 = this.f16761b;
        int i2 = this.f16762c;
        if ((zB && i2 == 443) || (Intrinsics.b(str, "http") && i2 == 80)) {
            return e.D(str, "://", str2, a());
        }
        return str + "://" + str2 + ":" + i2 + a();
    }
}
