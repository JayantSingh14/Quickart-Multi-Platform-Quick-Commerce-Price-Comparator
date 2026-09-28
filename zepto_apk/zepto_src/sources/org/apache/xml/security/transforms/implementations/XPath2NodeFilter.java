package org.apache.xml.security.transforms.implementations;

import java.util.Iterator;
import java.util.Set;
import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
class XPath2NodeFilter implements NodeFilter {

    /* renamed from: a, reason: collision with root package name */
    boolean f57302a;

    /* renamed from: b, reason: collision with root package name */
    boolean f57303b;

    /* renamed from: c, reason: collision with root package name */
    boolean f57304c;

    /* renamed from: d, reason: collision with root package name */
    Set f57305d;

    /* renamed from: e, reason: collision with root package name */
    Set f57306e;

    /* renamed from: f, reason: collision with root package name */
    Set f57307f;

    /* renamed from: g, reason: collision with root package name */
    int f57308g = -1;

    /* renamed from: h, reason: collision with root package name */
    int f57309h = -1;

    /* renamed from: i, reason: collision with root package name */
    int f57310i = -1;

    public XPath2NodeFilter(Set set, Set set2, Set set3) {
        this.f57305d = set;
        this.f57302a = !set.isEmpty();
        this.f57306e = set2;
        this.f57303b = !set2.isEmpty();
        this.f57307f = set3;
        this.f57304c = !set3.isEmpty();
    }

    public static boolean b(Node node, Set set) {
        return set.contains(node);
    }

    @Override // org.apache.xml.security.signature.NodeFilter
    public int a(Node node) {
        int i2 = (this.f57303b && a(node, this.f57306e)) ? -1 : (!this.f57304c || a(node, this.f57307f)) ? 1 : 0;
        if (i2 == 1) {
            return 1;
        }
        return this.f57302a ? a(node, this.f57305d) ? 1 : 0 : i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001f  */
    @Override // org.apache.xml.security.signature.NodeFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(org.w3c.dom.Node r6, int r7) {
        /*
            r5 = this;
            boolean r0 = r5.f57303b
            r1 = -1
            r2 = 1
            if (r0 == 0) goto L1f
            int r0 = r5.f57308g
            if (r0 == r1) goto Lc
            if (r7 > r0) goto L19
        Lc:
            java.util.Set r0 = r5.f57306e
            boolean r0 = b(r6, r0)
            if (r0 == 0) goto L17
            r5.f57308g = r7
            goto L19
        L17:
            r5.f57308g = r1
        L19:
            int r0 = r5.f57308g
            if (r0 == r1) goto L1f
            r0 = r1
            goto L20
        L1f:
            r0 = r2
        L20:
            r3 = 0
            if (r0 == r1) goto L3b
            boolean r4 = r5.f57304c
            if (r4 == 0) goto L3b
            int r4 = r5.f57309h
            if (r4 == r1) goto L2d
            if (r7 > r4) goto L3b
        L2d:
            java.util.Set r4 = r5.f57307f
            boolean r4 = b(r6, r4)
            if (r4 != 0) goto L39
            r5.f57309h = r1
            r0 = r3
            goto L3b
        L39:
            r5.f57309h = r7
        L3b:
            int r4 = r5.f57310i
            if (r7 > r4) goto L41
            r5.f57310i = r1
        L41:
            if (r0 != r2) goto L44
            return r2
        L44:
            boolean r4 = r5.f57302a
            if (r4 == 0) goto L5c
            int r0 = r5.f57310i
            if (r0 != r1) goto L56
            java.util.Set r0 = r5.f57305d
            boolean r6 = b(r6, r0)
            if (r6 == 0) goto L56
            r5.f57310i = r7
        L56:
            int r6 = r5.f57310i
            if (r6 == r1) goto L5b
            return r2
        L5b:
            return r3
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.transforms.implementations.XPath2NodeFilter.a(org.w3c.dom.Node, int):int");
    }

    public static boolean a(Node node, Set set) {
        if (set.contains(node)) {
            return true;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (XMLUtils.a((Node) it.next(), node)) {
                return true;
            }
        }
        return false;
    }
}
