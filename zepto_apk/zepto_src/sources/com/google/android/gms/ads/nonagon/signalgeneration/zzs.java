package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzs extends LinkedHashMap {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzv f21935a;

    public zzs(zzv zzvVar) {
        Objects.requireNonNull(zzvVar);
        this.f21935a = zzvVar;
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        zzv zzvVar = this.f21935a;
        synchronized (zzvVar) {
            try {
                if (size() <= zzvVar.f21943a) {
                    return false;
                }
                zzvVar.f21948f.add(new Pair((String) entry.getKey(), ((zzt) entry.getValue()).f21937b));
                return size() > zzvVar.f21943a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
