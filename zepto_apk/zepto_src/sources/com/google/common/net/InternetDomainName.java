package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.errorprone.annotations.Immutable;
import org.apache.commons.lang3.ClassUtils;

@Immutable
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class InternetDomainName {
    static {
        CharMatcher.c(".。．｡");
        Joiner.d(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        CharMatcher.g('0', '9').q(CharMatcher.g('a', 'z').q(CharMatcher.g('A', 'Z'))).q(CharMatcher.c("-_"));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InternetDomainName)) {
            return false;
        }
        ((InternetDomainName) obj).getClass();
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return null;
    }
}
