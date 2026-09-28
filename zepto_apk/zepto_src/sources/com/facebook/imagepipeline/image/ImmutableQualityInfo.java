package com.facebook.imagepipeline.image;

import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.common.api.Api;

@Nullsafe
/* loaded from: classes3.dex */
public class ImmutableQualityInfo implements QualityInfo {

    /* renamed from: d, reason: collision with root package name */
    public static final ImmutableQualityInfo f17971d = d(Api.BaseClientBuilder.API_PRIORITY_OTHER, true, true);

    /* renamed from: a, reason: collision with root package name */
    public int f17972a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17973b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17974c;

    public static ImmutableQualityInfo d(int i2, boolean z, boolean z2) {
        ImmutableQualityInfo immutableQualityInfo = new ImmutableQualityInfo();
        immutableQualityInfo.f17972a = i2;
        immutableQualityInfo.f17973b = z;
        immutableQualityInfo.f17974c = z2;
        return immutableQualityInfo;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public final boolean a() {
        return this.f17974c;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public final boolean b() {
        return this.f17973b;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public final int c() {
        return this.f17972a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableQualityInfo)) {
            return false;
        }
        ImmutableQualityInfo immutableQualityInfo = (ImmutableQualityInfo) obj;
        return this.f17972a == immutableQualityInfo.f17972a && this.f17973b == immutableQualityInfo.f17973b && this.f17974c == immutableQualityInfo.f17974c;
    }

    public final int hashCode() {
        return ((this.f17973b ? 4194304 : 0) ^ this.f17972a) ^ (this.f17974c ? 8388608 : 0);
    }
}
