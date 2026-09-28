package androidx.media3.session;

import android.os.Looper;
import androidx.media3.common.util.Assertions;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public final /* synthetic */ class i1 implements MediaSessionLegacyStub.SessionTask, MediaControllerStub.ControllerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10387a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10388b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10389c;

    public /* synthetic */ i1(int i2, List list) {
        this.f10387a = 2;
        this.f10389c = i2;
        this.f10388b = list;
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void a(MediaControllerImplBase mediaControllerImplBase) {
        int i2 = MediaControllerStub.f10021b;
        if (mediaControllerImplBase.isConnected()) {
            ImmutableList immutableList = mediaControllerImplBase.q;
            List list = (List) this.f10388b;
            mediaControllerImplBase.p = ImmutableList.o(list);
            ImmutableList immutableListA = CommandButton.a(list, mediaControllerImplBase.r, mediaControllerImplBase.u);
            mediaControllerImplBase.q = immutableListA;
            boolean zEquals = Objects.equals(immutableListA, immutableList);
            MediaController mediaControllerO = mediaControllerImplBase.o();
            mediaControllerO.getClass();
            Assertions.g(Looper.myLooper() == mediaControllerO.f9958e.getLooper());
            MediaController.Listener listener = mediaControllerO.f9957d;
            listener.getClass();
            ListenableFuture listenableFutureZ = MediaController.Listener.z();
            if (!zEquals) {
                listener.h();
            }
            int i3 = this.f10389c;
            mediaControllerImplBase.getClass();
            listenableFutureZ.q(new y0(mediaControllerImplBase, listenableFutureZ, i3), MoreExecutors.a());
        }
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void b(MediaSession.ControllerInfo controllerInfo) {
        switch (this.f10387a) {
            case 0:
                ((MediaSessionLegacyStub) this.f10388b).f10115g.s.d0(LegacyConversions.s(this.f10389c));
                break;
            default:
                ((MediaSessionLegacyStub) this.f10388b).f10115g.s.P0(LegacyConversions.u(this.f10389c));
                break;
        }
    }

    public /* synthetic */ i1(MediaSessionLegacyStub mediaSessionLegacyStub, int i2, int i3) {
        this.f10387a = i3;
        this.f10388b = mediaSessionLegacyStub;
        this.f10389c = i2;
    }
}
