package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public final class zzarg {

    /* renamed from: a, reason: collision with root package name */
    public final int f24205a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f24206b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f24207c;

    /* renamed from: d, reason: collision with root package name */
    public final List f24208d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f24209e;

    public zzarg(int i2, byte[] bArr, Map map, List list, boolean z) {
        this.f24205a = i2;
        this.f24206b = bArr;
        this.f24207c = map;
        this.f24208d = list == null ? null : Collections.unmodifiableList(list);
        this.f24209e = z;
    }

    public static List a(Map map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new zzarc((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    public zzarg(int i2, byte[] bArr, boolean z, List list) {
        Map treeMap;
        if (list == null) {
            treeMap = 0;
        } else if (list.isEmpty()) {
            treeMap = Collections.EMPTY_MAP;
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzarc zzarcVar = (zzarc) it.next();
                treeMap.put(zzarcVar.f24198a, zzarcVar.f24199b);
            }
        }
        this(i2, bArr, treeMap, list, z);
    }
}
