package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes.dex */
final class LocaleListPlatformWrapper implements LocaleListInterface {

    /* renamed from: a, reason: collision with root package name */
    public final LocaleList f2884a;

    public LocaleListPlatformWrapper(LocaleList localeList) {
        this.f2884a = localeList;
    }

    @Override // androidx.core.os.LocaleListInterface
    public final Object a() {
        return this.f2884a;
    }

    public final boolean equals(Object obj) {
        return this.f2884a.equals(((LocaleListInterface) obj).a());
    }

    public final int hashCode() {
        return this.f2884a.hashCode();
    }

    public final String toString() {
        return this.f2884a.toString();
    }
}
