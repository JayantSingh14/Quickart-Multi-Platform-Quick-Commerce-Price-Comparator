package org.xbill.DNS.tools;

import org.xbill.DNS.Message;
import org.xbill.DNS.Name;

/* loaded from: classes5.dex */
public class dig {
    static int dclass = 1;
    static Name name = null;
    static int type = 1;

    public static void doQuery(Message message, long j2) {
        System.out.println("; dnsjava dig");
        System.out.println(message);
        System.out.println(";; Query time: " + j2 + " ms");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void main(java.lang.String[] r10) throws java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.tools.dig.main(java.lang.String[]):void");
    }

    public static void usage() {
        System.out.println("; dnsjava dig");
        System.out.println("Usage: dig [@server] name [<type>] [<class>] [options]");
        System.exit(0);
    }
}
