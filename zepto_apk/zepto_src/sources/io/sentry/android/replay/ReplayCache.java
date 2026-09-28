package io.sentry.android.replay;

import androidx.compose.runtime.internal.StabilityInferred;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.replay.ReplayCache;
import io.sentry.android.replay.video.SimpleVideoEncoder;
import io.sentry.protocol.SentryId;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.KEYRecord;

@StabilityInferred(parameters = 0)
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReplayCache implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f52417a;

    /* renamed from: b, reason: collision with root package name */
    public final SentryId f52418b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f52419c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f52420d;

    /* renamed from: e, reason: collision with root package name */
    public SimpleVideoEncoder f52421e;

    /* renamed from: f, reason: collision with root package name */
    public final Lazy f52422f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f52423g;

    /* renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f52424h;

    /* renamed from: i, reason: collision with root package name */
    public final Lazy f52425i;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static File a(SentryOptions options, SentryId replayId) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(replayId, "replayId");
            String cacheDirPath = options.getCacheDirPath();
            if (cacheDirPath == null || cacheDirPath.length() == 0) {
                options.getLogger().c(SentryLevel.WARNING, "SentryOptions.cacheDirPath is not set, session replay is no-op", new Object[0]);
                return null;
            }
            String cacheDirPath2 = options.getCacheDirPath();
            Intrinsics.c(cacheDirPath2);
            File file = new File(cacheDirPath2, "replay_" + replayId);
            file.mkdirs();
            return file;
        }
    }

    public ReplayCache(SentryOptions options, SentryId replayId) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(replayId, "replayId");
        this.f52417a = options;
        this.f52418b = replayId;
        this.f52419c = new AtomicBoolean(false);
        this.f52420d = new Object();
        this.f52422f = LazyKt.b(new Function0<File>() { // from class: io.sentry.android.replay.ReplayCache$replayCacheDir$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ReplayCache replayCache = this.f52428c;
                return ReplayCache.Companion.a(replayCache.f52417a, replayCache.f52418b);
            }
        });
        this.f52423g = new ArrayList();
        this.f52424h = new LinkedHashMap();
        this.f52425i = LazyKt.b(new Function0<File>() { // from class: io.sentry.android.replay.ReplayCache$ongoingSegmentFile$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws IOException {
                ReplayCache replayCache = this.f52426c;
                if (replayCache.b() == null) {
                    return null;
                }
                File file = new File(replayCache.b(), ".ongoing_segment");
                if (!file.exists()) {
                    file.createNewFile();
                }
                return file;
            }
        });
    }

    public final void a(File file) {
        SentryOptions sentryOptions = this.f52417a;
        try {
            if (file.delete()) {
                return;
            }
            sentryOptions.getLogger().c(SentryLevel.ERROR, "Failed to delete replay frame: %s", file.getAbsolutePath());
        } catch (Throwable th) {
            sentryOptions.getLogger().a(SentryLevel.ERROR, th, "Failed to delete replay frame: %s", file.getAbsolutePath());
        }
    }

    public final File b() {
        return (File) this.f52422f.getValue();
    }

    public final synchronized void c(String key, String str) {
        File file;
        File file2;
        try {
            Intrinsics.checkNotNullParameter(key, "key");
            if (this.f52419c.get()) {
                return;
            }
            File file3 = (File) this.f52425i.getValue();
            if ((file3 == null || !file3.exists()) && (file = (File) this.f52425i.getValue()) != null) {
                file.createNewFile();
            }
            if (this.f52424h.isEmpty() && (file2 = (File) this.f52425i.getValue()) != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2), Charsets.UTF_8), KEYRecord.Flags.FLAG2);
                try {
                    ConstrainedOnceSequence constrainedOnceSequenceA = TextStreamsKt.a(bufferedReader);
                    LinkedHashMap linkedHashMap = this.f52424h;
                    Iterator it = constrainedOnceSequenceA.iterator();
                    while (it.hasNext()) {
                        List listSplit$default = StringsKt__StringsKt.split$default((String) it.next(), new String[]{"="}, false, 2, 2, null);
                        linkedHashMap.put((String) listSplit$default.get(0), (String) listSplit$default.get(1));
                    }
                    bufferedReader.close();
                } finally {
                }
            }
            if (str == null) {
                this.f52424h.remove(key);
            } else {
                this.f52424h.put(key, str);
            }
            File file4 = (File) this.f52425i.getValue();
            if (file4 != null) {
                Set setEntrySet = this.f52424h.entrySet();
                Intrinsics.checkNotNullExpressionValue(setEntrySet, "ongoingSegment.entries");
                FilesKt.d(file4, CollectionsKt.E(setEntrySet, StringUtils.LF, null, null, ReplayCache$persistSegmentValues$2.f52427c, 30));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f52420d) {
            try {
                SimpleVideoEncoder simpleVideoEncoder = this.f52421e;
                if (simpleVideoEncoder != null) {
                    simpleVideoEncoder.c();
                }
                this.f52421e = null;
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f52419c.set(true);
    }

    public final String e(final long j2) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        CollectionsKt.N(this.f52423g, new Function1<ReplayFrame, Boolean>() { // from class: io.sentry.android.replay.ReplayCache$rotate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ReplayFrame it = (ReplayFrame) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.f52433b < j2) {
                    this.a(it.f52432a);
                    return Boolean.TRUE;
                }
                Ref.ObjectRef objectRef2 = objectRef;
                if (objectRef2.f53801a == null) {
                    objectRef2.f53801a = it.f52434c;
                }
                return Boolean.FALSE;
            }
        });
        return (String) objectRef.f53801a;
    }
}
