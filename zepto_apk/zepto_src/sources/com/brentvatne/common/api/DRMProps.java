package com.brentvatne.common.api;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DRMProps {

    /* renamed from: a, reason: collision with root package name */
    public String f15382a;

    /* renamed from: b, reason: collision with root package name */
    public String f15383b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f15384c = new String[0];

    /* renamed from: d, reason: collision with root package name */
    public boolean f15385d;

    @Metadata
    public static final class Companion {
    }

    public final String a() {
        return this.f15382a;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof DRMProps)) {
            DRMProps dRMProps = (DRMProps) obj;
            if (Intrinsics.b(this.f15382a, dRMProps.f15382a) && Intrinsics.b(this.f15383b, dRMProps.f15383b) && this.f15385d == dRMProps.f15385d && ArraysKt.j(this.f15384c, dRMProps.f15384c)) {
                return true;
            }
        }
        return false;
    }
}
