package com.facebook.soloader.recovery;

import android.content.Context;

/* loaded from: classes3.dex */
public class CheckOnDiskStateDataApp implements RecoveryStrategy {

    /* renamed from: a, reason: collision with root package name */
    public final Context f20314a;

    public CheckOnDiskStateDataApp(Context context) {
        this.f20314a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        r5 = (com.facebook.soloader.BackupSoSource) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
    
        r3 = r5.g();
        r4 = r3.length;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        if (r6 >= r4) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
    
        r7 = r3[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        if (new java.io.File(r11, r7.f20304a).exists() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
    
        r2.add(r7.f20304a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        if (r2.isEmpty() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        android.util.Log.e("SoLoader", "No libraries missing from " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0089, code lost:
    
        android.util.Log.e("SoLoader", "Missing libraries from " + r11 + ": " + r2.toString() + ", will run prepare on tbe backup so source");
        r5.e(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b2, code lost:
    
        android.util.Log.e("SoLoader", "Encountered an exception while recovering from /data/app failure ", r11);
     */
    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.UnsatisfiedLinkError r11, com.facebook.soloader.SoSource[] r12) {
        /*
            r10 = this;
            boolean r11 = r11 instanceof com.facebook.soloader.SoLoaderULError
            r0 = 0
            if (r11 != 0) goto L7
            goto Lb7
        L7:
            java.lang.String r11 = "Checking /data/app missing libraries."
            java.lang.String r1 = "SoLoader"
            android.util.Log.e(r1, r11)
            java.io.File r11 = new java.io.File
            android.content.Context r2 = r10.f20314a
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo()
            java.lang.String r2 = r2.nativeLibraryDir
            r11.<init>(r2)
            boolean r2 = r11.exists()
            if (r2 != 0) goto L38
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r2 = "Native library directory "
            r12.<init>(r2)
            r12.append(r11)
            java.lang.String r11 = " does not exist, exiting /data/app recovery."
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            android.util.Log.e(r1, r11)
            return r0
        L38:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r3 = r12.length
            r4 = r0
        L3f:
            if (r4 >= r3) goto Lb8
            r5 = r12[r4]
            boolean r6 = r5 instanceof com.facebook.soloader.BackupSoSource
            if (r6 != 0) goto L4a
            int r4 = r4 + 1
            goto L3f
        L4a:
            com.facebook.soloader.BackupSoSource r5 = (com.facebook.soloader.BackupSoSource) r5
            com.facebook.soloader.UnpackingSoSource$Dso[] r3 = r5.g()     // Catch: java.lang.Exception -> L6c
            int r4 = r3.length     // Catch: java.lang.Exception -> L6c
            r6 = r0
        L52:
            if (r6 >= r4) goto L6e
            r7 = r3[r6]     // Catch: java.lang.Exception -> L6c
            java.io.File r8 = new java.io.File     // Catch: java.lang.Exception -> L6c
            java.lang.String r9 = r7.f20304a     // Catch: java.lang.Exception -> L6c
            r8.<init>(r11, r9)     // Catch: java.lang.Exception -> L6c
            boolean r8 = r8.exists()     // Catch: java.lang.Exception -> L6c
            if (r8 == 0) goto L64
            goto L69
        L64:
            java.lang.String r7 = r7.f20304a     // Catch: java.lang.Exception -> L6c
            r2.add(r7)     // Catch: java.lang.Exception -> L6c
        L69:
            int r6 = r6 + 1
            goto L52
        L6c:
            r11 = move-exception
            goto Lb2
        L6e:
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Exception -> L6c
            if (r3 == 0) goto L89
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6c
            r12.<init>()     // Catch: java.lang.Exception -> L6c
            java.lang.String r2 = "No libraries missing from "
            r12.append(r2)     // Catch: java.lang.Exception -> L6c
            r12.append(r11)     // Catch: java.lang.Exception -> L6c
            java.lang.String r11 = r12.toString()     // Catch: java.lang.Exception -> L6c
            android.util.Log.e(r1, r11)     // Catch: java.lang.Exception -> L6c
            return r0
        L89:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6c
            r3.<init>()     // Catch: java.lang.Exception -> L6c
            java.lang.String r4 = "Missing libraries from "
            r3.append(r4)     // Catch: java.lang.Exception -> L6c
            r3.append(r11)     // Catch: java.lang.Exception -> L6c
            java.lang.String r11 = ": "
            r3.append(r11)     // Catch: java.lang.Exception -> L6c
            java.lang.String r11 = r2.toString()     // Catch: java.lang.Exception -> L6c
            r3.append(r11)     // Catch: java.lang.Exception -> L6c
            java.lang.String r11 = ", will run prepare on tbe backup so source"
            r3.append(r11)     // Catch: java.lang.Exception -> L6c
            java.lang.String r11 = r3.toString()     // Catch: java.lang.Exception -> L6c
            android.util.Log.e(r1, r11)     // Catch: java.lang.Exception -> L6c
            r5.e(r0)     // Catch: java.lang.Exception -> L6c
            goto Lb8
        Lb2:
            java.lang.String r12 = "Encountered an exception while recovering from /data/app failure "
            android.util.Log.e(r1, r12, r11)
        Lb7:
            return r0
        Lb8:
            int r11 = r12.length
        Lb9:
            r2 = 1
            if (r0 >= r11) goto Ld2
            r3 = r12[r0]
            boolean r4 = r3 instanceof com.facebook.soloader.DirectorySoSource
            if (r4 != 0) goto Lc3
            goto Lcf
        Lc3:
            boolean r4 = r3 instanceof com.facebook.soloader.BackupSoSource
            if (r4 == 0) goto Lc8
            goto Lcf
        Lc8:
            com.facebook.soloader.DirectorySoSource r3 = (com.facebook.soloader.DirectorySoSource) r3
            int r4 = r3.f20255b
            r2 = r2 | r4
            r3.f20255b = r2
        Lcf:
            int r0 = r0 + 1
            goto Lb9
        Ld2:
            java.lang.String r11 = "Successfully recovered from /data/app disk failure."
            android.util.Log.e(r1, r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.recovery.CheckOnDiskStateDataApp.a(java.lang.UnsatisfiedLinkError, com.facebook.soloader.SoSource[]):boolean");
    }
}
