package org.apache.xml.security.c14n;

import org.apache.xml.security.exceptions.XMLSecurityException;

/* loaded from: classes5.dex */
public class CanonicalizationException extends XMLSecurityException {
    public CanonicalizationException() {
    }

    public CanonicalizationException(String str) {
        super(str);
    }

    public CanonicalizationException(String str, Exception exc) {
        super(str, exc);
    }

    public CanonicalizationException(String str, Object[] objArr) {
        super(str, objArr);
    }

    public CanonicalizationException(String str, Object[] objArr, Exception exc) {
        super(str, objArr, exc);
    }
}
