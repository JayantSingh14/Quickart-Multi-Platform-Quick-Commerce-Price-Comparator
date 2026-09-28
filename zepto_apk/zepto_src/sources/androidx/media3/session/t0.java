package androidx.media3.session;

import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import com.google.common.util.concurrent.AsyncFunction;

/* loaded from: classes3.dex */
public final /* synthetic */ class t0 implements AsyncFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaSession.ControllerInfo f10756a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaLibraryService.MediaLibrarySession f10757b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10758c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MediaLibraryService.LibraryParams f10759d;

    public /* synthetic */ t0(MediaSession.ControllerInfo controllerInfo, MediaLibraryService.MediaLibrarySession mediaLibrarySession, String str, MediaLibraryService.LibraryParams libraryParams) {
        this.f10756a = controllerInfo;
        this.f10757b = mediaLibrarySession;
        this.f10758c = str;
        this.f10759d = libraryParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005e A[PHI: r9
      0x005e: PHI (r9v10 androidx.media3.session.MediaSession$ControllerInfo) = 
      (r9v7 androidx.media3.session.MediaSession$ControllerInfo)
      (r9v7 androidx.media3.session.MediaSession$ControllerInfo)
      (r9v15 androidx.media3.session.MediaSession$ControllerInfo)
     binds: [B:16:0x0032, B:18:0x0038, B:27:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.common.util.concurrent.AsyncFunction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.common.util.concurrent.ListenableFuture apply(java.lang.Object r9) {
        /*
            r8 = this;
            androidx.media3.session.LibraryResult r9 = (androidx.media3.session.LibraryResult) r9
            int r0 = r9.f9947a
            if (r0 != 0) goto L82
            java.lang.Object r0 = r9.f9949c
            if (r0 == 0) goto L82
            androidx.media3.common.MediaItem r0 = (androidx.media3.common.MediaItem) r0
            androidx.media3.common.MediaMetadata r0 = r0.f5260d
            java.lang.Boolean r0 = r0.q
            if (r0 == 0) goto L82
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L19
            goto L82
        L19:
            androidx.media3.session.MediaSession$ControllerInfo r9 = r8.f10756a
            int r0 = r9.f10083b
            if (r0 == 0) goto L6f
            androidx.media3.session.MediaLibraryService$MediaLibrarySession r0 = r8.f10757b
            r0.getClass()
            androidx.media3.session.MediaSessionImpl r0 = r0.f10060a
            androidx.media3.session.MediaLibrarySessionImpl r0 = (androidx.media3.session.MediaLibrarySessionImpl) r0
            java.lang.String r1 = r8.f10758c
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L69
            boolean r2 = r0.y
            if (r2 == 0) goto L5e
            boolean r2 = r0.i(r9)
            if (r2 == 0) goto L5e
            androidx.media3.session.MediaSessionLegacyStub r9 = r0.f10098h
            androidx.media3.session.ConnectedControllersManager r9 = r9.f10114f
            com.google.common.collect.ImmutableList r9 = r9.f()
            r2 = 0
        L43:
            int r3 = r9.size()
            if (r2 >= r3) goto L5a
            java.lang.Object r3 = r9.get(r2)
            androidx.media3.session.MediaSession$ControllerInfo r3 = (androidx.media3.session.MediaSession.ControllerInfo) r3
            boolean r4 = androidx.media3.session.MediaSessionImpl.k(r3)
            if (r4 == 0) goto L57
            r9 = r3
            goto L5b
        L57:
            int r2 = r2 + 1
            goto L43
        L5a:
            r9 = 0
        L5b:
            if (r9 != 0) goto L5e
            goto L6f
        L5e:
            androidx.media3.session.j0 r2 = new androidx.media3.session.j0
            androidx.media3.session.MediaLibraryService$LibraryParams r3 = r8.f10759d
            r2.<init>(r0, r1, r3)
            r0.c(r9, r2)
            goto L6f
        L69:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>()
            throw r9
        L6f:
            androidx.media3.session.LibraryResult r0 = new androidx.media3.session.LibraryResult
            long r2 = android.os.SystemClock.elapsedRealtime()
            r4 = 0
            r5 = 0
            r1 = 0
            r6 = 0
            r7 = 1
            r0.<init>(r1, r2, r4, r5, r6, r7)
            com.google.common.util.concurrent.ListenableFuture r9 = com.google.common.util.concurrent.Futures.d(r0)
            return r9
        L82:
            int r9 = r9.f9947a
            if (r9 == 0) goto L87
            goto L88
        L87:
            r9 = -3
        L88:
            androidx.media3.session.LibraryResult r9 = androidx.media3.session.LibraryResult.b(r9)
            com.google.common.util.concurrent.ListenableFuture r9 = com.google.common.util.concurrent.Futures.d(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.t0.apply(java.lang.Object):com.google.common.util.concurrent.ListenableFuture");
    }
}
