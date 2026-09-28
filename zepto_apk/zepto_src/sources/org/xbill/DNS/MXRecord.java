package org.xbill.DNS;

/* loaded from: classes5.dex */
public class MXRecord extends U16NameBase {
    public MXRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getNameField();
    }

    public int getPriority() {
        return getU16Field();
    }

    public Name getTarget() {
        return getNameField();
    }

    @Override // org.xbill.DNS.U16NameBase, org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.u16Field);
        this.nameField.toWire(dNSOutput, compression, z);
    }

    public MXRecord(Name name, int i2, long j2, int i3, Name name2) {
        super(name, 15, i2, j2, i3, "priority", name2, "target");
    }
}
