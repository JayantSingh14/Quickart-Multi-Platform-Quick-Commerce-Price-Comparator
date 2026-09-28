package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.function.Function;

@RestrictTo
/* loaded from: classes4.dex */
public final class DynamicColor {

    /* renamed from: a, reason: collision with root package name */
    public final Function f40262a;

    /* renamed from: b, reason: collision with root package name */
    public final Function f40263b;

    /* renamed from: c, reason: collision with root package name */
    public final Function f40264c;

    /* renamed from: d, reason: collision with root package name */
    public final Function f40265d;

    public DynamicColor(String str, Function function, Function function2, boolean z, Function function3, ContrastCurve contrastCurve, Function function4) {
        new HashMap();
        this.f40262a = function;
        this.f40263b = function2;
        this.f40264c = function3;
        this.f40265d = function4;
    }

    public static DynamicColor a(String str, Function function, Function function2) {
        return new DynamicColor(str, function, function2, false, null, null, null);
    }

    public DynamicColor(a aVar, a aVar2, a aVar3) {
        new HashMap();
        this.f40262a = aVar;
        this.f40263b = aVar2;
        this.f40264c = null;
        this.f40265d = null;
    }
}
