package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class zzaeq implements Iterator {
    private final ArrayDeque zza;
    private zzabj zzb;

    public /* synthetic */ zzaeq(zzabn zzabnVar, zzaep zzaepVar) {
        if (!(zzabnVar instanceof zzaes)) {
            this.zza = null;
            this.zzb = (zzabj) zzabnVar;
            return;
        }
        zzaes zzaesVar = (zzaes) zzabnVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzaesVar.zzf());
        this.zza = arrayDeque;
        arrayDeque.push(zzaesVar);
        this.zzb = zzb(zzaesVar.zzd);
    }

    private final zzabj zzb(zzabn zzabnVar) {
        while (zzabnVar instanceof zzaes) {
            zzaes zzaesVar = (zzaes) zzabnVar;
            this.zza.push(zzaesVar);
            zzabnVar = zzaesVar.zzd;
        }
        return (zzabj) zzabnVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzabj next() {
        zzabj zzabjVarZzb;
        zzabj zzabjVar = this.zzb;
        if (zzabjVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.zza;
            zzabjVarZzb = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzabjVarZzb = zzb(((zzaes) this.zza.pop()).zze);
        } while (zzabjVarZzb.zzd() == 0);
        this.zzb = zzabjVarZzb;
        return zzabjVar;
    }
}
