package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzijs implements zzijg {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f34903c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final List f34904a;

    /* renamed from: b, reason: collision with root package name */
    public final List f34905b;

    static {
        zzijh.a(Collections.EMPTY_SET);
    }

    public /* synthetic */ zzijs(List list, List list2) {
        this.f34904a = list;
        this.f34905b = list2;
    }

    public static zzijr a(int i2, int i3) {
        return new zzijr(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Set zzb() {
        List list = this.f34904a;
        int size = list.size();
        List list2 = this.f34905b;
        ArrayList arrayList = new ArrayList(list2.size());
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Collection collection = (Collection) ((zzijp) list2.get(i2)).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSet = new HashSet(size < 3 ? size + 1 : size < 1073741824 ? (int) ((size / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER);
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            Object objZzb = ((zzijp) list.get(i3)).zzb();
            objZzb.getClass();
            hashSet.add(objZzb);
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            for (Object obj : (Collection) arrayList.get(i4)) {
                obj.getClass();
                hashSet.add(obj);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
