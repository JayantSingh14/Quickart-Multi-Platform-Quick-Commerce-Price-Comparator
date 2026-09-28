package org.xbill.DNS;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import lombok.Generated;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes5.dex */
public final class Address {
    public static final int IPv4 = 1;
    public static final int IPv6 = 2;

    @Generated
    private Address() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    private static InetAddress addrFromRecord(String str, Record record) throws UnknownHostException {
        return InetAddress.getByAddress(str, (record instanceof ARecord ? ((ARecord) record).getAddress() : ((AAAARecord) record).getAddress()).getAddress());
    }

    public static int addressLength(int i2) {
        if (i2 == 1) {
            return 4;
        }
        if (i2 == 2) {
            return 16;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static int familyOf(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return 1;
        }
        if (inetAddress instanceof Inet6Address) {
            return 2;
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static InetAddress[] getAllByName(String str) throws UnknownHostException {
        try {
            return new InetAddress[]{getByAddress(str)};
        } catch (UnknownHostException unused) {
            Record[] recordArrLookupHostName = lookupHostName(str, true);
            InetAddress[] inetAddressArr = new InetAddress[recordArrLookupHostName.length];
            for (int i2 = 0; i2 < recordArrLookupHostName.length; i2++) {
                inetAddressArr[i2] = addrFromRecord(str, recordArrLookupHostName[i2]);
            }
            return inetAddressArr;
        }
    }

    public static InetAddress getByAddress(String str) throws UnknownHostException {
        byte[] byteArray = toByteArray(str, 1);
        if (byteArray != null) {
            return InetAddress.getByAddress(str, byteArray);
        }
        byte[] byteArray2 = toByteArray(str, 2);
        if (byteArray2 != null) {
            return InetAddress.getByAddress(str, byteArray2);
        }
        throw new UnknownHostException(android.support.v4.media.b.C("Invalid address: ", str));
    }

    public static InetAddress getByName(String str) throws UnknownHostException {
        try {
            return getByAddress(str);
        } catch (UnknownHostException unused) {
            return addrFromRecord(str, lookupHostName(str, false)[0]);
        }
    }

    public static String getHostName(InetAddress inetAddress) throws UnknownHostException {
        Name nameFromAddress = ReverseMap.fromAddress(inetAddress);
        Record[] recordArrRun = new Lookup(nameFromAddress, 12).run();
        if (recordArrRun != null) {
            return ((PTRRecord) recordArrRun[0]).getTarget().toString();
        }
        throw new UnknownHostException("unknown address: " + nameFromAddress);
    }

    public static boolean isDottedQuad(String str) {
        return toByteArray(str, 1) != null;
    }

    private static Record[] lookupHostName(String str, boolean z) throws UnknownHostException {
        Record[] recordArrRun;
        Record[] recordArrRun2;
        try {
            Lookup lookup = new Lookup(str, 1);
            Record[] recordArrRun3 = lookup.run();
            if (recordArrRun3 != null) {
                if (z && (recordArrRun = new Lookup(str, 28).run()) != null) {
                    Record[] recordArr = new Record[recordArrRun3.length + recordArrRun.length];
                    System.arraycopy(recordArrRun3, 0, recordArr, 0, recordArrRun3.length);
                    System.arraycopy(recordArrRun, 0, recordArr, recordArrRun3.length, recordArrRun.length);
                    return recordArr;
                }
                return recordArrRun3;
            }
            if (lookup.getResult() == 4 && (recordArrRun2 = new Lookup(str, 28).run()) != null) {
                return recordArrRun2;
            }
            throw new UnknownHostException("<" + str + "> could not be resolved: " + lookup.getErrorString());
        } catch (TextParseException e2) {
            StringBuilder sbY = android.support.v4.media.b.y("<", str, "> is invalid: ");
            sbY.append(e2.getMessage());
            throw new UnknownHostException(sbY.toString());
        }
    }

    public static int[] toArray(String str, int i2) {
        byte[] byteArray = toByteArray(str, i2);
        if (byteArray == null) {
            return null;
        }
        int[] iArr = new int[byteArray.length];
        for (int i3 = 0; i3 < byteArray.length; i3++) {
            iArr[i3] = byteArray[i3] & 255;
        }
        return iArr;
    }

    public static byte[] toByteArray(String str, int i2) {
        if (i2 == 1) {
            return IPAddressUtils.parseV4(str);
        }
        if (i2 == 2) {
            return IPAddressUtils.parseV6(str);
        }
        throw new IllegalArgumentException("unknown address family");
    }

    public static String toDottedQuad(byte[] bArr) {
        return (bArr[0] & 255) + CLConstants.DOT_SALT_DELIMETER + (bArr[1] & 255) + CLConstants.DOT_SALT_DELIMETER + (bArr[2] & 255) + CLConstants.DOT_SALT_DELIMETER + (bArr[3] & 255);
    }

    public static InetAddress truncate(InetAddress inetAddress, int i2) {
        int i3;
        int iAddressLength = addressLength(familyOf(inetAddress)) * 8;
        if (i2 < 0 || i2 > iAddressLength) {
            throw new IllegalArgumentException("invalid mask length");
        }
        if (i2 == iAddressLength) {
            return inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i4 = i2 / 8;
        int i5 = i4 + 1;
        while (true) {
            if (i5 >= address.length) {
                break;
            }
            address[i5] = 0;
            i5++;
        }
        int i6 = 0;
        for (i3 = 0; i3 < i2 % 8; i3++) {
            i6 |= 1 << (7 - i3);
        }
        address[i4] = (byte) (address[i4] & ((byte) i6));
        try {
            return InetAddress.getByAddress(address);
        } catch (UnknownHostException unused) {
            throw new IllegalArgumentException("invalid address");
        }
    }

    public static String toDottedQuad(int[] iArr) {
        return iArr[0] + CLConstants.DOT_SALT_DELIMETER + iArr[1] + CLConstants.DOT_SALT_DELIMETER + iArr[2] + CLConstants.DOT_SALT_DELIMETER + iArr[3];
    }

    public static int[] toArray(String str) {
        return toArray(str, 1);
    }

    public static InetAddress getByAddress(String str, int i2) throws UnknownHostException {
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("unknown address family");
        }
        byte[] byteArray = toByteArray(str, i2);
        if (byteArray != null) {
            return InetAddress.getByAddress(str, byteArray);
        }
        throw new UnknownHostException(android.support.v4.media.b.C("Invalid address: ", str));
    }
}
