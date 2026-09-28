package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class XorWowRandom extends Random implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Companion f53821i = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public int f53822c;

    /* renamed from: d, reason: collision with root package name */
    public int f53823d;

    /* renamed from: e, reason: collision with root package name */
    public int f53824e;

    /* renamed from: f, reason: collision with root package name */
    public int f53825f;

    /* renamed from: g, reason: collision with root package name */
    public int f53826g;

    /* renamed from: h, reason: collision with root package name */
    public int f53827h;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Override // kotlin.random.Random
    public final int a(int i2) {
        return RandomKt.e(d(), i2);
    }

    @Override // kotlin.random.Random
    public final int d() {
        int i2 = this.f53822c;
        int i3 = i2 ^ (i2 >>> 2);
        this.f53822c = this.f53823d;
        this.f53823d = this.f53824e;
        this.f53824e = this.f53825f;
        int i4 = this.f53826g;
        this.f53825f = i4;
        int i5 = ((i3 ^ (i3 << 1)) ^ i4) ^ (i4 << 4);
        this.f53826g = i5;
        int i6 = this.f53827h + 362437;
        this.f53827h = i6;
        return i5 + i6;
    }
}
