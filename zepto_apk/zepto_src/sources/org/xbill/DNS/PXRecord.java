package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class PXRecord extends Record {
    private Name map822;
    private Name mapX400;
    private int preference;

    public PXRecord() {
    }

    public Name getMap822() {
        return this.map822;
    }

    public Name getMapX400() {
        return this.mapX400;
    }

    public int getPreference() {
        return this.preference;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.preference = tokenizer.getUInt16();
        this.map822 = tokenizer.getName(name);
        this.mapX400 = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.preference = dNSInput.readU16();
        this.map822 = new Name(dNSInput);
        this.mapX400 = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return this.preference + StringUtils.SPACE + this.map822 + StringUtils.SPACE + this.mapX400;
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.preference);
        this.map822.toWire(dNSOutput, null, z);
        this.mapX400.toWire(dNSOutput, null, z);
    }

    public PXRecord(Name name, int i2, long j2, int i3, Name name2, Name name3) {
        super(name, 26, i2, j2);
        this.preference = Record.checkU16("preference", i3);
        this.map822 = Record.checkName("map822", name2);
        this.mapX400 = Record.checkName("mapX400", name3);
    }
}
