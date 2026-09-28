package io.ktor.http.parsing.regex;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class GrammarRegex {

    /* renamed from: a, reason: collision with root package name */
    public final String f50310a;

    /* renamed from: b, reason: collision with root package name */
    public final int f50311b;

    public /* synthetic */ GrammarRegex(String str, int i2, int i3) {
        this(str, (i3 & 2) != 0 ? 0 : i2, false);
    }

    public GrammarRegex(String regexRaw, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(regexRaw, "regexRaw");
        this.f50310a = z ? e.l(')', "(", regexRaw) : regexRaw;
        this.f50311b = z ? i2 + 1 : i2;
    }
}
