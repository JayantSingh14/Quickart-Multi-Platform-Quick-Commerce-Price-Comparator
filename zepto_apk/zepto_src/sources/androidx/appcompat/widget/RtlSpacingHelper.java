package androidx.appcompat.widget;

/* loaded from: classes3.dex */
class RtlSpacingHelper {

    /* renamed from: a, reason: collision with root package name */
    public int f1100a;

    /* renamed from: b, reason: collision with root package name */
    public int f1101b;

    /* renamed from: c, reason: collision with root package name */
    public int f1102c;

    /* renamed from: d, reason: collision with root package name */
    public int f1103d;

    /* renamed from: e, reason: collision with root package name */
    public int f1104e;

    /* renamed from: f, reason: collision with root package name */
    public int f1105f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1106g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1107h;

    public final void a(int i2, int i3) {
        this.f1102c = i2;
        this.f1103d = i3;
        this.f1107h = true;
        if (this.f1106g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f1100a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f1101b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1100a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f1101b = i3;
        }
    }
}
