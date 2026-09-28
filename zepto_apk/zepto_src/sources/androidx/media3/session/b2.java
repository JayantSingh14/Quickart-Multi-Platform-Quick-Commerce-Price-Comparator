package androidx.media3.session;

import androidx.media3.common.util.Consumer;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;

/* loaded from: classes3.dex */
public final /* synthetic */ class b2 implements MediaSessionStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10318a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaSessionStub.SessionTask f10319b;

    public /* synthetic */ b2(MediaSessionStub.SessionTask sessionTask, int i2) {
        this.f10318a = i2;
        this.f10319b = sessionTask;
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public final Object c(MediaSessionImpl mediaSessionImpl, final MediaSession.ControllerInfo controllerInfo, final int i2) {
        switch (this.f10318a) {
            case 0:
                final int i3 = 0;
                return MediaSessionStub.w1((MediaLibrarySessionImpl) mediaSessionImpl, controllerInfo, i2, this.f10319b, new Consumer() { // from class: androidx.media3.session.c2
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    @Override // androidx.media3.common.util.Consumer
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void accept(java.lang.Object r7) {
                        /*
                            r6 = this;
                            int r0 = r2
                            androidx.media3.session.MediaSession$ControllerInfo r1 = r1
                            r2 = 1
                            r3 = -1
                            java.lang.String r4 = "MediaSessionStub"
                            int r5 = r3
                            com.google.common.util.concurrent.ListenableFuture r7 = (com.google.common.util.concurrent.ListenableFuture) r7
                            switch(r5) {
                                case 0: goto L46;
                                default: goto Lf;
                            }
                        Lf:
                            int r5 = androidx.media3.session.MediaSessionStub.f10157h
                            java.lang.Object r7 = r7.get()     // Catch: java.lang.InterruptedException -> L1d java.util.concurrent.ExecutionException -> L1f java.util.concurrent.CancellationException -> L21
                            androidx.media3.session.SessionResult r7 = (androidx.media3.session.SessionResult) r7     // Catch: java.lang.InterruptedException -> L1d java.util.concurrent.ExecutionException -> L1f java.util.concurrent.CancellationException -> L21
                            java.lang.String r5 = "SessionResult must not be null"
                            androidx.media3.common.util.Assertions.e(r7, r5)     // Catch: java.lang.InterruptedException -> L1d java.util.concurrent.ExecutionException -> L1f java.util.concurrent.CancellationException -> L21
                            goto L42
                        L1d:
                            r7 = move-exception
                            goto L23
                        L1f:
                            r7 = move-exception
                            goto L23
                        L21:
                            r7 = move-exception
                            goto L38
                        L23:
                            java.lang.String r2 = "Session operation failed"
                            androidx.media3.common.util.Log.i(r4, r2, r7)
                            androidx.media3.session.SessionResult r2 = new androidx.media3.session.SessionResult
                            java.lang.Throwable r7 = r7.getCause()
                            boolean r7 = r7 instanceof java.lang.UnsupportedOperationException
                            if (r7 == 0) goto L33
                            r3 = -6
                        L33:
                            r2.<init>(r3)
                            r7 = r2
                            goto L42
                        L38:
                            java.lang.String r3 = "Session operation cancelled"
                            androidx.media3.common.util.Log.i(r4, r3, r7)
                            androidx.media3.session.SessionResult r7 = new androidx.media3.session.SessionResult
                            r7.<init>(r2)
                        L42:
                            androidx.media3.session.MediaSessionStub.A4(r1, r0, r7)
                            return
                        L46:
                            int r5 = androidx.media3.session.MediaSessionStub.f10157h
                            java.lang.Object r7 = r7.get()     // Catch: java.lang.InterruptedException -> L54 java.util.concurrent.ExecutionException -> L56 java.util.concurrent.CancellationException -> L58
                            androidx.media3.session.LibraryResult r7 = (androidx.media3.session.LibraryResult) r7     // Catch: java.lang.InterruptedException -> L54 java.util.concurrent.ExecutionException -> L56 java.util.concurrent.CancellationException -> L58
                            java.lang.String r5 = "LibraryResult must not be null"
                            androidx.media3.common.util.Assertions.e(r7, r5)     // Catch: java.lang.InterruptedException -> L54 java.util.concurrent.ExecutionException -> L56 java.util.concurrent.CancellationException -> L58
                            goto L6d
                        L54:
                            r7 = move-exception
                            goto L5a
                        L56:
                            r7 = move-exception
                            goto L5a
                        L58:
                            r7 = move-exception
                            goto L64
                        L5a:
                            java.lang.String r2 = "Library operation failed"
                            androidx.media3.common.util.Log.i(r4, r2, r7)
                            androidx.media3.session.LibraryResult r7 = androidx.media3.session.LibraryResult.b(r3)
                            goto L6d
                        L64:
                            java.lang.String r3 = "Library operation cancelled"
                            androidx.media3.common.util.Log.i(r4, r3, r7)
                            androidx.media3.session.LibraryResult r7 = androidx.media3.session.LibraryResult.b(r2)
                        L6d:
                            androidx.media3.session.MediaSession$ControllerCb r2 = r1.f10086e     // Catch: android.os.RemoteException -> L76
                            androidx.media3.common.util.Assertions.h(r2)     // Catch: android.os.RemoteException -> L76
                            r2.b(r0, r7)     // Catch: android.os.RemoteException -> L76
                            goto L88
                        L76:
                            r7 = move-exception
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            java.lang.String r2 = "Failed to send result to browser "
                            r0.<init>(r2)
                            r0.append(r1)
                            java.lang.String r0 = r0.toString()
                            androidx.media3.common.util.Log.i(r4, r0, r7)
                        L88:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.c2.accept(java.lang.Object):void");
                    }
                });
            default:
                final int i4 = 1;
                return MediaSessionStub.w1(mediaSessionImpl, controllerInfo, i2, this.f10319b, new Consumer() { // from class: androidx.media3.session.c2
                    @Override // androidx.media3.common.util.Consumer
                    public final void accept(Object v) {
                        /*
                            this = this;
                            int r0 = r2
                            androidx.media3.session.MediaSession$ControllerInfo r1 = r1
                            r2 = 1
                            r3 = -1
                            java.lang.String r4 = "MediaSessionStub"
                            int r5 = r3
                            com.google.common.util.concurrent.ListenableFuture r7 = (com.google.common.util.concurrent.ListenableFuture) r7
                            switch(r5) {
                                case 0: goto L46;
                                default: goto Lf;
                            }
                        Lf:
                            int r5 = androidx.media3.session.MediaSessionStub.f10157h
                            java.lang.Object r7 = r7.get()     // Catch: java.lang.InterruptedException -> L1d java.util.concurrent.ExecutionException -> L1f java.util.concurrent.CancellationException -> L21
                            androidx.media3.session.SessionResult r7 = (androidx.media3.session.SessionResult) r7     // Catch: java.lang.InterruptedException -> L1d java.util.concurrent.ExecutionException -> L1f java.util.concurrent.CancellationException -> L21
                            java.lang.String r5 = "SessionResult must not be null"
                            androidx.media3.common.util.Assertions.e(r7, r5)     // Catch: java.lang.InterruptedException -> L1d java.util.concurrent.ExecutionException -> L1f java.util.concurrent.CancellationException -> L21
                            goto L42
                        L1d:
                            r7 = move-exception
                            goto L23
                        L1f:
                            r7 = move-exception
                            goto L23
                        L21:
                            r7 = move-exception
                            goto L38
                        L23:
                            java.lang.String r2 = "Session operation failed"
                            androidx.media3.common.util.Log.i(r4, r2, r7)
                            androidx.media3.session.SessionResult r2 = new androidx.media3.session.SessionResult
                            java.lang.Throwable r7 = r7.getCause()
                            boolean r7 = r7 instanceof java.lang.UnsupportedOperationException
                            if (r7 == 0) goto L33
                            r3 = -6
                        L33:
                            r2.<init>(r3)
                            r7 = r2
                            goto L42
                        L38:
                            java.lang.String r3 = "Session operation cancelled"
                            androidx.media3.common.util.Log.i(r4, r3, r7)
                            androidx.media3.session.SessionResult r7 = new androidx.media3.session.SessionResult
                            r7.<init>(r2)
                        L42:
                            androidx.media3.session.MediaSessionStub.A4(r1, r0, r7)
                            return
                        L46:
                            int r5 = androidx.media3.session.MediaSessionStub.f10157h
                            java.lang.Object r7 = r7.get()     // Catch: java.lang.InterruptedException -> L54 java.util.concurrent.ExecutionException -> L56 java.util.concurrent.CancellationException -> L58
                            androidx.media3.session.LibraryResult r7 = (androidx.media3.session.LibraryResult) r7     // Catch: java.lang.InterruptedException -> L54 java.util.concurrent.ExecutionException -> L56 java.util.concurrent.CancellationException -> L58
                            java.lang.String r5 = "LibraryResult must not be null"
                            androidx.media3.common.util.Assertions.e(r7, r5)     // Catch: java.lang.InterruptedException -> L54 java.util.concurrent.ExecutionException -> L56 java.util.concurrent.CancellationException -> L58
                            goto L6d
                        L54:
                            r7 = move-exception
                            goto L5a
                        L56:
                            r7 = move-exception
                            goto L5a
                        L58:
                            r7 = move-exception
                            goto L64
                        L5a:
                            java.lang.String r2 = "Library operation failed"
                            androidx.media3.common.util.Log.i(r4, r2, r7)
                            androidx.media3.session.LibraryResult r7 = androidx.media3.session.LibraryResult.b(r3)
                            goto L6d
                        L64:
                            java.lang.String r3 = "Library operation cancelled"
                            androidx.media3.common.util.Log.i(r4, r3, r7)
                            androidx.media3.session.LibraryResult r7 = androidx.media3.session.LibraryResult.b(r2)
                        L6d:
                            androidx.media3.session.MediaSession$ControllerCb r2 = r1.f10086e     // Catch: android.os.RemoteException -> L76
                            androidx.media3.common.util.Assertions.h(r2)     // Catch: android.os.RemoteException -> L76
                            r2.b(r0, r7)     // Catch: android.os.RemoteException -> L76
                            goto L88
                        L76:
                            r7 = move-exception
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            java.lang.String r2 = "Failed to send result to browser "
                            r0.<init>(r2)
                            r0.append(r1)
                            java.lang.String r0 = r0.toString()
                            androidx.media3.common.util.Log.i(r4, r0, r7)
                        L88:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.c2.accept(java.lang.Object):void");
                    }
                });
        }
    }
}
