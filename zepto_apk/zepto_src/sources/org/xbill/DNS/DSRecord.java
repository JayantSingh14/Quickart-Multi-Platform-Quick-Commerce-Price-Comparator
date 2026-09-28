package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.utils.base16;

/* loaded from: classes5.dex */
public class DSRecord extends Record {

    @Deprecated
    public static final int GOST3411_DIGEST_ID = 3;

    @Deprecated
    public static final int SHA1_DIGEST_ID = 1;

    @Deprecated
    public static final int SHA256_DIGEST_ID = 2;

    @Deprecated
    public static final int SHA384_DIGEST_ID = 4;
    private int alg;
    private byte[] digest;
    private int digestid;
    private int footprint;

    @Deprecated
    public static class Digest {
        public static final int GOST3411 = 3;
        public static final int SHA1 = 1;
        public static final int SHA256 = 2;
        public static final int SHA384 = 4;

        private Digest() {
        }
    }

    public DSRecord() {
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public byte[] getDigest() {
        return this.digest;
    }

    public int getDigestID() {
        return this.digestid;
    }

    public int getFootprint() {
        return this.footprint;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.footprint = tokenizer.getUInt16();
        this.alg = tokenizer.getUInt8();
        this.digestid = tokenizer.getUInt8();
        this.digest = tokenizer.getHex(true);
        int iAlgLength = DNSSEC.Digest.algLength(this.digestid);
        if (iAlgLength <= -1 || iAlgLength == this.digest.length) {
            return;
        }
        StringBuilder sbU = android.support.v4.media.b.u(iAlgLength, "Expected ", " bytes for ");
        sbU.append(DNSSEC.Digest.string(this.digestid));
        sbU.append(", got ");
        sbU.append(this.digest.length);
        throw tokenizer.exception(sbU.toString());
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.footprint = dNSInput.readU16();
        this.alg = dNSInput.readU8();
        this.digestid = dNSInput.readU8();
        this.digest = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.footprint);
        sb.append(StringUtils.SPACE);
        sb.append(this.alg);
        sb.append(StringUtils.SPACE);
        sb.append(this.digestid);
        if (this.digest != null) {
            sb.append(StringUtils.SPACE);
            sb.append(base16.toString(this.digest));
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.footprint);
        dNSOutput.writeU8(this.alg);
        dNSOutput.writeU8(this.digestid);
        byte[] bArr = this.digest;
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
        }
    }

    public DSRecord(Name name, int i2, int i3, long j2, int i4, int i5, int i6, byte[] bArr) {
        super(name, i2, i3, j2);
        int iAlgLength = DNSSEC.Digest.algLength(i6);
        if (iAlgLength <= -1 || iAlgLength == bArr.length) {
            this.footprint = Record.checkU16("footprint", i4);
            this.alg = Record.checkU8("alg", i5);
            this.digestid = Record.checkU8("digestid", i6);
            this.digest = bArr;
            return;
        }
        StringBuilder sbU = android.support.v4.media.b.u(iAlgLength, "Expected ", " bytes for ");
        sbU.append(DNSSEC.Digest.string(i6));
        sbU.append(", got ");
        sbU.append(bArr.length);
        throw new IllegalArgumentException(sbU.toString());
    }

    public DSRecord(Name name, int i2, long j2, int i3, int i4, int i5, byte[] bArr) {
        this(name, 43, i2, j2, i3, i4, i5, bArr);
    }

    public DSRecord(Name name, int i2, long j2, int i3, DNSKEYRecord dNSKEYRecord) {
        this(name, i2, j2, dNSKEYRecord.getFootprint(), dNSKEYRecord.getAlgorithm(), i3, DNSSEC.generateDSDigest(dNSKEYRecord, i3));
    }
}
