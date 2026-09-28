package androidx.recyclerview.widget;

/* loaded from: classes3.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a, reason: collision with root package name */
    public final ListAdapter f11348a;

    public AdapterListUpdateCallback(ListAdapter listAdapter) {
        this.f11348a = listAdapter;
    }

    public final void a(int i2, int i3) {
        this.f11348a.k(i2, i3);
    }

    public final void b(int i2, int i3) {
        this.f11348a.l(i2, i3);
    }
}
