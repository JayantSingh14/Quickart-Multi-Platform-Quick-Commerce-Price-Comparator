package org.xbill.DNS;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes5.dex */
public class AAAARecord extends Record {
    private byte[] address;

    public AAAARecord() {
    }

    public InetAddress getAddress() {
        try {
            Name name = this.name;
            return name == null ? InetAddress.getByAddress(this.address) : InetAddress.getByAddress(name.toString(), this.address);
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.address = tokenizer.getAddressBytes(2);
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.address = dNSInput.readByteArray(16);
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() throws UnknownHostException {
        try {
            InetAddress byAddress = InetAddress.getByAddress(null, this.address);
            if (byAddress.getAddress().length != 4) {
                return byAddress.getHostAddress();
            }
            return "::ffff:" + byAddress.getHostAddress();
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeByteArray(this.address);
    }

    public AAAARecord(Name name, int i2, long j2, InetAddress inetAddress) {
        super(name, 28, i2, j2);
        if (Address.familyOf(inetAddress) != 1 && Address.familyOf(inetAddress) != 2) {
            throw new IllegalArgumentException("invalid IPv4/IPv6 address");
        }
        this.address = inetAddress.getAddress();
    }

    public AAAARecord(Name name, int i2, long j2, byte[] bArr) {
        super(name, 28, i2, j2);
        if (bArr != null && bArr.length == 16) {
            this.address = bArr;
            return;
        }
        throw new IllegalArgumentException("invalid IPv6 address");
    }
}
