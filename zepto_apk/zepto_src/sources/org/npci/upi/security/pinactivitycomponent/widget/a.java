package org.npci.upi.security.pinactivitycomponent.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes5.dex */
public interface a {
    void a(String str);

    void a(String str, Drawable drawable, View.OnClickListener onClickListener, int i2, boolean z, boolean z2);

    boolean a();

    void b();

    boolean c();

    boolean d();

    int e();

    Object getFormDataTag();

    String getInputValue();

    boolean getTextEntered();

    boolean getToggleCheckBox();

    void setText(String str);

    void setTextEntered(boolean z);
}
