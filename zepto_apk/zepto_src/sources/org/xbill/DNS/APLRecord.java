package org.xbill.DNS;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.Tokenizer;
import org.xbill.DNS.utils.base16;

/* loaded from: classes5.dex */
public class APLRecord extends Record {
    private List<Element> elements;

    public static class Element implements Serializable {
        public final Object address;
        public final int family;
        public final boolean negative;
        public final int prefixLength;

        public boolean equals(Object obj) {
            if (!(obj instanceof Element)) {
                return false;
            }
            Element element = (Element) obj;
            return this.family == element.family && this.negative == element.negative && this.prefixLength == element.prefixLength && this.address.equals(element.address);
        }

        public int hashCode() {
            return this.address.hashCode() + this.prefixLength + (this.negative ? 1 : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.negative) {
                sb.append("!");
            }
            sb.append(this.family);
            sb.append(":");
            int i2 = this.family;
            if (i2 == 1 || i2 == 2) {
                sb.append(((InetAddress) this.address).getHostAddress());
            } else {
                sb.append(base16.toString((byte[]) this.address));
            }
            sb.append("/");
            sb.append(this.prefixLength);
            return sb.toString();
        }

        private Element(int i2, boolean z, Object obj, int i3) {
            this.family = i2;
            this.negative = z;
            this.address = obj;
            this.prefixLength = i3;
            if (!APLRecord.validatePrefixLength(i2, i3)) {
                throw new IllegalArgumentException("invalid prefix length");
            }
        }

        public Element(boolean z, InetAddress inetAddress, int i2) {
            this(Address.familyOf(inetAddress), z, inetAddress, i2);
        }
    }

    public APLRecord() {
    }

    private static int addressLength(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length] != 0) {
                return length + 1;
            }
        }
        return 0;
    }

    private static byte[] parseAddress(byte[] bArr, int i2) throws WireParseException {
        if (bArr.length > i2) {
            throw new WireParseException("invalid address length");
        }
        if (bArr.length == i2) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validatePrefixLength(int i2, int i3) {
        if (i3 < 0 || i3 >= 256) {
            return false;
        }
        return (i2 != 1 || i3 <= 32) && (i2 != 2 || i3 <= 128);
    }

    public List<Element> getElements() {
        return this.elements;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException, NumberFormatException {
        this.elements = new ArrayList(1);
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (!token.isString()) {
                tokenizer.unget();
                return;
            }
            String strValue = token.value();
            boolean zStartsWith = strValue.startsWith("!");
            int iIndexOf = strValue.indexOf(58, zStartsWith ? 1 : 0);
            if (iIndexOf < 0) {
                throw tokenizer.exception("invalid address prefix element");
            }
            int iIndexOf2 = strValue.indexOf(47, iIndexOf);
            if (iIndexOf2 < 0) {
                throw tokenizer.exception("invalid address prefix element");
            }
            String strSubstring = strValue.substring(zStartsWith ? 1 : 0, iIndexOf);
            String strSubstring2 = strValue.substring(iIndexOf + 1, iIndexOf2);
            String strSubstring3 = strValue.substring(iIndexOf2 + 1);
            try {
                int i2 = Integer.parseInt(strSubstring);
                if (i2 != 1 && i2 != 2) {
                    throw tokenizer.exception("unknown family");
                }
                try {
                    int i3 = Integer.parseInt(strSubstring3);
                    if (!validatePrefixLength(i2, i3)) {
                        throw tokenizer.exception("invalid prefix length");
                    }
                    byte[] byteArray = Address.toByteArray(strSubstring2, i2);
                    if (byteArray == null) {
                        throw tokenizer.exception("invalid IP address " + strSubstring2);
                    }
                    this.elements.add(new Element(zStartsWith, InetAddress.getByAddress(byteArray), i3));
                } catch (NumberFormatException unused) {
                    throw tokenizer.exception("invalid prefix length");
                }
            } catch (NumberFormatException unused2) {
                throw tokenizer.exception("invalid family");
            }
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.elements = new ArrayList(1);
        while (dNSInput.remaining() != 0) {
            int u16 = dNSInput.readU16();
            int u8 = dNSInput.readU8();
            int u82 = dNSInput.readU8();
            boolean z = (u82 & 128) != 0;
            byte[] byteArray = dNSInput.readByteArray(u82 & (-129));
            if (!validatePrefixLength(u16, u8)) {
                throw new WireParseException("invalid prefix length");
            }
            this.elements.add((u16 == 1 || u16 == 2) ? new Element(z, InetAddress.getByAddress(parseAddress(byteArray, Address.addressLength(u16))), u8) : new Element(u16, z, byteArray, u8));
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Element> it = this.elements.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(StringUtils.SPACE);
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        byte[] address;
        int iAddressLength;
        for (Element element : this.elements) {
            int i2 = element.family;
            if (i2 == 1 || i2 == 2) {
                address = ((InetAddress) element.address).getAddress();
                iAddressLength = addressLength(address);
            } else {
                address = (byte[]) element.address;
                iAddressLength = address.length;
            }
            int i3 = element.negative ? iAddressLength | 128 : iAddressLength;
            dNSOutput.writeU16(element.family);
            dNSOutput.writeU8(element.prefixLength);
            dNSOutput.writeU8(i3);
            dNSOutput.writeByteArray(address, 0, iAddressLength);
        }
    }

    public APLRecord(Name name, int i2, long j2, List<Element> list) {
        super(name, 42, i2, j2);
        this.elements = new ArrayList(list.size());
        for (Element element : list) {
            int i3 = element.family;
            if (i3 != 1 && i3 != 2) {
                throw new IllegalArgumentException("unknown family");
            }
            this.elements.add(element);
        }
    }
}
