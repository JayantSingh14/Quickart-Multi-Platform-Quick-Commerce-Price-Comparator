package io.ktor.util;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class CaseInsensitiveString {

    /* renamed from: a, reason: collision with root package name */
    public final String f50444a;

    /* renamed from: b, reason: collision with root package name */
    public final int f50445b;

    public CaseInsensitiveString(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.f50444a = content;
        String lowerCase = content.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.f50445b = lowerCase.hashCode();
    }

    public final boolean equals(Object obj) {
        String str;
        CaseInsensitiveString caseInsensitiveString = obj instanceof CaseInsensitiveString ? (CaseInsensitiveString) obj : null;
        return (caseInsensitiveString == null || (str = caseInsensitiveString.f50444a) == null || !str.equalsIgnoreCase(this.f50444a)) ? false : true;
    }

    public final int hashCode() {
        return this.f50445b;
    }

    public final String toString() {
        return this.f50444a;
    }
}
