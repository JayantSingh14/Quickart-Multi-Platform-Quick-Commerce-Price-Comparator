package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableMap;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {

    /* renamed from: i, reason: collision with root package name */
    public static final RegularImmutableBiMap f43004i = new RegularImmutableBiMap();

    /* renamed from: d, reason: collision with root package name */
    public final transient Object f43005d;

    /* renamed from: e, reason: collision with root package name */
    public final transient Object[] f43006e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int f43007f;

    /* renamed from: g, reason: collision with root package name */
    public final transient int f43008g;

    /* renamed from: h, reason: collision with root package name */
    public final transient RegularImmutableBiMap f43009h;

    public RegularImmutableBiMap() {
        this.f43005d = null;
        this.f43006e = new Object[0];
        this.f43007f = 0;
        this.f43008g = 0;
        this.f43009h = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet b() {
        return new RegularImmutableMap.EntrySet(this, this.f43006e, this.f43007f, this.f43008g);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet c() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.f43006e, this.f43007f, this.f43008g));
    }

    @Override // com.google.common.collect.ImmutableMap
    public final boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Object get(Object obj) {
        Object objQ = RegularImmutableMap.q(this.f43005d, this.f43006e, this.f43008g, this.f43007f, obj);
        if (objQ == null) {
            return null;
        }
        return objQ;
    }

    @Override // com.google.common.collect.ImmutableBiMap
    public final ImmutableBiMap o() {
        return this.f43009h;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f43008g;
    }

    public RegularImmutableBiMap(Object obj, Object[] objArr, int i2, RegularImmutableBiMap regularImmutableBiMap) {
        this.f43005d = obj;
        this.f43006e = objArr;
        this.f43007f = 1;
        this.f43008g = i2;
        this.f43009h = regularImmutableBiMap;
    }

    public RegularImmutableBiMap(Object[] objArr, int i2) {
        this.f43006e = objArr;
        this.f43008g = i2;
        this.f43007f = 0;
        int iM = i2 >= 2 ? ImmutableSet.m(i2) : 0;
        Object objP = RegularImmutableMap.p(objArr, i2, iM, 0);
        if (!(objP instanceof Object[])) {
            this.f43005d = objP;
            Object objP2 = RegularImmutableMap.p(objArr, i2, iM, 1);
            if (!(objP2 instanceof Object[])) {
                this.f43009h = new RegularImmutableBiMap(objP2, objArr, i2, this);
                return;
            }
            throw ((ImmutableMap.Builder.DuplicateKey) ((Object[]) objP2)[2]).a();
        }
        throw ((ImmutableMap.Builder.DuplicateKey) ((Object[]) objP)[2]).a();
    }
}
