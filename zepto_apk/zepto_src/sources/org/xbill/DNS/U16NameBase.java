package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
abstract class U16NameBase extends Record {
    protected Name nameField;
    protected int u16Field;

    public U16NameBase() {
    }

    public Name getNameField() {
        return this.nameField;
    }

    public int getU16Field() {
        return this.u16Field;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.u16Field = tokenizer.getUInt16();
        this.nameField = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.u16Field = dNSInput.readU16();
        this.nameField = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return this.u16Field + StringUtils.SPACE + this.nameField;
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.u16Field);
        this.nameField.toWire(dNSOutput, null, z);
    }

    public U16NameBase(Name name, int i2, int i3, long j2) {
        super(name, i2, i3, j2);
    }

    public U16NameBase(Name name, int i2, int i3, long j2, int i4, String str, Name name2, String str2) {
        super(name, i2, i3, j2);
        this.u16Field = Record.checkU16(str, i4);
        this.nameField = Record.checkName(str2, name2);
    }
}
