package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public final class HlsMultivariantPlaylist extends HlsPlaylist {
    public static final HlsMultivariantPlaylist n;

    /* renamed from: d, reason: collision with root package name */
    public final List f7154d;

    /* renamed from: e, reason: collision with root package name */
    public final List f7155e;

    /* renamed from: f, reason: collision with root package name */
    public final List f7156f;

    /* renamed from: g, reason: collision with root package name */
    public final List f7157g;

    /* renamed from: h, reason: collision with root package name */
    public final List f7158h;

    /* renamed from: i, reason: collision with root package name */
    public final List f7159i;

    /* renamed from: j, reason: collision with root package name */
    public final Format f7160j;

    /* renamed from: k, reason: collision with root package name */
    public final List f7161k;

    /* renamed from: l, reason: collision with root package name */
    public final Map f7162l;

    /* renamed from: m, reason: collision with root package name */
    public final List f7163m;

    public static final class Rendition {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f7164a;

        /* renamed from: b, reason: collision with root package name */
        public final Format f7165b;

        /* renamed from: c, reason: collision with root package name */
        public final String f7166c;

        public Rendition(Uri uri, Format format, String str) {
            this.f7164a = uri;
            this.f7165b = format;
            this.f7166c = str;
        }
    }

    public static final class Variant {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f7167a;

        /* renamed from: b, reason: collision with root package name */
        public final Format f7168b;

        /* renamed from: c, reason: collision with root package name */
        public final String f7169c;

        /* renamed from: d, reason: collision with root package name */
        public final String f7170d;

        /* renamed from: e, reason: collision with root package name */
        public final String f7171e;

        /* renamed from: f, reason: collision with root package name */
        public final String f7172f;

        public Variant(Uri uri, Format format, String str, String str2, String str3, String str4) {
            this.f7167a = uri;
            this.f7168b = format;
            this.f7169c = str;
            this.f7170d = str2;
            this.f7171e = str3;
            this.f7172f = str4;
        }
    }

    static {
        List list = Collections.EMPTY_LIST;
        n = new HlsMultivariantPlaylist("", list, list, list, list, list, list, null, list, false, Collections.EMPTY_MAP, list);
    }

    public HlsMultivariantPlaylist(String str, List list, List list2, List list3, List list4, List list5, List list6, Format format, List list7, boolean z, Map map, List list8) {
        super(str, list, z);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list2.size(); i2++) {
            Uri uri = ((Variant) list2.get(i2)).f7167a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        b(list6, arrayList);
        this.f7154d = Collections.unmodifiableList(arrayList);
        this.f7155e = Collections.unmodifiableList(list2);
        this.f7156f = Collections.unmodifiableList(list3);
        this.f7157g = Collections.unmodifiableList(list4);
        this.f7158h = Collections.unmodifiableList(list5);
        this.f7159i = Collections.unmodifiableList(list6);
        this.f7160j = format;
        this.f7161k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f7162l = Collections.unmodifiableMap(map);
        this.f7163m = Collections.unmodifiableList(list8);
    }

    public static void b(List list, ArrayList arrayList) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Uri uri = ((Rendition) list.get(i2)).f7164a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
    }

    public static ArrayList c(List list, int i2, List list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            Object obj = list.get(i3);
            int i4 = 0;
            while (true) {
                if (i4 < list2.size()) {
                    StreamKey streamKey = (StreamKey) list2.get(i4);
                    if (streamKey.f5460b == i2 && streamKey.f5461c == i3) {
                        arrayList.add(obj);
                        break;
                    }
                    i4++;
                }
            }
        }
        return arrayList;
    }

    @Override // androidx.media3.exoplayer.offline.FilterableManifest
    public final Object a(List list) {
        ArrayList arrayListC = c(this.f7155e, 0, list);
        List list2 = Collections.EMPTY_LIST;
        return new HlsMultivariantPlaylist(this.f7173a, this.f7174b, arrayListC, list2, c(this.f7157g, 1, list), c(this.f7158h, 2, list), list2, this.f7160j, this.f7161k, this.f7175c, this.f7162l, this.f7163m);
    }
}
