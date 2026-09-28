package com.unistyles;

import kotlin.Metadata;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class Screen {
    private float fontScale;
    private int height;
    private float pixelRatio;
    private int width;

    public Screen(int i2, int i3, float f2, float f3) {
        this.width = i2;
        this.height = i3;
        this.pixelRatio = f2;
        this.fontScale = f3;
    }

    public final float getFontScale() {
        return this.fontScale;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float getPixelRatio() {
        return this.pixelRatio;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setFontScale(float f2) {
        this.fontScale = f2;
    }

    public final void setHeight(int i2) {
        this.height = i2;
    }

    public final void setPixelRatio(float f2) {
        this.pixelRatio = f2;
    }

    public final void setWidth(int i2) {
        this.width = i2;
    }

    @NotNull
    public String toString() {
        return this.width + "x" + this.height + StringUtils.SPACE + this.pixelRatio + StringUtils.SPACE + this.fontScale;
    }
}
