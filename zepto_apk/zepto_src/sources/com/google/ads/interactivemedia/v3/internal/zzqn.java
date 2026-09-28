package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public final class zzqn extends zzqi implements NavigableMap {
    private static final Comparator zza;
    private static final zzqn zzb;
    private final transient zzre zzc;
    private final transient zzqf zzd;

    @CheckForNull
    private final transient zzqn zze;

    static {
        zzqu zzquVar = zzqu.zza;
        zza = zzquVar;
        zzre zzreVarZzs = zzqo.zzs(zzquVar);
        int i2 = zzqf.zzd;
        zzb = new zzqn(zzreVarZzs, zzqx.zza, null);
    }

    public zzqn(zzre zzreVar, zzqf zzqfVar, @CheckForNull zzqn zzqnVar) {
        this.zzc = zzreVar;
        this.zzd = zzqfVar;
        this.zze = zzqnVar;
    }

    public static zzqn zzm(Comparator comparator) {
        if (zzqu.zza.equals(comparator)) {
            return zzb;
        }
        zzre zzreVarZzs = zzqo.zzs(comparator);
        int i2 = zzqf.zzd;
        return new zzqn(zzreVarZzs, zzqx.zza, null);
    }

    public static zzqn zzo() {
        return zzb;
    }

    private final zzqn zzs(int i2, int i3) {
        if (i2 == 0) {
            if (i3 == this.zzd.size()) {
                return this;
            }
            i2 = 0;
        }
        if (i2 == i3) {
            return zzm(((zzqo) this.zzc).zza);
        }
        return new zzqn(this.zzc.zzw(i2, i3), this.zzd.subList(i2, i3), null);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Object ceilingKey(Object obj) {
        return zzqs.zza(ceilingEntry(obj));
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return ((zzqo) this.zzc).zza;
    }

    @Override // java.util.NavigableMap
    public final /* synthetic */ NavigableSet descendingKeySet() {
        return this.zzc.descendingSet();
    }

    @Override // java.util.NavigableMap
    public final /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        zzqn zzqnVar = this.zze;
        if (zzqnVar != null) {
            return zzqnVar;
        }
        if (!isEmpty()) {
            return new zzqn((zzre) this.zzc.descendingSet(), this.zzd.zzh(), this);
        }
        Comparator comparator = ((zzqo) this.zzc).zza;
        return zzm((comparator instanceof zzqw ? (zzqw) comparator : new zzpn(comparator)).zza());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqi, java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzd().get(0);
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return this.zzc.first();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Object floorKey(Object obj) {
        return zzqs.zza(floorEntry(obj));
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0005  */
    @Override // com.google.ads.interactivemedia.v3.internal.zzqi, java.util.Map
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(@javax.annotation.CheckForNull java.lang.Object r4) {
        /*
            r3 = this;
            com.google.ads.interactivemedia.v3.internal.zzre r0 = r3.zzc
            r1 = -1
            if (r4 != 0) goto L7
        L5:
            r4 = r1
            goto L12
        L7:
            com.google.ads.interactivemedia.v3.internal.zzqf r2 = r0.zzd     // Catch: java.lang.ClassCastException -> L5
            java.util.Comparator r0 = r0.zza     // Catch: java.lang.ClassCastException -> L5
            int r4 = java.util.Collections.binarySearch(r2, r4, r0)     // Catch: java.lang.ClassCastException -> L5
            if (r4 >= 0) goto L12
            goto L5
        L12:
            if (r4 != r1) goto L16
            r4 = 0
            return r4
        L16:
            com.google.ads.interactivemedia.v3.internal.zzqf r0 = r3.zzd
            java.lang.Object r4 = r0.get(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzqn.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Object higherKey(Object obj) {
        return zzqs.zza(higherEntry(obj));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqi, java.util.Map
    public final /* synthetic */ Set keySet() {
        return this.zzc;
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzd().get(this.zzd.size() - 1);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return this.zzc.last();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    public final Object lowerKey(Object obj) {
        return zzqs.zza(lowerEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final /* synthetic */ NavigableSet navigableKeySet() {
        return this.zzc;
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @Deprecated
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @CheckForNull
    @Deprecated
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd.size();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqi, java.util.Map
    public final /* synthetic */ Collection values() {
        return this.zzd;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqi
    public final zzqb zza() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqi
    /* renamed from: zzb */
    public final zzqb values() {
        return this.zzd;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqi
    public final zzqk zzg() {
        return isEmpty() ? zzrd.zza : new zzqm(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqi
    public final zzqk zzh() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqi
    /* renamed from: zzj */
    public final /* synthetic */ zzqk keySet() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqi
    public final boolean zzk() {
        return this.zzc.zzd.zzf() || this.zzd.zzf();
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final zzqn headMap(Object obj, boolean z) {
        obj.getClass();
        return zzs(0, this.zzc.zzu(obj, z));
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzp, reason: merged with bridge method [inline-methods] */
    public final zzqn subMap(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        if (((zzqo) this.zzc).zza.compare(obj, obj2) <= 0) {
            return headMap(obj2, z2).tailMap(obj, z);
        }
        throw new IllegalArgumentException(zzpg.zzb("expected fromKey <= toKey but %s > %s", obj, obj2));
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public final zzqn tailMap(Object obj, boolean z) {
        obj.getClass();
        return zzs(this.zzc.zzv(obj, z), this.zzd.size());
    }
}
