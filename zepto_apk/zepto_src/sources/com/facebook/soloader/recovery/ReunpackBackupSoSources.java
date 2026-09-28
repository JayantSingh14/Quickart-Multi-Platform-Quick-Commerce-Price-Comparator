package com.facebook.soloader.recovery;

/* loaded from: classes3.dex */
public class ReunpackBackupSoSources implements RecoveryStrategy {

    /* renamed from: a, reason: collision with root package name */
    public final int f20323a;

    public ReunpackBackupSoSources() {
        this(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x009e, code lost:
    
        r4 = (com.facebook.soloader.BackupSoSource) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a0, code lost:
    
        r9 = new java.lang.StringBuilder();
        r9.append("Preparing BackupSoSource for the first time ");
        r4.getClass();
        r9.append("BackupSoSource");
        android.util.Log.e("SoLoader", r9.toString());
        r4.e(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bc, code lost:
    
        r9 = r10.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bd, code lost:
    
        if (r1 >= r9) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bf, code lost:
    
        r0 = r10[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c3, code lost:
    
        if ((r0 instanceof com.facebook.soloader.DirectorySoSource) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c8, code lost:
    
        if ((r0 instanceof com.facebook.soloader.BackupSoSource) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cb, code lost:
    
        ((com.facebook.soloader.DirectorySoSource) r0).f20255b |= 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d2, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d6, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d7, code lost:
    
        r10 = new java.lang.StringBuilder("Encountered an exception while reunpacking BackupSoSource BackupSoSource for library ");
        r4.getClass();
        r10.append(r0);
        r10.append(": ");
        android.util.Log.e("SoLoader", r10.toString(), r9);
     */
    @Override // com.facebook.soloader.recovery.RecoveryStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.UnsatisfiedLinkError r9, com.facebook.soloader.SoSource[] r10) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.recovery.ReunpackBackupSoSources.a(java.lang.UnsatisfiedLinkError, com.facebook.soloader.SoSource[]):boolean");
    }

    public ReunpackBackupSoSources(int i2) {
        this.f20323a = i2;
    }
}
