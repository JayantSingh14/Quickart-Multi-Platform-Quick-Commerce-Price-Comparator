package coil3.size;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import coil3.decode.DecodeUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ScaleDrawable extends Drawable implements Drawable.Callback, Animatable {

    @NotNull
    private final Drawable child;
    private float childDx;
    private float childDy;
    private float childScale;

    @NotNull
    private final Scale scale;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ScaleDrawable(@NotNull Drawable drawable) {
        this(drawable, null, 2, 0 == true ? 1 : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        int iSave = canvas.save();
        try {
            canvas.translate(this.childDx, this.childDy);
            float f2 = this.childScale;
            canvas.scale(f2, f2);
            this.child.draw(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.child.getAlpha();
    }

    @NotNull
    public final Drawable getChild() {
        return this.child;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.child.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.child.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.child.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public int getOpacity() {
        return this.child.getOpacity();
    }

    @NotNull
    public final Scale getScale() {
        return this.scale;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Object obj = this.child;
        return (obj instanceof Animatable) && ((Animatable) obj).isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NotNull Rect rect) {
        int intrinsicWidth = this.child.getIntrinsicWidth();
        int intrinsicHeight = this.child.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            this.child.setBounds(rect);
            this.childDx = 0.0f;
            this.childDy = 0.0f;
            this.childScale = 1.0f;
            return;
        }
        int iWidth = rect.width();
        int iHeight = rect.height();
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(intrinsicWidth, intrinsicHeight, iWidth, iHeight, this.scale);
        double d2 = 2;
        int iA = MathKt.a((iWidth - (intrinsicWidth * dComputeSizeMultiplier)) / d2);
        int iA2 = MathKt.a((iHeight - (intrinsicHeight * dComputeSizeMultiplier)) / d2);
        this.child.setBounds(iA, iA2, intrinsicWidth + iA, intrinsicHeight + iA2);
        this.childDx = rect.left;
        this.childDy = rect.top;
        this.childScale = (float) dComputeSizeMultiplier;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        return this.child.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NotNull int[] iArr) {
        return this.child.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NotNull Drawable drawable, @NotNull Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.child.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.child.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        this.child.setTint(i2);
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi
    public void setTintBlendMode(@Nullable BlendMode blendMode) {
        this.child.setTintBlendMode(blendMode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.child.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.child.setTintMode(mode);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Object obj = this.child;
        if (obj instanceof Animatable) {
            ((Animatable) obj).start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Object obj = this.child;
        if (obj instanceof Animatable) {
            ((Animatable) obj).stop();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NotNull Drawable drawable, @NotNull Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public /* synthetic */ ScaleDrawable(Drawable drawable, Scale scale, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, (i2 & 2) != 0 ? Scale.FIT : scale);
    }

    @JvmOverloads
    public ScaleDrawable(@NotNull Drawable drawable, @NotNull Scale scale) {
        this.child = drawable;
        this.scale = scale;
        this.childScale = 1.0f;
        drawable.setCallback(this);
    }
}
