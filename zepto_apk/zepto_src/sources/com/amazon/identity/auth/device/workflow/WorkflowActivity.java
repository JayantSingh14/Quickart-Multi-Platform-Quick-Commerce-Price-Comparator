package com.amazon.identity.auth.device.workflow;

import android.annotation.SuppressLint;
import android.app.Activity;

@SuppressLint({"Registered"})
/* loaded from: classes3.dex */
public final class WorkflowActivity extends Activity {
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093 A[Catch: AuthError -> 0x00d6, TryCatch #1 {AuthError -> 0x00d6, blocks: (B:3:0x0005, B:28:0x0073, B:35:0x0088, B:36:0x0089, B:38:0x0093, B:40:0x00a1, B:41:0x00bb, B:42:0x00d3, B:44:0x00d5, B:26:0x006e, B:29:0x0074, B:31:0x0078, B:34:0x0086, B:6:0x001c, B:8:0x0022, B:9:0x002a, B:10:0x0030, B:17:0x0045, B:18:0x0046, B:20:0x005e, B:22:0x0064, B:23:0x0068, B:24:0x006c, B:25:0x006d), top: B:50:0x0005, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bb A[Catch: AuthError -> 0x00d6, TryCatch #1 {AuthError -> 0x00d6, blocks: (B:3:0x0005, B:28:0x0073, B:35:0x0088, B:36:0x0089, B:38:0x0093, B:40:0x00a1, B:41:0x00bb, B:42:0x00d3, B:44:0x00d5, B:26:0x006e, B:29:0x0074, B:31:0x0078, B:34:0x0086, B:6:0x001c, B:8:0x0022, B:9:0x002a, B:10:0x0030, B:17:0x0045, B:18:0x0046, B:20:0x005e, B:22:0x0064, B:23:0x0068, B:24:0x006c, B:25:0x006d), top: B:50:0x0005, inners: #2, #3 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r7) throws com.amazon.identity.auth.device.AuthError {
        /*
            r6 = this;
            java.lang.String r0 = "Could not find request id: "
            super.onCreate(r7)
            android.content.Intent r7 = r6.getIntent()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            android.net.Uri r7 = r7.getData()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            java.lang.String r7 = com.amazon.identity.auth.device.b.a(r7)     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            android.content.Intent r1 = r6.getIntent()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            android.net.Uri r1 = r1.getData()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            if (r1 != 0) goto L1c
            goto L71
        L1c:
            boolean r2 = com.amazon.identity.auth.device.b.c(r1)     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            if (r2 == 0) goto L2a
            com.amazon.identity.auth.device.ResponseManager r2 = com.amazon.identity.auth.device.ResponseManager.a()     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            r2.b(r1, r7)     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            goto L71
        L2a:
            android.content.Context r2 = r6.getApplicationContext()     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            java.lang.Class<com.amazon.identity.auth.device.b> r3 = com.amazon.identity.auth.device.b.class
            monitor-enter(r3)     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            com.amazon.identity.auth.device.b r4 = com.amazon.identity.auth.device.b.f15200c     // Catch: java.lang.Throwable -> L41
            if (r4 != 0) goto L43
            com.amazon.identity.auth.device.b r4 = new com.amazon.identity.auth.device.b     // Catch: java.lang.Throwable -> L41
            com.amazon.identity.auth.internal.BrowsingExperienceManager r2 = com.amazon.identity.auth.internal.BrowsingExperienceManager.getInstance(r2)     // Catch: java.lang.Throwable -> L41
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L41
            com.amazon.identity.auth.device.b.f15200c = r4     // Catch: java.lang.Throwable -> L41
            goto L43
        L41:
            r2 = move-exception
            goto L6c
        L43:
            com.amazon.identity.auth.device.b r2 = com.amazon.identity.auth.device.b.f15200c     // Catch: java.lang.Throwable -> L41
            monitor-exit(r3)     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            android.content.Context r3 = r6.getApplicationContext()     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            r2.getClass()     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            java.lang.String r4 = com.amazon.identity.auth.device.b.a(r1)     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            r1.toString()     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            java.util.Map r5 = r2.f15201a     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            java.lang.Object r4 = r5.remove(r4)     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            com.amazon.identity.auth.device.a r4 = (com.amazon.identity.auth.device.a) r4     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            if (r4 == 0) goto L68
            boolean r5 = r4.handleResponse(r1, r3)     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            if (r5 != 0) goto L71
            r2.b(r4, r3)     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            goto L71
        L68:
            r1.toString()     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            goto L71
        L6c:
            monitor-exit(r3)     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
            throw r2     // Catch: com.amazon.identity.auth.device.AuthError -> L6e
        L6e:
            r1.toString()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
        L71:
            java.lang.Class<com.amazon.identity.auth.device.b> r1 = com.amazon.identity.auth.device.b.class
            monitor-enter(r1)     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            com.amazon.identity.auth.device.b r2 = com.amazon.identity.auth.device.b.f15200c     // Catch: java.lang.Throwable -> L84
            if (r2 != 0) goto L86
            com.amazon.identity.auth.device.b r2 = new com.amazon.identity.auth.device.b     // Catch: java.lang.Throwable -> L84
            com.amazon.identity.auth.internal.BrowsingExperienceManager r3 = com.amazon.identity.auth.internal.BrowsingExperienceManager.getInstance(r6)     // Catch: java.lang.Throwable -> L84
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L84
            com.amazon.identity.auth.device.b.f15200c = r2     // Catch: java.lang.Throwable -> L84
            goto L86
        L84:
            r7 = move-exception
            goto Ld4
        L86:
            com.amazon.identity.auth.device.b r2 = com.amazon.identity.auth.device.b.f15200c     // Catch: java.lang.Throwable -> L84
            monitor-exit(r1)     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            java.util.Map r1 = r2.f15201a     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            java.lang.Object r1 = r1.get(r7)     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            com.amazon.identity.auth.device.a r1 = (com.amazon.identity.auth.device.a) r1     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            if (r1 == 0) goto Lbb
            com.amazon.identity.auth.device.interactive.InteractiveRequest r7 = r1.getOriginalRequest()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            com.amazon.identity.auth.device.api.workflow.RequestContext r7 = r7.getRequestContext()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            android.content.Intent r7 = r7.getInvokingIntent()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            if (r7 == 0) goto Le1
            r0 = 603979776(0x24000000, float:2.7755576E-17)
            r7.setFlags(r0)     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            android.content.Intent r0 = r6.getIntent()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            android.net.Uri r0 = r0.getData()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            java.lang.String r0 = r0.toString()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            java.lang.String r1 = "authResponse"
            r7.putExtra(r1, r0)     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            r6.startActivity(r7)     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            goto Le1
        Lbb:
            com.amazon.identity.auth.device.AuthError r1 = new com.amazon.identity.auth.device.AuthError     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            r2.<init>(r0)     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            r2.append(r7)     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            java.lang.String r7 = " in active requests"
            r2.append(r7)     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            java.lang.String r7 = r2.toString()     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            com.amazon.identity.auth.device.AuthError$ERROR_TYPE r0 = com.amazon.identity.auth.device.AuthError.ERROR_TYPE.ERROR_UNKNOWN     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            r1.<init>(r7, r0)     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
            throw r1     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
        Ld4:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L84
            throw r7     // Catch: com.amazon.identity.auth.device.AuthError -> Ld6
        Ld6:
            android.content.Intent r7 = r6.getIntent()
            android.net.Uri r7 = r7.getData()
            r7.toString()
        Le1:
            r6.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.identity.auth.device.workflow.WorkflowActivity.onCreate(android.os.Bundle):void");
    }
}
