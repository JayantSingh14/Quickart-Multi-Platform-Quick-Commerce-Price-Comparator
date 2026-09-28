package com.unistyles;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class Insets {
    private int bottom;
    private int left;
    private int right;
    private int top;

    public Insets(int i2, int i3, int i4, int i5) {
        this.top = i2;
        this.bottom = i3;
        this.left = i4;
        this.right = i5;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public final void setBottom(int i2) {
        this.bottom = i2;
    }

    public final void setLeft(int i2) {
        this.left = i2;
    }

    public final void setRight(int i2) {
        this.right = i2;
    }

    public final void setTop(int i2) {
        this.top = i2;
    }

    @NotNull
    public String toString() {
        int i2 = this.top;
        int i3 = this.bottom;
        int i4 = this.left;
        int i5 = this.right;
        StringBuilder sbT = android.support.v4.media.b.t(i2, i3, "T:", "B:", "L:");
        sbT.append(i4);
        sbT.append("R:");
        sbT.append(i5);
        return sbT.toString();
    }
}
