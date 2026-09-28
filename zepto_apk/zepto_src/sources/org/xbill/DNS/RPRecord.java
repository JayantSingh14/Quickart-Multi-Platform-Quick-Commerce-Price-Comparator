package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class RPRecord extends Record {
    private Name mailbox;
    private Name textDomain;

    public RPRecord() {
    }

    public Name getMailbox() {
        return this.mailbox;
    }

    public Name getTextDomain() {
        return this.textDomain;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.mailbox = tokenizer.getName(name);
        this.textDomain = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.mailbox = new Name(dNSInput);
        this.textDomain = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return this.mailbox + StringUtils.SPACE + this.textDomain;
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.mailbox.toWire(dNSOutput, null, z);
        this.textDomain.toWire(dNSOutput, null, z);
    }

    public RPRecord(Name name, int i2, long j2, Name name2, Name name3) {
        super(name, 17, i2, j2);
        this.mailbox = Record.checkName("mailbox", name2);
        this.textDomain = Record.checkName("textDomain", name3);
    }
}
