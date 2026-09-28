package com.google.android.material.carousel;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
class KeylineStateList {

    /* renamed from: a, reason: collision with root package name */
    public final KeylineState f40181a;

    /* renamed from: b, reason: collision with root package name */
    public final List f40182b;

    /* renamed from: c, reason: collision with root package name */
    public final List f40183c;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f40184d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f40185e;

    /* renamed from: f, reason: collision with root package name */
    public final float f40186f;

    /* renamed from: g, reason: collision with root package name */
    public final float f40187g;

    public KeylineStateList(KeylineState keylineState, ArrayList arrayList, ArrayList arrayList2) {
        this.f40181a = keylineState;
        this.f40182b = Collections.unmodifiableList(arrayList);
        this.f40183c = Collections.unmodifiableList(arrayList2);
        float f2 = ((KeylineState) b.c(1, arrayList)).b().f40173a - keylineState.b().f40173a;
        this.f40186f = f2;
        float f3 = keylineState.d().f40173a - ((KeylineState) b.c(1, arrayList2)).d().f40173a;
        this.f40187g = f3;
        this.f40184d = d(f2, arrayList, true);
        this.f40185e = d(f3, arrayList2, false);
    }

    public static float[] d(float f2, ArrayList arrayList, boolean z) {
        int size = arrayList.size();
        float[] fArr = new float[size];
        int i2 = 1;
        while (i2 < size) {
            int i3 = i2 - 1;
            KeylineState keylineState = (KeylineState) arrayList.get(i3);
            KeylineState keylineState2 = (KeylineState) arrayList.get(i2);
            fArr[i2] = i2 == size + (-1) ? 1.0f : fArr[i3] + ((z ? keylineState2.b().f40173a - keylineState.b().f40173a : keylineState.d().f40173a - keylineState2.d().f40173a) / f2);
            i2++;
        }
        return fArr;
    }

    public static float[] e(List list, float f2, float[] fArr) {
        int size = list.size();
        float f3 = fArr[0];
        int i2 = 1;
        while (i2 < size) {
            float f4 = fArr[i2];
            if (f2 <= f4) {
                return new float[]{AnimationUtils.b(0.0f, 1.0f, f3, f4, f2), i2 - 1, i2};
            }
            i2++;
            f3 = f4;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    public static KeylineState f(KeylineState keylineState, int i2, int i3, float f2, int i4, int i5, float f3) {
        ArrayList arrayList = new ArrayList(keylineState.f40161b);
        arrayList.add(i3, (KeylineState.Keyline) arrayList.remove(i2));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.f40160a, f3);
        float f4 = f2;
        int i6 = 0;
        while (i6 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i6);
            float f5 = keyline.f40176d;
            builder.b((f5 / 2.0f) + f4, keyline.f40175c, f5, i6 >= i4 && i6 <= i5, keyline.f40177e, keyline.f40178f, 0.0f, 0.0f);
            f4 += keyline.f40176d;
            i6++;
        }
        return builder.d();
    }

    public static KeylineState g(KeylineState keylineState, float f2, float f3, boolean z, float f4) {
        int i2;
        List list = keylineState.f40161b;
        ArrayList arrayList = new ArrayList(list);
        float f5 = keylineState.f40160a;
        KeylineState.Builder builder = new KeylineState.Builder(f5, f3);
        Iterator it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((KeylineState.Keyline) it.next()).f40177e) {
                i3++;
            }
        }
        float size = f2 / (list.size() - i3);
        float f6 = z ? f2 : 0.0f;
        int i4 = 0;
        while (i4 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i4);
            if (keyline.f40177e) {
                i2 = i4;
                builder.b(keyline.f40174b, keyline.f40175c, keyline.f40176d, false, true, keyline.f40178f, 0.0f, 0.0f);
            } else {
                i2 = i4;
                boolean z2 = i2 >= keylineState.f40162c && i2 <= keylineState.f40163d;
                float f7 = keyline.f40176d - size;
                float fB = CarouselStrategy.b(f7, f5, f4);
                float f8 = (f7 / 2.0f) + f6;
                float f9 = f8 - keyline.f40174b;
                float f10 = f9;
                if (!z) {
                    f9 = 0.0f;
                }
                if (z) {
                    f10 = 0.0f;
                }
                builder.b(f8, fB, f7, z2, false, keyline.f40178f, f9, f10);
                f6 += f7;
            }
            i4 = i2 + 1;
        }
        return builder.d();
    }

    public final KeylineState a() {
        return (KeylineState) e.k(1, this.f40183c);
    }

    public final KeylineState b(float f2, float f3, float f4, boolean z) {
        float fB;
        List list;
        float[] fArr;
        float f5 = this.f40186f;
        float f6 = f3 + f5;
        float f7 = this.f40187g;
        float f8 = f4 - f7;
        float f9 = c().a().f40179g;
        float f10 = a().c().f40180h;
        if (f5 == f9) {
            f6 += f9;
        }
        if (f7 == f10) {
            f8 -= f10;
        }
        if (f2 < f6) {
            fB = AnimationUtils.b(1.0f, 0.0f, f3, f6, f2);
            list = this.f40182b;
            fArr = this.f40184d;
        } else {
            if (f2 <= f8) {
                return this.f40181a;
            }
            fB = AnimationUtils.b(0.0f, 1.0f, f8, f4, f2);
            list = this.f40183c;
            fArr = this.f40185e;
        }
        if (z) {
            float[] fArrE = e(list, fB, fArr);
            return fArrE[0] >= 0.5f ? (KeylineState) list.get((int) fArrE[2]) : (KeylineState) list.get((int) fArrE[1]);
        }
        float[] fArrE2 = e(list, fB, fArr);
        KeylineState keylineState = (KeylineState) list.get((int) fArrE2[1]);
        KeylineState keylineState2 = (KeylineState) list.get((int) fArrE2[2]);
        float f11 = fArrE2[0];
        if (keylineState.f40160a != keylineState2.f40160a) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List list2 = keylineState.f40161b;
        int size = list2.size();
        List list3 = keylineState2.f40161b;
        if (size != list3.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list2.size(); i2++) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) list2.get(i2);
            KeylineState.Keyline keyline2 = (KeylineState.Keyline) list3.get(i2);
            arrayList.add(new KeylineState.Keyline(AnimationUtils.a(keyline.f40173a, keyline2.f40173a, f11), AnimationUtils.a(keyline.f40174b, keyline2.f40174b, f11), AnimationUtils.a(keyline.f40175c, keyline2.f40175c, f11), AnimationUtils.a(keyline.f40176d, keyline2.f40176d, f11), false, 0.0f, 0.0f, 0.0f));
        }
        return new KeylineState(keylineState.f40160a, arrayList, AnimationUtils.c(f11, keylineState.f40162c, keylineState2.f40162c), AnimationUtils.c(f11, keylineState.f40163d, keylineState2.f40163d));
    }

    public final KeylineState c() {
        return (KeylineState) e.k(1, this.f40182b);
    }
}
