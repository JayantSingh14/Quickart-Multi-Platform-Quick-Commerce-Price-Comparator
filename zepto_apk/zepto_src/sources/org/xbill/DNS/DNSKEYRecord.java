package org.xbill.DNS;

import java.io.IOException;
import java.security.PublicKey;
import org.xbill.DNS.DNSSEC;

/* loaded from: classes5.dex */
public class DNSKEYRecord extends KEYBase {

    public static class Flags {
        public static final int REVOKE = 128;
        public static final int SEP_KEY = 1;
        public static final int ZONE_KEY = 256;

        private Flags() {
        }
    }

    public static class Protocol {
        public static final int DNSSEC = 3;

        private Protocol() {
        }
    }

    public DNSKEYRecord() {
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ int getAlgorithm() {
        return super.getAlgorithm();
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ int getFlags() {
        return super.getFlags();
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ int getFootprint() {
        return super.getFootprint();
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ byte[] getKey() {
        return super.getKey();
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ int getProtocol() {
        return super.getProtocol();
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ PublicKey getPublicKey() throws DNSSEC.DNSSECException {
        return super.getPublicKey();
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.flags = tokenizer.getUInt16();
        this.proto = tokenizer.getUInt8();
        String string = tokenizer.getString();
        int iValue = DNSSEC.Algorithm.value(string);
        this.alg = iValue;
        if (iValue >= 0) {
            this.key = tokenizer.getBase64();
        } else {
            throw tokenizer.exception("Invalid algorithm: " + string);
        }
    }

    public DNSKEYRecord(Name name, int i2, int i3, long j2, int i4, int i5, int i6, byte[] bArr) {
        super(name, i2, i3, j2, i4, i5, i6, bArr);
    }

    public DNSKEYRecord(Name name, int i2, long j2, int i3, int i4, int i5, byte[] bArr) {
        this(name, 48, i2, j2, i3, i4, i5, bArr);
    }

    public DNSKEYRecord(Name name, int i2, long j2, int i3, int i4, int i5, PublicKey publicKey) throws DNSSEC.DNSSECException {
        super(name, 48, i2, j2, i3, i4, i5, DNSSEC.fromPublicKey(publicKey, i5));
        this.publicKey = publicKey;
    }
}
