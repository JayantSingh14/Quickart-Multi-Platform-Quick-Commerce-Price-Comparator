package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzict extends zzhzl {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f34737h = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Api.BaseClientBuilder.API_PRIORITY_OTHER};

    /* renamed from: c, reason: collision with root package name */
    public final int f34738c;

    /* renamed from: d, reason: collision with root package name */
    public final zzhzl f34739d;

    /* renamed from: e, reason: collision with root package name */
    public final zzhzl f34740e;

    /* renamed from: f, reason: collision with root package name */
    public final int f34741f;

    /* renamed from: g, reason: collision with root package name */
    public final int f34742g;

    public zzict(zzhzl zzhzlVar, zzhzl zzhzlVar2) {
        this.f34739d = zzhzlVar;
        this.f34740e = zzhzlVar2;
        int i2 = zzhzlVar.i();
        this.f34741f = i2;
        this.f34738c = zzhzlVar2.i() + i2;
        this.f34742g = Math.max(zzhzlVar.m(), zzhzlVar2.m()) + 1;
    }

    public static int A(int i2) {
        return i2 >= 47 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : f34737h[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final byte f(int i2) {
        zzhzl.b(i2, this.f34738c);
        return g(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final byte g(int i2) {
        int i3 = this.f34741f;
        return i2 < i3 ? this.f34739d.g(i2) : this.f34740e.g(i2 - i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final int i() {
        return this.f34738c;
    }

    @Override // com.google.android.gms.internal.ads.zzhzl, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        return new zzicq(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final void k(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        zzhzl zzhzlVar = this.f34739d;
        int i6 = this.f34741f;
        if (i5 <= i6) {
            zzhzlVar.k(bArr, i2, i3, i4);
            return;
        }
        zzhzl zzhzlVar2 = this.f34740e;
        if (i2 >= i6) {
            zzhzlVar2.k(bArr, i2 - i6, i3, i4);
            return;
        }
        int i7 = i6 - i2;
        zzhzlVar.k(bArr, i2, i3, i7);
        zzhzlVar2.k(bArr, 0, i3 + i7, i4 - i7);
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final int m() {
        return this.f34742g;
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final boolean n() {
        return this.f34738c >= A(this.f34742g);
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final zzhzl o(int i2, int i3) {
        int i4 = this.f34738c;
        int iD = zzhzl.d(i2, i3, i4);
        if (iD == 0) {
            return zzhzl.f34557b;
        }
        if (iD == i4) {
            return this;
        }
        zzhzl zzhzlVar = this.f34739d;
        int i5 = this.f34741f;
        if (i3 <= i5) {
            return zzhzlVar.o(i2, i3);
        }
        int i6 = i3 - i5;
        zzhzl zzhzlVar2 = this.f34740e;
        return i2 >= i5 ? zzhzlVar2.o(i2 - i5, i6) : new zzict(zzhzlVar.o(i2, zzhzlVar.i()), zzhzlVar2.o(0, i6));
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final void q(zzhzw zzhzwVar) {
        this.f34739d.q(zzhzwVar);
        this.f34740e.q(zzhzwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final boolean r(zzhzl zzhzlVar) {
        zzics zzicsVar = new zzics(this);
        zzhzi zzhziVarA = zzicsVar.next();
        zzics zzicsVar2 = new zzics(zzhzlVar);
        zzhzi zzhziVarA2 = zzicsVar2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = zzhziVarA.i() - i2;
            int i6 = zzhziVarA2.i() - i3;
            int iMin = Math.min(i5, i6);
            if (!(i2 == 0 ? zzhziVarA.A(zzhziVarA2, i3, iMin) : zzhziVarA2.A(zzhziVarA, i2, iMin))) {
                return false;
            }
            i4 += iMin;
            int i7 = this.f34738c;
            if (i4 >= i7) {
                if (i4 == i7) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == i5) {
                i2 = 0;
                zzhziVarA = zzicsVar.next();
            } else {
                i2 += iMin;
                zzhziVarA = zzhziVarA;
            }
            if (iMin == i6) {
                zzhziVarA2 = zzicsVar2.next();
                i3 = 0;
            } else {
                i3 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final int s(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        zzhzl zzhzlVar = this.f34739d;
        int i6 = this.f34741f;
        if (i5 <= i6) {
            return zzhzlVar.s(i2, i3, i4);
        }
        zzhzl zzhzlVar2 = this.f34740e;
        if (i3 >= i6) {
            return zzhzlVar2.s(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return zzhzlVar2.s(zzhzlVar.s(i2, i3, i7), 0, i4 - i7);
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    public final zzhzq t() {
        ArrayList arrayList = new ArrayList();
        zzics zzicsVar = new zzics(this);
        while (zzicsVar.hasNext()) {
            arrayList.add(zzicsVar.next().p());
        }
        Iterator it = arrayList.iterator();
        int i2 = 0;
        int iRemaining = 0;
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            iRemaining += byteBuffer.remaining();
            i2 = byteBuffer.hasArray() ? i2 | 1 : byteBuffer.isDirect() ? i2 | 2 : i2 | 4;
        }
        if (i2 == 2) {
            return new zzhzn(iRemaining, arrayList);
        }
        zzibh zzibhVar = new zzibh();
        zzibhVar.f34664a = arrayList.iterator();
        zzibhVar.f34666c = 0;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            zzibhVar.f34666c++;
        }
        zzibhVar.f34667d = -1;
        if (!zzibhVar.a()) {
            zzibhVar.f34665b = zzibe.f34662c;
            zzibhVar.f34667d = 0;
            zzibhVar.f34668e = 0;
            zzibhVar.f34672i = 0L;
        }
        return new zzhzo(zzibhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhzl
    /* renamed from: u */
    public final zzhzg iterator() {
        return new zzicq(this);
    }
}
