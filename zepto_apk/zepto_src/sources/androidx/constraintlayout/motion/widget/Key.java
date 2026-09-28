package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public abstract class Key {

    /* renamed from: a, reason: collision with root package name */
    public int f2085a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f2086b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f2087c = null;

    /* renamed from: d, reason: collision with root package name */
    public HashMap f2088d;

    public static float g(Number number) {
        return number instanceof Float ? ((Float) number).floatValue() : Float.parseFloat(number.toString());
    }

    public abstract void a(HashMap map);

    @Override // 
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract Key clone();

    public Key c(Key key) {
        this.f2085a = key.f2085a;
        this.f2086b = key.f2086b;
        this.f2087c = key.f2087c;
        this.f2088d = key.f2088d;
        return this;
    }

    public abstract void d(HashSet hashSet);

    public abstract void e(Context context, AttributeSet attributeSet);

    public void f(HashMap map) {
    }
}
