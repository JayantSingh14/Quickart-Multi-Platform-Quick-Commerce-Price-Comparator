package org.xbill.DNS;

import java.security.PublicKey;
import org.xbill.DNS.DNSSEC;

/* loaded from: classes5.dex */
public class CDNSKEYRecord extends DNSKEYRecord {
    public CDNSKEYRecord() {
    }

    public CDNSKEYRecord(Name name, int i2, long j2, int i3, int i4, int i5, byte[] bArr) {
        super(name, 60, i2, j2, i3, i4, i5, bArr);
    }

    public CDNSKEYRecord(Name name, int i2, long j2, int i3, int i4, int i5, PublicKey publicKey) throws DNSSEC.DNSSECException {
        super(name, 60, i2, j2, i3, i4, i5, DNSSEC.fromPublicKey(publicKey, i5));
    }
}
