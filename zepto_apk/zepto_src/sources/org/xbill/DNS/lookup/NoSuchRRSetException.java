package org.xbill.DNS.lookup;

import org.xbill.DNS.Name;

/* loaded from: classes5.dex */
public class NoSuchRRSetException extends LookupFailedException {
    public NoSuchRRSetException(Name name, int i2) {
        this(name, i2, false);
    }

    public NoSuchRRSetException(Name name, int i2, boolean z) {
        super(null, null, name, i2, z);
    }
}
