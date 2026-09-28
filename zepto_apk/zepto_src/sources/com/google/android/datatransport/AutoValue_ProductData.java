package com.google.android.datatransport;

/* loaded from: classes3.dex */
final class AutoValue_ProductData extends ProductData {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f20512a;

    public AutoValue_ProductData(Integer num) {
        this.f20512a = num;
    }

    @Override // com.google.android.datatransport.ProductData
    public final Integer a() {
        return this.f20512a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductData)) {
            return false;
        }
        Integer num = this.f20512a;
        Integer numA = ((ProductData) obj).a();
        return num == null ? numA == null : num.equals(numA);
    }

    public final int hashCode() {
        Integer num = this.f20512a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public final String toString() {
        return "ProductData{productId=" + this.f20512a + "}";
    }
}
