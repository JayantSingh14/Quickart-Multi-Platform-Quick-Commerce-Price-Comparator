package androidx.media3.exoplayer.smoothstreaming.manifest;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.exoplayer.offline.FilterableManifest;
import androidx.media3.extractor.mp4.TrackEncryptionBox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@UnstableApi
/* loaded from: classes3.dex */
public class SsManifest implements FilterableManifest<SsManifest> {

    /* renamed from: a, reason: collision with root package name */
    public final int f7444a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7445b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7446c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7447d;

    /* renamed from: e, reason: collision with root package name */
    public final ProtectionElement f7448e;

    /* renamed from: f, reason: collision with root package name */
    public final StreamElement[] f7449f;

    /* renamed from: g, reason: collision with root package name */
    public final long f7450g;

    /* renamed from: h, reason: collision with root package name */
    public final long f7451h;

    public static class ProtectionElement {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f7452a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f7453b;

        /* renamed from: c, reason: collision with root package name */
        public final TrackEncryptionBox[] f7454c;

        public ProtectionElement(UUID uuid, byte[] bArr, TrackEncryptionBox[] trackEncryptionBoxArr) {
            this.f7452a = uuid;
            this.f7453b = bArr;
            this.f7454c = trackEncryptionBoxArr;
        }
    }

    public static class StreamElement {

        /* renamed from: a, reason: collision with root package name */
        public final int f7455a;

        /* renamed from: b, reason: collision with root package name */
        public final String f7456b;

        /* renamed from: c, reason: collision with root package name */
        public final long f7457c;

        /* renamed from: d, reason: collision with root package name */
        public final String f7458d;

        /* renamed from: e, reason: collision with root package name */
        public final int f7459e;

        /* renamed from: f, reason: collision with root package name */
        public final int f7460f;

        /* renamed from: g, reason: collision with root package name */
        public final int f7461g;

        /* renamed from: h, reason: collision with root package name */
        public final int f7462h;

        /* renamed from: i, reason: collision with root package name */
        public final String f7463i;

        /* renamed from: j, reason: collision with root package name */
        public final Format[] f7464j;

        /* renamed from: k, reason: collision with root package name */
        public final int f7465k;

        /* renamed from: l, reason: collision with root package name */
        public final String f7466l;

        /* renamed from: m, reason: collision with root package name */
        public final String f7467m;
        public final ArrayList n;
        public final long[] o;
        public final long p;

        public StreamElement(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, Format[] formatArr, ArrayList arrayList, long[] jArr, long j3) {
            this.f7466l = str;
            this.f7467m = str2;
            this.f7455a = i2;
            this.f7456b = str3;
            this.f7457c = j2;
            this.f7458d = str4;
            this.f7459e = i3;
            this.f7460f = i4;
            this.f7461g = i5;
            this.f7462h = i6;
            this.f7463i = str5;
            this.f7464j = formatArr;
            this.n = arrayList;
            this.o = jArr;
            this.p = j3;
            this.f7465k = arrayList.size();
        }

        public final Uri a(int i2, int i3) {
            Format[] formatArr = this.f7464j;
            Assertions.g(formatArr != null);
            ArrayList arrayList = this.n;
            Assertions.g(arrayList != null);
            Assertions.g(i3 < arrayList.size());
            String string = Integer.toString(formatArr[i2].f5221i);
            String string2 = ((Long) arrayList.get(i3)).toString();
            return UriUtil.e(this.f7466l, this.f7467m.replace("{bitrate}", string).replace("{Bitrate}", string).replace("{start time}", string2).replace("{start_time}", string2));
        }

        public final StreamElement b(Format[] formatArr) {
            long[] jArr = this.o;
            return new StreamElement(this.f7466l, this.f7467m, this.f7455a, this.f7456b, this.f7457c, this.f7458d, this.f7459e, this.f7460f, this.f7461g, this.f7462h, this.f7463i, formatArr, this.n, jArr, this.p);
        }

        public final long c(int i2) {
            if (i2 == this.f7465k - 1) {
                return this.p;
            }
            long[] jArr = this.o;
            return jArr[i2 + 1] - jArr[i2];
        }
    }

    public SsManifest(int i2, int i3, long j2, long j3, int i4, boolean z, ProtectionElement protectionElement, StreamElement[] streamElementArr) {
        this.f7444a = i2;
        this.f7445b = i3;
        this.f7450g = j2;
        this.f7451h = j3;
        this.f7446c = i4;
        this.f7447d = z;
        this.f7448e = protectionElement;
        this.f7449f = streamElementArr;
    }

    @Override // androidx.media3.exoplayer.offline.FilterableManifest
    public final Object a(List list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        StreamElement streamElement = null;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i2);
            StreamElement streamElement2 = this.f7449f[streamKey.f5460b];
            if (streamElement2 != streamElement && streamElement != null) {
                arrayList2.add(streamElement.b((Format[]) arrayList3.toArray(new Format[0])));
                arrayList3.clear();
            }
            arrayList3.add(streamElement2.f7464j[streamKey.f5461c]);
            i2++;
            streamElement = streamElement2;
        }
        if (streamElement != null) {
            arrayList2.add(streamElement.b((Format[]) arrayList3.toArray(new Format[0])));
        }
        return new SsManifest(this.f7444a, this.f7445b, this.f7450g, this.f7451h, this.f7446c, this.f7447d, this.f7448e, (StreamElement[]) arrayList2.toArray(new StreamElement[0]));
    }
}
