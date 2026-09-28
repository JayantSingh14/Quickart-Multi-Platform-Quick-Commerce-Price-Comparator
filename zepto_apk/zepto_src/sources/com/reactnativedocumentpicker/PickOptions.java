package com.reactnativedocumentpicker;

import android.support.v4.media.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class PickOptions {

    /* renamed from: a, reason: collision with root package name */
    public final String f46371a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f46372b;

    /* renamed from: c, reason: collision with root package name */
    public final String f46373c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f46374d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f46375e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f46376f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f46377g;

    public PickOptions(String str, String[] mimeTypes, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(mimeTypes, "mimeTypes");
        this.f46371a = str;
        this.f46372b = mimeTypes;
        this.f46373c = str2;
        this.f46374d = z;
        this.f46375e = z2;
        this.f46376f = z3;
        this.f46377g = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickOptions)) {
            return false;
        }
        PickOptions pickOptions = (PickOptions) obj;
        return Intrinsics.b(this.f46371a, pickOptions.f46371a) && Intrinsics.b(this.f46372b, pickOptions.f46372b) && Intrinsics.b(this.f46373c, pickOptions.f46373c) && this.f46374d == pickOptions.f46374d && this.f46375e == pickOptions.f46375e && this.f46376f == pickOptions.f46376f && this.f46377g == pickOptions.f46377g;
    }

    public final int hashCode() {
        String str = this.f46371a;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f46372b)) * 31;
        String str2 = this.f46373c;
        return Boolean.hashCode(this.f46377g) + ((Boolean.hashCode(this.f46376f) + ((Boolean.hashCode(this.f46375e) + ((Boolean.hashCode(this.f46374d) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String string = Arrays.toString(this.f46372b);
        StringBuilder sb = new StringBuilder("PickOptions(mode=");
        b.B(sb, this.f46371a, ", mimeTypes=", string, ", initialDirectoryUrl=");
        sb.append(this.f46373c);
        sb.append(", localOnly=");
        sb.append(this.f46374d);
        sb.append(", multiple=");
        sb.append(this.f46375e);
        sb.append(", requestLongTermAccess=");
        sb.append(this.f46376f);
        sb.append(", allowVirtualFiles=");
        sb.append(this.f46377g);
        sb.append(")");
        return sb.toString();
    }
}
