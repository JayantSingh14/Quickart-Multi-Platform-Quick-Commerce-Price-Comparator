package org.xbill.DNS;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class A6Record extends Record {
    private Name prefix;
    private int prefixBits;
    private InetAddress suffix;

    public A6Record() {
    }

    public Name getPrefix() {
        return this.prefix;
    }

    public int getPrefixBits() {
        return this.prefixBits;
    }

    public InetAddress getSuffix() {
        return this.suffix;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        int uInt8 = tokenizer.getUInt8();
        this.prefixBits = uInt8;
        if (uInt8 > 128) {
            throw tokenizer.exception("prefix bits must be [0..128]");
        }
        if (uInt8 < 128) {
            String string = tokenizer.getString();
            try {
                this.suffix = Address.getByAddress(string, 2);
            } catch (UnknownHostException unused) {
                throw tokenizer.exception("invalid IPv6 address: " + string);
            }
        }
        if (this.prefixBits > 0) {
            this.prefix = tokenizer.getName(name);
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        int u8 = dNSInput.readU8();
        this.prefixBits = u8;
        int i2 = (135 - u8) / 8;
        if (u8 < 128) {
            byte[] bArr = new byte[16];
            dNSInput.readByteArray(bArr, 16 - i2, i2);
            this.suffix = InetAddress.getByAddress(bArr);
        }
        if (this.prefixBits > 0) {
            this.prefix = new Name(dNSInput);
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.prefixBits);
        if (this.suffix != null) {
            sb.append(StringUtils.SPACE);
            sb.append(this.suffix.getHostAddress());
        }
        if (this.prefix != null) {
            sb.append(StringUtils.SPACE);
            sb.append(this.prefix);
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(this.prefixBits);
        InetAddress inetAddress = this.suffix;
        if (inetAddress != null) {
            int i2 = (135 - this.prefixBits) / 8;
            dNSOutput.writeByteArray(inetAddress.getAddress(), 16 - i2, i2);
        }
        Name name = this.prefix;
        if (name != null) {
            name.toWire(dNSOutput, null, z);
        }
    }

    public A6Record(Name name, int i2, long j2, int i3, InetAddress inetAddress, Name name2) {
        super(name, 38, i2, j2);
        this.prefixBits = Record.checkU8("prefixBits", i3);
        if (inetAddress != null && Address.familyOf(inetAddress) != 2) {
            throw new IllegalArgumentException("invalid IPv6 address");
        }
        this.suffix = inetAddress;
        if (name2 != null) {
            this.prefix = Record.checkName("prefix", name2);
        }
    }
}
