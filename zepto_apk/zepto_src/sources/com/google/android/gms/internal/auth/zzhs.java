package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
public final class zzhs extends zzev implements zzfy {
    private static final zzhs zzb;
    private zzez zzd = zzgg.f36389d;

    static {
        zzhs zzhsVar = new zzhs();
        zzb = zzhsVar;
        zzev.d(zzhsVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0048, code lost:
    
        if (r7 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.auth.zzhs h(byte[] r7) throws com.google.android.gms.internal.auth.zzfb {
        /*
            com.google.android.gms.internal.auth.zzhs r0 = com.google.android.gms.internal.auth.zzhs.zzb
            int r5 = r7.length
            com.google.android.gms.internal.auth.zzel r1 = com.google.android.gms.internal.auth.zzel.f36341b
            r2 = 4
            java.lang.Object r0 = r0.g(r2)
            r2 = r0
            com.google.android.gms.internal.auth.zzev r2 = (com.google.android.gms.internal.auth.zzev) r2
            com.google.android.gms.internal.auth.zzgf r0 = com.google.android.gms.internal.auth.zzgf.f36386c     // Catch: java.io.IOException -> L5e com.google.android.gms.internal.auth.zzgy -> L61 com.google.android.gms.internal.auth.zzfb -> L64 java.lang.IndexOutOfBoundsException -> L67
            java.lang.Class r3 = r2.getClass()     // Catch: java.io.IOException -> L5e com.google.android.gms.internal.auth.zzgy -> L61 com.google.android.gms.internal.auth.zzfb -> L64 java.lang.IndexOutOfBoundsException -> L67
            com.google.android.gms.internal.auth.zzgi r3 = r0.a(r3)     // Catch: java.io.IOException -> L5e com.google.android.gms.internal.auth.zzgy -> L61 com.google.android.gms.internal.auth.zzfb -> L64 java.lang.IndexOutOfBoundsException -> L67
            com.google.android.gms.internal.auth.zzdt r6 = new com.google.android.gms.internal.auth.zzdt     // Catch: java.io.IOException -> L5e com.google.android.gms.internal.auth.zzgy -> L61 com.google.android.gms.internal.auth.zzfb -> L64 java.lang.IndexOutOfBoundsException -> L67
            r6.<init>()     // Catch: java.io.IOException -> L5e com.google.android.gms.internal.auth.zzgy -> L61 com.google.android.gms.internal.auth.zzfb -> L64 java.lang.IndexOutOfBoundsException -> L67
            r1.getClass()     // Catch: java.io.IOException -> L5e com.google.android.gms.internal.auth.zzgy -> L61 com.google.android.gms.internal.auth.zzfb -> L64 java.lang.IndexOutOfBoundsException -> L67
            r4 = 0
            r1 = r3
            r3 = r7
            r1.d(r2, r3, r4, r5, r6)     // Catch: java.io.IOException -> L5e com.google.android.gms.internal.auth.zzgy -> L61 com.google.android.gms.internal.auth.zzfb -> L64 java.lang.IndexOutOfBoundsException -> L67
            r1.a(r2)     // Catch: java.io.IOException -> L5e com.google.android.gms.internal.auth.zzgy -> L61 com.google.android.gms.internal.auth.zzfb -> L64 java.lang.IndexOutOfBoundsException -> L67
            r7 = 1
            java.lang.Object r1 = r2.g(r7)
            java.lang.Byte r1 = (java.lang.Byte) r1
            byte r1 = r1.byteValue()
            if (r1 != r7) goto L36
            goto L4a
        L36:
            if (r1 == 0) goto L4d
            java.lang.Class r7 = r2.getClass()
            com.google.android.gms.internal.auth.zzgi r7 = r0.a(r7)
            boolean r7 = r7.f(r2)
            r0 = 2
            r2.g(r0)
            if (r7 == 0) goto L4d
        L4a:
            com.google.android.gms.internal.auth.zzhs r2 = (com.google.android.gms.internal.auth.zzhs) r2
            return r2
        L4d:
            com.google.android.gms.internal.auth.zzgy r7 = new com.google.android.gms.internal.auth.zzgy
            java.lang.String r0 = "Message was missing required fields.  (Lite runtime could not determine which fields were missing)."
            r7.<init>(r0)
            com.google.android.gms.internal.auth.zzfb r0 = new com.google.android.gms.internal.auth.zzfb
            java.lang.String r7 = r7.getMessage()
            r0.<init>(r7)
            throw r0
        L5e:
            r0 = move-exception
            r7 = r0
            goto L6c
        L61:
            r0 = move-exception
            r7 = r0
            goto L85
        L64:
            r0 = move-exception
            r7 = r0
            goto L8f
        L67:
            com.google.android.gms.internal.auth.zzfb r7 = com.google.android.gms.internal.auth.zzfb.c()
            throw r7
        L6c:
            java.lang.Throwable r0 = r7.getCause()
            boolean r0 = r0 instanceof com.google.android.gms.internal.auth.zzfb
            if (r0 == 0) goto L7b
            java.lang.Throwable r7 = r7.getCause()
            com.google.android.gms.internal.auth.zzfb r7 = (com.google.android.gms.internal.auth.zzfb) r7
            throw r7
        L7b:
            com.google.android.gms.internal.auth.zzfb r0 = new com.google.android.gms.internal.auth.zzfb
            java.lang.String r1 = r7.getMessage()
            r0.<init>(r1, r7)
            throw r0
        L85:
            com.google.android.gms.internal.auth.zzfb r0 = new com.google.android.gms.internal.auth.zzfb
            java.lang.String r7 = r7.getMessage()
            r0.<init>(r7)
            throw r0
        L8f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzhs.h(byte[]):com.google.android.gms.internal.auth.zzhs");
    }

    @Override // com.google.android.gms.internal.auth.zzev
    public final Object g(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzgh(zzb, new Object[]{"zzd"});
        }
        if (i3 == 3) {
            return new zzhs();
        }
        if (i3 == 4) {
            return new zzhr(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
