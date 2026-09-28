package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class DebugKt {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        if (r0.equals("on") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        if (r0.equals("") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        r0 = kotlinx.coroutines.internal.SystemPropsKt.c("kotlinx.coroutines.stacktrace.recovery");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        if (r0 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        java.lang.Boolean.parseBoolean(r0);
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.c(r0)
            if (r0 == 0) goto L6b
            int r1 = r0.hashCode()
            if (r1 == 0) goto L37
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L2e
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 == r2) goto L25
            r2 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r1 != r2) goto L4e
            java.lang.String r1 = "auto"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L4e
            goto L6b
        L25:
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L4e
            goto L6b
        L2e:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L4e
            goto L3f
        L37:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L4e
        L3f:
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.c(r0)
            if (r0 == 0) goto L4c
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            goto L6b
        L4c:
            r0 = 1
            goto L6b
        L4e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r2.<init>(r3)
            r2.append(r0)
            r0 = 39
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L6b:
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DebugKt.<clinit>():void");
    }
}
