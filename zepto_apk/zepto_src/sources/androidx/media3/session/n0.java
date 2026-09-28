package androidx.media3.session;

import android.graphics.Bitmap;
import android.os.RemoteException;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.legacy.MediaSessionManager;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10710a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10711b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10712c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10713d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f10714e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f10715f;

    public /* synthetic */ n0(MediaControllerImplLegacy mediaControllerImplLegacy, AtomicInteger atomicInteger, List list, ArrayList arrayList, int i2) {
        this.f10712c = mediaControllerImplLegacy;
        this.f10713d = atomicInteger;
        this.f10714e = list;
        this.f10715f = arrayList;
        this.f10711b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap;
        switch (this.f10710a) {
            case 0:
                MediaControllerImplLegacy mediaControllerImplLegacy = (MediaControllerImplLegacy) this.f10712c;
                mediaControllerImplLegacy.getClass();
                int iIncrementAndGet = ((AtomicInteger) this.f10713d).incrementAndGet();
                List list = (List) this.f10714e;
                if (iIncrementAndGet == list.size()) {
                    int i2 = 0;
                    while (true) {
                        ArrayList arrayList = (ArrayList) this.f10715f;
                        if (i2 >= arrayList.size()) {
                            break;
                        } else {
                            ListenableFuture listenableFuture = (ListenableFuture) arrayList.get(i2);
                            if (listenableFuture != null) {
                                try {
                                    bitmap = (Bitmap) Futures.b(listenableFuture);
                                } catch (CancellationException | ExecutionException e2) {
                                    Log.c("MCImplLegacy", "Failed to get bitmap", e2);
                                }
                            } else {
                                bitmap = null;
                            }
                            mediaControllerImplLegacy.f9996g.a(LegacyConversions.i((MediaItem) list.get(i2), bitmap), this.f10711b + i2);
                            i2++;
                        }
                    }
                }
                break;
            default:
                MediaSessionLegacyStub.SessionTask sessionTask = (MediaSessionLegacyStub.SessionTask) this.f10715f;
                MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.f10712c;
                if (!mediaSessionLegacyStub.f10115g.j()) {
                    boolean zE = mediaSessionLegacyStub.f10119k.e();
                    SessionCommand sessionCommand = (SessionCommand) this.f10713d;
                    int i3 = this.f10711b;
                    MediaSessionManager.RemoteUserInfo remoteUserInfo = (MediaSessionManager.RemoteUserInfo) this.f10714e;
                    if (!zE) {
                        StringBuilder sb = new StringBuilder("Ignore incoming session command before initialization. command=");
                        sb.append(sessionCommand == null ? Integer.valueOf(i3) : sessionCommand.f10234b);
                        sb.append(", pid=");
                        sb.append(remoteUserInfo.b());
                        Log.h("MediaSessionLegacyStub", sb.toString());
                        break;
                    } else {
                        MediaSession.ControllerInfo controllerInfoH = mediaSessionLegacyStub.H(remoteUserInfo);
                        if (controllerInfoH != null) {
                            ConnectedControllersManager connectedControllersManager = mediaSessionLegacyStub.f10114f;
                            if (sessionCommand != null) {
                                if (!connectedControllersManager.l(controllerInfoH, sessionCommand)) {
                                }
                            } else if (!connectedControllersManager.k(controllerInfoH, i3)) {
                            }
                            try {
                                sessionTask.b(controllerInfoH);
                                break;
                            } catch (RemoteException e3) {
                                Log.i("MediaSessionLegacyStub", "Exception in " + controllerInfoH, e3);
                            }
                        }
                    }
                }
                break;
        }
    }

    public /* synthetic */ n0(MediaSessionLegacyStub mediaSessionLegacyStub, SessionCommand sessionCommand, int i2, MediaSessionManager.RemoteUserInfo remoteUserInfo, MediaSessionLegacyStub.SessionTask sessionTask) {
        this.f10712c = mediaSessionLegacyStub;
        this.f10713d = sessionCommand;
        this.f10711b = i2;
        this.f10714e = remoteUserInfo;
        this.f10715f = sessionTask;
    }
}
