package androidx.media3.exoplayer.trackselection;

import com.google.common.base.Predicate;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector f8053a;

    public /* synthetic */ e(DefaultTrackSelector defaultTrackSelector) {
        this.f8053a = defaultTrackSelector;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0069 A[Catch: all -> 0x0067, TryCatch #0 {all -> 0x0067, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x0014, B:10:0x0018, B:36:0x005a, B:38:0x005e, B:40:0x0062, B:45:0x0069, B:47:0x006d, B:49:0x0071, B:51:0x0075, B:53:0x007d, B:55:0x0087, B:58:0x0092), top: B:62:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0091  */
    @Override // com.google.common.base.Predicate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean apply(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 2
            r2 = 1
            androidx.media3.exoplayer.trackselection.DefaultTrackSelector r3 = r8.f8053a
            androidx.media3.common.Format r9 = (androidx.media3.common.Format) r9
            java.lang.Object r4 = r3.f7975d
            monitor-enter(r4)
            androidx.media3.exoplayer.trackselection.DefaultTrackSelector$Parameters r5 = r3.f7979h     // Catch: java.lang.Throwable -> L67
            boolean r5 = r5.m0     // Catch: java.lang.Throwable -> L67
            if (r5 == 0) goto L91
            boolean r5 = r3.f7978g     // Catch: java.lang.Throwable -> L67
            if (r5 != 0) goto L91
            int r5 = r9.A     // Catch: java.lang.Throwable -> L67
            if (r5 <= r1) goto L91
            java.lang.String r5 = r9.f5225m     // Catch: java.lang.Throwable -> L67
            if (r5 != 0) goto L1e
        L1c:
            r1 = r0
            goto L56
        L1e:
            r6 = -1
            int r7 = r5.hashCode()
            switch(r7) {
                case -2123537834: goto L47;
                case 187078296: goto L3c;
                case 187078297: goto L33;
                case 1504578661: goto L28;
                default: goto L26;
            }
        L26:
            r1 = r6
            goto L51
        L28:
            java.lang.String r1 = "audio/eac3"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L31
            goto L26
        L31:
            r1 = 3
            goto L51
        L33:
            java.lang.String r7 = "audio/ac4"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L51
            goto L26
        L3c:
            java.lang.String r1 = "audio/ac3"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L45
            goto L26
        L45:
            r1 = r2
            goto L51
        L47:
            java.lang.String r1 = "audio/eac3-joc"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L50
            goto L26
        L50:
            r1 = r0
        L51:
            switch(r1) {
                case 0: goto L55;
                case 1: goto L55;
                case 2: goto L55;
                case 3: goto L55;
                default: goto L54;
            }
        L54:
            goto L1c
        L55:
            r1 = r2
        L56:
            r5 = 32
            if (r1 == 0) goto L69
            int r1 = androidx.media3.common.util.Util.f5744a     // Catch: java.lang.Throwable -> L67
            if (r1 < r5) goto L91
            androidx.media3.exoplayer.trackselection.DefaultTrackSelector$SpatializerWrapperV32 r1 = r3.f7980i     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L91
            boolean r1 = r1.f7999b     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L91
            goto L69
        L67:
            r9 = move-exception
            goto L94
        L69:
            int r1 = androidx.media3.common.util.Util.f5744a     // Catch: java.lang.Throwable -> L67
            if (r1 < r5) goto L92
            androidx.media3.exoplayer.trackselection.DefaultTrackSelector$SpatializerWrapperV32 r1 = r3.f7980i     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L92
            boolean r5 = r1.f7999b     // Catch: java.lang.Throwable -> L67
            if (r5 == 0) goto L92
            android.media.Spatializer r1 = r1.f7998a     // Catch: java.lang.Throwable -> L67
            boolean r1 = androidx.media3.common.a.f(r1)     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L92
            androidx.media3.exoplayer.trackselection.DefaultTrackSelector$SpatializerWrapperV32 r1 = r3.f7980i     // Catch: java.lang.Throwable -> L67
            android.media.Spatializer r1 = r1.f7998a     // Catch: java.lang.Throwable -> L67
            boolean r1 = androidx.media3.common.a.h(r1)     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L92
            androidx.media3.exoplayer.trackselection.DefaultTrackSelector$SpatializerWrapperV32 r1 = r3.f7980i     // Catch: java.lang.Throwable -> L67
            androidx.media3.common.AudioAttributes r3 = r3.f7981j     // Catch: java.lang.Throwable -> L67
            boolean r9 = r1.a(r3, r9)     // Catch: java.lang.Throwable -> L67
            if (r9 == 0) goto L92
        L91:
            r0 = r2
        L92:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L67
            return r0
        L94:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L67
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.e.apply(java.lang.Object):boolean");
    }
}
