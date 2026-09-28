package androidx.media3.exoplayer.dash.manifest;

import androidx.media3.common.util.UnstableApi;
import com.google.common.base.Objects;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class BaseUrl {

    /* renamed from: a, reason: collision with root package name */
    public final String f6785a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6786b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6787c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6788d;

    public BaseUrl(int i2, int i3, String str, String str2) {
        this.f6785a = str;
        this.f6786b = str2;
        this.f6787c = i2;
        this.f6788d = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseUrl)) {
            return false;
        }
        BaseUrl baseUrl = (BaseUrl) obj;
        return this.f6787c == baseUrl.f6787c && this.f6788d == baseUrl.f6788d && Objects.a(this.f6785a, baseUrl.f6785a) && Objects.a(this.f6786b, baseUrl.f6786b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6785a, this.f6786b, Integer.valueOf(this.f6787c), Integer.valueOf(this.f6788d)});
    }
}
