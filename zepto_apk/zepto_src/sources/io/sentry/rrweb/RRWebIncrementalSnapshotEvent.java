package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.Objects;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public abstract class RRWebIncrementalSnapshotEvent extends RRWebEvent {

    /* renamed from: c, reason: collision with root package name */
    public IncrementalSource f53032c;

    /* loaded from: classes3.dex */
    public static final class Deserializer {
        public static boolean a(RRWebIncrementalSnapshotEvent rRWebIncrementalSnapshotEvent, String str, ObjectReader objectReader, ILogger iLogger) {
            if (!str.equals("source")) {
                return false;
            }
            IncrementalSource incrementalSource = (IncrementalSource) objectReader.o0(iLogger, new IncrementalSource.Deserializer());
            Objects.b(incrementalSource, "");
            rRWebIncrementalSnapshotEvent.f53032c = incrementalSource;
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public enum IncrementalSource implements JsonSerializable {
        Mutation,
        MouseMove,
        MouseInteraction,
        Scroll,
        ViewportResize,
        Input,
        TouchMove,
        MediaInteraction,
        StyleSheetRule,
        CanvasMutation,
        Font,
        Log,
        Drag,
        StyleDeclaration,
        Selection,
        AdoptedStyleSheet,
        CustomElement;

        public static final class Deserializer implements JsonDeserializer<IncrementalSource> {
            @Override // io.sentry.JsonDeserializer
            public final Object a(ObjectReader objectReader, ILogger iLogger) {
                return IncrementalSource.values()[objectReader.nextInt()];
            }
        }

        @Override // io.sentry.JsonSerializable
        public void serialize(@NotNull ObjectWriter objectWriter, @NotNull ILogger iLogger) throws IOException {
            objectWriter.a(ordinal());
        }
    }

    /* loaded from: classes3.dex */
    public static final class JsonKeys {
    }

    /* loaded from: classes3.dex */
    public static final class Serializer {
        public static void a(RRWebIncrementalSnapshotEvent rRWebIncrementalSnapshotEvent, ObjectWriter objectWriter, ILogger iLogger) {
            objectWriter.d("source").h(iLogger, rRWebIncrementalSnapshotEvent.f53032c);
        }
    }

    public RRWebIncrementalSnapshotEvent(IncrementalSource incrementalSource) {
        super(RRWebEventType.IncrementalSnapshot);
        this.f53032c = incrementalSource;
    }
}
