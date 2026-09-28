package com.unistyles;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class Dimensions {
    private int height;
    private int width;

    public Dimensions(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int i2) {
        this.height = i2;
    }

    public final void setWidth(int i2) {
        this.width = i2;
    }

    @NotNull
    public String toString() {
        return this.width + "x" + this.height;
    }
}
