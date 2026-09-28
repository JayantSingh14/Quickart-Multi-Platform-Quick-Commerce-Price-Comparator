package org.xbill.DNS;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import lombok.Generated;
import org.apache.commons.lang3.ClassUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes5.dex */
public class Name implements Comparable<Name>, Serializable {
    private static final int LABEL_COMPRESSION = 192;
    private static final int LABEL_MASK = 192;
    private static final int LABEL_NORMAL = 0;
    private static final int MAXLABEL = 63;
    private static final int MAXNAME = 255;
    private static final int MAXOFFSETS = 9;
    public static final Name empty;
    public static final Name root;
    private static final long serialVersionUID = -6036624806201621219L;
    private static final Name wild;
    private transient int hashcode;
    private int labels;
    private byte[] name;
    private long offsets;

    @Generated
    private static final Logger log = LoggerFactory.b(Name.class);
    private static final byte[] emptyLabel = {0};
    private static final byte[] wildLabel = {1, 42};
    private static final byte[] lowercase = new byte[256];

    static {
        int i2 = 0;
        while (true) {
            byte[] bArr = lowercase;
            if (i2 >= bArr.length) {
                Name name = new Name();
                root = name;
                name.name = emptyLabel;
                name.labels = 1;
                Name name2 = new Name();
                empty = name2;
                name2.name = new byte[0];
                Name name3 = new Name();
                wild = name3;
                name3.name = wildLabel;
                name3.labels = 1;
                return;
            }
            if (i2 < 65 || i2 > 90) {
                bArr[i2] = (byte) i2;
            } else {
                bArr[i2] = (byte) (i2 + 32);
            }
            i2++;
        }
    }

    private Name() {
    }

    private void append(byte[] bArr, int i2, int i3) throws NameTooLongException {
        byte[] bArr2 = this.name;
        int length = bArr2 == null ? 0 : bArr2.length;
        int i4 = i2;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = bArr[i4] + 1;
            i4 += i7;
            i5 += i7;
        }
        int i8 = length + i5;
        if (i8 > 255) {
            throw new NameTooLongException();
        }
        byte[] bArr3 = this.name;
        byte[] bArrCopyOf = bArr3 != null ? Arrays.copyOf(bArr3, i8) : new byte[i8];
        System.arraycopy(bArr, i2, bArrCopyOf, length, i5);
        this.name = bArrCopyOf;
        for (int i9 = 0; i9 < i3 && i9 < 9; i9++) {
            setOffset(this.labels + i9, length);
            length += bArrCopyOf[length] + 1;
        }
        this.labels += i3;
    }

    private void appendFromString(String str, char[] cArr, int i2) throws TextParseException {
        try {
            append(cArr, i2);
        } catch (NameTooLongException e2) {
            throw new TextParseException(str, "Name too long", e2);
        }
    }

    private String byteString(byte[] bArr, int i2) {
        StringBuilder sb = new StringBuilder();
        int i3 = i2 + 1;
        int i4 = bArr[i2];
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            int i6 = bArr[i5] & 255;
            if (i6 <= 32 || i6 >= 127) {
                sb.append('\\');
                if (i6 < 10) {
                    sb.append("00");
                } else if (i6 < 100) {
                    sb.append('0');
                }
                sb.append(i6);
            } else if (i6 == 34 || i6 == 40 || i6 == 41 || i6 == 46 || i6 == 59 || i6 == 92 || i6 == 64 || i6 == 36) {
                sb.append('\\');
                sb.append((char) i6);
            } else {
                sb.append((char) i6);
            }
        }
        return sb.toString();
    }

    public static Name concatenate(Name name, Name name2) throws NameTooLongException {
        if (name.isAbsolute()) {
            return name;
        }
        Name name3 = new Name();
        name3.append(name.name, 0, name.labels);
        name3.append(name2.name, 0, name2.labels);
        return name3;
    }

    private static void copy(Name name, Name name2) {
        name2.name = name.name;
        name2.offsets = name.offsets;
        name2.labels = name.labels;
    }

    private boolean equals(byte[] bArr, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < this.labels; i4++) {
            byte b2 = this.name[i3];
            if (b2 != bArr[i2]) {
                return false;
            }
            i3++;
            i2++;
            int i5 = 0;
            while (i5 < b2) {
                byte[] bArr2 = lowercase;
                int i6 = i3 + 1;
                int i7 = i2 + 1;
                if (bArr2[this.name[i3] & 255] != bArr2[bArr[i2] & 255]) {
                    return false;
                }
                i5++;
                i2 = i7;
                i3 = i6;
            }
        }
        return true;
    }

    public static Name fromConstantString(String str) {
        try {
            return fromString(str, null);
        } catch (TextParseException unused) {
            throw new IllegalArgumentException(android.support.v4.media.b.D("Invalid name '", str, "'"));
        }
    }

    public static Name fromString(String str, Name name) throws TextParseException {
        return str.equals("@") ? name != null ? name : empty : str.equals(CLConstants.DOT_SALT_DELIMETER) ? root : new Name(str, name);
    }

    private int offset(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 1 || i2 >= this.labels) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i2 < 9) {
            return ((int) (this.offsets >>> ((i2 - 1) * 8))) & 255;
        }
        int i3 = ((int) (this.offsets >>> 56)) & 255;
        for (int i4 = 8; i4 < i2; i4++) {
            i3 += this.name[i3] + 1;
        }
        return i3;
    }

    private int prepareAppend(int i2) throws NameTooLongException {
        byte[] bArr = this.name;
        int length = bArr == null ? 0 : bArr.length;
        int i3 = length + 1;
        int i4 = i3 + i2;
        if (i4 > 255) {
            throw new NameTooLongException();
        }
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, i4) : new byte[i4];
        bArrCopyOf[length] = (byte) i2;
        this.name = bArrCopyOf;
        setOffset(this.labels, length);
        this.labels++;
        return i3;
    }

    private void setOffset(int i2, int i3) {
        if (i2 == 0 || i2 >= 9) {
            return;
        }
        int i4 = (i2 - 1) * 8;
        this.offsets = (i3 << i4) | (this.offsets & (~(255 << i4)));
    }

    public Name canonicalize() {
        int i2 = 0;
        for (byte b2 : this.name) {
            if (lowercase[b2 & 255] != b2) {
                Name name = new Name();
                name.offsets = this.offsets;
                name.labels = this.labels;
                name.name = new byte[length()];
                while (true) {
                    byte[] bArr = name.name;
                    if (i2 >= bArr.length) {
                        return name;
                    }
                    bArr[i2] = lowercase[this.name[i2] & 255];
                    i2++;
                }
            }
        }
        return this;
    }

    public Name fromDNAME(DNAMERecord dNAMERecord) throws NameTooLongException {
        Name name = dNAMERecord.getName();
        Name target = dNAMERecord.getTarget();
        if (!subdomain(name)) {
            return null;
        }
        int i2 = this.labels - name.labels;
        int length = length() - name.length();
        int i3 = target.labels;
        short length2 = target.length();
        int i4 = length + length2;
        if (i4 > 255) {
            throw new NameTooLongException();
        }
        Name name2 = new Name();
        int i5 = i2 + i3;
        name2.labels = i5;
        byte[] bArrCopyOf = Arrays.copyOf(this.name, i4);
        name2.name = bArrCopyOf;
        System.arraycopy(target.name, 0, bArrCopyOf, length, length2);
        int i6 = 0;
        for (int i7 = 0; i7 < 9 && i7 < i5; i7++) {
            name2.setOffset(i7, i6);
            i6 += name2.name[i6] + 1;
        }
        return name2;
    }

    public byte[] getLabel(int i2) {
        int iOffset = offset(i2);
        byte[] bArr = this.name;
        return Arrays.copyOfRange(bArr, iOffset, ((byte) (bArr[iOffset] + 1)) + iOffset);
    }

    public String getLabelString(int i2) {
        return byteString(this.name, offset(i2));
    }

    public int hashCode() {
        int i2 = this.hashcode;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 0;
        int iOffset = offset(0);
        while (true) {
            byte[] bArr = this.name;
            if (iOffset >= bArr.length) {
                this.hashcode = i3;
                return i3;
            }
            i3 += (i3 << 3) + (lowercase[bArr[iOffset] & 255] & 255);
            iOffset++;
        }
    }

    public boolean isAbsolute() {
        int i2 = this.labels;
        return i2 != 0 && this.name[offset(i2 - 1)] == 0;
    }

    public boolean isWild() {
        if (this.labels == 0) {
            return false;
        }
        byte[] bArr = this.name;
        return bArr[0] == 1 && bArr[1] == 42;
    }

    public int labels() {
        return this.labels;
    }

    public short length() {
        if (this.labels == 0) {
            return (short) 0;
        }
        return (short) this.name.length;
    }

    public Name relativize(Name name) {
        if (name == null || !subdomain(name)) {
            return this;
        }
        Name name2 = new Name();
        int length = length() - name.length();
        name2.labels = this.labels - name.labels;
        name2.offsets = this.offsets;
        byte[] bArr = new byte[length];
        name2.name = bArr;
        System.arraycopy(this.name, 0, bArr, 0, length);
        return name2;
    }

    public boolean subdomain(Name name) {
        int i2 = name.labels;
        int i3 = this.labels;
        if (i2 > i3) {
            return false;
        }
        return i2 == i3 ? equals(name) : name.equals(this.name, offset(i3 - i2));
    }

    public String toString(boolean z) {
        int i2 = this.labels;
        if (i2 == 0) {
            return "@";
        }
        int i3 = 0;
        if (i2 == 1 && this.name[0] == 0) {
            return CLConstants.DOT_SALT_DELIMETER;
        }
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (true) {
            if (i3 >= this.labels) {
                break;
            }
            byte b2 = this.name[i4];
            if (b2 != 0) {
                if (i3 > 0) {
                    sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                }
                sb.append(byteString(this.name, i4));
                i4 += b2 + 1;
                i3++;
            } else if (!z) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
        }
        return sb.toString();
    }

    public void toWire(DNSOutput dNSOutput, Compression compression) {
        if (!isAbsolute()) {
            throw new IllegalArgumentException("toWire() called on non-absolute name");
        }
        int i2 = 0;
        while (i2 < this.labels - 1) {
            Name name = i2 == 0 ? this : new Name(this, i2);
            int i3 = compression != null ? compression.get(name) : -1;
            if (i3 >= 0) {
                dNSOutput.writeU16(49152 | i3);
                return;
            }
            if (compression != null) {
                compression.add(dNSOutput.current(), name);
            }
            int iOffset = offset(i2);
            byte[] bArr = this.name;
            dNSOutput.writeByteArray(bArr, iOffset, bArr[iOffset] + 1);
            i2++;
        }
        dNSOutput.writeU8(0);
    }

    public void toWireCanonical(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(toWireCanonical());
    }

    public Name wild(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("must replace 1 or more labels");
        }
        try {
            Name name = new Name();
            copy(wild, name);
            name.append(this.name, offset(i2), this.labels - i2);
            return name;
        } catch (NameTooLongException unused) {
            throw new IllegalStateException("Name.wild: concatenate failed");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Name(java.lang.String r19, org.xbill.DNS.Name r20) throws org.xbill.DNS.TextParseException {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.Name.<init>(java.lang.String, org.xbill.DNS.Name):void");
    }

    @Override // java.lang.Comparable
    public int compareTo(Name name) {
        if (this == name) {
            return 0;
        }
        int i2 = name.labels;
        int iMin = Math.min(this.labels, i2);
        for (int i3 = 1; i3 <= iMin; i3++) {
            int iOffset = offset(this.labels - i3);
            int iOffset2 = name.offset(i2 - i3);
            byte b2 = this.name[iOffset];
            byte b3 = name.name[iOffset2];
            for (int i4 = 0; i4 < b2 && i4 < b3; i4++) {
                byte[] bArr = lowercase;
                int i5 = (bArr[this.name[(i4 + iOffset) + 1] & 255] & 255) - (bArr[name.name[(i4 + iOffset2) + 1] & 255] & 255);
                if (i5 != 0) {
                    return i5;
                }
            }
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return this.labels - i2;
    }

    private void appendFromString(String str, byte[] bArr, int i2) throws TextParseException {
        try {
            append(bArr, 0, i2);
        } catch (NameTooLongException unused) {
            throw new TextParseException(str, "Name too long");
        }
    }

    public byte[] toWireCanonical() {
        if (this.labels == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.name.length];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.labels; i4++) {
            byte b2 = this.name[i2];
            i2++;
            bArr[i3] = b2;
            i3++;
            int i5 = 0;
            while (i5 < b2) {
                bArr[i3] = lowercase[this.name[i2] & 255];
                i5++;
                i3++;
                i2++;
            }
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        if (name.labels == this.labels && name.hashCode() == hashCode()) {
            return equals(name.name, 0);
        }
        return false;
    }

    public static Name fromString(String str) throws TextParseException {
        return fromString(str, null);
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, null);
        return dNSOutput.toByteArray();
    }

    private void append(char[] cArr, int i2) throws NameTooLongException {
        int iPrepareAppend = prepareAppend(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            this.name[iPrepareAppend + i3] = (byte) cArr[i3];
        }
    }

    public String toString() {
        return toString(false);
    }

    public void toWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        if (z) {
            toWireCanonical(dNSOutput);
        } else {
            toWire(dNSOutput, compression);
        }
    }

    public Name(String str) throws TextParseException {
        this(str, (Name) null);
    }

    public Name(DNSInput dNSInput) throws WireParseException {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int u8 = dNSInput.readU8();
            int i2 = u8 & 192;
            if (i2 != 0) {
                if (i2 == 192) {
                    int u82 = dNSInput.readU8() + ((u8 & (-193)) << 8);
                    Logger logger = log;
                    logger.d("currently {}, pointer to {}", Integer.valueOf(dNSInput.current()), Integer.valueOf(u82));
                    if (u82 < dNSInput.current() - 2) {
                        if (!z2) {
                            dNSInput.save();
                            z2 = true;
                        }
                        dNSInput.jump(u82);
                        logger.d("current name '{}', seeking to {}", this, Integer.valueOf(u82));
                    } else {
                        throw new WireParseException("bad compression");
                    }
                } else {
                    throw new WireParseException("bad label type");
                }
            } else if (u8 == 0) {
                append(emptyLabel, 0, 1);
                z = true;
            } else {
                bArr[0] = (byte) u8;
                dNSInput.readByteArray(bArr, 1, u8);
                append(bArr, 0, 1);
            }
        }
        if (z2) {
            dNSInput.restore();
        }
    }

    public Name(byte[] bArr) throws IOException {
        this(new DNSInput(bArr));
    }

    public Name(Name name, int i2) {
        int i3 = name.labels;
        if (i2 > i3) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        if (i2 == i3) {
            copy(empty, this);
            return;
        }
        this.labels = i3 - i2;
        this.name = Arrays.copyOfRange(name.name, name.offset(i2), name.name.length);
        int iOffset = name.offset(i2);
        for (int i4 = 1; i4 < 9 && i4 < this.labels; i4++) {
            setOffset(i4, name.offset(i4 + i2) - iOffset);
        }
    }
}
