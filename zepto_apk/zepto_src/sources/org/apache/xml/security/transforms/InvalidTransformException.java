package org.apache.xml.security.transforms;

import org.apache.xml.security.exceptions.XMLSecurityException;

/* loaded from: classes5.dex */
public class InvalidTransformException extends XMLSecurityException {
    public InvalidTransformException() {
    }

    public InvalidTransformException(String str, Object[] objArr) {
        super(str, objArr);
    }

    public InvalidTransformException(String str, Object[] objArr, Exception exc) {
        super(str, objArr, exc);
    }
}
