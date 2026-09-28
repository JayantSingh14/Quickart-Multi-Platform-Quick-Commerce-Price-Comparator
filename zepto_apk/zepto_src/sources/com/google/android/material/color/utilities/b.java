package com.google.android.material.color.utilities;

import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f40271a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f40272b;

    public /* synthetic */ b(MaterialDynamicColors materialDynamicColors, int i2) {
        this.f40271a = i2;
        this.f40272b = materialDynamicColors;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f40271a) {
            case 0:
                MaterialDynamicColors materialDynamicColors = this.f40272b;
                materialDynamicColors.e();
                materialDynamicColors.d();
                return new ToneDeltaPair();
            case 1:
                MaterialDynamicColors materialDynamicColors2 = this.f40272b;
                materialDynamicColors2.i();
                materialDynamicColors2.h();
                return new ToneDeltaPair();
            case 2:
                this.f40272b.getClass();
                throw null;
            case 3:
                MaterialDynamicColors materialDynamicColors3 = this.f40272b;
                materialDynamicColors3.g();
                materialDynamicColors3.f();
                return new ToneDeltaPair();
            case 4:
                MaterialDynamicColors materialDynamicColors4 = this.f40272b;
                materialDynamicColors4.e();
                materialDynamicColors4.d();
                return new ToneDeltaPair();
            case 5:
                return this.f40272b.d();
            case 6:
                return this.f40272b.a();
            case 7:
                return this.f40272b.e();
            case 8:
                MaterialDynamicColors materialDynamicColors5 = this.f40272b;
                materialDynamicColors5.i();
                materialDynamicColors5.h();
                return new ToneDeltaPair();
            case 9:
                return this.f40272b.f();
            case 10:
                MaterialDynamicColors materialDynamicColors6 = this.f40272b;
                materialDynamicColors6.g();
                materialDynamicColors6.f();
                return new ToneDeltaPair();
            case 11:
                return this.f40272b.h();
            case 12:
                return this.f40272b.i();
            case 13:
                return this.f40272b.g();
            case 14:
                MaterialDynamicColors materialDynamicColors7 = this.f40272b;
                materialDynamicColors7.b();
                materialDynamicColors7.a();
                return new ToneDeltaPair();
            case 15:
                return this.f40272b.b();
            default:
                MaterialDynamicColors materialDynamicColors8 = this.f40272b;
                materialDynamicColors8.b();
                materialDynamicColors8.a();
                return new ToneDeltaPair();
        }
    }
}
