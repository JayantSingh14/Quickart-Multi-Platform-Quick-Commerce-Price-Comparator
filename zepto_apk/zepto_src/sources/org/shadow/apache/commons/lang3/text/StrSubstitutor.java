package org.shadow.apache.commons.lang3.text;

import org.shadow.apache.commons.lang3.StringUtils;
import org.shadow.apache.commons.lang3.text.StrMatcher;

/* loaded from: classes5.dex */
public class StrSubstitutor {

    /* renamed from: a, reason: collision with root package name */
    public static final StrMatcher f57775a;

    /* renamed from: b, reason: collision with root package name */
    public static final StrMatcher f57776b;

    static {
        StrMatcher stringMatcher;
        if (StringUtils.a("${")) {
            stringMatcher = StrMatcher.f57771f;
        } else {
            StrMatcher strMatcher = StrMatcher.f57766a;
            stringMatcher = new StrMatcher.StringMatcher("${");
        }
        f57775a = stringMatcher;
        f57776b = StringUtils.a("}") ? StrMatcher.f57771f : new StrMatcher.StringMatcher("}");
        if (StringUtils.a(":-")) {
            StrMatcher strMatcher2 = StrMatcher.f57766a;
        } else {
            new StrMatcher.StringMatcher(":-");
        }
    }

    public StrSubstitutor() {
        if (f57775a == null) {
            throw new IllegalArgumentException("Variable prefix matcher must not be null!");
        }
        if (f57776b == null) {
            throw new IllegalArgumentException("Variable suffix matcher must not be null!");
        }
    }
}
