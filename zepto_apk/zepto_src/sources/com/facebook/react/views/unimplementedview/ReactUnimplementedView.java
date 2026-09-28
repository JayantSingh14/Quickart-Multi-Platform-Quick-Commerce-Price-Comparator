package com.facebook.react.views.unimplementedview;

import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class ReactUnimplementedView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final AppCompatTextView f20232a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactUnimplementedView(ThemedReactContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        AppCompatTextView appCompatTextView = new AppCompatTextView(context, null);
        this.f20232a = appCompatTextView;
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        appCompatTextView.setGravity(17);
        appCompatTextView.setTextColor(-1);
        setBackgroundColor(1442775040);
        setGravity(1);
        setOrientation(1);
        addView(appCompatTextView);
    }

    public final void setName$ReactAndroid_release(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f20232a.setText("'" + name + "' is not Fabric compatible yet.");
    }
}
