package com.swmansion.rnscreens.stack.views;

import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public abstract class ChildrenDrawingOrderStrategyBase implements ChildrenDrawingOrderStrategy {

    /* renamed from: a, reason: collision with root package name */
    public boolean f47139a;

    public ChildrenDrawingOrderStrategyBase() {
        this(0);
    }

    public final void b() {
        this.f47139a = false;
    }

    public final void c() {
        this.f47139a = true;
    }

    public ChildrenDrawingOrderStrategyBase(int i2) {
        this.f47139a = false;
    }
}
