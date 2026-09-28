package org.apache.xml.security.utils.resolver;

import org.apache.xml.security.exceptions.XMLSecurityException;
import org.w3c.dom.Attr;

/* loaded from: classes5.dex */
public class ResourceResolverException extends XMLSecurityException {

    /* renamed from: c, reason: collision with root package name */
    Attr f57378c;

    /* renamed from: d, reason: collision with root package name */
    String f57379d;

    public ResourceResolverException(String str, Exception exc, Attr attr, String str2) {
        super(str, exc);
        this.f57378c = attr;
        this.f57379d = str2;
    }

    public ResourceResolverException(String str, Object[] objArr, Attr attr, String str2) {
        super(str, objArr);
        this.f57378c = attr;
        this.f57379d = str2;
    }
}
