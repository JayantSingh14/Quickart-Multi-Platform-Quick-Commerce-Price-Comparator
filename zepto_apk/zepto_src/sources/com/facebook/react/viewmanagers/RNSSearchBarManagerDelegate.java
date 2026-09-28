package com.facebook.react.viewmanagers;

import android.view.View;
import com.appsflyer.AdRevenueScheme;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSSearchBarManagerInterface;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes.dex */
public class RNSSearchBarManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSSearchBarManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        str.getClass();
        View.OnLayoutChangeListener onLayoutChangeListener = this.f19368a;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1619312835:
                if (str.equals("hideNavigationBar")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1465798051:
                if (str.equals("headerIconColor")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1339545093:
                if (str.equals("autoCapitalize")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    c2 = 3;
                    break;
                }
                break;
            case -336520619:
                if (str.equals("barTintColor")) {
                    c2 = 4;
                    break;
                }
                break;
            case -256845969:
                if (str.equals("hintTextColor")) {
                    c2 = 5;
                    break;
                }
                break;
            case -186579527:
                if (str.equals("hideWhenScrolling")) {
                    c2 = 6;
                    break;
                }
                break;
            case -146361959:
                if (str.equals("cancelButtonText")) {
                    c2 = 7;
                    break;
                }
                break;
            case -109380883:
                if (str.equals("disableBackButtonOverride")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -39414888:
                if (str.equals("shouldShowHintSearchIcon")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 598246771:
                if (str.equals("placeholder")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1327599912:
                if (str.equals("tintColor")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1584806451:
                if (str.equals("obscureBackground")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1706976804:
                if (str.equals("inputType")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case 1792938725:
                if (str.equals(AdRevenueScheme.PLACEMENT)) {
                    c2 = 14;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setHideNavigationBar(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 1:
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setHeaderIconColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 2:
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setAutoCapitalize(view, (String) obj);
                break;
            case 3:
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setTextColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 4:
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setBarTintColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 5:
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setHintTextColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 6:
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setHideWhenScrolling(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 7:
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setCancelButtonText(view, obj != null ? (String) obj : null);
                break;
            case '\b':
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setDisableBackButtonOverride(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\t':
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setShouldShowHintSearchIcon(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case '\n':
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setPlaceholder(view, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setTintColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case '\f':
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setObscureBackground(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\r':
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setInputType(view, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setPlacement(view, (String) obj);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void b(View view, String str, ReadableArray readableArray) {
        View.OnLayoutChangeListener onLayoutChangeListener;
        str.getClass();
        onLayoutChangeListener = this.f19368a;
        switch (str) {
            case "cancelSearch":
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).cancelSearch(view);
                break;
            case "clearText":
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).clearText(view);
                break;
            case "toggleCancelButton":
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).toggleCancelButton(view, readableArray.getBoolean(0));
                break;
            case "blur":
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).blur(view);
                break;
            case "focus":
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).focus(view);
                break;
            case "setText":
                ((RNSSearchBarManagerInterface) onLayoutChangeListener).setText(view, readableArray.getString(0));
                break;
        }
    }
}
