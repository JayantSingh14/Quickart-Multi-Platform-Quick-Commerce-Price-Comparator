package com.facebook.react.viewmanagers;

import android.view.View;

/* loaded from: classes.dex */
public interface RNSScreenStackHeaderConfigManagerInterface<T extends View> {
    void setBackButtonDisplayMode(View view, String str);

    void setBackButtonInCustomView(View view, boolean z);

    void setBackTitle(View view, String str);

    void setBackTitleFontFamily(View view, String str);

    void setBackTitleFontSize(View view, int i2);

    void setBackTitleVisible(View view, boolean z);

    void setBackgroundColor(View view, Integer num);

    void setBlurEffect(View view, String str);

    void setColor(View view, Integer num);

    void setDirection(View view, String str);

    void setDisableBackButtonMenu(View view, boolean z);

    void setHidden(View view, boolean z);

    void setHideBackButton(View view, boolean z);

    void setHideShadow(View view, boolean z);

    void setLargeTitle(View view, boolean z);

    void setLargeTitleBackgroundColor(View view, Integer num);

    void setLargeTitleColor(View view, Integer num);

    void setLargeTitleFontFamily(View view, String str);

    void setLargeTitleFontSize(View view, int i2);

    void setLargeTitleFontWeight(View view, String str);

    void setLargeTitleHideShadow(View view, boolean z);

    void setTitle(View view, String str);

    void setTitleColor(View view, Integer num);

    void setTitleFontFamily(View view, String str);

    void setTitleFontSize(View view, int i2);

    void setTitleFontWeight(View view, String str);

    void setTopInsetEnabled(View view, boolean z);

    void setTranslucent(View view, boolean z);
}
