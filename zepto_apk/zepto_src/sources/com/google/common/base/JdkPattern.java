package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class JdkPattern extends CommonPattern implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f42274a;

    public static final class JdkMatcher extends CommonMatcher {

        /* renamed from: a, reason: collision with root package name */
        public final Matcher f42275a;

        public JdkMatcher(Matcher matcher) {
            matcher.getClass();
            this.f42275a = matcher;
        }

        @Override // com.google.common.base.CommonMatcher
        public final int a() {
            return this.f42275a.end();
        }

        @Override // com.google.common.base.CommonMatcher
        public final boolean b(int i2) {
            return this.f42275a.find(i2);
        }

        @Override // com.google.common.base.CommonMatcher
        public final int c() {
            return this.f42275a.start();
        }
    }

    public JdkPattern(Pattern pattern) {
        pattern.getClass();
        this.f42274a = pattern;
    }

    public final String toString() {
        return this.f42274a.toString();
    }
}
