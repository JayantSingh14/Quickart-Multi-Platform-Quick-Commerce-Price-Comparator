package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGLinearGradientManagerInterface;
import org.apache.commons.lang3.CharUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class RNSVGLinearGradientManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGLinearGradientManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        str.getClass();
        BaseViewManager baseViewManager = this.f19368a;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1932235233:
                if (str.equals("gradientUnits")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    c2 = 2;
                    break;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    c2 = 3;
                    break;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    c2 = 4;
                    break;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3769:
                if (str.equals("x1")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3770:
                if (str.equals("x2")) {
                    c2 = 7;
                    break;
                }
                break;
            case 3800:
                if (str.equals("y1")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 3801:
                if (str.equals("y2")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 3373707:
                if (str.equals(CLConstants.FIELD_PAY_INFO_NAME)) {
                    c2 = 11;
                    break;
                }
                break;
            case 89650992:
                if (str.equals("gradient")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    c2 = 14;
                    break;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1822665244:
                if (str.equals("gradientTransform")) {
                    c2 = 17;
                    break;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    c2 = 18;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setGradientUnits(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 1:
                baseViewManager.setOpacity(view, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case 2:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setX1(view, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setX2(view, new DynamicFromObject(obj));
                break;
            case '\b':
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setY1(view, new DynamicFromObject(obj));
                break;
            case '\t':
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setY2(view, new DynamicFromObject(obj));
                break;
            case '\n':
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case '\f':
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setGradient(view, (ReadableArray) obj);
                break;
            case '\r':
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case 15:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 16:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setGradientTransform(view, (ReadableArray) obj);
                break;
            case 18:
                ((RNSVGLinearGradientManagerInterface) baseViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
