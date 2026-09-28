package org.apache.xml.security.transforms.params;

import org.apache.xml.security.transforms.TransformParam;
import org.apache.xml.security.utils.ElementProxy;

/* loaded from: classes5.dex */
public class XPathFilterCHGPContainer extends ElementProxy implements TransformParam {
    private XPathFilterCHGPContainer() {
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public final String d() {
        return "http://www.nue.et-inf.uni-siegen.de/~geuer-pollmann/#xpathFilter";
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public final String e() {
        return "XPathAlternative";
    }
}
