package ch.qos.logback.classic.net;

/* loaded from: classes3.dex */
public class SimpleSocketServer extends Thread {
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        throw null;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r4 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            r1 = 0
            java.lang.Class r2 = r4.getClass()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r3}     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            java.lang.String r3 = "Logback %s (port %d)"
            java.lang.String r2 = java.lang.String.format(r3, r2)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            r3.setName(r2)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            throw r1     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
        L28:
            r1 = move-exception
            goto L2b
        L2a:
            throw r1     // Catch: java.lang.Throwable -> L28
        L2b:
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.setName(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.classic.net.SimpleSocketServer.run():void");
    }
}
