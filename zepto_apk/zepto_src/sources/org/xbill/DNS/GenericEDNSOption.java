package org.xbill.DNS;

import org.xbill.DNS.utils.base16;

/* loaded from: classes5.dex */
public class GenericEDNSOption extends EDNSOption {
    private byte[] data;

    public GenericEDNSOption(int i2) {
        super(i2);
    }

    @Override // org.xbill.DNS.EDNSOption
    public void optionFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.EDNSOption
    public String optionToString() {
        return "<" + base16.toString(this.data) + ">";
    }

    @Override // org.xbill.DNS.EDNSOption
    public void optionToWire(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(this.data);
    }

    public GenericEDNSOption(int i2, byte[] bArr) {
        super(i2);
        this.data = Record.checkByteArrayLength("option data", bArr, Message.MAXLENGTH);
    }
}
