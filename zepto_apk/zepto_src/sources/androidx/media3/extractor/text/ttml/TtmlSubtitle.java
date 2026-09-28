package androidx.media3.extractor.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes3.dex */
final class TtmlSubtitle implements Subtitle {

    /* renamed from: a, reason: collision with root package name */
    public final TtmlNode f9420a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f9421b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f9422c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f9423d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f9424e;

    public TtmlSubtitle(TtmlNode ttmlNode, HashMap map, HashMap map2, HashMap map3) {
        this.f9420a = ttmlNode;
        this.f9423d = map2;
        this.f9424e = map3;
        this.f9422c = Collections.unmodifiableMap(map);
        TreeSet treeSet = new TreeSet();
        int i2 = 0;
        ttmlNode.d(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i2] = ((Long) it.next()).longValue();
            i2++;
        }
        this.f9421b = jArr;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final int a(long j2) {
        long[] jArr = this.f9421b;
        int iB = Util.b(jArr, j2, false);
        if (iB < jArr.length) {
            return iB;
        }
        return -1;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final List b(long j2) {
        TtmlNode ttmlNode = this.f9420a;
        ArrayList arrayList = new ArrayList();
        ttmlNode.g(j2, ttmlNode.f9377h, arrayList);
        TreeMap treeMap = new TreeMap();
        ttmlNode.i(j2, false, ttmlNode.f9377h, treeMap);
        HashMap map = this.f9423d;
        ttmlNode.h(j2, this.f9422c, map, ttmlNode.f9377h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) this.f9424e.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                TtmlRegion ttmlRegion = (TtmlRegion) map.get(pair.first);
                ttmlRegion.getClass();
                Cue.Builder builder = new Cue.Builder();
                builder.f5626b = bitmapDecodeByteArray;
                builder.f5632h = ttmlRegion.f9398b;
                builder.f5633i = 0;
                builder.f5629e = ttmlRegion.f9399c;
                builder.f5630f = 0;
                builder.f5631g = ttmlRegion.f9401e;
                builder.f5636l = ttmlRegion.f9402f;
                builder.f5637m = ttmlRegion.f9403g;
                builder.p = ttmlRegion.f9406j;
                arrayList2.add(builder.a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = (TtmlRegion) map.get(entry.getKey());
            ttmlRegion2.getClass();
            Cue.Builder builder2 = (Cue.Builder) entry.getValue();
            CharSequence charSequence = builder2.f5625a;
            charSequence.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (DeleteTextSpan deleteTextSpan : (DeleteTextSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), DeleteTextSpan.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(deleteTextSpan), spannableStringBuilder.getSpanEnd(deleteTextSpan), (CharSequence) "");
            }
            for (int i2 = 0; i2 < spannableStringBuilder.length(); i2++) {
                if (spannableStringBuilder.charAt(i2) == ' ') {
                    int i3 = i2 + 1;
                    int i4 = i3;
                    while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                        i4++;
                    }
                    int i5 = i4 - i3;
                    if (i5 > 0) {
                        spannableStringBuilder.delete(i2, i5 + i2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            for (int i6 = 0; i6 < spannableStringBuilder.length() - 1; i6++) {
                if (spannableStringBuilder.charAt(i6) == '\n') {
                    int i7 = i6 + 1;
                    if (spannableStringBuilder.charAt(i7) == ' ') {
                        spannableStringBuilder.delete(i7, i6 + 2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            for (int i8 = 0; i8 < spannableStringBuilder.length() - 1; i8++) {
                if (spannableStringBuilder.charAt(i8) == ' ') {
                    int i9 = i8 + 1;
                    if (spannableStringBuilder.charAt(i9) == '\n') {
                        spannableStringBuilder.delete(i8, i9);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            builder2.f5629e = ttmlRegion2.f9399c;
            builder2.f5630f = ttmlRegion2.f9400d;
            builder2.f5631g = ttmlRegion2.f9401e;
            builder2.f5632h = ttmlRegion2.f9398b;
            builder2.f5636l = ttmlRegion2.f9402f;
            builder2.f5635k = ttmlRegion2.f9405i;
            builder2.f5634j = ttmlRegion2.f9404h;
            builder2.p = ttmlRegion2.f9406j;
            arrayList2.add(builder2.a());
        }
        return arrayList2;
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final long c(int i2) {
        return this.f9421b[i2];
    }

    @Override // androidx.media3.extractor.text.Subtitle
    public final int d() {
        return this.f9421b.length;
    }
}
