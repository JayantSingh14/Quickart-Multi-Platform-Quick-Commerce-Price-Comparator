package com.google.android.gms.internal.common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzt implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f36501a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzw f36502b;

    public zzt(zzw zzwVar, String str) {
        this.f36501a = str;
        Objects.requireNonNull(zzwVar);
        this.f36502b = zzwVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        zzw zzwVar = this.f36502b;
        return new zzs(zzwVar, this.f36501a, zzwVar.f36509b.f36503a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        try {
            zzk zzkVar = (zzk) iterator();
            if (zzkVar.hasNext()) {
                Object next = zzkVar.next();
                Objects.requireNonNull(next);
                sb.append(next instanceof CharSequence ? (CharSequence) next : next.toString());
                while (zzkVar.hasNext()) {
                    sb.append((CharSequence) ", ");
                    Object next2 = zzkVar.next();
                    Objects.requireNonNull(next2);
                    sb.append(next2 instanceof CharSequence ? (CharSequence) next2 : next2.toString());
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
