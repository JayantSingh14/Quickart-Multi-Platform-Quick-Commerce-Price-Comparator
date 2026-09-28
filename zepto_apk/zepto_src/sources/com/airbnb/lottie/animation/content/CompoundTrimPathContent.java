package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class CompoundTrimPathContent {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f14226a = new ArrayList();

    public final void a(Path path) {
        ArrayList arrayList = this.f14226a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            TrimPathContent trimPathContent = (TrimPathContent) arrayList.get(size);
            ThreadLocal threadLocal = Utils.f14810a;
            if (trimPathContent != null && !trimPathContent.f14323a) {
                Utils.a(path, trimPathContent.f14326d.l() / 100.0f, trimPathContent.f14327e.l() / 100.0f, trimPathContent.f14328f.l() / 360.0f);
            }
        }
    }
}
