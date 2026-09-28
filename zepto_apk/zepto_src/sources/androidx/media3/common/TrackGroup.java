package androidx.media3.common;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.e;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class TrackGroup {

    /* renamed from: f, reason: collision with root package name */
    public static final String f5499f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f5500g;

    /* renamed from: a, reason: collision with root package name */
    public final int f5501a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5502b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5503c;

    /* renamed from: d, reason: collision with root package name */
    public final Format[] f5504d;

    /* renamed from: e, reason: collision with root package name */
    public int f5505e;

    static {
        int i2 = Util.f5744a;
        f5499f = Integer.toString(0, 36);
        f5500g = Integer.toString(1, 36);
    }

    public TrackGroup(String str, Format... formatArr) {
        Assertions.a(formatArr.length > 0);
        this.f5502b = str;
        this.f5504d = formatArr;
        this.f5501a = formatArr.length;
        int i2 = MimeTypes.i(formatArr[0].f5225m);
        this.f5503c = i2 == -1 ? MimeTypes.i(formatArr[0].f5224l) : i2;
        String str2 = formatArr[0].f5216d;
        str2 = (str2 == null || str2.equals("und")) ? "" : str2;
        int i3 = formatArr[0].f5218f | 16384;
        for (int i4 = 1; i4 < formatArr.length; i4++) {
            String str3 = formatArr[i4].f5216d;
            if (!str2.equals((str3 == null || str3.equals("und")) ? "" : str3)) {
                d(i4, "languages", formatArr[0].f5216d, formatArr[i4].f5216d);
                return;
            } else {
                if (i3 != (formatArr[i4].f5218f | 16384)) {
                    d(i4, "role flags", Integer.toBinaryString(formatArr[0].f5218f), Integer.toBinaryString(formatArr[i4].f5218f));
                    return;
                }
            }
        }
    }

    public static TrackGroup a(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f5499f);
        return new TrackGroup(bundle.getString(f5500g, ""), (Format[]) (parcelableArrayList == null ? ImmutableList.r() : BundleCollectionUtil.a(new b(6), parcelableArrayList)).toArray(new Format[0]));
    }

    public static void d(int i2, String str, String str2, String str3) {
        StringBuilder sbV = e.v("Different ", str, " combined in one TrackGroup: '", str2, "' (track 0) and '");
        sbV.append(str3);
        sbV.append("' (track ");
        sbV.append(i2);
        sbV.append(")");
        Log.e("TrackGroup", "", new IllegalStateException(sbV.toString()));
    }

    public final Format b(int i2) {
        return this.f5504d[i2];
    }

    public final int c(Format format) {
        int i2 = 0;
        while (true) {
            Format[] formatArr = this.f5504d;
            if (i2 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    public final Bundle e() {
        Bundle bundle = new Bundle();
        Format[] formatArr = this.f5504d;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(formatArr.length);
        for (Format format : formatArr) {
            arrayList.add(format.c(true));
        }
        bundle.putParcelableArrayList(f5499f, arrayList);
        bundle.putString(f5500g, this.f5502b);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackGroup.class == obj.getClass()) {
            TrackGroup trackGroup = (TrackGroup) obj;
            if (this.f5502b.equals(trackGroup.f5502b) && Arrays.equals(this.f5504d, trackGroup.f5504d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f5505e == 0) {
            this.f5505e = Arrays.hashCode(this.f5504d) + e.e(527, 31, this.f5502b);
        }
        return this.f5505e;
    }
}
