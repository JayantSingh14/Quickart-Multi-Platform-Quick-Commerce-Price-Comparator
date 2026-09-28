package io.ktor.http;

import android.support.v4.media.b;
import io.ktor.http.ContentType;
import io.ktor.util.TextKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
final class MimesKt$loadMimes$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends ContentType>> {

    /* renamed from: c, reason: collision with root package name */
    public static final MimesKt$loadMimes$1 f50233c = new MimesKt$loadMimes$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        String string = StringsKt.b0(it).toString();
        if (string.length() == 0) {
            return null;
        }
        int iW = StringsKt.w(string, ',', 0, 6);
        String strSubstring = string.substring(0, iW);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = string.substring(iW + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        String strB = TextKt.b(StringsKt.F(strSubstring, CLConstants.DOT_SALT_DELIMETER));
        Lazy lazy = FileContentTypeKt.f50187a;
        Intrinsics.checkNotNullParameter(strSubstring2, "<this>");
        try {
            ContentType contentType = ContentType.f50126e;
            return new Pair(strB, ContentType.Companion.a(strSubstring2));
        } catch (Throwable th) {
            throw new IllegalArgumentException(b.C("Failed to parse ", strSubstring2), th);
        }
    }
}
