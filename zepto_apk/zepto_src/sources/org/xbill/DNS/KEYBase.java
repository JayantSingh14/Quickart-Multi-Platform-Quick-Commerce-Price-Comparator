package org.xbill.DNS;

import java.io.IOException;
import java.security.PublicKey;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.utils.base64;

/* loaded from: classes5.dex */
abstract class KEYBase extends Record {
    protected int alg;
    protected int flags;
    protected int footprint;
    protected byte[] key;
    protected int proto;
    protected PublicKey publicKey;

    public KEYBase() {
        this.footprint = -1;
        this.publicKey = null;
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getFootprint() {
        int i2;
        int i3;
        int i4 = this.footprint;
        if (i4 >= 0) {
            return i4;
        }
        DNSOutput dNSOutput = new DNSOutput();
        int i5 = 0;
        rrToWire(dNSOutput, null, false);
        byte[] byteArray = dNSOutput.toByteArray();
        if (this.alg == 1) {
            int i6 = byteArray[byteArray.length - 3] & 255;
            i3 = byteArray[byteArray.length - 2] & 255;
            i2 = i6 << 8;
        } else {
            i2 = 0;
            while (i5 < byteArray.length - 1) {
                i2 += ((byteArray[i5] & 255) << 8) + (byteArray[i5 + 1] & 255);
                i5 += 2;
            }
            if (i5 < byteArray.length) {
                i2 += (byteArray[i5] & 255) << 8;
            }
            i3 = (i2 >> 16) & Message.MAXLENGTH;
        }
        int i7 = (i2 + i3) & Message.MAXLENGTH;
        this.footprint = i7;
        return i7;
    }

    public byte[] getKey() {
        return this.key;
    }

    public int getProtocol() {
        return this.proto;
    }

    public PublicKey getPublicKey() throws DNSSEC.DNSSECException {
        PublicKey publicKey = this.publicKey;
        if (publicKey != null) {
            return publicKey;
        }
        PublicKey publicKey2 = DNSSEC.toPublicKey(this);
        this.publicKey = publicKey2;
        return publicKey2;
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.flags = dNSInput.readU16();
        this.proto = dNSInput.readU8();
        this.alg = dNSInput.readU8();
        if (dNSInput.remaining() > 0) {
            this.key = dNSInput.readByteArray();
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.flags);
        sb.append(StringUtils.SPACE);
        sb.append(this.proto);
        sb.append(StringUtils.SPACE);
        sb.append(this.alg);
        if (this.key != null) {
            if (Options.multiline()) {
                sb.append(" (\n");
                sb.append(base64.formatString(this.key, 64, "\t", true));
                sb.append(" ; key_tag = ");
                sb.append(getFootprint());
            } else {
                sb.append(StringUtils.SPACE);
                sb.append(base64.toString(this.key));
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.flags);
        dNSOutput.writeU8(this.proto);
        dNSOutput.writeU8(this.alg);
        byte[] bArr = this.key;
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
        }
    }

    public KEYBase(Name name, int i2, int i3, long j2, int i4, int i5, int i6, byte[] bArr) {
        super(name, i2, i3, j2);
        this.footprint = -1;
        this.publicKey = null;
        this.flags = Record.checkU16("flags", i4);
        this.proto = Record.checkU8("proto", i5);
        this.alg = Record.checkU8("alg", i6);
        this.key = bArr;
    }
}
