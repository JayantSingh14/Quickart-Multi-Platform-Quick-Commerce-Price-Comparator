package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.utils.base16;

/* loaded from: classes5.dex */
public class DLVRecord extends Record {

    @Deprecated
    public static final int SHA1_DIGEST_ID = 1;

    @Deprecated
    public static final int SHA256_DIGEST_ID = 2;
    private int alg;
    private byte[] digest;
    private int digestid;
    private int footprint;

    public DLVRecord() {
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

    public DLVRecord(Name name, int i2, long j2, int i3, int i4, int i5, byte[] bArr) {
        super(name, Type.DLV, i2, j2);
        this.footprint = Record.checkU16("footprint", i3);
        this.alg = Record.checkU8("alg", i4);
        this.digestid = Record.checkU8("digestid", i5);
        this.digest = bArr;
    }
}
