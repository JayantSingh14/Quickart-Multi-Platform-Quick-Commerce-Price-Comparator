package androidx.media3.session;

import android.os.Looper;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionImpl;
import com.google.common.collect.ImmutableList;

/* loaded from: classes3.dex */
public final /* synthetic */ class q0 implements MediaControllerStub.ControllerTask, MediaSessionImpl.RemoteControllerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Player.Commands f10738a;

    public /* synthetic */ q0(Player.Commands commands) {
        this.f10738a = commands;
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void a(MediaControllerImplBase mediaControllerImplBase) {
        boolean z;
        int i2 = MediaControllerStub.f10021b;
        if (mediaControllerImplBase.isConnected()) {
            Player.Commands commands = mediaControllerImplBase.t;
            Player.Commands commands2 = this.f10738a;
            if (Util.a(commands, commands2)) {
                return;
            }
            mediaControllerImplBase.t = commands2;
            Player.Commands commands3 = mediaControllerImplBase.u;
            Player.Commands commandsI = MediaControllerImplBase.i(mediaControllerImplBase.s, commands2);
            mediaControllerImplBase.u = commandsI;
            if (commandsI.equals(commands3)) {
                z = false;
            } else {
                ImmutableList immutableList = mediaControllerImplBase.q;
                ImmutableList immutableListA = CommandButton.a(mediaControllerImplBase.p, mediaControllerImplBase.r, mediaControllerImplBase.u);
                mediaControllerImplBase.q = immutableListA;
                z = !immutableListA.equals(immutableList);
                mediaControllerImplBase.f9978i.f(13, new i(mediaControllerImplBase, 19));
            }
            if (z) {
                MediaController mediaControllerO = mediaControllerImplBase.o();
                mediaControllerO.getClass();
                Assertions.g(Looper.myLooper() == mediaControllerO.f9958e.getLooper());
                mediaControllerO.f9957d.h();
            }
        }
    }

    @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
    public void d(MediaSession.ControllerCb controllerCb, int i2) {
        int i3 = MediaSessionImpl.B;
        controllerCb.e(i2, this.f10738a);
    }
}
