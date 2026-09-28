package androidx.recyclerview.widget;

/* loaded from: classes3.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a, reason: collision with root package name */
    public final AdapterListUpdateCallback f11370a;

    /* renamed from: b, reason: collision with root package name */
    public int f11371b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f11372c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f11373d = -1;

    /* renamed from: e, reason: collision with root package name */
    public Object f11374e = null;

    public BatchingListUpdateCallback(AdapterListUpdateCallback adapterListUpdateCallback) {
        this.f11370a = adapterListUpdateCallback;
    }

    public final void a() {
        int i2 = this.f11371b;
        if (i2 == 0) {
            return;
        }
        AdapterListUpdateCallback adapterListUpdateCallback = this.f11370a;
        if (i2 == 1) {
            adapterListUpdateCallback.a(this.f11372c, this.f11373d);
        } else if (i2 == 2) {
            adapterListUpdateCallback.b(this.f11372c, this.f11373d);
        } else if (i2 == 3) {
            adapterListUpdateCallback.f11348a.f11563a.d(this.f11372c, this.f11373d, this.f11374e);
        }
        this.f11374e = null;
        this.f11371b = 0;
    }

    public final void b(int i2, int i3, Object obj) {
        int i4;
        int i5;
        int i6;
        if (this.f11371b == 3 && i2 <= (i5 = this.f11373d + (i4 = this.f11372c)) && (i6 = i2 + i3) >= i4 && this.f11374e == obj) {
            this.f11372c = Math.min(i2, i4);
            this.f11373d = Math.max(i5, i6) - this.f11372c;
            return;
        }
        a();
        this.f11372c = i2;
        this.f11373d = i3;
        this.f11374e = obj;
        this.f11371b = 3;
    }

    public final void c(int i2, int i3) {
        a();
        this.f11370a.f11348a.f11563a.c(i2, i3);
    }
}
