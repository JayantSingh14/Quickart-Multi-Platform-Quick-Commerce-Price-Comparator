package androidx.media3.exoplayer.dash;

import androidx.media3.exoplayer.dash.manifest.BaseUrl;
import java.util.Comparator;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        BaseUrl baseUrl = (BaseUrl) obj;
        BaseUrl baseUrl2 = (BaseUrl) obj2;
        int iCompare = Integer.compare(baseUrl.f6787c, baseUrl2.f6787c);
        return iCompare != 0 ? iCompare : baseUrl.f6786b.compareTo(baseUrl2.f6786b);
    }
}
