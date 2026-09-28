package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import coil3.network.internal.UtilsKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class TextViewCompat {

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api23Impl {
        public static int a(AppCompatTextView appCompatTextView) {
            return appCompatTextView.getBreakStrategy();
        }

        public static int b(AppCompatTextView appCompatTextView) {
            return appCompatTextView.getHyphenationFrequency();
        }

        public static void c(AppCompatTextView appCompatTextView, int i2) {
            appCompatTextView.setBreakStrategy(i2);
        }

        public static void d(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        public static void e(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        public static void f(AppCompatTextView appCompatTextView, int i2) {
            appCompatTextView.setHyphenationFrequency(i2);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api24Impl {
        public static DecimalFormatSymbols a(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api26Impl {
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api28Impl {
        public static String[] a(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        public static PrecomputedText.Params b(AppCompatTextView appCompatTextView) {
            return appCompatTextView.getTextMetricsParams();
        }

        public static void c(TextView textView, int i2) {
            textView.setFirstBaselineToTopHeight(i2);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api34Impl {
        public static void a(TextView textView, int i2, float f2) {
            textView.setLineHeight(i2, f2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface AutoSizeTextType {
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class OreoCallback implements ActionMode.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f3289a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f3290b;

        /* renamed from: c, reason: collision with root package name */
        public Class f3291c;

        /* renamed from: d, reason: collision with root package name */
        public Method f3292d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3293e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f3294f = false;

        public OreoCallback(ActionMode.Callback callback, TextView textView) {
            this.f3289a = callback;
            this.f3290b = textView;
        }

        public final ActionMode.Callback a() {
            return this.f3289a;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f3289a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f3289a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode actionMode) {
            this.f3289a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            String str;
            TextView textView = this.f3290b;
            Context context = textView.getContext();
            PackageManager packageManager = context.getPackageManager();
            boolean z = this.f3294f;
            Class cls = Integer.TYPE;
            if (!z) {
                this.f3294f = true;
                try {
                    Class<?> cls2 = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f3291c = cls2;
                    this.f3292d = cls2.getDeclaredMethod("removeItemAt", cls);
                    this.f3293e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f3291c = null;
                    this.f3292d = null;
                    this.f3293e = false;
                }
            }
            try {
                Method declaredMethod = (this.f3293e && this.f3291c.isInstance(menu)) ? this.f3292d : menu.getClass().getDeclaredMethod("removeItemAt", cls);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                ArrayList arrayList = new ArrayList();
                if (context instanceof Activity) {
                    for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType(UtilsKt.MIME_TYPE_TEXT_PLAIN), 0)) {
                        if (!context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                            ActivityInfo activityInfo = resolveInfo.activityInfo;
                            if (activityInfo.exported && ((str = activityInfo.permission) == null || context.checkSelfPermission(str) == 0)) {
                            }
                        }
                        arrayList.add(resolveInfo);
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ResolveInfo resolveInfo2 = (ResolveInfo) arrayList.get(i2);
                    MenuItem menuItemAdd = menu.add(0, 0, i2 + 100, resolveInfo2.loadLabel(packageManager));
                    Intent intentPutExtra = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType(UtilsKt.MIME_TYPE_TEXT_PLAIN).putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled()));
                    ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
                    menuItemAdd.setIntent(intentPutExtra.setClassName(activityInfo2.packageName, activityInfo2.name)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
            return this.f3289a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static PrecomputedTextCompat.Params a(AppCompatTextView appCompatTextView) {
        TextDirectionHeuristic textDirectionHeuristic;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new PrecomputedTextCompat.Params(Api28Impl.b(appCompatTextView));
        }
        PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(new TextPaint(appCompatTextView.getPaint()));
        builder.b(Api23Impl.a(appCompatTextView));
        builder.c(Api23Impl.b(appCompatTextView));
        if (appCompatTextView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else {
            if (i2 < 28 || (appCompatTextView.getInputType() & 15) != 3) {
                boolean z = appCompatTextView.getLayoutDirection() == 1;
                switch (appCompatTextView.getTextDirection()) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        break;
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (!z) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                            break;
                        } else {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        }
                }
            } else {
                byte directionality = Character.getDirectionality(Api28Impl.a(Api24Impl.a(appCompatTextView.getTextLocale()))[0].codePointAt(0));
                textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            }
        }
        builder.d(textDirectionHeuristic);
        return builder.a();
    }

    public static void b(TextView textView, ColorStateList colorStateList) {
        Api23Impl.d(textView, colorStateList);
    }

    public static void c(TextView textView, PorterDuff.Mode mode) {
        Api23Impl.e(textView, mode);
    }

    public static void d(TextView textView, int i2) {
        Preconditions.b(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.c(textView, i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void e(TextView textView, int i2) {
        Preconditions.b(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void f(TextView textView, int i2) {
        Preconditions.b(i2);
        if (i2 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i2 - r0, 1.0f);
        }
    }

    public static void g(TextView textView, int i2, float f2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.a(textView, i2, f2);
        } else {
            f(textView, Math.round(TypedValue.applyDimension(i2, f2, textView.getResources().getDisplayMetrics())));
        }
    }

    public static void h(AppCompatTextView appCompatTextView, PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            appCompatTextView.setText(precomputedTextCompat.a());
            return;
        }
        PrecomputedTextCompat.Params paramsA = a(appCompatTextView);
        precomputedTextCompat.getClass();
        paramsA.a(null);
        throw null;
    }

    public static void i(AppCompatTextView appCompatTextView, PrecomputedTextCompat.Params params) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristicD = params.d();
        TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i2 = 1;
        if (textDirectionHeuristicD != textDirectionHeuristic2 && textDirectionHeuristicD != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristicD == TextDirectionHeuristics.ANYRTL_LTR) {
                i2 = 2;
            } else if (textDirectionHeuristicD == TextDirectionHeuristics.LTR) {
                i2 = 3;
            } else if (textDirectionHeuristicD == TextDirectionHeuristics.RTL) {
                i2 = 4;
            } else if (textDirectionHeuristicD == TextDirectionHeuristics.LOCALE) {
                i2 = 5;
            } else if (textDirectionHeuristicD == textDirectionHeuristic) {
                i2 = 6;
            } else if (textDirectionHeuristicD == textDirectionHeuristic2) {
                i2 = 7;
            }
        }
        appCompatTextView.setTextDirection(i2);
        appCompatTextView.getPaint().set(params.e());
        Api23Impl.c(appCompatTextView, params.b());
        Api23Impl.f(appCompatTextView, params.c());
    }

    public static ActionMode.Callback j(ActionMode.Callback callback) {
        return (!(callback instanceof OreoCallback) || Build.VERSION.SDK_INT < 26) ? callback : ((OreoCallback) callback).a();
    }

    public static ActionMode.Callback k(ActionMode.Callback callback, TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof OreoCallback) || callback == null) ? callback : new OreoCallback(callback, textView);
    }
}
