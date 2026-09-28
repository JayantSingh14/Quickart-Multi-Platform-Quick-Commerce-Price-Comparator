package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class ScreenStackHeaderSubview extends FabricEnabledHeaderSubviewViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public int f47035a;

    /* renamed from: b, reason: collision with root package name */
    public int f47036b;

    /* renamed from: c, reason: collision with root package name */
    public Type f47037c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    /* loaded from: classes4.dex */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f47038a;

        /* renamed from: b, reason: collision with root package name */
        public static final Type f47039b;

        /* renamed from: c, reason: collision with root package name */
        public static final Type f47040c;

        /* renamed from: d, reason: collision with root package name */
        public static final Type f47041d;

        /* renamed from: e, reason: collision with root package name */
        public static final Type f47042e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ Type[] f47043f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f47044g;

        static {
            Type type = new Type("LEFT", 0);
            f47038a = type;
            Type type2 = new Type("CENTER", 1);
            f47039b = type2;
            Type type3 = new Type("RIGHT", 2);
            f47040c = type3;
            Type type4 = new Type("BACK", 3);
            f47041d = type4;
            Type type5 = new Type("SEARCH_BAR", 4);
            f47042e = type5;
            Type[] typeArr = {type, type2, type3, type4, type5};
            f47043f = typeArr;
            f47044g = EnumEntriesKt.a(typeArr);
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f47043f.clone();
        }
    }

    @Nullable
    public final ScreenStackHeaderConfig getConfig() {
        ViewParent parent = getParent();
        CustomToolbar customToolbar = parent instanceof CustomToolbar ? (CustomToolbar) parent : null;
        if (customToolbar != null) {
            return customToolbar.getConfig();
        }
        return null;
    }

    @NotNull
    public final Type getType() {
        return this.f47037c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == 1073741824) {
            this.f47035a = View.MeasureSpec.getSize(i2);
            this.f47036b = View.MeasureSpec.getSize(i3);
            Object parent = getParent();
            if (parent != null) {
                forceLayout();
                ((View) parent).requestLayout();
            }
        }
        setMeasuredDimension(this.f47035a, this.f47036b);
    }

    public final void setType(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "<set-?>");
        this.f47037c = type;
    }
}
