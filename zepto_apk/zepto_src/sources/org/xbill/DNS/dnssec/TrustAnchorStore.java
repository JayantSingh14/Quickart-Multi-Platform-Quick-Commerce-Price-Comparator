package org.xbill.DNS.dnssec;

import java.util.Collection;
import org.xbill.DNS.Name;
import org.xbill.DNS.RRset;

/* loaded from: classes5.dex */
public interface TrustAnchorStore {
    void clear();

    RRset find(Name name, int i2);

    Collection<RRset> items();

    void store(RRset rRset);
}
