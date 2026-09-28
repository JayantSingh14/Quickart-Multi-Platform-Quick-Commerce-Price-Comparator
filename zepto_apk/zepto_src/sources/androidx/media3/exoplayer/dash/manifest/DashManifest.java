package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.FilterableManifest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public class DashManifest implements FilterableManifest<DashManifest> {

    /* renamed from: a, reason: collision with root package name */
    public final long f6789a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6790b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6791c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6792d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6793e;

    /* renamed from: f, reason: collision with root package name */
    public final long f6794f;

    /* renamed from: g, reason: collision with root package name */
    public final long f6795g;

    /* renamed from: h, reason: collision with root package name */
    public final long f6796h;

    /* renamed from: i, reason: collision with root package name */
    public final UtcTimingElement f6797i;

    /* renamed from: j, reason: collision with root package name */
    public final ServiceDescriptionElement f6798j;

    /* renamed from: k, reason: collision with root package name */
    public final Uri f6799k;

    /* renamed from: l, reason: collision with root package name */
    public final ProgramInformation f6800l;

    /* renamed from: m, reason: collision with root package name */
    public final List f6801m;

    public DashManifest(long j2, long j3, long j4, boolean z, long j5, long j6, long j7, long j8, ProgramInformation programInformation, UtcTimingElement utcTimingElement, ServiceDescriptionElement serviceDescriptionElement, Uri uri, ArrayList arrayList) {
        this.f6789a = j2;
        this.f6790b = j3;
        this.f6791c = j4;
        this.f6792d = z;
        this.f6793e = j5;
        this.f6794f = j6;
        this.f6795g = j7;
        this.f6796h = j8;
        this.f6800l = programInformation;
        this.f6797i = utcTimingElement;
        this.f6799k = uri;
        this.f6798j = serviceDescriptionElement;
        this.f6801m = arrayList;
    }

    @Override // androidx.media3.exoplayer.offline.FilterableManifest
    public final Object a(List list) {
        long j2;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j3 = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f6801m.size()) {
                break;
            }
            if (((StreamKey) linkedList.peek()).f5459a != i2) {
                long jC = c(i2);
                if (jC != -9223372036854775807L) {
                    j3 += jC;
                }
            } else {
                Period periodB = b(i2);
                List list2 = periodB.f6824c;
                StreamKey streamKey = (StreamKey) linkedList.poll();
                int i3 = streamKey.f5459a;
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    int i4 = streamKey.f5460b;
                    AdaptationSet adaptationSet = (AdaptationSet) list2.get(i4);
                    List list3 = adaptationSet.f6781c;
                    ArrayList arrayList3 = new ArrayList();
                    do {
                        arrayList3.add((Representation) list3.get(streamKey.f5461c));
                        streamKey = (StreamKey) linkedList.poll();
                        if (streamKey.f5459a != i3) {
                            break;
                        }
                    } while (streamKey.f5460b == i4);
                    j2 = j3;
                    arrayList2.add(new AdaptationSet(adaptationSet.f6779a, adaptationSet.f6780b, arrayList3, adaptationSet.f6782d, adaptationSet.f6783e, adaptationSet.f6784f));
                    if (streamKey.f5459a != i3) {
                        break;
                    }
                    j3 = j2;
                }
                linkedList.addFirst(streamKey);
                arrayList.add(new Period(periodB.f6822a, periodB.f6823b - j2, arrayList2, periodB.f6825d));
                j3 = j2;
            }
            i2++;
        }
        long j4 = j3;
        long j5 = this.f6790b;
        return new DashManifest(this.f6789a, j5 != -9223372036854775807L ? j5 - j4 : -9223372036854775807L, this.f6791c, this.f6792d, this.f6793e, this.f6794f, this.f6795g, this.f6796h, this.f6800l, this.f6797i, this.f6798j, this.f6799k, arrayList);
    }

    public final Period b(int i2) {
        return (Period) this.f6801m.get(i2);
    }

    public final long c(int i2) {
        long j2;
        long j3;
        List list = this.f6801m;
        if (i2 == list.size() - 1) {
            j2 = this.f6790b;
            if (j2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j3 = ((Period) list.get(i2)).f6823b;
        } else {
            j2 = ((Period) list.get(i2 + 1)).f6823b;
            j3 = ((Period) list.get(i2)).f6823b;
        }
        return j2 - j3;
    }

    public final long d(int i2) {
        return Util.T(c(i2));
    }
}
