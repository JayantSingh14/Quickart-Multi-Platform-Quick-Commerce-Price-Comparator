package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class LottieComposition {

    /* renamed from: c, reason: collision with root package name */
    public HashMap f14137c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f14138d;

    /* renamed from: e, reason: collision with root package name */
    public float f14139e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f14140f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f14141g;

    /* renamed from: h, reason: collision with root package name */
    public SparseArrayCompat f14142h;

    /* renamed from: i, reason: collision with root package name */
    public LongSparseArray f14143i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f14144j;

    /* renamed from: k, reason: collision with root package name */
    public Rect f14145k;

    /* renamed from: l, reason: collision with root package name */
    public float f14146l;

    /* renamed from: m, reason: collision with root package name */
    public float f14147m;
    public float n;
    public boolean o;

    /* renamed from: a, reason: collision with root package name */
    public final PerformanceTracker f14135a = new PerformanceTracker();

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f14136b = new HashSet();
    public int p = 0;

    @Deprecated
    /* loaded from: classes3.dex */
    public static class Factory {

        public static final class ListenerAdapter implements LottieListener<LottieComposition>, Cancellable {
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                throw null;
            }
        }
    }

    public final void a(String str) {
        Logger.b(str);
        this.f14136b.add(str);
    }

    public final float b() {
        return (long) (((this.f14147m - this.f14146l) / this.n) * 1000.0f);
    }

    public final Map c() {
        float fC = Utils.c();
        if (fC != this.f14139e) {
            for (Map.Entry entry : this.f14138d.entrySet()) {
                this.f14138d.put((String) entry.getKey(), ((LottieImageAsset) entry.getValue()).a(this.f14139e / fC));
            }
        }
        this.f14139e = fC;
        return this.f14138d;
    }

    public final Marker d(String str) {
        int size = this.f14141g.size();
        for (int i2 = 0; i2 < size; i2++) {
            Marker marker = (Marker) this.f14141g.get(i2);
            if (marker.a(str)) {
                return marker;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator it = this.f14144j.iterator();
        while (it.hasNext()) {
            sb.append(((Layer) it.next()).a("\t"));
        }
        return sb.toString();
    }
}
