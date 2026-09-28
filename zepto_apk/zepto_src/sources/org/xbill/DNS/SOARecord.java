package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class SOARecord extends Record {
    private Name admin;
    private long expire;
    private Name host;
    private long minimum;
    private long refresh;
    private long retry;
    private long serial;

    public SOARecord() {
    }

    public Name getAdmin() {
        return this.admin;
    }

    public long getExpire() {
        return this.expire;
    }

    public Name getHost() {
        return this.host;
    }

    public long getMinimum() {
        return this.minimum;
    }

    public long getRefresh() {
        return this.refresh;
    }

    public long getRetry() {
        return this.retry;
    }

    public long getSerial() {
        return this.serial;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.host = tokenizer.getName(name);
        this.admin = tokenizer.getName(name);
        this.serial = tokenizer.getUInt32();
        this.refresh = tokenizer.getTTLLike();
        this.retry = tokenizer.getTTLLike();
        this.expire = tokenizer.getTTLLike();
        this.minimum = tokenizer.getTTLLike();
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.host = new Name(dNSInput);
        this.admin = new Name(dNSInput);
        this.serial = dNSInput.readU32();
        this.refresh = dNSInput.readU32();
        this.retry = dNSInput.readU32();
        this.expire = dNSInput.readU32();
        this.minimum = dNSInput.readU32();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.host);
        sb.append(StringUtils.SPACE);
        sb.append(this.admin);
        if (Options.multiline()) {
            sb.append(" (\n\t\t\t\t\t");
            sb.append(this.serial);
            sb.append("\t; serial\n\t\t\t\t\t");
            sb.append(this.refresh);
            sb.append("\t; refresh\n\t\t\t\t\t");
            sb.append(this.retry);
            sb.append("\t; retry\n\t\t\t\t\t");
            sb.append(this.expire);
            sb.append("\t; expire\n\t\t\t\t\t");
            sb.append(this.minimum);
            sb.append(" )\t; minimum");
        } else {
            sb.append(StringUtils.SPACE);
            sb.append(this.serial);
            sb.append(StringUtils.SPACE);
            sb.append(this.refresh);
            sb.append(StringUtils.SPACE);
            sb.append(this.retry);
            sb.append(StringUtils.SPACE);
            sb.append(this.expire);
            sb.append(StringUtils.SPACE);
            sb.append(this.minimum);
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.host.toWire(dNSOutput, compression, z);
        this.admin.toWire(dNSOutput, compression, z);
        dNSOutput.writeU32(this.serial);
        dNSOutput.writeU32(this.refresh);
        dNSOutput.writeU32(this.retry);
        dNSOutput.writeU32(this.expire);
        dNSOutput.writeU32(this.minimum);
    }

    public SOARecord(Name name, int i2, long j2, Name name2, Name name3, long j3, long j4, long j5, long j6, long j7) {
        super(name, 6, i2, j2);
        this.host = Record.checkName("host", name2);
        this.admin = Record.checkName("admin", name3);
        this.serial = Record.checkU32("serial", j3);
        this.refresh = Record.checkU32("refresh", j4);
        this.retry = Record.checkU32("retry", j5);
        this.expire = Record.checkU32("expire", j6);
        this.minimum = Record.checkU32("minimum", j7);
    }
}
