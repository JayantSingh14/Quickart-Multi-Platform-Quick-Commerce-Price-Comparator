package androidx.privacysandbox.ads.adservices.internal;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class AdServicesInfo {

    @RequiresApi
    @Metadata
    public static final class Extensions30ExtImpl {

        /* renamed from: a, reason: collision with root package name */
        public static final Extensions30ExtImpl f11199a = new Extensions30ExtImpl();

        @DoNotInline
        public final int a() {
            return SdkExtensions.getExtensionVersion(31);
        }
    }

    @RequiresApi
    @Metadata
    public static final class Extensions30Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final Extensions30Impl f11200a = new Extensions30Impl();

        @DoNotInline
        public final int a() {
            return SdkExtensions.getExtensionVersion(1000000);
        }
    }

    public static int a() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Extensions30Impl.f11200a.a();
        }
        return 0;
    }

    public static int b() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 31 || i2 == 32) {
            return Extensions30ExtImpl.f11199a.a();
        }
        return 0;
    }
}
