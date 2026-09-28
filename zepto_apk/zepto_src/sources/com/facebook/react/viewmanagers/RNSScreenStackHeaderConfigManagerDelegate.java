package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes.dex */
public class RNSScreenStackHeaderConfigManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSScreenStackHeaderConfigManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        str.getClass();
        BaseViewManager baseViewManager = this.f19368a;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1822687399:
                if (str.equals("translucent")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1799367701:
                if (str.equals("titleColor")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1795707688:
                if (str.equals("blurEffect")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1774658170:
                if (str.equals("largeTitleColor")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1715368693:
                if (str.equals("titleFontFamily")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1503810304:
                if (str.equals("disableBackButtonMenu")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1225100257:
                if (str.equals("titleFontWeight")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1217487446:
                if (str.equals("hidden")) {
                    c2 = 7;
                    break;
                }
                break;
            case -1094575123:
                if (str.equals("largeTitleFontSize")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -1093089076:
                if (str.equals("backButtonDisplayMode")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -1063138943:
                if (str.equals("backTitleVisible")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    c2 = 11;
                    break;
                }
                break;
            case -389245640:
                if (str.equals("largeTitleBackgroundColor")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -140063148:
                if (str.equals("backButtonInCustomView")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case 347216:
                if (str.equals("largeTitleFontFamily")) {
                    c2 = 14;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c2 = 15;
                    break;
                }
                break;
            case 110371416:
                if (str.equals("title")) {
                    c2 = 16;
                    break;
                }
                break;
            case 183888321:
                if (str.equals("backTitleFontSize")) {
                    c2 = 17;
                    break;
                }
                break;
            case 243070244:
                if (str.equals("backTitleFontFamily")) {
                    c2 = 18;
                    break;
                }
                break;
            case 339462402:
                if (str.equals("hideShadow")) {
                    c2 = 19;
                    break;
                }
                break;
            case 490615652:
                if (str.equals("largeTitleFontWeight")) {
                    c2 = 20;
                    break;
                }
                break;
            case 1038753243:
                if (str.equals("hideBackButton")) {
                    c2 = 21;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c2 = 22;
                    break;
                }
                break;
            case 1324688817:
                if (str.equals("backTitle")) {
                    c2 = 23;
                    break;
                }
                break;
            case 1518161768:
                if (str.equals("titleFontSize")) {
                    c2 = 24;
                    break;
                }
                break;
            case 1564506303:
                if (str.equals("largeTitleHideShadow")) {
                    c2 = 25;
                    break;
                }
                break;
            case 2029798365:
                if (str.equals("largeTitle")) {
                    c2 = 26;
                    break;
                }
                break;
            case 2099541337:
                if (str.equals("topInsetEnabled")) {
                    c2 = 27;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setTranslucent(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setTitleColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 2:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setBlurEffect(view, (String) obj);
                break;
            case 3:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setLargeTitleColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 4:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setTitleFontFamily(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setDisableBackButtonMenu(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 6:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setTitleFontWeight(view, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setHidden(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\b':
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setLargeTitleFontSize(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '\t':
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setBackButtonDisplayMode(view, (String) obj);
                break;
            case '\n':
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setBackTitleVisible(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case 11:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setDirection(view, (String) obj);
                break;
            case '\f':
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setLargeTitleBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case '\r':
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setBackButtonInCustomView(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 14:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setLargeTitleFontFamily(view, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 16:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setTitle(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setBackTitleFontSize(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 18:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setBackTitleFontFamily(view, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setHideShadow(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 20:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setLargeTitleFontWeight(view, obj != null ? (String) obj : null);
                break;
            case 21:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setHideBackButton(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 22:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 23:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setBackTitle(view, obj != null ? (String) obj : null);
                break;
            case 24:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setTitleFontSize(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 25:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setLargeTitleHideShadow(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 26:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setLargeTitle(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 27:
                ((RNSScreenStackHeaderConfigManagerInterface) baseViewManager).setTopInsetEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
