package androidx.media3.exoplayer.dash;

import android.os.Handler;
import android.os.Message;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.emsg.EventMessageDecoder;
import java.util.TreeMap;

@UnstableApi
/* loaded from: classes3.dex */
public final class PlayerEmsgHandler implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final Allocator f6761a;

    /* renamed from: b, reason: collision with root package name */
    public final PlayerEmsgCallback f6762b;

    /* renamed from: f, reason: collision with root package name */
    public DashManifest f6766f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6767g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6768h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6769i;

    /* renamed from: e, reason: collision with root package name */
    public final TreeMap f6765e = new TreeMap();

    /* renamed from: d, reason: collision with root package name */
    public final Handler f6764d = Util.o(this);

    /* renamed from: c, reason: collision with root package name */
    public final EventMessageDecoder f6763c = new EventMessageDecoder();

    public static final class ManifestExpiryEventInfo {

        /* renamed from: a, reason: collision with root package name */
        public final long f6770a;

        /* renamed from: b, reason: collision with root package name */
        public final long f6771b;

        public ManifestExpiryEventInfo(long j2, long j3) {
            this.f6770a = j2;
            this.f6771b = j3;
        }
    }

    public interface PlayerEmsgCallback {
    }

    public final class PlayerTrackEmsgHandler implements TrackOutput {

        /* renamed from: a, reason: collision with root package name */
        public final SampleQueue f6772a;

        /* renamed from: b, reason: collision with root package name */
        public final FormatHolder f6773b = new FormatHolder();

        /* renamed from: c, reason: collision with root package name */
        public final MetadataInputBuffer f6774c = new MetadataInputBuffer();

        /* renamed from: d, reason: collision with root package name */
        public long f6775d = -9223372036854775807L;

        public PlayerTrackEmsgHandler(Allocator allocator) {
            this.f6772a = new SampleQueue(allocator, null, null);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void a(ParsableByteArray parsableByteArray, int i2, int i3) {
            this.f6772a.a(parsableByteArray, i2, 0);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void b(Format format) {
            this.f6772a.b(format);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final int d(DataReader dataReader, int i2, boolean z) {
            return this.f6772a.c(dataReader, i2, z);
        }

        @Override // androidx.media3.extractor.TrackOutput
        public final void f(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            long jW;
            SampleQueue sampleQueue = this.f6772a;
            sampleQueue.f(j2, i2, i3, i4, cryptoData);
            while (sampleQueue.t(false)) {
                MetadataInputBuffer metadataInputBuffer = this.f6774c;
                metadataInputBuffer.h();
                if (sampleQueue.y(this.f6773b, metadataInputBuffer, 0, false) == -4) {
                    metadataInputBuffer.n();
                } else {
                    metadataInputBuffer = null;
                }
                if (metadataInputBuffer != null) {
                    long j3 = metadataInputBuffer.f6073f;
                    PlayerEmsgHandler playerEmsgHandler = PlayerEmsgHandler.this;
                    Metadata metadataA = playerEmsgHandler.f6763c.a(metadataInputBuffer);
                    if (metadataA != null) {
                        EventMessage eventMessage = (EventMessage) metadataA.f5405a[0];
                        if ("urn:mpeg:dash:event:2012".equals(eventMessage.f8770a)) {
                            String str = eventMessage.f8771b;
                            if ("1".equals(str) || "2".equals(str) || "3".equals(str)) {
                                try {
                                    jW = Util.W(Util.p(eventMessage.f8774e));
                                } catch (ParserException unused) {
                                    jW = -9223372036854775807L;
                                }
                                if (jW != -9223372036854775807L) {
                                    ManifestExpiryEventInfo manifestExpiryEventInfo = new ManifestExpiryEventInfo(j3, jW);
                                    Handler handler = playerEmsgHandler.f6764d;
                                    handler.sendMessage(handler.obtainMessage(1, manifestExpiryEventInfo));
                                }
                            }
                        }
                    }
                }
            }
            sampleQueue.j();
        }
    }

    public PlayerEmsgHandler(DashManifest dashManifest, PlayerEmsgCallback playerEmsgCallback, Allocator allocator) {
        this.f6766f = dashManifest;
        this.f6762b = playerEmsgCallback;
        this.f6761a = allocator;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (!this.f6769i) {
            if (message.what != 1) {
                return false;
            }
            ManifestExpiryEventInfo manifestExpiryEventInfo = (ManifestExpiryEventInfo) message.obj;
            long j2 = manifestExpiryEventInfo.f6770a;
            TreeMap treeMap = this.f6765e;
            long j3 = manifestExpiryEventInfo.f6771b;
            Long l2 = (Long) treeMap.get(Long.valueOf(j3));
            if (l2 == null) {
                treeMap.put(Long.valueOf(j3), Long.valueOf(j2));
                return true;
            }
            if (l2.longValue() > j2) {
                treeMap.put(Long.valueOf(j3), Long.valueOf(j2));
            }
        }
        return true;
    }
}
