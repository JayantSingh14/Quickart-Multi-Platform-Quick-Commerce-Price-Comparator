package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.Immutable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Immutable
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {

    /* renamed from: c, reason: collision with root package name */
    public final ImmutableMap f43078c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f43079d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f43080e;

    static {
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList immutableList = RegularImmutableList.f43010e;
        int i2 = ImmutableSet.f42719c;
        RegularImmutableSet regularImmutableSet = RegularImmutableSet.f43033j;
        new SparseImmutableTable(immutableList, regularImmutableSet, regularImmutableSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SparseImmutableTable(ImmutableList immutableList, ImmutableSet immutableSet, ImmutableSet immutableSet2) {
        ImmutableMap.Builder builder = new ImmutableMap.Builder(((RegularImmutableSet) immutableSet).f43038h);
        UnmodifiableIterator it = ((RegularImmutableSet) immutableSet).iterator();
        int i2 = 0;
        while (it.hasNext()) {
            builder.c(it.next(), Integer.valueOf(i2));
            i2++;
        }
        ImmutableMap immutableMapA = builder.a(true);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        UnmodifiableIterator it2 = immutableSet.iterator();
        while (it2.hasNext()) {
            linkedHashMap.put(it2.next(), new LinkedHashMap());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        UnmodifiableIterator it3 = immutableSet2.iterator();
        while (it3.hasNext()) {
            linkedHashMap2.put(it3.next(), new LinkedHashMap());
        }
        int[] iArr = new int[((RegularImmutableList) immutableList).f43012d];
        RegularImmutableList regularImmutableList = (RegularImmutableList) immutableList;
        int i3 = regularImmutableList.f43012d;
        int[] iArr2 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            Table.Cell cell = (Table.Cell) regularImmutableList.get(i4);
            Object objA = cell.a();
            Object objB = cell.b();
            Object value = cell.getValue();
            Integer num = (Integer) ((RegularImmutableMap) immutableMapA).get(objA);
            Objects.requireNonNull(num);
            iArr[i4] = num.intValue();
            Map map = (Map) linkedHashMap.get(objA);
            Objects.requireNonNull(map);
            iArr2[i4] = map.size();
            Object objPut = map.put(objB, value);
            if (objPut != null) {
                throw new IllegalArgumentException(Strings.a("Duplicate key: (row=%s, column=%s), values: [%s, %s].", objA, objB, value, objPut));
            }
            Map map2 = (Map) linkedHashMap2.get(objB);
            Objects.requireNonNull(map2);
            map2.put(objA, value);
        }
        this.f43079d = iArr;
        this.f43080e = iArr2;
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            builder2.c(entry.getKey(), ImmutableMap.a((Map) entry.getValue()));
        }
        this.f43078c = builder2.a(true);
        ImmutableMap.Builder builder3 = new ImmutableMap.Builder(linkedHashMap2.size());
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            builder3.c(entry2.getKey(), ImmutableMap.a((Map) entry2.getValue()));
        }
        builder3.a(true);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public final Map g() {
        return ImmutableMap.a(this.f43078c);
    }

    @Override // com.google.common.collect.ImmutableTable
    /* renamed from: k */
    public final ImmutableMap g() {
        return ImmutableMap.a(this.f43078c);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public final Table.Cell l(int i2) {
        Map.Entry entry = (Map.Entry) this.f43078c.entrySet().b().get(this.f43079d[i2]);
        ImmutableMap immutableMap = (ImmutableMap) entry.getValue();
        Map.Entry entry2 = (Map.Entry) immutableMap.entrySet().b().get(this.f43080e[i2]);
        Object key = entry.getKey();
        Object key2 = entry2.getKey();
        Object value = entry2.getValue();
        Preconditions.j(key, "rowKey");
        Preconditions.j(key2, "columnKey");
        Preconditions.j(value, CLConstants.FIELD_PAY_INFO_VALUE);
        return new Tables.ImmutableCell(key, key2, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RegularImmutableTable
    public final Object m(int i2) {
        ImmutableMap immutableMap = (ImmutableMap) this.f43078c.values().b().get(this.f43079d[i2]);
        return immutableMap.values().b().get(this.f43080e[i2]);
    }

    @Override // com.google.common.collect.Table
    public final int size() {
        return this.f43079d.length;
    }
}
