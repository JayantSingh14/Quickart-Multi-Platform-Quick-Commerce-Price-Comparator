package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
class QueueFileLogStore implements FileLogStore {

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f43920c = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final File f43921a;

    /* renamed from: b, reason: collision with root package name */
    public QueueFile f43922b;

    /* loaded from: classes4.dex */
    public static class LogBytes {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f43925a;

        /* renamed from: b, reason: collision with root package name */
        public final int f43926b;

        public LogBytes(byte[] bArr, int i2) {
            this.f43925a = bArr;
            this.f43926b = i2;
        }
    }

    public QueueFileLogStore(File file) {
        this.f43921a = file;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public final void a() throws IOException {
        CommonUtils.b(this.f43922b, "There was a problem closing the Crashlytics log file.");
        this.f43922b = null;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public final String b() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return new String(bArrC, f43920c);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] c() {
        /*
            r7 = this;
            java.io.File r0 = r7.f43921a
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto Lc
        La:
            r4 = r1
            goto L38
        Lc:
            r7.f()
            com.google.firebase.crashlytics.internal.metadata.QueueFile r0 = r7.f43922b
            if (r0 != 0) goto L14
            goto La
        L14:
            int[] r3 = new int[]{r2}
            int r0 = r0.D()
            byte[] r0 = new byte[r0]
            com.google.firebase.crashlytics.internal.metadata.QueueFile r4 = r7.f43922b     // Catch: java.io.IOException -> L29
            com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore$1 r5 = new com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore$1     // Catch: java.io.IOException -> L29
            r5.<init>()     // Catch: java.io.IOException -> L29
            r4.c(r5)     // Catch: java.io.IOException -> L29
            goto L31
        L29:
            r4 = move-exception
            com.google.firebase.crashlytics.internal.Logger r5 = com.google.firebase.crashlytics.internal.Logger.f43705a
            java.lang.String r6 = "A problem occurred while reading the Crashlytics log file."
            r5.c(r6, r4)
        L31:
            com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore$LogBytes r4 = new com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore$LogBytes
            r3 = r3[r2]
            r4.<init>(r0, r3)
        L38:
            if (r4 != 0) goto L3b
            return r1
        L3b:
            int r0 = r4.f43926b
            byte[] r1 = new byte[r0]
            byte[] r3 = r4.f43925a
            java.lang.System.arraycopy(r3, r2, r1, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore.c():byte[]");
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public final void d() throws IOException {
        a();
        this.f43921a.delete();
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public final void e(long j2, String str) {
        f();
        if (this.f43922b == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            if (str.length() > 16384) {
                str = "..." + str.substring(str.length() - 16384);
            }
            this.f43922b.a(String.format(Locale.US, "%d %s%n", Long.valueOf(j2), str.replaceAll(StringUtils.CR, StringUtils.SPACE).replaceAll(StringUtils.LF, StringUtils.SPACE)).getBytes(f43920c));
            while (!this.f43922b.e() && this.f43922b.D() > 65536) {
                this.f43922b.s();
            }
        } catch (IOException e2) {
            Logger.f43705a.c("There was a problem writing to the Crashlytics log.", e2);
        }
    }

    public final void f() {
        File file = this.f43921a;
        if (this.f43922b == null) {
            try {
                this.f43922b = new QueueFile(file);
            } catch (IOException e2) {
                Logger.f43705a.c("Could not open log file: " + file, e2);
            }
        }
    }
}
