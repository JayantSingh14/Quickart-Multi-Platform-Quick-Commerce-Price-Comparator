package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGCircleManagerInterface;
import org.apache.commons.lang3.CharUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class RNSVGCircleManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGCircleManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        str.getClass();
        BaseViewManager baseViewManager = this.f19368a;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1274492040:
                if (str.equals("filter")) {
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
            case -993894751:
                if (str.equals("propList")) {
                    c2 = 3;
                    break;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    c2 = 4;
                    break;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    c2 = 5;
                    break;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    c2 = 6;
                    break;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    c2 = 7;
                    break;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    c2 = 11;
                    break;
                }
                break;
            case 114:
                if (str.equals("r")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 3189:
                if (str.equals("cx")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case 3190:
                if (str.equals("cy")) {
                    c2 = 14;
                    break;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    c2 = 15;
                    break;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    c2 = 16;
                    break;
                }
                break;
            case 3373707:
                if (str.equals(CLConstants.FIELD_PAY_INFO_NAME)) {
                    c2 = 17;
                    break;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    c2 = 18;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c2 = 19;
                    break;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    c2 = 20;
                    break;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    c2 = 21;
                    break;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    c2 = 22;
                    break;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    c2 = 23;
                    break;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    c2 = 24;
                    break;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    c2 = 25;
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c2 = 26;
                    break;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    c2 = 27;
                    break;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    c2 = 28;
                    break;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    c2 = 29;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((RNSVGCircleManagerInterface) baseViewManager).setFilter(view, obj != null ? (String) obj : null);
                break;
            case 1:
                baseViewManager.setOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 2:
                ((RNSVGCircleManagerInterface) baseViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 3:
                ((RNSVGCircleManagerInterface) baseViewManager).setPropList(view, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGCircleManagerInterface) baseViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGCircleManagerInterface) baseViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGCircleManagerInterface) baseViewManager).setStroke(view, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGCircleManagerInterface) baseViewManager).setFillRule(view, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case '\b':
                ((RNSVGCircleManagerInterface) baseViewManager).setStrokeOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case '\t':
                ((RNSVGCircleManagerInterface) baseViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case '\n':
                ((RNSVGCircleManagerInterface) baseViewManager).setFillOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 11:
                ((RNSVGCircleManagerInterface) baseViewManager).setStrokeDashoffset(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case '\f':
                ((RNSVGCircleManagerInterface) baseViewManager).setR(view, new DynamicFromObject(obj));
                break;
            case '\r':
                ((RNSVGCircleManagerInterface) baseViewManager).setCx(view, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGCircleManagerInterface) baseViewManager).setCy(view, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGCircleManagerInterface) baseViewManager).setFill(view, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGCircleManagerInterface) baseViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGCircleManagerInterface) baseViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSVGCircleManagerInterface) baseViewManager).setStrokeMiterlimit(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 19:
                ((RNSVGCircleManagerInterface) baseViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 20:
                ((RNSVGCircleManagerInterface) baseViewManager).setVectorEffect(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 21:
                ((RNSVGCircleManagerInterface) baseViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case 22:
                ((RNSVGCircleManagerInterface) baseViewManager).setStrokeDasharray(view, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGCircleManagerInterface) baseViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case 24:
                ((RNSVGCircleManagerInterface) baseViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 25:
                ((RNSVGCircleManagerInterface) baseViewManager).setStrokeLinecap(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 26:
                ((RNSVGCircleManagerInterface) baseViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGCircleManagerInterface) baseViewManager).setStrokeLinejoin(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 28:
                ((RNSVGCircleManagerInterface) baseViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 29:
                ((RNSVGCircleManagerInterface) baseViewManager).setStrokeWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
