package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xbill.DNS.Message;

@Metadata
/* loaded from: classes.dex */
public final class Settings {

    /* renamed from: a, reason: collision with root package name */
    public int f56764a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f56765b = new int[10];

    @Metadata
    public static final class Companion {
    }

    public final int a() {
        return (this.f56764a & 128) != 0 ? this.f56765b[7] : Message.MAXLENGTH;
    }

    public final void b(Settings other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i2 = 0; i2 < 10; i2++) {
            if (((1 << i2) & other.f56764a) != 0) {
                c(i2, other.f56765b[i2]);
            }
        }
    }

    public final void c(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.f56765b;
            if (i2 >= iArr.length) {
                return;
            }
            this.f56764a = (1 << i2) | this.f56764a;
            iArr[i2] = i3;
        }
    }
}
