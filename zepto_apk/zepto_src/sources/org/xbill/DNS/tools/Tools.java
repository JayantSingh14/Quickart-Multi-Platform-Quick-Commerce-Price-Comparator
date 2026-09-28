package org.xbill.DNS.tools;

/* loaded from: classes5.dex */
public class Tools {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void main(java.lang.String[] r5) throws java.lang.Exception {
        /*
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L84
            int r2 = r5.length
            if (r2 != 0) goto L9
            goto L84
        L9:
            r2 = r5[r0]
            int r3 = r5.length
            int r3 = r3 - r1
            java.lang.String[] r3 = new java.lang.String[r3]
            int r4 = r5.length
            int r4 = r4 - r1
            java.lang.System.arraycopy(r5, r1, r3, r0, r4)
            r2.getClass()
            r5 = -1
            int r4 = r2.hashCode()
            switch(r4) {
                case -1155692273: goto L58;
                case -1097094790: goto L4d;
                case -838846263: goto L42;
                case -314765822: goto L37;
                case 99458: goto L2c;
                case 113974121: goto L21;
                default: goto L1f;
            }
        L1f:
            r0 = r5
            goto L61
        L21:
            java.lang.String r0 = "xfrin"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L2a
            goto L1f
        L2a:
            r0 = 5
            goto L61
        L2c:
            java.lang.String r0 = "dig"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L35
            goto L1f
        L35:
            r0 = 4
            goto L61
        L37:
            java.lang.String r0 = "primary"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L40
            goto L1f
        L40:
            r0 = 3
            goto L61
        L42:
            java.lang.String r0 = "update"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L4b
            goto L1f
        L4b:
            r0 = 2
            goto L61
        L4d:
            java.lang.String r0 = "lookup"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L56
            goto L1f
        L56:
            r0 = r1
            goto L61
        L58:
            java.lang.String r1 = "jnamed"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L61
            goto L1f
        L61:
            switch(r0) {
                case 0: goto L80;
                case 1: goto L7c;
                case 2: goto L78;
                case 3: goto L74;
                case 4: goto L70;
                case 5: goto L6c;
                default: goto L64;
            }
        L64:
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r0 = "invalid command"
            r5.println(r0)
            return
        L6c:
            org.xbill.DNS.tools.xfrin.main(r3)
            return
        L70:
            org.xbill.DNS.tools.dig.main(r3)
            return
        L74:
            org.xbill.DNS.tools.primary.main(r3)
            return
        L78:
            org.xbill.DNS.tools.update.main(r3)
            return
        L7c:
            org.xbill.DNS.tools.lookup.main(r3)
            return
        L80:
            org.xbill.DNS.tools.jnamed.main(r3)
            return
        L84:
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r0 = "Usage: <command> <options>"
            r5.println(r0)
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r0 = "  Commands:"
            r5.println(r0)
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r0 = "    dig"
            r5.println(r0)
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r0 = "    jnamed"
            r5.println(r0)
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r0 = "    lookup"
            r5.println(r0)
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r0 = "    primary"
            r5.println(r0)
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r0 = "    update"
            r5.println(r0)
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r0 = "    xfrin"
            r5.println(r0)
            java.lang.System.exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.tools.Tools.main(java.lang.String[]):void");
    }
}
