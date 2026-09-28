package androidx.webkit.internal;

import android.os.Build;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes3.dex */
public abstract class ApiFeature implements ConditionallySupportedFeature {

    /* renamed from: c, reason: collision with root package name */
    public static final HashSet f12428c = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final String f12429a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12430b;

    public static class LAZY_HOLDER {

        /* renamed from: a, reason: collision with root package name */
        public static final HashSet f12431a = new HashSet(Arrays.asList(WebViewGlueCommunicator.LAZY_FACTORY_HOLDER.f12462a.a()));
    }

    public static class M extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return true;
        }
    }

    public static class N extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return true;
        }
    }

    public static class NoFramework extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return false;
        }
    }

    public static class O extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    public static class O_MR1 extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    public static class P extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    public static class Q extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    public static class T extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean c() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public ApiFeature(String str, String str2) {
        this.f12429a = str;
        this.f12430b = str2;
        f12428c.add(this);
    }

    @Override // androidx.webkit.internal.ConditionallySupportedFeature
    public final boolean a() {
        return c() || d();
    }

    @Override // androidx.webkit.internal.ConditionallySupportedFeature
    public final String b() {
        return this.f12429a;
    }

    public abstract boolean c();

    public boolean d() {
        HashSet hashSet = LAZY_HOLDER.f12431a;
        String str = this.f12430b;
        if (hashSet.contains(str)) {
            return true;
        }
        String str2 = Build.TYPE;
        return ("eng".equals(str2) || "userdebug".equals(str2)) && hashSet.contains(str.concat(":dev"));
    }
}
