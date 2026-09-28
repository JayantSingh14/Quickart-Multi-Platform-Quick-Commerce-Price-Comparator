package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class zzhl extends LruCache {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzhs f39039g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhl(zzhs zzhsVar) {
        super(20);
        Objects.requireNonNull(zzhsVar);
        this.f39039g = zzhsVar;
    }

    @Override // androidx.collection.LruCache
    public final Object a(Object obj) throws Throwable {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        zzhs zzhsVar = this.f39039g;
        zzhsVar.h();
        Preconditions.checkNotEmpty(str);
        zzav zzavVar = zzhsVar.f39551b.f39596c;
        zzpf.S(zzavVar);
        zzaq zzaqVarO0 = zzavVar.o0(str);
        if (zzaqVarO0 == null) {
            return null;
        }
        zzgt zzgtVar = zzhsVar.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.n.b(str, "Populate EES config from database on cache miss. appId");
        zzhsVar.o(str, zzhsVar.p(str, zzaqVarO0.f38705a));
        LruCache lruCache = zzhsVar.f39056j;
        lruCache.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (lruCache.f1483c) {
            try {
                Set<Map.Entry> setEntrySet = lruCache.f1482b.f1613a.entrySet();
                Intrinsics.checkNotNullExpressionValue(setEntrySet, "map.entries");
                for (Map.Entry entry : setEntrySet) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return (com.google.android.gms.internal.measurement.zzc) linkedHashMap.get(str);
    }
}
