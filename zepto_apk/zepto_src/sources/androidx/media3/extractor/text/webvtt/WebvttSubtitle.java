package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class WebvttSubtitle implements Subtitle {

    /* renamed from: a, reason: collision with root package name */
    public final List f9480a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f9481b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f9482c;

    public WebvttSubtitle(ArrayList arrayList) {
        this.f9480a = Collections.unmodifiableList(new ArrayList(arrayList));
        this.f9481b = new long[arrayList.size() * 2];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            WebvttCueInfo webvttCueInfo = (WebvttCueInfo) arrayList.get(i2);
            int i3 = i2 * 2;
            long[] jArr = this.f9481b;
            jArr[i3] = webvttCueInfo.f9451b;
            jArr[i3 + 1] = webvttCueInfo.f9452c;
        }
        long[] jArr2 = this.f9481b;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f9482c = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final int a(long j2) {
        long[] jArr = this.f9482c;
        int iB = Util.b(jArr, j2, false);
        if (iB < jArr.length) {
            return iB;
        }
        return -1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final List b(long j2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (true) {
            List list = this.f9480a;
            if (i2 >= list.size()) {
                break;
            }
            int i3 = i2 * 2;
            long[] jArr = this.f9481b;
            if (jArr[i3] <= j2 && j2 < jArr[i3 + 1]) {
                WebvttCueInfo webvttCueInfo = (WebvttCueInfo) list.get(i2);
                Cue cue = webvttCueInfo.f9450a;
                if (cue.f5616e == -3.4028235E38f) {
                    arrayList2.add(webvttCueInfo);
                } else {
                    arrayList.add(cue);
                }
            }
            i2++;
        }
        Collections.sort(arrayList2, new a(1));
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            Cue.Builder builderA = ((WebvttCueInfo) arrayList2.get(i4)).f9450a.a();
            builderA.f5629e = (-1) - i4;
            builderA.f5630f = 1;
            arrayList.add(builderA.a());
        }
        return arrayList;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final long c(int i2) {
        Assertions.a(i2 >= 0);
        long[] jArr = this.f9482c;
        Assertions.a(i2 < jArr.length);
        return jArr[i2];
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final int d() {
        return this.f9482c.length;
    }
}
