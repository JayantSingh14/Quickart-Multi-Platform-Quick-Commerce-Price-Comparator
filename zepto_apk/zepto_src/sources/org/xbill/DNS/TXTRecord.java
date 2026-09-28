package org.xbill.DNS;

import java.util.List;

/* loaded from: classes5.dex */
public class TXTRecord extends TXTBase {
    public TXTRecord() {
    }

    @Override // org.xbill.DNS.TXTBase
    public /* bridge */ /* synthetic */ List getStrings() {
        return super.getStrings();
    }

    @Override // org.xbill.DNS.TXTBase
    public /* bridge */ /* synthetic */ List getStringsAsByteArrays() {
        return super.getStringsAsByteArrays();
    }

    public TXTRecord(Name name, int i2, long j2, List<String> list) {
        super(name, 16, i2, j2, list);
    }

    public TXTRecord(Name name, int i2, long j2, String str) {
        super(name, 16, i2, j2, str);
    }
}
