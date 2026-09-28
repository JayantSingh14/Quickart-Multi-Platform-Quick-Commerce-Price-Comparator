package io.sentry.android.core.internal.threaddump;

import java.util.ArrayList;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class Lines {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f52284a;

    /* renamed from: b, reason: collision with root package name */
    public final int f52285b;

    /* renamed from: c, reason: collision with root package name */
    public int f52286c;

    public Lines(ArrayList arrayList) {
        this.f52284a = arrayList;
        this.f52285b = arrayList.size();
    }

    public final Line a() {
        int i2 = this.f52286c;
        if (i2 < 0 || i2 >= this.f52285b) {
            return null;
        }
        this.f52286c = i2 + 1;
        return (Line) this.f52284a.get(i2);
    }
}
