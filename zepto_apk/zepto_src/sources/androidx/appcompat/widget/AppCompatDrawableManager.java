package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

@RestrictTo
/* loaded from: classes.dex */
public final class AppCompatDrawableManager {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f834b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static AppCompatDrawableManager f835c;

    /* renamed from: a, reason: collision with root package name */
    public ResourceManagerInternal f836a;

    /* renamed from: androidx.appcompat.widget.AppCompatDrawableManager$1, reason: invalid class name */
    class AnonymousClass1 implements ResourceManagerInternal.ResourceManagerHooks {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f837a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b, reason: collision with root package name */
        public final int[] f838b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c, reason: collision with root package name */
        public final int[] f839c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d, reason: collision with root package name */
        public final int[] f840d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e, reason: collision with root package name */
        public final int[] f841e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

        /* renamed from: f, reason: collision with root package name */
        public final int[] f842f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        public static boolean a(int i2, int[] iArr) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        public static ColorStateList b(int i2, Context context) {
            int iC = ThemeUtils.c(R.attr.colorControlHighlight, context);
            int iB = ThemeUtils.b(R.attr.colorButtonNormal, context);
            int[] iArr = ThemeUtils.f1173b;
            int[] iArr2 = ThemeUtils.f1175d;
            int iH = ColorUtils.h(iC, i2);
            return new ColorStateList(new int[][]{iArr, iArr2, ThemeUtils.f1174c, ThemeUtils.f1177f}, new int[]{iB, iH, ColorUtils.h(iC, i2), i2});
        }

        public static LayerDrawable d(ResourceManagerInternal resourceManagerInternal, Context context, int i2) throws Resources.NotFoundException {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
            Drawable drawableD = resourceManagerInternal.d(R.drawable.abc_star_black_48dp, context);
            Drawable drawableD2 = resourceManagerInternal.d(R.drawable.abc_star_half_black_48dp, context);
            if ((drawableD instanceof BitmapDrawable) && drawableD.getIntrinsicWidth() == dimensionPixelSize && drawableD.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableD;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableD.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableD.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableD2 instanceof BitmapDrawable) && drawableD2.getIntrinsicWidth() == dimensionPixelSize && drawableD2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableD2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableD2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableD2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        public static void f(Drawable drawable, int i2, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = AppCompatDrawableManager.f834b;
            }
            drawableMutate.setColorFilter(AppCompatDrawableManager.c(i2, mode));
        }

        public final LayerDrawable c(ResourceManagerInternal resourceManagerInternal, Context context, int i2) {
            if (i2 == R.drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{resourceManagerInternal.d(R.drawable.abc_cab_background_internal_bg, context), resourceManagerInternal.d(R.drawable.abc_cab_background_top_mtrl_alpha, context)});
            }
            if (i2 == R.drawable.abc_ratingbar_material) {
                return d(resourceManagerInternal, context, R.dimen.abc_star_big);
            }
            if (i2 == R.drawable.abc_ratingbar_indicator_material) {
                return d(resourceManagerInternal, context, R.dimen.abc_star_medium);
            }
            if (i2 == R.drawable.abc_ratingbar_small_material) {
                return d(resourceManagerInternal, context, R.dimen.abc_star_small);
            }
            return null;
        }

        public final ColorStateList e(int i2, Context context) {
            if (i2 == R.drawable.abc_edit_text_material) {
                return AppCompatResources.a(R.color.abc_tint_edittext, context);
            }
            if (i2 == R.drawable.abc_switch_track_mtrl_alpha) {
                return AppCompatResources.a(R.color.abc_tint_switch_track, context);
            }
            if (i2 != R.drawable.abc_switch_thumb_material) {
                if (i2 == R.drawable.abc_btn_default_mtrl_shape) {
                    return b(ThemeUtils.c(R.attr.colorButtonNormal, context), context);
                }
                if (i2 == R.drawable.abc_btn_borderless_material) {
                    return b(0, context);
                }
                if (i2 == R.drawable.abc_btn_colored_material) {
                    return b(ThemeUtils.c(R.attr.colorAccent, context), context);
                }
                if (i2 == R.drawable.abc_spinner_mtrl_am_alpha || i2 == R.drawable.abc_spinner_textfield_background_material) {
                    return AppCompatResources.a(R.color.abc_tint_spinner, context);
                }
                if (a(i2, this.f838b)) {
                    return ThemeUtils.d(R.attr.colorControlNormal, context);
                }
                if (a(i2, this.f841e)) {
                    return AppCompatResources.a(R.color.abc_tint_default, context);
                }
                if (a(i2, this.f842f)) {
                    return AppCompatResources.a(R.color.abc_tint_btn_checkable, context);
                }
                if (i2 == R.drawable.abc_seekbar_thumb_material) {
                    return AppCompatResources.a(R.color.abc_tint_seek_thumb, context);
                }
                return null;
            }
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListD = ThemeUtils.d(R.attr.colorSwitchThumbNormal, context);
            if (colorStateListD == null || !colorStateListD.isStateful()) {
                iArr[0] = ThemeUtils.f1173b;
                iArr2[0] = ThemeUtils.b(R.attr.colorSwitchThumbNormal, context);
                iArr[1] = ThemeUtils.f1176e;
                iArr2[1] = ThemeUtils.c(R.attr.colorControlActivated, context);
                iArr[2] = ThemeUtils.f1177f;
                iArr2[2] = ThemeUtils.c(R.attr.colorSwitchThumbNormal, context);
            } else {
                int[] iArr3 = ThemeUtils.f1173b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
                iArr[1] = ThemeUtils.f1176e;
                iArr2[1] = ThemeUtils.c(R.attr.colorControlActivated, context);
                iArr[2] = ThemeUtils.f1177f;
                iArr2[2] = colorStateListD.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }
    }

    public static synchronized AppCompatDrawableManager a() {
        try {
            if (f835c == null) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f835c;
    }

    public static synchronized PorterDuffColorFilter c(int i2, PorterDuff.Mode mode) {
        return ResourceManagerInternal.f(i2, mode);
    }

    public static synchronized void d() {
        if (f835c == null) {
            AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
            f835c = appCompatDrawableManager;
            appCompatDrawableManager.f836a = ResourceManagerInternal.b();
            ResourceManagerInternal resourceManagerInternal = f835c.f836a;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            synchronized (resourceManagerInternal) {
                resourceManagerInternal.f1099e = anonymousClass1;
            }
        }
    }

    public static void e(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        PorterDuff.Mode mode = ResourceManagerInternal.f1092f;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = tintInfo.f1183d;
        if (!z && !tintInfo.f1182c) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterF = null;
        ColorStateList colorStateList = z ? tintInfo.f1180a : null;
        PorterDuff.Mode mode2 = tintInfo.f1182c ? tintInfo.f1181b : ResourceManagerInternal.f1092f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterF = ResourceManagerInternal.f(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterF);
    }

    public final synchronized Drawable b(int i2, Context context) {
        return this.f836a.d(i2, context);
    }
}
