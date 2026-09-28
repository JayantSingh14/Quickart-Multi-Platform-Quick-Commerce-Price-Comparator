package org.xbill.DNS.tools;

import java.util.Iterator;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.ZoneTransferIn;

/* loaded from: classes5.dex */
public class xfrin {
    public static void main(String[] strArr) throws Exception {
        String strRdataToString = null;
        int i2 = -1;
        TSIG tsig = null;
        int i3 = 53;
        int i4 = 0;
        boolean z = false;
        while (i4 < strArr.length) {
            if (strArr[i4].equals("-i")) {
                i4++;
                i2 = Integer.parseInt(strArr[i4]);
                if (i2 < 0) {
                    usage("invalid serial number");
                }
            } else if (strArr[i4].equals("-k")) {
                i4++;
                String str = strArr[i4];
                int iIndexOf = str.indexOf(47);
                if (iIndexOf < 0) {
                    usage("invalid key");
                }
                tsig = new TSIG(TSIG.HMAC_MD5, str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            } else if (strArr[i4].equals("-s")) {
                i4++;
                strRdataToString = strArr[i4];
            } else if (strArr[i4].equals("-p")) {
                i4++;
                int i5 = Integer.parseInt(strArr[i4]);
                if (i5 < 0 || i5 > 65535) {
                    usage("invalid port");
                }
                i3 = i5;
            } else if (strArr[i4].equals("-f")) {
                z = true;
            } else if (!strArr[i4].startsWith("-")) {
                break;
            } else {
                usage("invalid option");
            }
            i4++;
        }
        if (i4 >= strArr.length) {
            usage("no zone name specified");
        }
        Name nameFromString = Name.fromString(strArr[i4]);
        if (strRdataToString == null) {
            Lookup lookup = new Lookup(nameFromString, 2);
            Record[] recordArrRun = lookup.run();
            if (recordArrRun == null) {
                System.out.println("failed to look up NS record: " + lookup.getErrorString());
                System.exit(1);
            }
            strRdataToString = recordArrRun[0].rdataToString();
            System.out.println("sending to server '" + strRdataToString + "'");
        }
        String str2 = strRdataToString;
        ZoneTransferIn zoneTransferInNewIXFR = i2 >= 0 ? ZoneTransferIn.newIXFR(nameFromString, i2, z, str2, i3, tsig) : ZoneTransferIn.newAXFR(nameFromString, str2, i3, tsig);
        zoneTransferInNewIXFR.run();
        if (zoneTransferInNewIXFR.isAXFR()) {
            if (i2 >= 0) {
                System.out.println("AXFR-like IXFR response");
            } else {
                System.out.println("AXFR response");
            }
            Iterator<Record> it = zoneTransferInNewIXFR.getAXFR().iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            return;
        }
        if (!zoneTransferInNewIXFR.isIXFR()) {
            if (zoneTransferInNewIXFR.isCurrent()) {
                System.out.println("up to date");
                return;
            }
            return;
        }
        System.out.println("IXFR response");
        for (ZoneTransferIn.Delta delta : zoneTransferInNewIXFR.getIXFR()) {
            System.out.println("delta from " + delta.start + " to " + delta.end);
            System.out.println("deletes");
            Iterator<Record> it2 = delta.deletes.iterator();
            while (it2.hasNext()) {
                System.out.println(it2.next());
            }
            System.out.println("adds");
            Iterator<Record> it3 = delta.adds.iterator();
            while (it3.hasNext()) {
                System.out.println(it3.next());
            }
        }
    }

    private static void usage(String str) {
        System.out.println("Error: " + str);
        System.out.println("usage: xfrin [-i serial] [-k keyname/secret] [-s server] [-p port] [-f] zone");
        System.exit(1);
    }
}
