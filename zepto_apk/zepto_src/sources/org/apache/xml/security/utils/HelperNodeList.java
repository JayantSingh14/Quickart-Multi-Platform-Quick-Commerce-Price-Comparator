package org.apache.xml.security.utils;

import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public class HelperNodeList implements NodeList {

    /* renamed from: a, reason: collision with root package name */
    ArrayList f57336a;

    /* renamed from: b, reason: collision with root package name */
    boolean f57337b;

    public HelperNodeList() {
        this(false);
    }

    @Override // org.w3c.dom.NodeList
    public int getLength() {
        return this.f57336a.size();
    }

    @Override // org.w3c.dom.NodeList
    public Node item(int i2) {
        return (Node) this.f57336a.get(i2);
    }

    public HelperNodeList(boolean z) {
        this.f57336a = new ArrayList(20);
        this.f57337b = z;
    }
}
