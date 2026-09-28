package org.xbill.DNS;

/* loaded from: classes5.dex */
public class CDSRecord extends DSRecord {
    public CDSRecord() {
    }

    public CDSRecord(Name name, int i2, long j2, int i3, int i4, int i5, byte[] bArr) {
        super(name, 59, i2, j2, i3, i4, i5, bArr);
    }

    public CDSRecord(Name name, int i2, long j2, int i3, DNSKEYRecord dNSKEYRecord) {
        super(name, 59, i2, j2, dNSKEYRecord.getFootprint(), dNSKEYRecord.getAlgorithm(), i3, DNSSEC.generateDSDigest(dNSKEYRecord, i3));
    }
}
