package org.xbill.DNS;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes5.dex */
public final class ReverseMap {
    private static final Name inaddr4 = Name.fromConstantString("in-addr.arpa.");
    private static final Name inaddr6 = Name.fromConstantString("ip6.arpa.");

    private ReverseMap() {
    }

    public static Name fromAddress(byte[] bArr) {
        if (bArr.length != 4 && bArr.length != 16) {
            throw new IllegalArgumentException("array must contain 4 or 16 elements");
        }
        StringBuilder sb = new StringBuilder();
        if (bArr.length == 4) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                sb.append(bArr[length] & 255);
                if (length > 0) {
                    sb.append(CLConstants.DOT_SALT_DELIMETER);
                }
            }
        } else {
            for (int length2 = bArr.length - 1; length2 >= 0; length2--) {
                int i2 = bArr[length2];
                int[] iArr = {(i2 & 255) >> 4, i2 & 15};
                for (int i3 = 1; i3 >= 0; i3--) {
                    sb.append(Integer.toHexString(iArr[i3]));
                    if (length2 > 0 || i3 > 0) {
                        sb.append(CLConstants.DOT_SALT_DELIMETER);
                    }
                }
            }
        }
        try {
            return bArr.length == 4 ? Name.fromString(sb.toString(), inaddr4) : Name.fromString(sb.toString(), inaddr6);
        } catch (TextParseException unused) {
            throw new IllegalStateException("name cannot be invalid");
        }
    }

    public static InetAddress fromName(String str) throws TextParseException, UnknownHostException {
        return fromName(Name.fromString(str));
    }

    public static InetAddress fromName(Name name) throws UnknownHostException {
        if (name.labels() <= 3) {
            throw new UnknownHostException("Not an arpa address: " + name.toString());
        }
        Name name2 = inaddr4;
        if (name.subdomain(name2)) {
            Name nameRelativize = name.relativize(name2);
            if (nameRelativize.labels() > 4) {
                throw new UnknownHostException("Invalid IPv4 arpa address: " + name.toString());
            }
            byte[] bArr = new byte[4];
            for (int i2 = 0; i2 < nameRelativize.labels(); i2++) {
                try {
                    bArr[(nameRelativize.labels() - i2) - 1] = (byte) Integer.parseInt(nameRelativize.getLabelString(i2));
                } catch (NumberFormatException unused) {
                    throw new UnknownHostException("Invalid IPv4 arpa address: " + name.toString());
                }
            }
            return InetAddress.getByAddress(bArr);
        }
        Name name3 = inaddr6;
        if (!name.subdomain(name3)) {
            throw new UnknownHostException("Not an arpa address: " + name.toString());
        }
        Name nameRelativize2 = name.relativize(name3);
        if (nameRelativize2.labels() > 32) {
            throw new UnknownHostException("Invalid IPv6 arpa address: " + name.toString());
        }
        byte[] bArr2 = new byte[16];
        for (int i3 = 0; i3 < nameRelativize2.labels(); i3++) {
            try {
                int iLabels = ((nameRelativize2.labels() - i3) - 1) / 2;
                bArr2[iLabels] = (byte) (bArr2[iLabels] | (Byte.parseByte(nameRelativize2.getLabelString(i3), 16) << ((nameRelativize2.labels() - i3) % 2 == 0 ? (byte) 0 : (byte) 4)));
            } catch (NumberFormatException unused2) {
                throw new UnknownHostException("Invalid IPv6 arpa address: " + name.toString());
            }
        }
        return InetAddress.getByAddress(bArr2);
    }

    public static Name fromAddress(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 >= 0 && i3 <= 255) {
                bArr[i2] = (byte) i3;
            } else {
                throw new IllegalArgumentException("array must contain values between 0 and 255");
            }
        }
        return fromAddress(bArr);
    }

    public static Name fromAddress(InetAddress inetAddress) {
        return fromAddress(inetAddress.getAddress());
    }

    public static Name fromAddress(String str, int i2) throws UnknownHostException {
        byte[] byteArray = Address.toByteArray(str, i2);
        if (byteArray != null) {
            return fromAddress(byteArray);
        }
        throw new UnknownHostException(android.support.v4.media.b.C("Invalid IP address: ", str));
    }

    public static Name fromAddress(String str) throws UnknownHostException {
        byte[] byteArray = Address.toByteArray(str, 1);
        if (byteArray == null) {
            byteArray = Address.toByteArray(str, 2);
        }
        if (byteArray != null) {
            return fromAddress(byteArray);
        }
        throw new UnknownHostException(android.support.v4.media.b.C("Invalid IP address: ", str));
    }
}
