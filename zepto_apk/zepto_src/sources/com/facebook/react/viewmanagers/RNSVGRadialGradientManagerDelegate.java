package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGRadialGradientManagerInterface;
import org.apache.commons.lang3.CharUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class RNSVGRadialGradientManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGRadialGradientManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
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
            case 3189:
                if (str.equals("cx")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3190:
                if (str.equals("cy")) {
                    c2 = 7;
                    break;
                }
                break;
            case 3282:
                if (str.equals("fx")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 3283:
                if (str.equals("fy")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 3654:
                if (str.equals("rx")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 3655:
                if (str.equals("ry")) {
                    c2 = 11;
                    break;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 3373707:
                if (str.equals(CLConstants.FIELD_PAY_INFO_NAME)) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case 89650992:
                if (str.equals("gradient")) {
                    c2 = 14;
                    break;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    c2 = 15;
                    break;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    c2 = 16;
                    break;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    c2 = 17;
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c2 = 18;
                    break;
                }
                break;
            case 1822665244:
                if (str.equals("gradientTransform")) {
                    c2 = 19;
                    break;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    c2 = 20;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setGradientUnits(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 1:
                baseViewManager.setOpacity(view, obj == null ? 1.0f : ((Double) obj).floatValue());
                break;
            case 2:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setCx(view, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setCy(view, new DynamicFromObject(obj));
                break;
            case '\b':
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setFx(view, new DynamicFromObject(obj));
                break;
            case '\t':
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setFy(view, new DynamicFromObject(obj));
                break;
            case '\n':
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setRx(view, new DynamicFromObject(obj));
                break;
            case 11:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setRy(view, new DynamicFromObject(obj));
                break;
            case '\f':
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case '\r':
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 14:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setGradient(view, (ReadableArray) obj);
                break;
            case 15:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 18:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setGradientTransform(view, (ReadableArray) obj);
                break;
            case 20:
                ((RNSVGRadialGradientManagerInterface) baseViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
