package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class MINFORecord extends Record {
    private Name errorAddress;
    private Name responsibleAddress;

    public MINFORecord() {
    }

    public Name getErrorAddress() {
        return this.errorAddress;
    }

    public Name getResponsibleAddress() {
        return this.responsibleAddress;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.responsibleAddress = tokenizer.getName(name);
        this.errorAddress = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.responsibleAddress = new Name(dNSInput);
        this.errorAddress = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return this.responsibleAddress + StringUtils.SPACE + this.errorAddress;
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.responsibleAddress.toWire(dNSOutput, null, z);
        this.errorAddress.toWire(dNSOutput, null, z);
    }

    public MINFORecord(Name name, int i2, long j2, Name name2, Name name3) {
        super(name, 14, i2, j2);
        this.responsibleAddress = Record.checkName("responsibleAddress", name2);
        this.errorAddress = Record.checkName("errorAddress", name3);
    }
}
