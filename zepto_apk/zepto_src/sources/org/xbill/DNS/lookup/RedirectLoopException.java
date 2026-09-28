package org.xbill.DNS.lookup;

/* loaded from: classes5.dex */
public class RedirectLoopException extends RedirectOverflowException {
    public RedirectLoopException(int i2) {
        super("Detected a redirect loop", i2);
    }
}
