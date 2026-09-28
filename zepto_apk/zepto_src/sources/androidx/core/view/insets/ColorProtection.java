package androidx.core.view.insets;

/* loaded from: classes3.dex */
public class ColorProtection extends Protection {

    /* renamed from: b, reason: collision with root package name */
    public int f3226b;

    @Override // androidx.core.view.insets.Protection
    public final void a(int i2) {
        if (this.f3226b == i2) {
            return;
        }
        this.f3226b = i2;
        throw null;
    }
}
