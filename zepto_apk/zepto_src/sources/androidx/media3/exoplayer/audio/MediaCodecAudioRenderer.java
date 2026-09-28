package androidx.media3.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.MediaClock;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioCapabilitiesReceiver;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@UnstableApi
/* loaded from: classes3.dex */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    public int A1;
    public final Context o1;
    public final AudioRendererEventListener.EventDispatcher p1;
    public final DefaultAudioSink q1;
    public int r1;
    public boolean s1;
    public boolean t1;
    public Format u1;
    public Format v1;
    public long w1;
    public boolean x1;
    public boolean y1;
    public boolean z1;

    @RequiresApi
    public static final class Api23 {
        @DoNotInline
        public static void a(AudioSink audioSink, @Nullable Object obj) {
            audioSink.a((AudioDeviceInfo) obj);
        }
    }

    public final class AudioSinkListener implements AudioSink.Listener {
        public AudioSinkListener() {
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void a(AudioSink.AudioTrackConfig audioTrackConfig) {
            AudioRendererEventListener.EventDispatcher eventDispatcher = MediaCodecAudioRenderer.this.p1;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new c(eventDispatcher, audioTrackConfig, 0));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void b() {
            MediaCodecAudioRenderer.this.z1 = true;
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void c(AudioSink.AudioTrackConfig audioTrackConfig) {
            AudioRendererEventListener.EventDispatcher eventDispatcher = MediaCodecAudioRenderer.this.p1;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new c(eventDispatcher, audioTrackConfig, 1));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void d(boolean z) {
            AudioRendererEventListener.EventDispatcher eventDispatcher = MediaCodecAudioRenderer.this.p1;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new h(eventDispatcher, z, 0));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void e(Exception exc) {
            Log.e("MediaCodecAudioRenderer", "Audio sink error", exc);
            AudioRendererEventListener.EventDispatcher eventDispatcher = MediaCodecAudioRenderer.this.p1;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new d(eventDispatcher, exc, 1));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void f() {
            Renderer.WakeupListener wakeupListener = MediaCodecAudioRenderer.this.G;
            if (wakeupListener != null) {
                wakeupListener.a();
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void g(long j2, long j3, int i2) {
            AudioRendererEventListener.EventDispatcher eventDispatcher = MediaCodecAudioRenderer.this.p1;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new g(eventDispatcher, i2, j2, j3));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void h(long j2) {
            AudioRendererEventListener.EventDispatcher eventDispatcher = MediaCodecAudioRenderer.this.p1;
            Handler handler = eventDispatcher.f6523a;
            if (handler != null) {
                handler.post(new f(eventDispatcher, 0, j2));
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void i() {
            RendererCapabilities.Listener listener;
            MediaCodecAudioRenderer mediaCodecAudioRenderer = MediaCodecAudioRenderer.this;
            synchronized (mediaCodecAudioRenderer.f6112a) {
                listener = mediaCodecAudioRenderer.q;
            }
            if (listener != null) {
                listener.a(mediaCodecAudioRenderer);
            }
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void j() {
            MediaCodecAudioRenderer.this.x1 = true;
        }

        @Override // androidx.media3.exoplayer.audio.AudioSink.Listener
        public final void k() {
            Renderer.WakeupListener wakeupListener = MediaCodecAudioRenderer.this.G;
            if (wakeupListener != null) {
                wakeupListener.b();
            }
        }
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecAdapter.Factory factory, boolean z, Handler handler, AudioRendererEventListener audioRendererEventListener, DefaultAudioSink defaultAudioSink) {
        super(1, factory, z, 44100.0f);
        this.o1 = context.getApplicationContext();
        this.q1 = defaultAudioSink;
        this.A1 = -1000;
        this.p1 = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        defaultAudioSink.s = new AudioSinkListener();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public final MediaClock B() {
        return this;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final void D(PlaybackParameters playbackParameters) {
        this.q1.E(playbackParameters);
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final PlaybackParameters F() {
        return this.q1.D;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean F0(Format format) {
        RendererConfiguration rendererConfiguration = this.f6115d;
        rendererConfiguration.getClass();
        if (rendererConfiguration.f6357a != 0) {
            int iK0 = K0(format);
            if ((iK0 & 512) != 0) {
                RendererConfiguration rendererConfiguration2 = this.f6115d;
                rendererConfiguration2.getClass();
                if (rendererConfiguration2.f6357a == 2 || (iK0 & 1024) != 0) {
                    return true;
                }
                if (format.D == 0 && format.E == 0) {
                    return true;
                }
            }
        }
        return this.q1.H(format);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void G() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.p1;
        this.y1 = true;
        this.u1 = null;
        try {
            this.q1.g();
            try {
                super.G();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.G();
                throw th;
            } finally {
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final int G0(androidx.media3.exoplayer.mediacodec.d dVar, Format format) {
        int iK0;
        MediaCodecInfo mediaCodecInfoE;
        boolean z;
        if (!MimeTypes.l(format.f5225m)) {
            return RendererCapabilities.h(0, 0, 0, 0);
        }
        int i2 = Util.f5744a >= 21 ? 32 : 0;
        boolean z2 = true;
        int i3 = format.J;
        boolean z3 = i3 != 0;
        boolean z4 = i3 == 0 || i3 == 2;
        int i4 = 8;
        DefaultAudioSink defaultAudioSink = this.q1;
        if (!z4 || (z3 && MediaCodecUtil.e("audio/raw") == null)) {
            iK0 = 0;
        } else {
            iK0 = K0(format);
            if (defaultAudioSink.H(format)) {
                return RendererCapabilities.h(4, 8, i2, iK0);
            }
        }
        String str = format.f5225m;
        if ("audio/raw".equals(str) && !defaultAudioSink.H(format)) {
            return RendererCapabilities.h(1, 0, 0, 0);
        }
        Format.Builder builder = new Format.Builder();
        builder.d("audio/raw");
        builder.b(format.A);
        builder.e(format.B);
        builder.c(2);
        if (!defaultAudioSink.H(builder.a())) {
            return RendererCapabilities.h(1, 0, 0, 0);
        }
        List listR = str == null ? ImmutableList.r() : (!defaultAudioSink.H(format) || (mediaCodecInfoE = MediaCodecUtil.e("audio/raw")) == null) ? MediaCodecUtil.h(dVar, format, false, false) : ImmutableList.t(mediaCodecInfoE);
        if (((AbstractCollection) listR).isEmpty()) {
            return RendererCapabilities.h(1, 0, 0, 0);
        }
        if (!z4) {
            return RendererCapabilities.h(2, 0, 0, 0);
        }
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) listR.get(0);
        boolean zD = mediaCodecInfo.d(format);
        if (zD) {
            z = true;
            z2 = zD;
        } else {
            for (int i5 = 1; i5 < listR.size(); i5++) {
                MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) listR.get(i5);
                if (mediaCodecInfo2.d(format)) {
                    z = false;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
            }
            z = true;
            z2 = zD;
        }
        int i6 = z2 ? 4 : 3;
        if (z2 && mediaCodecInfo.e(format)) {
            i4 = 16;
        }
        return i6 | i4 | i2 | (mediaCodecInfo.f7326g ? 64 : 0) | (z ? 128 : 0) | iK0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void H(boolean z, boolean z2) throws IllegalStateException {
        super.H(z, z2);
        DecoderCounters decoderCounters = this.j1;
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.p1;
        Handler handler = eventDispatcher.f6523a;
        if (handler != null) {
            handler.post(new b(eventDispatcher, decoderCounters, 0));
        }
        RendererConfiguration rendererConfiguration = this.f6115d;
        rendererConfiguration.getClass();
        boolean z3 = rendererConfiguration.f6358b;
        DefaultAudioSink defaultAudioSink = this.q1;
        if (z3) {
            defaultAudioSink.f();
        } else {
            defaultAudioSink.d();
        }
        PlayerId playerId = this.f6117f;
        playerId.getClass();
        defaultAudioSink.r = playerId;
        SystemClock systemClock = this.f6118g;
        systemClock.getClass();
        defaultAudioSink.f6577i.J = systemClock;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void I(long j2, boolean z) throws IllegalStateException {
        super.I(j2, z);
        this.q1.g();
        this.w1 = j2;
        this.z1 = false;
        this.x1 = true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void J() {
        AudioCapabilitiesReceiver.AudioDeviceCallbackV23 audioDeviceCallbackV23;
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.q1.y;
        if (audioCapabilitiesReceiver == null || !audioCapabilitiesReceiver.f6509j) {
            return;
        }
        audioCapabilitiesReceiver.f6506g = null;
        int i2 = Util.f5744a;
        Context context = audioCapabilitiesReceiver.f6500a;
        if (i2 >= 23 && (audioDeviceCallbackV23 = audioCapabilitiesReceiver.f6503d) != null) {
            AudioCapabilitiesReceiver.Api23.b(context, audioDeviceCallbackV23);
        }
        BroadcastReceiver broadcastReceiver = audioCapabilitiesReceiver.f6504e;
        if (broadcastReceiver != null) {
            context.unregisterReceiver(broadcastReceiver);
        }
        AudioCapabilitiesReceiver.ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = audioCapabilitiesReceiver.f6505f;
        if (externalSurroundSoundSettingObserver != null) {
            externalSurroundSoundSettingObserver.f6511a.unregisterContentObserver(externalSurroundSoundSettingObserver);
        }
        audioCapabilitiesReceiver.f6509j = false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void K() throws IllegalStateException {
        DefaultAudioSink defaultAudioSink = this.q1;
        this.z1 = false;
        try {
            super.K();
        } finally {
            if (this.y1) {
                this.y1 = false;
                defaultAudioSink.y();
            }
        }
    }

    public final int K0(Format format) {
        AudioOffloadSupport audioOffloadSupportI = this.q1.i(format);
        if (!audioOffloadSupportI.f6517a) {
            return 0;
        }
        int i2 = audioOffloadSupportI.f6518b ? 1536 : 512;
        return audioOffloadSupportI.f6519c ? i2 | 2048 : i2;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void L() throws IllegalStateException {
        this.q1.u();
    }

    public final int L0(MediaCodecInfo mediaCodecInfo, Format format) {
        int i2;
        if (!"OMX.google.raw.decoder".equals(mediaCodecInfo.f7320a) || (i2 = Util.f5744a) >= 24 || (i2 == 23 && Util.R(this.o1))) {
            return format.n;
        }
        return -1;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void M() throws IllegalStateException {
        M0();
        this.q1.t();
    }

    public final void M0() {
        long jH = this.q1.h(c());
        if (jH != Long.MIN_VALUE) {
            if (!this.x1) {
                jH = Math.max(this.w1, jH);
            }
            this.w1 = jH;
            this.x1 = false;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final DecoderReuseEvaluation Q(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation decoderReuseEvaluationB = mediaCodecInfo.b(format, format2);
        boolean z = this.F == null && F0(format2);
        int i2 = decoderReuseEvaluationB.f6141e;
        if (z) {
            i2 |= 32768;
        }
        if (L0(mediaCodecInfo, format2) > this.r1) {
            i2 |= 64;
        }
        int i3 = i2;
        return new DecoderReuseEvaluation(mediaCodecInfo.f7320a, format, format2, i3 == 0 ? decoderReuseEvaluationB.f6140d : 0, i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public final boolean a() {
        return this.q1.n() || super.a();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final float b0(float f2, Format[] formatArr) {
        int iMax = -1;
        for (Format format : formatArr) {
            int i2 = format.B;
            if (i2 != -1) {
                iMax = Math.max(iMax, i2);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return iMax * f2;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public final boolean c() {
        return this.f1 && this.q1.q();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final ArrayList c0(androidx.media3.exoplayer.mediacodec.d dVar, Format format, boolean z) {
        MediaCodecInfo mediaCodecInfoE;
        Collection collectionR = format.f5225m == null ? ImmutableList.r() : (!this.q1.H(format) || (mediaCodecInfoE = MediaCodecUtil.e("audio/raw")) == null) ? MediaCodecUtil.h(dVar, format, z, false) : ImmutableList.t(mediaCodecInfoE);
        Pattern pattern = MediaCodecUtil.f7340a;
        ArrayList arrayList = new ArrayList(collectionR);
        Collections.sort(arrayList, new androidx.media3.exoplayer.mediacodec.f(new androidx.media3.exoplayer.mediacodec.e(format)));
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d3  */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Configuration d0(androidx.media3.exoplayer.mediacodec.MediaCodecInfo r12, androidx.media3.common.Format r13, android.media.MediaCrypto r14, float r15) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.MediaCodecAudioRenderer.d0(androidx.media3.exoplayer.mediacodec.MediaCodecInfo, androidx.media3.common.Format, android.media.MediaCrypto, float):androidx.media3.exoplayer.mediacodec.MediaCodecAdapter$Configuration");
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void g0(DecoderInputBuffer decoderInputBuffer) {
        Format format;
        DefaultAudioSink.Configuration configuration;
        if (Util.f5744a < 29 || (format = decoderInputBuffer.f6069b) == null || !Objects.equals(format.f5225m, "audio/opus") || !this.S0) {
            return;
        }
        ByteBuffer byteBuffer = decoderInputBuffer.f6074g;
        byteBuffer.getClass();
        Format format2 = decoderInputBuffer.f6069b;
        format2.getClass();
        if (byteBuffer.remaining() == 8) {
            int i2 = (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000);
            DefaultAudioSink defaultAudioSink = this.q1;
            AudioTrack audioTrack = defaultAudioSink.w;
            if (audioTrack == null || !DefaultAudioSink.r(audioTrack) || (configuration = defaultAudioSink.u) == null || !configuration.f6599k) {
                return;
            }
            defaultAudioSink.w.setOffloadDelayPadding(format2.D, i2);
        }
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public final String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void l0(Exception exc) {
        Log.e("MediaCodecAudioRenderer", "Audio codec error", exc);
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.p1;
        Handler handler = eventDispatcher.f6523a;
        if (handler != null) {
            handler.post(new d(eventDispatcher, exc, 0));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void m0(long j2, long j3, String str) {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.p1;
        Handler handler = eventDispatcher.f6523a;
        if (handler != null) {
            handler.post(new e(eventDispatcher, str, j2, j3, 0));
        }
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final boolean n() {
        boolean z = this.z1;
        this.z1 = false;
        return z;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void n0(String str) {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.p1;
        Handler handler = eventDispatcher.f6523a;
        if (handler != null) {
            handler.post(new androidx.constraintlayout.motion.widget.a(4, eventDispatcher, str));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public final void o(int i2, Object obj) throws IllegalStateException {
        DefaultAudioSink defaultAudioSink = this.q1;
        if (i2 == 2) {
            obj.getClass();
            defaultAudioSink.G(((Float) obj).floatValue());
            return;
        }
        if (i2 == 3) {
            AudioAttributes audioAttributes = (AudioAttributes) obj;
            audioAttributes.getClass();
            defaultAudioSink.z(audioAttributes);
            return;
        }
        if (i2 == 6) {
            AuxEffectInfo auxEffectInfo = (AuxEffectInfo) obj;
            auxEffectInfo.getClass();
            defaultAudioSink.C(auxEffectInfo);
            return;
        }
        if (i2 == 12) {
            if (Util.f5744a >= 23) {
                Api23.a(defaultAudioSink, obj);
                return;
            }
            return;
        }
        if (i2 != 16) {
            if (i2 == 9) {
                obj.getClass();
                defaultAudioSink.F(((Boolean) obj).booleanValue());
                return;
            } else if (i2 != 10) {
                super.o(i2, obj);
                return;
            } else {
                obj.getClass();
                defaultAudioSink.A(((Integer) obj).intValue());
                return;
            }
        }
        obj.getClass();
        this.A1 = ((Integer) obj).intValue();
        MediaCodecAdapter mediaCodecAdapter = this.L;
        if (mediaCodecAdapter != null && Util.f5744a >= 35) {
            Bundle bundle = new Bundle();
            bundle.putInt("importance", Math.max(0, -this.A1));
            mediaCodecAdapter.b(bundle);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final DecoderReuseEvaluation o0(FormatHolder formatHolder) throws ExoPlaybackException {
        Format format = formatHolder.f6254b;
        format.getClass();
        this.u1 = format;
        DecoderReuseEvaluation decoderReuseEvaluationO0 = super.o0(formatHolder);
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.p1;
        Handler handler = eventDispatcher.f6523a;
        if (handler != null) {
            handler.post(new androidx.media3.common.util.e(eventDispatcher, format, decoderReuseEvaluationO0, 2));
        }
        return decoderReuseEvaluationO0;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb A[Catch: ConfigurationException -> 0x00f9, TryCatch #0 {ConfigurationException -> 0x00f9, blocks: (B:42:0x00d9, B:45:0x00e1, B:47:0x00e5, B:49:0x00ee, B:52:0x00fb, B:53:0x00fe), top: B:57:0x00d9 }] */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p0(androidx.media3.common.Format r14, android.media.MediaFormat r15) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.MediaCodecAudioRenderer.p0(androidx.media3.common.Format, android.media.MediaFormat):void");
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void q0(long j2) {
        this.q1.getClass();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void s0() {
        this.q1.M = true;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final long w() {
        if (this.f6119h == 2) {
            M0();
        }
        return this.w1;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean w0(long r1, long r3, androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r5, java.nio.ByteBuffer r6, int r7, int r8, int r9, long r10, boolean r12, boolean r13, androidx.media3.common.Format r14) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r0 = this;
            r6.getClass()
            androidx.media3.common.Format r1 = r0.v1
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L14
            r1 = r8 & 2
            if (r1 == 0) goto L14
            r5.getClass()
            r5.m(r7, r3)
            return r2
        L14:
            androidx.media3.exoplayer.audio.DefaultAudioSink r1 = r0.q1
            if (r12 == 0) goto L27
            if (r5 == 0) goto L1d
            r5.m(r7, r3)
        L1d:
            androidx.media3.exoplayer.DecoderCounters r3 = r0.j1
            int r4 = r3.f6130f
            int r4 = r4 + r9
            r3.f6130f = r4
            r1.M = r2
            return r2
        L27:
            boolean r1 = r1.m(r6, r9, r10)     // Catch: androidx.media3.exoplayer.audio.AudioSink.WriteException -> L3b androidx.media3.exoplayer.audio.AudioSink.InitializationException -> L55
            if (r1 == 0) goto L3a
            if (r5 == 0) goto L32
            r5.m(r7, r3)
        L32:
            androidx.media3.exoplayer.DecoderCounters r1 = r0.j1
            int r3 = r1.f6129e
            int r3 = r3 + r9
            r1.f6129e = r3
            return r2
        L3a:
            return r3
        L3b:
            r1 = move-exception
            boolean r2 = r0.S0
            if (r2 == 0) goto L4c
            androidx.media3.exoplayer.RendererConfiguration r2 = r0.f6115d
            r2.getClass()
            int r2 = r2.f6357a
            if (r2 == 0) goto L4c
            r2 = 5003(0x138b, float:7.01E-42)
            goto L4e
        L4c:
            r2 = 5002(0x138a, float:7.009E-42)
        L4e:
            boolean r3 = r1.f6536b
            androidx.media3.exoplayer.ExoPlaybackException r1 = r0.C(r1, r14, r3, r2)
            throw r1
        L55:
            r1 = move-exception
            androidx.media3.common.Format r2 = r0.u1
            boolean r3 = r0.S0
            if (r3 == 0) goto L68
            androidx.media3.exoplayer.RendererConfiguration r3 = r0.f6115d
            r3.getClass()
            int r3 = r3.f6357a
            if (r3 == 0) goto L68
            r3 = 5004(0x138c, float:7.012E-42)
            goto L6a
        L68:
            r3 = 5001(0x1389, float:7.008E-42)
        L6a:
            boolean r4 = r1.f6533b
            androidx.media3.exoplayer.ExoPlaybackException r1 = r0.C(r1, r2, r4, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.MediaCodecAudioRenderer.w0(long, long, androidx.media3.exoplayer.mediacodec.MediaCodecAdapter, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, androidx.media3.common.Format):boolean");
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void z0() throws IllegalStateException, ExoPlaybackException {
        try {
            this.q1.w();
        } catch (AudioSink.WriteException e2) {
            throw C(e2, e2.f6537c, e2.f6536b, this.S0 ? 5003 : 5002);
        }
    }
}
