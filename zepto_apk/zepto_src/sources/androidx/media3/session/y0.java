package androidx.media3.session;

import android.os.RemoteException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaSession;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public final /* synthetic */ class y0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10799a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10800b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f10801c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10802d;

    public /* synthetic */ y0(MediaControllerImplBase mediaControllerImplBase, ListenableFuture listenableFuture, int i2) {
        this.f10799a = 2;
        this.f10800b = mediaControllerImplBase;
        this.f10801c = listenableFuture;
        this.f10802d = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        SessionResult sessionResult;
        Object obj = this.f10800b;
        int i2 = this.f10802d;
        ListenableFuture listenableFuture = this.f10801c;
        switch (this.f10799a) {
            case 0:
                int i3 = MediaLibrarySessionImpl.C;
                ((MediaLibrarySessionImpl) obj).getClass();
                LibraryResult libraryResult = (LibraryResult) MediaLibrarySessionImpl.B(listenableFuture);
                if (libraryResult != null) {
                    MediaLibrarySessionImpl.C(i2, libraryResult);
                    break;
                }
                break;
            case 1:
                int i4 = MediaLibrarySessionImpl.C;
                ((MediaLibrarySessionImpl) obj).getClass();
                LibraryResult libraryResult2 = (LibraryResult) MediaLibrarySessionImpl.B(listenableFuture);
                if (libraryResult2 != null) {
                    MediaLibrarySessionImpl.C(i2, libraryResult2);
                    break;
                }
                break;
            default:
                MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) obj;
                mediaControllerImplBase.getClass();
                try {
                    sessionResult = (SessionResult) listenableFuture.get();
                    Assertions.e(sessionResult, "SessionResult must not be null");
                } catch (InterruptedException e2) {
                    e = e2;
                    Log.i("MCImplBase", "Session operation failed", e);
                    sessionResult = new SessionResult(-1);
                } catch (CancellationException e3) {
                    Log.i("MCImplBase", "Session operation cancelled", e3);
                    sessionResult = new SessionResult(1);
                } catch (ExecutionException e4) {
                    e = e4;
                    Log.i("MCImplBase", "Session operation failed", e);
                    sessionResult = new SessionResult(-1);
                }
                IMediaSession iMediaSession = mediaControllerImplBase.z;
                if (iMediaSession != null) {
                    try {
                        iMediaSession.A6(mediaControllerImplBase.f9972c, i2, sessionResult.b());
                        break;
                    } catch (RemoteException unused) {
                        Log.h("MCImplBase", "Error in sending");
                    }
                }
                break;
        }
    }

    public /* synthetic */ y0(MediaLibrarySessionImpl mediaLibrarySessionImpl, ListenableFuture listenableFuture, MediaSession.ControllerInfo controllerInfo, int i2, int i3) {
        this.f10799a = i3;
        this.f10800b = mediaLibrarySessionImpl;
        this.f10801c = listenableFuture;
        this.f10802d = i2;
    }
}
