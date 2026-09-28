package org.apache.xml.security.utils.resolver.implementations;

import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.w3c.dom.Attr;

/* loaded from: classes5.dex */
public class ResolverAnonymous extends ResourceResolverSpi {

    /* renamed from: d, reason: collision with root package name */
    private XMLSignatureInput f57383d;

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public XMLSignatureInput a(Attr attr, String str) {
        return this.f57383d;
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public boolean b(Attr attr, String str) {
        return attr == null;
    }
}
