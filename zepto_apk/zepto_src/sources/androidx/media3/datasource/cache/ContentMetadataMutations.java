package androidx.media3.datasource.cache;

import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.HashMap;

@UnstableApi
/* loaded from: classes3.dex */
public class ContentMetadataMutations {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6016a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f6017b = new ArrayList();

    public final void a(Object obj, String str) {
        HashMap map = this.f6016a;
        obj.getClass();
        map.put(str, obj);
        this.f6017b.remove(str);
    }
}
