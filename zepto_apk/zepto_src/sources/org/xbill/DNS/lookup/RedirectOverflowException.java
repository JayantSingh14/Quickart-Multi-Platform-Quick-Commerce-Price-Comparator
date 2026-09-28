package org.xbill.DNS.lookup;

import lombok.Generated;

/* loaded from: classes5.dex */
public class RedirectOverflowException extends LookupFailedException {
    private final int maxRedirects;

    @Deprecated
    public RedirectOverflowException(String str) {
        super(str);
        this.maxRedirects = 0;
    }

    @Generated
    public int getMaxRedirects() {
        return this.maxRedirects;
    }

    public RedirectOverflowException(int i2) {
        super(android.support.v4.media.b.g(i2, "Refusing to follow more than ", " redirects"));
        this.maxRedirects = i2;
    }

    public RedirectOverflowException(String str, int i2) {
        super(str);
        this.maxRedirects = i2;
    }
}
