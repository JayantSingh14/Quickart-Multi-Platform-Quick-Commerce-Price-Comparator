package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class zzadg extends zzaax implements RandomAccess, zzadh {

    @Deprecated
    public static final zzadh zza;
    private static final zzadg zzb;
    private final List zzc;

    static {
        zzadg zzadgVar = new zzadg(false);
        zzb = zzadgVar;
        zza = zzadgVar;
    }

    public zzadg() {
        this(10);
    }

    private static String zzj(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzabn ? ((zzabn) obj).zzu(zzacx.zzb) : zzacx.zzd((byte[]) obj);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        zza();
        this.zzc.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        zza();
        if (collection instanceof zzadh) {
            collection = ((zzadh) collection).zzh();
        }
        boolean zAddAll = this.zzc.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zza();
        Object objRemove = this.zzc.remove(i2);
        ((AbstractList) this).modCount++;
        return zzj(objRemove);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        zza();
        return zzj(this.zzc.set(i2, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacw
    public final /* bridge */ /* synthetic */ zzacw zzd(int i2) {
        if (i2 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i2);
        arrayList.addAll(this.zzc);
        return new zzadg(arrayList);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadh
    public final zzadh zze() {
        return zzc() ? new zzafp(this) : this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadh
    public final Object zzf(int i2) {
        return this.zzc.get(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i2) {
        Object obj = this.zzc.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzabn) {
            zzabn zzabnVar = (zzabn) obj;
            String strZzu = zzabnVar.zzu(zzacx.zzb);
            if (zzabnVar.zzo()) {
                this.zzc.set(i2, strZzu);
            }
            return strZzu;
        }
        byte[] bArr = (byte[]) obj;
        String strZzd = zzacx.zzd(bArr);
        if (zzafz.zzh(bArr)) {
            this.zzc.set(i2, strZzd);
        }
        return strZzd;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadh
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadh
    public final void zzi(zzabn zzabnVar) {
        zza();
        this.zzc.add(zzabnVar);
        ((AbstractList) this).modCount++;
    }

    public zzadg(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        super(true);
        this.zzc = arrayList;
    }

    private zzadg(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzadg(boolean z) {
        super(false);
        this.zzc = Collections.EMPTY_LIST;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaax, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
