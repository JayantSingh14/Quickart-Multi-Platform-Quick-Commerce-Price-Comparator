package androidx.media3.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.AudioProcessingPipeline;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.ToInt16PcmAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioCapabilitiesReceiver;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.AudioTrackPositionTracker;
import androidx.media3.exoplayer.audio.DefaultAudioOffloadSupportProvider;
import androidx.media3.exoplayer.audio.DefaultAudioTrackBufferSizeProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultAudioSink implements AudioSink {
    public static final Object m0 = new Object();
    public static ExecutorService n0;
    public static int o0;
    public AudioAttributes A;
    public MediaPositionParameters B;
    public MediaPositionParameters C;
    public PlaybackParameters D;
    public boolean E;
    public ByteBuffer F;
    public int G;
    public long H;
    public long I;
    public long J;
    public long K;
    public int L;
    public boolean M;
    public boolean N;
    public long O;
    public float P;
    public ByteBuffer Q;
    public int R;
    public ByteBuffer S;
    public byte[] T;
    public int U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6569a;
    public int a0;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultAudioProcessorChain f6570b;
    public AuxEffectInfo b0;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6571c;
    public AudioDeviceInfoApi23 c0;

    /* renamed from: d, reason: collision with root package name */
    public final ChannelMappingAudioProcessor f6572d;
    public boolean d0;

    /* renamed from: e, reason: collision with root package name */
    public final TrimmingAudioProcessor f6573e;
    public long e0;

    /* renamed from: f, reason: collision with root package name */
    public final ImmutableList f6574f;
    public long f0;

    /* renamed from: g, reason: collision with root package name */
    public final ImmutableList f6575g;
    public boolean g0;

    /* renamed from: h, reason: collision with root package name */
    public final ConditionVariable f6576h;
    public boolean h0;

    /* renamed from: i, reason: collision with root package name */
    public final AudioTrackPositionTracker f6577i;
    public Looper i0;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayDeque f6578j;
    public long j0;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f6579k;
    public long k0;

    /* renamed from: l, reason: collision with root package name */
    public int f6580l;
    public Handler l0;

    /* renamed from: m, reason: collision with root package name */
    public StreamEventCallbackV29 f6581m;
    public final PendingExceptionHolder n;
    public final PendingExceptionHolder o;
    public final DefaultAudioTrackBufferSizeProvider p;
    public final DefaultAudioOffloadSupportProvider q;
    public PlayerId r;
    public AudioSink.Listener s;
    public Configuration t;
    public Configuration u;
    public AudioProcessingPipeline v;
    public AudioTrack w;
    public AudioCapabilities x;
    public AudioCapabilitiesReceiver y;
    public OnRoutingChangedListenerApi24 z;

    @RequiresApi
    public static final class Api23 {
        @DoNotInline
        public static void a(AudioTrack audioTrack, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            audioTrack.setPreferredDevice(audioDeviceInfoApi23 == null ? null : audioDeviceInfoApi23.f6515a);
        }
    }

    @RequiresApi
    public static final class Api31 {
        @DoNotInline
        public static void a(AudioTrack audioTrack, PlayerId playerId) {
            LogSessionId logSessionIdA = playerId.a();
            LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            audioTrack.setLogSessionId(logSessionIdA);
        }
    }

    public interface AudioOffloadSupportProvider {
    }

    @Deprecated
    public interface AudioProcessorChain extends androidx.media3.common.audio.AudioProcessorChain {
    }

    public interface AudioTrackBufferSizeProvider {

        /* renamed from: a, reason: collision with root package name */
        public static final DefaultAudioTrackBufferSizeProvider f6582a;

        static {
            new DefaultAudioTrackBufferSizeProvider.Builder();
            f6582a = new DefaultAudioTrackBufferSizeProvider();
        }
    }

    public static final class Configuration {

        /* renamed from: a, reason: collision with root package name */
        public final Format f6589a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6590b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6591c;

        /* renamed from: d, reason: collision with root package name */
        public final int f6592d;

        /* renamed from: e, reason: collision with root package name */
        public final int f6593e;

        /* renamed from: f, reason: collision with root package name */
        public final int f6594f;

        /* renamed from: g, reason: collision with root package name */
        public final int f6595g;

        /* renamed from: h, reason: collision with root package name */
        public final int f6596h;

        /* renamed from: i, reason: collision with root package name */
        public final AudioProcessingPipeline f6597i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f6598j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f6599k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f6600l;

        public Configuration(Format format, int i2, int i3, int i4, int i5, int i6, int i7, int i8, AudioProcessingPipeline audioProcessingPipeline, boolean z, boolean z2, boolean z3) {
            this.f6589a = format;
            this.f6590b = i2;
            this.f6591c = i3;
            this.f6592d = i4;
            this.f6593e = i5;
            this.f6594f = i6;
            this.f6595g = i7;
            this.f6596h = i8;
            this.f6597i = audioProcessingPipeline;
            this.f6598j = z;
            this.f6599k = z2;
            this.f6600l = z3;
        }

        public static android.media.AudioAttributes c(AudioAttributes audioAttributes, boolean z) {
            return z ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : audioAttributes.b().f5155a;
        }

        public final AudioTrack a(androidx.media3.common.AudioAttributes audioAttributes, int i2) throws AudioSink.InitializationException {
            int i3 = this.f6591c;
            try {
                AudioTrack audioTrackB = b(audioAttributes, i2);
                int state = audioTrackB.getState();
                if (state == 1) {
                    return audioTrackB;
                }
                try {
                    audioTrackB.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.f6593e, this.f6594f, this.f6596h, this.f6589a, i3 == 1, null);
            } catch (IllegalArgumentException | UnsupportedOperationException e2) {
                throw new AudioSink.InitializationException(0, this.f6593e, this.f6594f, this.f6596h, this.f6589a, i3 == 1, e2);
            }
        }

        public final AudioTrack b(androidx.media3.common.AudioAttributes audioAttributes, int i2) {
            int i3;
            int i4 = Util.f5744a;
            int i5 = 0;
            boolean z = this.f6600l;
            int i6 = this.f6593e;
            int i7 = this.f6595g;
            int i8 = this.f6594f;
            if (i4 >= 29) {
                return new AudioTrack.Builder().setAudioAttributes(c(audioAttributes, z)).setAudioFormat(Util.r(i6, i8, i7)).setTransferMode(1).setBufferSizeInBytes(this.f6596h).setSessionId(i2).setOffloadedPlayback(this.f6591c == 1).build();
            }
            if (i4 >= 21) {
                return new AudioTrack(c(audioAttributes, z), Util.r(i6, i8, i7), this.f6596h, 1, i2);
            }
            int i9 = audioAttributes.f5151c;
            if (i9 != 13) {
                switch (i9) {
                    case 2:
                        break;
                    case 3:
                        i5 = 8;
                        break;
                    case 4:
                        i5 = 4;
                        break;
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        i5 = 5;
                        break;
                    case 6:
                        i5 = 2;
                        break;
                    default:
                        i5 = 3;
                        break;
                }
                i3 = i5;
            } else {
                i3 = 1;
            }
            if (i2 == 0) {
                return new AudioTrack(i3, this.f6593e, this.f6594f, this.f6595g, this.f6596h, 1);
            }
            return new AudioTrack(i3, this.f6593e, this.f6594f, this.f6595g, this.f6596h, 1, i2);
        }
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {

        /* renamed from: a, reason: collision with root package name */
        public final AudioProcessor[] f6601a;

        /* renamed from: b, reason: collision with root package name */
        public final SilenceSkippingAudioProcessor f6602b;

        /* renamed from: c, reason: collision with root package name */
        public final androidx.media3.common.audio.SonicAudioProcessor f6603c;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            SilenceSkippingAudioProcessor silenceSkippingAudioProcessor = new SilenceSkippingAudioProcessor();
            androidx.media3.common.audio.SonicAudioProcessor sonicAudioProcessor = new androidx.media3.common.audio.SonicAudioProcessor();
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f6601a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f6602b = silenceSkippingAudioProcessor;
            this.f6603c = sonicAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor;
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
    }

    public static final class MediaPositionParameters {

        /* renamed from: a, reason: collision with root package name */
        public final PlaybackParameters f6604a;

        /* renamed from: b, reason: collision with root package name */
        public final long f6605b;

        /* renamed from: c, reason: collision with root package name */
        public final long f6606c;

        public MediaPositionParameters(PlaybackParameters playbackParameters, long j2, long j3) {
            this.f6604a = playbackParameters;
            this.f6605b = j2;
            this.f6606c = j3;
        }
    }

    @RequiresApi
    public static final class OnRoutingChangedListenerApi24 {

        /* renamed from: a, reason: collision with root package name */
        public final AudioTrack f6607a;

        /* renamed from: b, reason: collision with root package name */
        public final AudioCapabilitiesReceiver f6608b;

        /* renamed from: c, reason: collision with root package name */
        public l f6609c = new AudioRouting.OnRoutingChangedListener() { // from class: androidx.media3.exoplayer.audio.l
            @Override // android.media.AudioRouting.OnRoutingChangedListener
            public final void onRoutingChanged(AudioRouting audioRouting) {
                this.f6666a.b(audioRouting);
            }
        };

        /* JADX WARN: Type inference failed for: r3v1, types: [androidx.media3.exoplayer.audio.l] */
        public OnRoutingChangedListenerApi24(AudioTrack audioTrack, AudioCapabilitiesReceiver audioCapabilitiesReceiver) {
            this.f6607a = audioTrack;
            this.f6608b = audioCapabilitiesReceiver;
            audioTrack.addOnRoutingChangedListener(this.f6609c, new Handler(Looper.myLooper()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @DoNotInline
        public void b(AudioRouting audioRouting) {
            if (this.f6609c == null || audioRouting.getRoutedDevice() == null) {
                return;
            }
            this.f6608b.b(audioRouting.getRoutedDevice());
        }

        @DoNotInline
        public void c() {
            l lVar = this.f6609c;
            lVar.getClass();
            this.f6607a.removeOnRoutingChangedListener(lVar);
            this.f6609c = null;
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputMode {
    }

    public static final class PendingExceptionHolder<T extends Exception> {

        /* renamed from: a, reason: collision with root package name */
        public Exception f6610a;

        /* renamed from: b, reason: collision with root package name */
        public long f6611b;

        public final void a(Exception exc) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f6610a == null) {
                this.f6610a = exc;
                this.f6611b = 100 + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.f6611b) {
                Exception exc2 = this.f6610a;
                if (exc2 != exc) {
                    exc2.addSuppressed(exc);
                }
                Exception exc3 = this.f6610a;
                this.f6610a = null;
                throw exc3;
            }
        }
    }

    public final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        public PositionTrackerListener() {
        }
    }

    @RequiresApi
    public final class StreamEventCallbackV29 {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f6613a = new Handler(Looper.myLooper());

        /* renamed from: b, reason: collision with root package name */
        public final AudioTrack$StreamEventCallback f6614b = new AudioTrack$StreamEventCallback() { // from class: androidx.media3.exoplayer.audio.DefaultAudioSink.StreamEventCallbackV29.1
            public final void onDataRequest(AudioTrack audioTrack, int i2) {
                DefaultAudioSink defaultAudioSink;
                AudioSink.Listener listener;
                if (audioTrack.equals(DefaultAudioSink.this.w) && (listener = (defaultAudioSink = DefaultAudioSink.this).s) != null && defaultAudioSink.Y) {
                    listener.k();
                }
            }

            public final void onPresentationEnded(AudioTrack audioTrack) {
                if (audioTrack.equals(DefaultAudioSink.this.w)) {
                    DefaultAudioSink.this.X = true;
                }
            }

            public final void onTearDown(AudioTrack audioTrack) {
                DefaultAudioSink defaultAudioSink;
                AudioSink.Listener listener;
                if (audioTrack.equals(DefaultAudioSink.this.w) && (listener = (defaultAudioSink = DefaultAudioSink.this).s) != null && defaultAudioSink.Y) {
                    listener.k();
                }
            }
        };

        public StreamEventCallbackV29() {
        }

        @DoNotInline
        public void a(AudioTrack audioTrack) {
            Handler handler = this.f6613a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new m(handler), this.f6614b);
        }

        @DoNotInline
        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f6614b);
            this.f6613a.removeCallbacksAndMessages(null);
        }
    }

    public DefaultAudioSink(Builder builder) {
        AudioCapabilities audioCapabilitiesC;
        Context context = builder.f6583a;
        this.f6569a = context;
        androidx.media3.common.AudioAttributes audioAttributes = androidx.media3.common.AudioAttributes.f5143g;
        this.A = audioAttributes;
        if (context != null) {
            AudioCapabilities audioCapabilities = AudioCapabilities.f6491c;
            int i2 = Util.f5744a;
            audioCapabilitiesC = AudioCapabilities.c(context, audioAttributes, null);
        } else {
            audioCapabilitiesC = builder.f6584b;
        }
        this.x = audioCapabilitiesC;
        this.f6570b = builder.f6585c;
        int i3 = Util.f5744a;
        this.f6571c = false;
        this.f6579k = false;
        this.f6580l = 0;
        this.p = builder.f6587e;
        DefaultAudioOffloadSupportProvider defaultAudioOffloadSupportProvider = builder.f6588f;
        defaultAudioOffloadSupportProvider.getClass();
        this.q = defaultAudioOffloadSupportProvider;
        ConditionVariable conditionVariable = new ConditionVariable(0);
        this.f6576h = conditionVariable;
        conditionVariable.e();
        this.f6577i = new AudioTrackPositionTracker(new PositionTrackerListener());
        ChannelMappingAudioProcessor channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.f6572d = channelMappingAudioProcessor;
        TrimmingAudioProcessor trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.f6573e = trimmingAudioProcessor;
        ToInt16PcmAudioProcessor toInt16PcmAudioProcessor = new ToInt16PcmAudioProcessor();
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        Object[] objArr = {toInt16PcmAudioProcessor, channelMappingAudioProcessor, trimmingAudioProcessor};
        ObjectArrays.a(3, objArr);
        this.f6574f = ImmutableList.m(3, objArr);
        this.f6575g = ImmutableList.t(new ToFloatPcmAudioProcessor());
        this.P = 1.0f;
        this.a0 = 0;
        this.b0 = new AuxEffectInfo();
        PlaybackParameters playbackParameters = PlaybackParameters.f5424d;
        this.C = new MediaPositionParameters(playbackParameters, 0L, 0L);
        this.D = playbackParameters;
        this.E = false;
        this.f6578j = new ArrayDeque();
        this.n = new PendingExceptionHolder();
        this.o = new PendingExceptionHolder();
    }

    public static boolean r(AudioTrack audioTrack) {
        return Util.f5744a >= 29 && audioTrack.isOffloadedPlayback();
    }

    public final void A(int i2) throws IllegalStateException {
        if (this.a0 != i2) {
            this.a0 = i2;
            this.Z = i2 != 0;
            g();
        }
    }

    public final void B() {
        if (p()) {
            try {
                this.w.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(this.D.f5427a).setPitch(this.D.f5428b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                Log.i("DefaultAudioSink", "Failed to set playback params", e2);
            }
            PlaybackParameters playbackParameters = new PlaybackParameters(this.w.getPlaybackParams().getSpeed(), this.w.getPlaybackParams().getPitch());
            this.D = playbackParameters;
            AudioTrackPositionTracker audioTrackPositionTracker = this.f6577i;
            audioTrackPositionTracker.f6560j = playbackParameters.f5427a;
            AudioTimestampPoller audioTimestampPoller = audioTrackPositionTracker.f6556f;
            if (audioTimestampPoller != null) {
                audioTimestampPoller.a();
            }
            audioTrackPositionTracker.d();
        }
    }

    public final void C(AuxEffectInfo auxEffectInfo) {
        if (this.b0.equals(auxEffectInfo)) {
            return;
        }
        auxEffectInfo.getClass();
        if (this.w != null) {
            this.b0.getClass();
        }
        this.b0 = auxEffectInfo;
    }

    public final void D(int i2) {
        Assertions.g(Util.f5744a >= 29);
        this.f6580l = i2;
    }

    public final void E(PlaybackParameters playbackParameters) {
        this.D = new PlaybackParameters(Util.j(playbackParameters.f5427a, 0.1f, 8.0f), Util.j(playbackParameters.f5428b, 0.1f, 8.0f));
        if (I()) {
            B();
            return;
        }
        MediaPositionParameters mediaPositionParameters = new MediaPositionParameters(playbackParameters, -9223372036854775807L, -9223372036854775807L);
        if (p()) {
            this.B = mediaPositionParameters;
        } else {
            this.C = mediaPositionParameters;
        }
    }

    public final void F(boolean z) {
        this.E = z;
        MediaPositionParameters mediaPositionParameters = new MediaPositionParameters(I() ? PlaybackParameters.f5424d : this.D, -9223372036854775807L, -9223372036854775807L);
        if (p()) {
            this.B = mediaPositionParameters;
        } else {
            this.C = mediaPositionParameters;
        }
    }

    public final void G(float f2) {
        if (this.P != f2) {
            this.P = f2;
            if (p()) {
                if (Util.f5744a >= 21) {
                    this.w.setVolume(this.P);
                    return;
                }
                AudioTrack audioTrack = this.w;
                float f3 = this.P;
                audioTrack.setStereoVolume(f3, f3);
            }
        }
    }

    public final boolean H(Format format) {
        return j(format) != 0;
    }

    public final boolean I() {
        Configuration configuration = this.u;
        return configuration != null && configuration.f6598j && Util.f5744a >= 23;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(java.nio.ByteBuffer r13, long r14) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.J(java.nio.ByteBuffer, long):void");
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public final void a(AudioDeviceInfo audioDeviceInfo) {
        this.c0 = audioDeviceInfo == null ? null : new AudioDeviceInfoApi23(audioDeviceInfo);
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.y;
        if (audioCapabilitiesReceiver != null) {
            audioCapabilitiesReceiver.b(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.w;
        if (audioTrack != null) {
            Api23.a(audioTrack, this.c0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r15) {
        /*
            r14 = this;
            boolean r0 = r14.I()
            androidx.media3.exoplayer.audio.DefaultAudioSink$DefaultAudioProcessorChain r1 = r14.f6570b
            r2 = 4
            r3 = 1610612736(0x60000000, float:3.6893488E19)
            r4 = 22
            r5 = 1342177280(0x50000000, float:8.5899346E9)
            r6 = 21
            boolean r7 = r14.f6571c
            if (r0 != 0) goto L57
            boolean r0 = r14.d0
            if (r0 != 0) goto L51
            androidx.media3.exoplayer.audio.DefaultAudioSink$Configuration r0 = r14.u
            int r8 = r0.f6591c
            if (r8 != 0) goto L51
            androidx.media3.common.Format r0 = r0.f6589a
            int r0 = r0.C
            if (r7 == 0) goto L30
            int r8 = androidx.media3.common.util.Util.f5744a
            if (r0 == r6) goto L51
            if (r0 == r5) goto L51
            if (r0 == r4) goto L51
            if (r0 == r3) goto L51
            if (r0 != r2) goto L30
            goto L51
        L30:
            androidx.media3.common.PlaybackParameters r0 = r14.D
            r1.getClass()
            float r8 = r0.f5427a
            androidx.media3.common.audio.SonicAudioProcessor r9 = r1.f6603c
            float r10 = r9.f5600c
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            r11 = 1
            if (r10 == 0) goto L44
            r9.f5600c = r8
            r9.f5606i = r11
        L44:
            float r8 = r9.f5601d
            float r10 = r0.f5428b
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L53
            r9.f5601d = r10
            r9.f5606i = r11
            goto L53
        L51:
            androidx.media3.common.PlaybackParameters r0 = androidx.media3.common.PlaybackParameters.f5424d
        L53:
            r14.D = r0
        L55:
            r9 = r0
            goto L5a
        L57:
            androidx.media3.common.PlaybackParameters r0 = androidx.media3.common.PlaybackParameters.f5424d
            goto L55
        L5a:
            boolean r0 = r14.d0
            if (r0 != 0) goto L7e
            androidx.media3.exoplayer.audio.DefaultAudioSink$Configuration r0 = r14.u
            int r8 = r0.f6591c
            if (r8 != 0) goto L7e
            androidx.media3.common.Format r0 = r0.f6589a
            int r0 = r0.C
            if (r7 == 0) goto L77
            int r7 = androidx.media3.common.util.Util.f5744a
            if (r0 == r6) goto L7e
            if (r0 == r5) goto L7e
            if (r0 == r4) goto L7e
            if (r0 == r3) goto L7e
            if (r0 != r2) goto L77
            goto L7e
        L77:
            boolean r0 = r14.E
            androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor r1 = r1.f6602b
            r1.o = r0
            goto L7f
        L7e:
            r0 = 0
        L7f:
            r14.E = r0
            java.util.ArrayDeque r0 = r14.f6578j
            androidx.media3.exoplayer.audio.DefaultAudioSink$MediaPositionParameters r8 = new androidx.media3.exoplayer.audio.DefaultAudioSink$MediaPositionParameters
            r1 = 0
            r3 = r15
            long r10 = java.lang.Math.max(r1, r3)
            androidx.media3.exoplayer.audio.DefaultAudioSink$Configuration r1 = r14.u
            long r2 = r14.l()
            int r1 = r1.f6593e
            long r12 = androidx.media3.common.util.Util.Z(r1, r2)
            r8.<init>(r9, r10, r12)
            r0.add(r8)
            androidx.media3.exoplayer.audio.DefaultAudioSink$Configuration r0 = r14.u
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r0.f6597i
            r14.v = r0
            r0.b()
            androidx.media3.exoplayer.audio.AudioSink$Listener r0 = r14.s
            if (r0 == 0) goto Lb0
            boolean r1 = r14.E
            r0.d(r1)
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.b(long):void");
    }

    public final void c(Format format, int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessingPipeline audioProcessingPipeline;
        int iIntValue;
        int iIntValue2;
        int i2;
        boolean z;
        int i3;
        int iC;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int iK;
        int i7;
        int i8;
        int iA;
        int[] iArr2;
        s();
        boolean zEquals = "audio/raw".equals(format.f5225m);
        boolean z3 = this.f6579k;
        String str = format.f5225m;
        int i9 = format.B;
        int i10 = format.A;
        if (zEquals) {
            int i11 = format.C;
            Assertions.a(Util.O(i11));
            int iC2 = Util.C(i11, i10);
            ImmutableList.Builder builder = new ImmutableList.Builder();
            if (this.f6571c && (i11 == 21 || i11 == 1342177280 || i11 == 22 || i11 == 1610612736 || i11 == 4)) {
                builder.f(this.f6575g);
            } else {
                builder.f(this.f6574f);
                builder.i(this.f6570b.f6601a);
            }
            audioProcessingPipeline = new AudioProcessingPipeline(builder.j());
            if (audioProcessingPipeline.equals(this.v)) {
                audioProcessingPipeline = this.v;
            }
            int i12 = format.D;
            TrimmingAudioProcessor trimmingAudioProcessor = this.f6573e;
            trimmingAudioProcessor.f6629i = i12;
            trimmingAudioProcessor.f6630j = format.E;
            if (Util.f5744a < 21 && i10 == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i13 = 0; i13 < 6; i13++) {
                    iArr2[i13] = i13;
                }
            } else {
                iArr2 = iArr;
            }
            this.f6572d.f6564i = iArr2;
            try {
                AudioProcessor.AudioFormat audioFormatA = audioProcessingPipeline.a(new AudioProcessor.AudioFormat(i9, i10, i11));
                int i14 = audioFormatA.f5575b;
                iIntValue2 = Util.s(i14);
                iIntValue = audioFormatA.f5576c;
                iC = Util.C(iIntValue, i14);
                i2 = audioFormatA.f5574a;
                z = z3;
                i3 = iC2;
                z2 = false;
                i4 = 0;
            } catch (AudioProcessor.UnhandledAudioFormatException e2) {
                throw new AudioSink.ConfigurationException(e2, format);
            }
        } else {
            audioProcessingPipeline = new AudioProcessingPipeline(ImmutableList.r());
            AudioOffloadSupport audioOffloadSupportI = this.f6580l != 0 ? i(format) : AudioOffloadSupport.f6516d;
            if (this.f6580l == 0 || !audioOffloadSupportI.f6517a) {
                Pair pairD = this.x.d(this.A, format);
                if (pairD == null) {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + format, format);
                }
                iIntValue = ((Integer) pairD.first).intValue();
                iIntValue2 = ((Integer) pairD.second).intValue();
                i2 = i9;
                z = z3;
                i3 = -1;
                iC = -1;
                z2 = false;
                i4 = 2;
            } else {
                str.getClass();
                int iD = MimeTypes.d(str, format.f5222j);
                int iS = Util.s(i10);
                z2 = audioOffloadSupportI.f6518b;
                iIntValue = iD;
                i3 = -1;
                i2 = i9;
                z = true;
                i4 = 1;
                iIntValue2 = iS;
                iC = -1;
            }
        }
        if (iIntValue == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i4 + ") for: " + format, format);
        }
        if (iIntValue2 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i4 + ") for: " + format, format);
        }
        boolean zEquals2 = "audio/vnd.dts.hd;profile=lbr".equals(str);
        int i15 = format.f5221i;
        if (zEquals2 && i15 == -1) {
            i15 = 768000;
        }
        DefaultAudioTrackBufferSizeProvider defaultAudioTrackBufferSizeProvider = this.p;
        int minBufferSize = AudioTrack.getMinBufferSize(i2, iIntValue2, iIntValue);
        Assertions.g(minBufferSize != -2);
        int i16 = iC != -1 ? iC : 1;
        double d2 = z ? 8.0d : 1.0d;
        defaultAudioTrackBufferSizeProvider.getClass();
        if (i4 != 0) {
            if (i4 == 1) {
                i5 = i3;
                iK = Ints.b((50000000 * DefaultAudioTrackBufferSizeProvider.a(iIntValue)) / 1000000);
            } else {
                if (i4 != 2) {
                    throw new IllegalArgumentException();
                }
                if (iIntValue == 5) {
                    i8 = 500000;
                    i7 = 8;
                } else {
                    i7 = 8;
                    i8 = iIntValue == 8 ? 1000000 : 250000;
                }
                if (i15 != -1) {
                    RoundingMode roundingMode = RoundingMode.CEILING;
                    iA = IntMath.c(i15, i7);
                } else {
                    iA = DefaultAudioTrackBufferSizeProvider.a(iIntValue);
                }
                i5 = i3;
                iK = Ints.b((i8 * iA) / 1000000);
            }
            i6 = i2;
        } else {
            i5 = i3;
            long j2 = i2;
            long j3 = 250000 * j2;
            long j4 = i16;
            int iB = Ints.b((j3 * j4) / 1000000);
            i6 = i2;
            iK = Util.k(minBufferSize * 4, iB, Ints.b(((750000 * j2) * j4) / 1000000));
        }
        this.g0 = false;
        Configuration configuration = new Configuration(format, i5, i4, iC, i6, iIntValue2, iIntValue, (((Math.max(minBufferSize, (int) (iK * d2)) + i16) - 1) / i16) * i16, audioProcessingPipeline, z, z2, this.d0);
        if (p()) {
            this.t = configuration;
        } else {
            this.u = configuration;
        }
    }

    public final void d() throws IllegalStateException {
        if (this.d0) {
            this.d0 = false;
            g();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e() throws java.lang.Exception {
        /*
            r6 = this;
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r6.v
            boolean r0 = r0.e()
            r1 = -9223372036854775808
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L19
            java.nio.ByteBuffer r0 = r6.S
            if (r0 != 0) goto L11
            goto L48
        L11:
            r6.J(r0, r1)
            java.nio.ByteBuffer r0 = r6.S
            if (r0 != 0) goto L49
            goto L48
        L19:
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r6.v
            boolean r5 = r0.e()
            if (r5 == 0) goto L33
            boolean r5 = r0.f5571d
            if (r5 == 0) goto L26
            goto L33
        L26:
            r0.f5571d = r4
            java.util.ArrayList r0 = r0.f5569b
            java.lang.Object r0 = r0.get(r3)
            androidx.media3.common.audio.AudioProcessor r0 = (androidx.media3.common.audio.AudioProcessor) r0
            r0.f()
        L33:
            r6.x(r1)
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r6.v
            boolean r0 = r0.d()
            if (r0 == 0) goto L49
            java.nio.ByteBuffer r0 = r6.S
            if (r0 == 0) goto L48
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L49
        L48:
            return r4
        L49:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.e():boolean");
    }

    public final void f() throws IllegalStateException {
        Assertions.g(Util.f5744a >= 21);
        Assertions.g(this.Z);
        if (this.d0) {
            return;
        }
        this.d0 = true;
        g();
    }

    public final void g() throws IllegalStateException {
        OnRoutingChangedListenerApi24 onRoutingChangedListenerApi24;
        if (p()) {
            this.H = 0L;
            this.I = 0L;
            this.J = 0L;
            this.K = 0L;
            this.h0 = false;
            this.L = 0;
            this.C = new MediaPositionParameters(this.D, 0L, 0L);
            this.O = 0L;
            this.B = null;
            this.f6578j.clear();
            this.Q = null;
            this.R = 0;
            this.S = null;
            this.W = false;
            this.V = false;
            this.X = false;
            this.F = null;
            this.G = 0;
            this.f6573e.o = 0L;
            AudioProcessingPipeline audioProcessingPipeline = this.u.f6597i;
            this.v = audioProcessingPipeline;
            audioProcessingPipeline.b();
            AudioTrack audioTrack = this.f6577i.f6553c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 3) {
                this.w.pause();
            }
            if (r(this.w)) {
                StreamEventCallbackV29 streamEventCallbackV29 = this.f6581m;
                streamEventCallbackV29.getClass();
                streamEventCallbackV29.b(this.w);
            }
            int i2 = Util.f5744a;
            if (i2 < 21 && !this.Z) {
                this.a0 = 0;
            }
            Configuration configuration = this.u;
            AudioSink.AudioTrackConfig audioTrackConfig = new AudioSink.AudioTrackConfig(configuration.f6595g, configuration.f6593e, configuration.f6594f, configuration.f6596h, configuration.f6600l, configuration.f6591c == 1);
            Configuration configuration2 = this.t;
            if (configuration2 != null) {
                this.u = configuration2;
                this.t = null;
            }
            AudioTrackPositionTracker audioTrackPositionTracker = this.f6577i;
            audioTrackPositionTracker.d();
            audioTrackPositionTracker.f6553c = null;
            audioTrackPositionTracker.f6556f = null;
            if (i2 >= 24 && (onRoutingChangedListenerApi24 = this.z) != null) {
                onRoutingChangedListenerApi24.c();
                this.z = null;
            }
            AudioTrack audioTrack2 = this.w;
            ConditionVariable conditionVariable = this.f6576h;
            AudioSink.Listener listener = this.s;
            conditionVariable.c();
            Handler handler = new Handler(Looper.myLooper());
            synchronized (m0) {
                try {
                    if (n0 == null) {
                        n0 = Executors.newSingleThreadExecutor(new androidx.media3.common.util.d("ExoPlayer:AudioTrackReleaseThread"));
                    }
                    o0++;
                    n0.execute(new i(audioTrack2, listener, handler, audioTrackConfig, conditionVariable, 0));
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.w = null;
        }
        this.o.f6610a = null;
        this.n.f6610a = null;
        this.j0 = 0L;
        this.k0 = 0L;
        Handler handler2 = this.l0;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public final long h(boolean z) {
        ArrayDeque arrayDeque;
        long jZ;
        if (!p() || this.N) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.f6577i.a(z), Util.Z(this.u.f6593e, l()));
        while (true) {
            arrayDeque = this.f6578j;
            if (arrayDeque.isEmpty() || jMin < ((MediaPositionParameters) arrayDeque.getFirst()).f6606c) {
                break;
            }
            this.C = (MediaPositionParameters) arrayDeque.remove();
        }
        long jB = jMin - this.C.f6606c;
        boolean zIsEmpty = arrayDeque.isEmpty();
        DefaultAudioProcessorChain defaultAudioProcessorChain = this.f6570b;
        if (zIsEmpty) {
            androidx.media3.common.audio.SonicAudioProcessor sonicAudioProcessor = defaultAudioProcessorChain.f6603c;
            if (sonicAudioProcessor.a()) {
                jB = sonicAudioProcessor.b(jB);
            }
            jZ = this.C.f6605b + jB;
        } else {
            MediaPositionParameters mediaPositionParameters = (MediaPositionParameters) arrayDeque.getFirst();
            jZ = mediaPositionParameters.f6605b - Util.z(mediaPositionParameters.f6606c - jMin, this.C.f6604a.f5427a);
        }
        long j2 = defaultAudioProcessorChain.f6602b.q;
        long jZ2 = Util.Z(this.u.f6593e, j2) + jZ;
        long j3 = this.j0;
        if (j2 > j3) {
            long jZ3 = Util.Z(this.u.f6593e, j2 - j3);
            this.j0 = j2;
            this.k0 += jZ3;
            if (this.l0 == null) {
                this.l0 = new Handler(Looper.myLooper());
            }
            this.l0.removeCallbacksAndMessages(null);
            this.l0.postDelayed(new Runnable() { // from class: androidx.media3.exoplayer.audio.j
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultAudioSink defaultAudioSink = this.f6664a;
                    if (defaultAudioSink.k0 >= 300000) {
                        defaultAudioSink.s.b();
                        defaultAudioSink.k0 = 0L;
                    }
                }
            }, 100L);
        }
        return jZ2;
    }

    public final AudioOffloadSupport i(Format format) {
        int i2;
        boolean zBooleanValue;
        AudioManager audioManager;
        if (this.g0) {
            return AudioOffloadSupport.f6516d;
        }
        androidx.media3.common.AudioAttributes audioAttributes = this.A;
        DefaultAudioOffloadSupportProvider defaultAudioOffloadSupportProvider = this.q;
        defaultAudioOffloadSupportProvider.getClass();
        format.getClass();
        audioAttributes.getClass();
        int i3 = Util.f5744a;
        if (i3 < 29 || (i2 = format.B) == -1) {
            return AudioOffloadSupport.f6516d;
        }
        Boolean bool = defaultAudioOffloadSupportProvider.f6568b;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            Context context = defaultAudioOffloadSupportProvider.f6567a;
            if (context == null || (audioManager = (AudioManager) context.getSystemService("audio")) == null) {
                defaultAudioOffloadSupportProvider.f6568b = Boolean.FALSE;
            } else {
                String parameters = audioManager.getParameters("offloadVariableRateSupported");
                defaultAudioOffloadSupportProvider.f6568b = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
            }
            zBooleanValue = defaultAudioOffloadSupportProvider.f6568b.booleanValue();
        }
        String str = format.f5225m;
        str.getClass();
        int iD = MimeTypes.d(str, format.f5222j);
        if (iD == 0 || i3 < Util.q(iD)) {
            return AudioOffloadSupport.f6516d;
        }
        int iS = Util.s(format.A);
        if (iS == 0) {
            return AudioOffloadSupport.f6516d;
        }
        try {
            AudioFormat audioFormatR = Util.r(i2, iS, iD);
            return i3 >= 31 ? DefaultAudioOffloadSupportProvider.Api31.a(audioFormatR, audioAttributes.b().f5155a, zBooleanValue) : DefaultAudioOffloadSupportProvider.Api29.a(audioFormatR, audioAttributes.b().f5155a, zBooleanValue);
        } catch (IllegalArgumentException unused) {
            return AudioOffloadSupport.f6516d;
        }
    }

    public final int j(Format format) {
        s();
        if (!"audio/raw".equals(format.f5225m)) {
            return this.x.d(this.A, format) != null ? 2 : 0;
        }
        int i2 = format.C;
        if (Util.O(i2)) {
            return (i2 == 2 || (this.f6571c && i2 == 4)) ? 2 : 1;
        }
        Log.h("DefaultAudioSink", "Invalid PCM encoding: " + i2);
        return 0;
    }

    public final long k() {
        return this.u.f6591c == 0 ? this.H / r0.f6590b : this.I;
    }

    public final long l() {
        Configuration configuration = this.u;
        if (configuration.f6591c != 0) {
            return this.K;
        }
        long j2 = this.J;
        long j3 = configuration.f6592d;
        int i2 = Util.f5744a;
        return ((j2 + j3) - 1) / j3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0389, code lost:
    
        if (r13 == 0) goto L208;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(java.nio.ByteBuffer r26, int r27, long r28) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.m(java.nio.ByteBuffer, int, long):boolean");
    }

    public final boolean n() {
        if (p()) {
            return !(Util.f5744a >= 29 && this.w.isOffloadedPlayback() && this.X) && this.f6577i.c(l());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o() throws androidx.media3.exoplayer.audio.AudioSink.InitializationException {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.o():boolean");
    }

    public final boolean p() {
        return this.w != null;
    }

    public final boolean q() {
        if (p()) {
            return this.V && !n();
        }
        return true;
    }

    public final void s() {
        Context context;
        AudioCapabilities audioCapabilitiesB;
        AudioCapabilitiesReceiver.AudioDeviceCallbackV23 audioDeviceCallbackV23;
        if (this.y != null || (context = this.f6569a) == null) {
            return;
        }
        this.i0 = Looper.myLooper();
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = new AudioCapabilitiesReceiver(context, new k(this), this.A, this.c0);
        this.y = audioCapabilitiesReceiver;
        if (audioCapabilitiesReceiver.f6509j) {
            audioCapabilitiesB = audioCapabilitiesReceiver.f6506g;
            audioCapabilitiesB.getClass();
        } else {
            audioCapabilitiesReceiver.f6509j = true;
            AudioCapabilitiesReceiver.ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = audioCapabilitiesReceiver.f6505f;
            if (externalSurroundSoundSettingObserver != null) {
                externalSurroundSoundSettingObserver.f6511a.registerContentObserver(externalSurroundSoundSettingObserver.f6512b, false, externalSurroundSoundSettingObserver);
            }
            int i2 = Util.f5744a;
            Handler handler = audioCapabilitiesReceiver.f6502c;
            Context context2 = audioCapabilitiesReceiver.f6500a;
            if (i2 >= 23 && (audioDeviceCallbackV23 = audioCapabilitiesReceiver.f6503d) != null) {
                AudioCapabilitiesReceiver.Api23.a(context2, audioDeviceCallbackV23, handler);
            }
            BroadcastReceiver broadcastReceiver = audioCapabilitiesReceiver.f6504e;
            audioCapabilitiesB = AudioCapabilities.b(context2, broadcastReceiver != null ? context2.registerReceiver(broadcastReceiver, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, handler) : null, audioCapabilitiesReceiver.f6508i, audioCapabilitiesReceiver.f6507h);
            audioCapabilitiesReceiver.f6506g = audioCapabilitiesB;
        }
        this.x = audioCapabilitiesB;
    }

    public final void t() throws IllegalStateException {
        this.Y = false;
        if (p()) {
            AudioTrackPositionTracker audioTrackPositionTracker = this.f6577i;
            audioTrackPositionTracker.d();
            if (audioTrackPositionTracker.y == -9223372036854775807L) {
                AudioTimestampPoller audioTimestampPoller = audioTrackPositionTracker.f6556f;
                audioTimestampPoller.getClass();
                audioTimestampPoller.a();
            } else {
                audioTrackPositionTracker.A = audioTrackPositionTracker.b();
                if (!r(this.w)) {
                    return;
                }
            }
            this.w.pause();
        }
    }

    public final void u() throws IllegalStateException {
        this.Y = true;
        if (p()) {
            AudioTrackPositionTracker audioTrackPositionTracker = this.f6577i;
            if (audioTrackPositionTracker.y != -9223372036854775807L) {
                audioTrackPositionTracker.J.getClass();
                audioTrackPositionTracker.y = Util.T(SystemClock.elapsedRealtime());
            }
            AudioTimestampPoller audioTimestampPoller = audioTrackPositionTracker.f6556f;
            audioTimestampPoller.getClass();
            audioTimestampPoller.a();
            this.w.play();
        }
    }

    public final void v() throws IllegalStateException {
        if (this.W) {
            return;
        }
        this.W = true;
        long jL = l();
        AudioTrackPositionTracker audioTrackPositionTracker = this.f6577i;
        audioTrackPositionTracker.A = audioTrackPositionTracker.b();
        audioTrackPositionTracker.J.getClass();
        audioTrackPositionTracker.y = Util.T(SystemClock.elapsedRealtime());
        audioTrackPositionTracker.B = jL;
        if (r(this.w)) {
            this.X = false;
        }
        this.w.stop();
        this.G = 0;
    }

    public final void w() throws IllegalStateException {
        if (!this.V && p() && e()) {
            v();
            this.V = true;
        }
    }

    public final void x(long j2) throws Exception {
        ByteBuffer byteBuffer;
        if (!this.v.e()) {
            ByteBuffer byteBuffer2 = this.Q;
            if (byteBuffer2 == null) {
                byteBuffer2 = AudioProcessor.f5572a;
            }
            J(byteBuffer2, j2);
            return;
        }
        while (!this.v.d()) {
            do {
                AudioProcessingPipeline audioProcessingPipeline = this.v;
                if (audioProcessingPipeline.e()) {
                    ByteBuffer byteBuffer3 = audioProcessingPipeline.f5570c[audioProcessingPipeline.c()];
                    if (byteBuffer3.hasRemaining()) {
                        byteBuffer = byteBuffer3;
                    } else {
                        audioProcessingPipeline.f(AudioProcessor.f5572a);
                        byteBuffer = audioProcessingPipeline.f5570c[audioProcessingPipeline.c()];
                    }
                } else {
                    byteBuffer = AudioProcessor.f5572a;
                }
                if (byteBuffer.hasRemaining()) {
                    J(byteBuffer, j2);
                } else {
                    ByteBuffer byteBuffer4 = this.Q;
                    if (byteBuffer4 == null || !byteBuffer4.hasRemaining()) {
                        return;
                    }
                    AudioProcessingPipeline audioProcessingPipeline2 = this.v;
                    ByteBuffer byteBuffer5 = this.Q;
                    if (audioProcessingPipeline2.e() && !audioProcessingPipeline2.f5571d) {
                        audioProcessingPipeline2.f(byteBuffer5);
                    }
                }
            } while (!byteBuffer.hasRemaining());
            return;
        }
    }

    public final void y() throws IllegalStateException {
        g();
        UnmodifiableListIterator unmodifiableListIteratorListIterator = this.f6574f.listIterator(0);
        while (unmodifiableListIteratorListIterator.hasNext()) {
            ((AudioProcessor) unmodifiableListIteratorListIterator.next()).reset();
        }
        UnmodifiableListIterator unmodifiableListIteratorListIterator2 = this.f6575g.listIterator(0);
        while (unmodifiableListIteratorListIterator2.hasNext()) {
            ((AudioProcessor) unmodifiableListIteratorListIterator2.next()).reset();
        }
        AudioProcessingPipeline audioProcessingPipeline = this.v;
        if (audioProcessingPipeline != null) {
            int i2 = 0;
            while (true) {
                ImmutableList immutableList = audioProcessingPipeline.f5568a;
                if (i2 >= immutableList.size()) {
                    break;
                }
                AudioProcessor audioProcessor = (AudioProcessor) immutableList.get(i2);
                audioProcessor.flush();
                audioProcessor.reset();
                i2++;
            }
            audioProcessingPipeline.f5570c = new ByteBuffer[0];
            AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f5573e;
            audioProcessingPipeline.f5571d = false;
        }
        this.Y = false;
        this.g0 = false;
    }

    public final void z(androidx.media3.common.AudioAttributes audioAttributes) throws IllegalStateException {
        if (this.A.equals(audioAttributes)) {
            return;
        }
        this.A = audioAttributes;
        if (this.d0) {
            return;
        }
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.y;
        if (audioCapabilitiesReceiver != null) {
            audioCapabilitiesReceiver.f6508i = audioAttributes;
            audioCapabilitiesReceiver.a(AudioCapabilities.c(audioCapabilitiesReceiver.f6500a, audioAttributes, audioCapabilitiesReceiver.f6507h));
        }
        g();
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f6583a;

        /* renamed from: b, reason: collision with root package name */
        public AudioCapabilities f6584b;

        /* renamed from: c, reason: collision with root package name */
        public DefaultAudioProcessorChain f6585c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f6586d;

        /* renamed from: e, reason: collision with root package name */
        public final DefaultAudioTrackBufferSizeProvider f6587e;

        /* renamed from: f, reason: collision with root package name */
        public DefaultAudioOffloadSupportProvider f6588f;

        @Deprecated
        public Builder() {
            this.f6583a = null;
            this.f6584b = AudioCapabilities.f6491c;
            this.f6587e = AudioTrackBufferSizeProvider.f6582a;
        }

        public final DefaultAudioSink a() {
            Assertions.g(!this.f6586d);
            this.f6586d = true;
            if (this.f6585c == null) {
                this.f6585c = new DefaultAudioProcessorChain(new AudioProcessor[0]);
            }
            if (this.f6588f == null) {
                this.f6588f = new DefaultAudioOffloadSupportProvider(this.f6583a);
            }
            return new DefaultAudioSink(this);
        }

        public Builder(Context context) {
            this.f6583a = context;
            this.f6584b = AudioCapabilities.f6491c;
            this.f6587e = AudioTrackBufferSizeProvider.f6582a;
        }
    }
}
