package androidx.media3.exoplayer;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BasePlayer;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.TrackSelectionArray;
import androidx.media3.exoplayer.util.EventLogger;
import java.util.List;

@UnstableApi
@Deprecated
/* loaded from: classes3.dex */
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {

    @Deprecated
    public static final class Builder {
    }

    @Override // androidx.media3.common.Player
    public final void A0(Player.Listener listener) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long A1() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int B0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void C0(boolean z) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void D(PlaybackParameters playbackParameters) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void D0(Player.Listener listener) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int E0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackParameters F() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final Timeline F0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final Looper F1() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int G() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void G0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final TrackSelectionParameters H0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void J0(TextureView textureView) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int K0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final Player.Commands N0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final boolean O0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void P0(boolean z) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long Q0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int T0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void U0(TextureView textureView) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final VideoSize V0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void W0(AudioAttributes audioAttributes, boolean z) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final AudioAttributes X0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final DeviceInfo Y0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void Z0(int i2, int i3) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackException a() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int a1() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final boolean b() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void b1(float f2) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void c(MediaSource mediaSource, boolean z) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void c1(List list, int i2, long j2) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void d(MediaSource mediaSource, long j2) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void d0(int i2) {
        throw null;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void e(AnalyticsListener analyticsListener) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void e0(Surface surface) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long e1() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final Format f() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final boolean f0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long f1() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final TrackSelectionArray g() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long g0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void g1(int i2, List list) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long getDuration() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final float getVolume() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final int h(int i2) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long h1() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final int i() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata i1() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void j(EventLogger eventLogger) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void l0(int i2, boolean z) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int l1() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void m0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void m1(TrackSelectionParameters trackSelectionParameters) {
        throw null;
    }

    @Override // androidx.media3.common.BasePlayer
    public final void n(int i2, long j2, boolean z) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void n0(int i2) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void n1(SurfaceView surfaceView) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void o0(SurfaceView surfaceView) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void p() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void p0(int i2, int i3, List list) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void p1(int i2, int i3, int i4) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void q0(MediaMetadata mediaMetadata) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final boolean r1() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void release() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void s0(int i2, int i3) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final boolean s1() {
        throw null;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void setImageOutput(ImageOutput imageOutput) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void stop() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long t1() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final int u() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void u0(boolean z) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void u1(int i2) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void x0(int i2) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata x1() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final Tracks y0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final void y1(List list) {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final CueGroup z0() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final long z1() {
        throw null;
    }

    @Override // androidx.media3.common.Player
    public final ExoPlaybackException a() {
        throw null;
    }
}
