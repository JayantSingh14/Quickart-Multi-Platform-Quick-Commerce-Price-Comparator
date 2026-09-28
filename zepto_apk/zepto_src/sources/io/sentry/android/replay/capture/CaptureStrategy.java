package io.sentry.android.replay.capture;

import android.view.MotionEvent;
import androidx.compose.runtime.internal.StabilityInferred;
import io.sentry.Hint;
import io.sentry.IHub;
import io.sentry.ReplayRecording;
import io.sentry.SentryReplayEvent;
import io.sentry.android.replay.ScreenshotRecorderConfig;
import io.sentry.protocol.SentryId;
import io.sentry.rrweb.RRWebEvent;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public interface CaptureStrategy {

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:126:0x02ff  */
        /* JADX WARN: Removed duplicated region for block: B:182:0x01ac A[EDGE_INSN: B:182:0x01ac->B:77:0x01ac BREAK  A[LOOP:1: B:30:0x010a->B:75:0x01a3], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0173 A[PHI: r12 r22
          0x0173: PHI (r12v10 int) = (r12v8 int), (r12v7 int) binds: [B:58:0x016f, B:71:0x0192] A[DONT_GENERATE, DONT_INLINE]
          0x0173: PHI (r22v9 long) = (r22v6 long), (r22v10 long) binds: [B:58:0x016f, B:71:0x0192] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0194  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01a3 A[LOOP:1: B:30:0x010a->B:75:0x01a3, LOOP_END] */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, kotlin.Lazy] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static io.sentry.android.replay.capture.CaptureStrategy.ReplaySegment a(io.sentry.HubAdapter r26, io.sentry.SentryOptions r27, long r28, java.util.Date r30, io.sentry.protocol.SentryId r31, int r32, int r33, int r34, io.sentry.SentryReplayEvent.ReplayType r35, io.sentry.android.replay.ReplayCache r36, int r37, int r38, java.lang.String r39, java.util.List r40, java.util.Deque r41) {
            /*
                Method dump skipped, instructions count: 987
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.capture.CaptureStrategy.Companion.a(io.sentry.HubAdapter, io.sentry.SentryOptions, long, java.util.Date, io.sentry.protocol.SentryId, int, int, int, io.sentry.SentryReplayEvent$ReplayType, io.sentry.android.replay.ReplayCache, int, int, java.lang.String, java.util.List, java.util.Deque):io.sentry.android.replay.capture.CaptureStrategy$ReplaySegment");
        }

        public static void b(Deque events, long j2, Function1 function1) {
            Intrinsics.checkNotNullParameter(events, "events");
            Iterator it = events.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "events.iterator()");
            while (it.hasNext()) {
                RRWebEvent event = (RRWebEvent) it.next();
                if (event.f53031b < j2) {
                    if (function1 != null) {
                        Intrinsics.checkNotNullExpressionValue(event, "event");
                        ((CaptureStrategy$Companion$buildReplay$4) function1).invoke(event);
                    }
                    it.remove();
                }
            }
        }
    }

    @Metadata
    public static final class DefaultImpls {
    }

    @StabilityInferred(parameters = 0)
    @Metadata
    public static abstract class ReplaySegment {

        @StabilityInferred(parameters = 0)
        @Metadata
        @SourceDebugExtension
        public static final class Created extends ReplaySegment {

            /* renamed from: a, reason: collision with root package name */
            public final SentryReplayEvent f52586a;

            /* renamed from: b, reason: collision with root package name */
            public final ReplayRecording f52587b;

            public Created(SentryReplayEvent replay, ReplayRecording recording) {
                Intrinsics.checkNotNullParameter(replay, "replay");
                Intrinsics.checkNotNullParameter(recording, "recording");
                this.f52586a = replay;
                this.f52587b = recording;
            }

            public final void a(IHub iHub, Hint hint) {
                Intrinsics.checkNotNullParameter(hint, "hint");
                if (iHub != null) {
                    hint.f51641f = this.f52587b;
                    Unit unit = Unit.f53572a;
                    iHub.x(this.f52586a, hint);
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Created)) {
                    return false;
                }
                Created created = (Created) obj;
                return Intrinsics.b(this.f52586a, created.f52586a) && Intrinsics.b(this.f52587b, created.f52587b);
            }

            public final int hashCode() {
                return this.f52587b.hashCode() + (this.f52586a.hashCode() * 31);
            }

            public final String toString() {
                return "Created(replay=" + this.f52586a + ", recording=" + this.f52587b + ')';
            }
        }

        @StabilityInferred(parameters = 0)
        @Metadata
        public static final class Failed extends ReplaySegment {

            /* renamed from: a, reason: collision with root package name */
            public static final Failed f52588a = new Failed();
        }
    }

    void a(MotionEvent motionEvent);

    void b(ScreenshotRecorderConfig screenshotRecorderConfig);

    void c(ScreenshotRecorderConfig screenshotRecorderConfig, int i2, SentryId sentryId, SentryReplayEvent.ReplayType replayType);

    SentryId d();

    void e(int i2);

    int f();

    void g(boolean z, Function1 function1);

    CaptureStrategy h();

    void i(Date date);

    void j(Function2 function2);

    void pause();

    void resume();

    void stop();
}
