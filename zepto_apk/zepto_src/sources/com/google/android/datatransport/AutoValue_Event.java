package com.google.android.datatransport;

/* loaded from: classes3.dex */
final class AutoValue_Event<T> extends Event<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f20509a;

    /* renamed from: b, reason: collision with root package name */
    public final Priority f20510b;

    /* renamed from: c, reason: collision with root package name */
    public final ProductData f20511c;

    public AutoValue_Event(Object obj, Priority priority, ProductData productData) {
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f20509a = obj;
        this.f20510b = priority;
        this.f20511c = productData;
    }

    @Override // com.google.android.datatransport.Event
    public final Integer a() {
        return null;
    }

    @Override // com.google.android.datatransport.Event
    public final EventContext b() {
        return null;
    }

    @Override // com.google.android.datatransport.Event
    public final Object c() {
        return this.f20509a;
    }

    @Override // com.google.android.datatransport.Event
    public final Priority d() {
        return this.f20510b;
    }

    @Override // com.google.android.datatransport.Event
    public final ProductData e() {
        return this.f20511c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        if (event.a() != null) {
            return false;
        }
        if (!this.f20509a.equals(event.c()) || !this.f20510b.equals(event.d())) {
            return false;
        }
        ProductData productData = this.f20511c;
        if (productData == null) {
            if (event.e() != null) {
                return false;
            }
        } else if (!productData.equals(event.e())) {
            return false;
        }
        return event.b() == null;
    }

    public final int hashCode() {
        int iHashCode = ((((1000003 * 1000003) ^ this.f20509a.hashCode()) * 1000003) ^ this.f20510b.hashCode()) * 1000003;
        ProductData productData = this.f20511c;
        return (iHashCode ^ (productData == null ? 0 : productData.hashCode())) * 1000003;
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f20509a + ", priority=" + this.f20510b + ", productData=" + this.f20511c + ", eventContext=null}";
    }
}
