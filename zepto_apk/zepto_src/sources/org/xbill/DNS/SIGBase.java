package org.xbill.DNS;

import j$.time.Instant;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.utils.base64;

/* loaded from: classes5.dex */
abstract class SIGBase extends Record {
    protected int alg;
    protected int covered;
    protected Instant expire;
    protected int footprint;
    protected int labels;
    protected long origttl;
    protected byte[] signature;
    protected Name signer;
    protected Instant timeSigned;

    public SIGBase() {
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public Instant getExpire() {
        return this.expire;
    }

    public int getFootprint() {
        return this.footprint;
    }

    public int getLabels() {
        return this.labels;
    }

    public long getOrigTTL() {
        return this.origttl;
    }

    @Override // org.xbill.DNS.Record
    public int getRRsetType() {
        return this.covered;
    }

    public byte[] getSignature() {
        return this.signature;
    }

    public Name getSigner() {
        return this.signer;
    }

    public Instant getTimeSigned() {
        return this.timeSigned;
    }

    public int getTypeCovered() {
        return this.covered;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        String string = tokenizer.getString();
        int iValue = Type.value(string);
        this.covered = iValue;
        if (iValue < 0) {
            throw tokenizer.exception("Invalid type: " + string);
        }
        String string2 = tokenizer.getString();
        int iValue2 = DNSSEC.Algorithm.value(string2);
        this.alg = iValue2;
        if (iValue2 < 0) {
            throw tokenizer.exception("Invalid algorithm: " + string2);
        }
        this.labels = tokenizer.getUInt8();
        this.origttl = tokenizer.getTTL();
        this.expire = FormattedTime.parse(tokenizer.getString());
        this.timeSigned = FormattedTime.parse(tokenizer.getString());
        this.footprint = tokenizer.getUInt16();
        this.signer = tokenizer.getName(name);
        this.signature = tokenizer.getBase64();
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.covered = dNSInput.readU16();
        this.alg = dNSInput.readU8();
        this.labels = dNSInput.readU8();
        this.origttl = dNSInput.readU32();
        this.expire = Instant.ofEpochSecond(dNSInput.readU32());
        this.timeSigned = Instant.ofEpochSecond(dNSInput.readU32());
        this.footprint = dNSInput.readU16();
        this.signer = new Name(dNSInput);
        this.signature = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Type.string(this.covered));
        sb.append(StringUtils.SPACE);
        sb.append(this.alg);
        sb.append(StringUtils.SPACE);
        sb.append(this.labels);
        sb.append(StringUtils.SPACE);
        sb.append(this.origttl);
        sb.append(StringUtils.SPACE);
        if (Options.multiline()) {
            sb.append("(\n\t");
        }
        sb.append(FormattedTime.format(this.expire));
        sb.append(StringUtils.SPACE);
        sb.append(FormattedTime.format(this.timeSigned));
        sb.append(StringUtils.SPACE);
        sb.append(this.footprint);
        sb.append(StringUtils.SPACE);
        sb.append(this.signer);
        if (Options.multiline()) {
            sb.append(StringUtils.LF);
            sb.append(base64.formatString(this.signature, 64, "\t", true));
        } else {
            sb.append(StringUtils.SPACE);
            sb.append(base64.toString(this.signature));
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.covered);
        dNSOutput.writeU8(this.alg);
        dNSOutput.writeU8(this.labels);
        dNSOutput.writeU32(this.origttl);
        dNSOutput.writeU32(this.expire.getEpochSecond());
        dNSOutput.writeU32(this.timeSigned.getEpochSecond());
        dNSOutput.writeU16(this.footprint);
        this.signer.toWire(dNSOutput, null, z);
        dNSOutput.writeByteArray(this.signature);
    }

    public void setSignature(byte[] bArr) {
        this.signature = bArr;
    }

    public SIGBase(Name name, int i2, int i3, long j2, int i4, int i5, long j3, Instant instant, Instant instant2, int i6, Name name2, byte[] bArr) {
        super(name, i2, i3, j2);
        Type.check(i4);
        TTL.check(j3);
        this.covered = i4;
        this.alg = Record.checkU8("alg", i5);
        this.labels = name.labels() - 1;
        if (name.isWild()) {
            this.labels--;
        }
        this.origttl = j3;
        this.expire = instant;
        this.timeSigned = instant2;
        this.footprint = Record.checkU16("footprint", i6);
        this.signer = Record.checkName("signer", name2);
        this.signature = bArr;
    }
}
