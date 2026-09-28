package org.xbill.DNS;

import java.util.List;

/* loaded from: classes5.dex */
public class SPFRecord extends TXTBase {
    public SPFRecord() {
    }

    @Override // org.xbill.DNS.TXTBase
    public /* bridge */ /* synthetic */ List getStrings() {
        return super.getStrings();
    }

    @Override // org.xbill.DNS.TXTBase
    public /* bridge */ /* synthetic */ List getStringsAsByteArrays() {
        return super.getStringsAsByteArrays();
    }

    public SPFRecord(Name name, int i2, long j2, List<String> list) {
        super(name, 99, i2, j2, list);
    }

    public SPFRecord(Name name, int i2, long j2, String str) {
        super(name, 99, i2, j2, str);
    }
}
