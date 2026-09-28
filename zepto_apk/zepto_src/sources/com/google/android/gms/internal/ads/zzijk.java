package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzijk extends zzijc {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f34900b = 0;

    static {
        zzijh.a(Collections.EMPTY_MAP);
    }

    public static zzijj a(int i2) {
        return new zzijj(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Map zzb() {
        Map map = this.f34893a;
        int size = map.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(size < 3 ? size + 1 : size < 1073741824 ? (int) ((size / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER);
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((zzijp) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}
