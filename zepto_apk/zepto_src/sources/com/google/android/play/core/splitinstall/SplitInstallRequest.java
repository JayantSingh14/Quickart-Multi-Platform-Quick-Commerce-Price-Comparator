package com.google.android.play.core.splitinstall;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class SplitInstallRequest {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f41931a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f41932b;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f41933a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f41934b = new ArrayList();
    }

    public /* synthetic */ SplitInstallRequest(Builder builder) {
        this.f41931a = new ArrayList(builder.f41933a);
        this.f41932b = new ArrayList(builder.f41934b);
    }

    public final String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", this.f41931a, this.f41932b);
    }
}
