package org.xbill.DNS;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class Header implements Cloneable {
    public static final int LENGTH = 12;
    private static final Random random = new SecureRandom();
    private int[] counts;
    private int flags;
    private int id;

    public Header(int i2) {
        if (!Utils.isUInt16(i2)) {
            throw new IllegalArgumentException(android.support.v4.media.b.g(i2, "DNS message ID ", " is out of range"));
        }
        this.counts = new int[4];
        this.flags = 0;
        this.id = i2;
    }

    private static void checkFlag(int i2) {
        if (!validFlag(i2)) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "invalid flag bit "));
        }
    }

    public static boolean getFlag(int i2, int i3) {
        checkFlag(i3);
        return (i2 & (1 << (15 - i3))) != 0;
    }

    public static int setFlag(int i2, int i3, boolean z) {
        checkFlag(i3);
        return z ? i2 | (1 << (15 - i3)) : i2 & (~(1 << (15 - i3)));
    }

    private static boolean validFlag(int i2) {
        return i2 >= 0 && i2 <= 15 && Flags.isFlag(i2);
    }

    public void decCount(int i2) {
        int[] iArr = this.counts;
        int i3 = iArr[i2];
        if (i3 == 0) {
            throw new IllegalStateException("DNS section count cannot be decremented");
        }
        iArr[i2] = i3 - 1;
    }

    public int getCount(int i2) {
        return this.counts[i2];
    }

    public boolean[] getFlags() {
        boolean[] zArr = new boolean[16];
        for (int i2 = 0; i2 < 16; i2++) {
            if (validFlag(i2)) {
                zArr[i2] = getFlag(i2);
            }
        }
        return zArr;
    }

    public int getFlagsByte() {
        return this.flags;
    }

    public int getID() {
        return this.id;
    }

    public int getOpcode() {
        return (this.flags >> 11) & 15;
    }

    public int getRcode() {
        return this.flags & 15;
    }

    public void incCount(int i2) {
        int[] iArr = this.counts;
        int i3 = iArr[i2];
        if (i3 == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i2] = i3 + 1;
    }

    public String printFlags() {
        StringBuilder sb = new StringBuilder();
        printFlags(sb);
        return sb.toString();
    }

    public void setCount(int i2, int i3) {
        if (!Utils.isUInt16(i3)) {
            throw new IllegalArgumentException(android.support.v4.media.b.g(i3, "DNS section count ", " is out of range"));
        }
        this.counts[i2] = i3;
    }

    public void setID(int i2) {
        if (!Utils.isUInt16(i2)) {
            throw new IllegalArgumentException(android.support.v4.media.b.g(i2, "DNS message ID ", " is out of range"));
        }
        this.id = i2;
    }

    public void setOpcode(int i2) {
        if (i2 < 0 || i2 > 15) {
            throw new IllegalArgumentException(android.support.v4.media.b.g(i2, "DNS Opcode ", "is out of range"));
        }
        this.flags = (i2 << 11) | (this.flags & 34815);
    }

    public void setRcode(int i2) {
        if (i2 < 0 || i2 > 15) {
            throw new IllegalArgumentException(android.support.v4.media.b.g(i2, "DNS Rcode ", " is out of range"));
        }
        this.flags = i2 | (this.flags & (-16));
    }

    public String toString() {
        return toStringWithRcode(getRcode());
    }

    public String toStringWithRcode(int i2) {
        StringBuilder sbW = android.support.v4.media.b.w(";; ->>HEADER<<- opcode: ");
        sbW.append(Opcode.string(getOpcode()));
        sbW.append(", status: ");
        sbW.append(Rcode.string(i2));
        sbW.append(", id: ");
        sbW.append(getID());
        sbW.append("\n;; flags: ");
        printFlags(sbW);
        sbW.append("; ");
        for (int i3 = 0; i3 < 4; i3++) {
            sbW.append(Section.string(i3));
            sbW.append(": ");
            sbW.append(getCount(i3));
            sbW.append(StringUtils.SPACE);
        }
        return sbW.toString();
    }

    public void toWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(getID());
        dNSOutput.writeU16(this.flags);
        for (int i2 : this.counts) {
            dNSOutput.writeU16(i2);
        }
    }

    public void unsetFlag(int i2) {
        checkFlag(i2);
        this.flags = setFlag(this.flags, i2, false);
    }

    public Header clone() {
        Header header = (Header) super.clone();
        header.id = this.id;
        header.flags = this.flags;
        int[] iArr = new int[header.counts.length];
        header.counts = iArr;
        int[] iArr2 = this.counts;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        return header;
    }

    public boolean getFlag(int i2) {
        return getFlag(this.flags, i2);
    }

    public void setFlag(int i2) {
        checkFlag(i2);
        this.flags = setFlag(this.flags, i2, true);
    }

    private void printFlags(StringBuilder sb) {
        for (int i2 = 0; i2 < 16; i2++) {
            if (validFlag(i2) && getFlag(i2)) {
                sb.append(Flags.string(i2));
                sb.append(StringUtils.SPACE);
            }
        }
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    public Header() {
        this(random.nextInt(Message.MAXLENGTH));
    }

    public Header(DNSInput dNSInput) throws IOException {
        this(dNSInput.readU16());
        this.flags = dNSInput.readU16();
        int i2 = 0;
        while (true) {
            int[] iArr = this.counts;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = dNSInput.readU16();
            i2++;
        }
    }

    public Header(byte[] bArr) throws IOException {
        this(new DNSInput(bArr));
    }
}
