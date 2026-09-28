package com.brentvatne.exoplayer;

import android.os.Bundle;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.session.MediaSession;
import androidx.media3.session.SessionCommand;
import androidx.media3.session.SessionCommands;
import com.brentvatne.exoplayer.VideoPlaybackService;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class VideoPlaybackCallback implements MediaSession.Callback {
    @Override // androidx.media3.session.MediaSession.Callback
    public final ListenableFuture a(MediaSession session, MediaSession.ControllerInfo controller, SessionCommand customCommand, Bundle args) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(customCommand, "customCommand");
        Intrinsics.checkNotNullParameter(args, "args");
        int i2 = VideoPlaybackService.n;
        String customAction = customCommand.f10234b;
        Intrinsics.checkNotNullExpressionValue(customAction, "customAction");
        VideoPlaybackService.Companion.b(VideoPlaybackService.Companion.a(customAction), session);
        ListenableFuture listenableFutureA = super.a(session, controller, customCommand, args);
        Intrinsics.checkNotNullExpressionValue(listenableFutureA, "onCustomCommand(...)");
        return listenableFutureA;
    }

    @Override // androidx.media3.session.MediaSession.Callback
    public final MediaSession.ConnectionResult b(MediaSession session, MediaSession.ControllerInfo controller) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(controller, "controller");
        try {
            MediaSession.ConnectionResult.AcceptedResultBuilder acceptedResultBuilder = new MediaSession.ConnectionResult.AcceptedResultBuilder(session);
            Player.Commands commands = MediaSession.ConnectionResult.f10073h;
            commands.getClass();
            Player.Commands.Builder builder = new Player.Commands.Builder(commands);
            FlagSet.Builder builder2 = builder.f5434a;
            builder2.a(12);
            builder2.a(11);
            acceptedResultBuilder.f10080b = builder.d();
            SessionCommands sessionCommands = MediaSession.ConnectionResult.f10071f;
            sessionCommands.getClass();
            SessionCommands.Builder builder3 = new SessionCommands.Builder(sessionCommands);
            VideoPlaybackService.Companion.COMMAND command = VideoPlaybackService.Companion.COMMAND.f15593a;
            Bundle bundle = Bundle.EMPTY;
            SessionCommand sessionCommand = new SessionCommand("COMMAND_SEEK_FORWARD", bundle);
            HashSet hashSet = builder3.f10239a;
            hashSet.add(sessionCommand);
            hashSet.add(new SessionCommand("COMMAND_SEEK_BACKWARD", bundle));
            acceptedResultBuilder.f10079a = builder3.b();
            MediaSession.ConnectionResult connectionResultA = acceptedResultBuilder.a();
            Intrinsics.checkNotNullExpressionValue(connectionResultA, "build(...)");
            return connectionResultA;
        } catch (Exception unused) {
            MediaSession.ConnectionResult connectionResult = new MediaSession.ConnectionResult(false, SessionCommands.f10236b, Player.Commands.f5430b, ImmutableList.r(), Bundle.EMPTY);
            Intrinsics.checkNotNullExpressionValue(connectionResult, "reject(...)");
            return connectionResult;
        }
    }
}
