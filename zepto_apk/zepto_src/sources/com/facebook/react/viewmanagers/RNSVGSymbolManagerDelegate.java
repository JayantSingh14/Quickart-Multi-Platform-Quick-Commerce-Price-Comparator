package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGSymbolManagerInterface;
import org.apache.commons.lang3.CharUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class RNSVGSymbolManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGSymbolManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        str.getClass();
        BaseViewManager baseViewManager = this.f19368a;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1567958285:
                if (str.equals("vbHeight")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    c2 = 3;
                    break;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    c2 = 4;
                    break;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    c2 = 5;
                    break;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    c2 = 6;
                    break;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    c2 = 7;
                    break;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    c2 = 11;
                    break;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    c2 = 14;
                    break;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
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
            case 3351622:
                if (str.equals("minX")) {
                    c2 = 17;
                    break;
                }
                break;
            case 3351623:
                if (str.equals("minY")) {
                    c2 = 18;
                    break;
                }
                break;
            case 3373707:
                if (str.equals(CLConstants.FIELD_PAY_INFO_NAME)) {
                    c2 = 19;
                    break;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    c2 = 20;
                    break;
                }
                break;
            case 92903173:
                if (str.equals("align")) {
                    c2 = 21;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c2 = 22;
                    break;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    c2 = 23;
                    break;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    c2 = 24;
                    break;
                }
                break;
            case 240482938:
                if (str.equals("vbWidth")) {
                    c2 = 25;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    c2 = 26;
                    break;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    c2 = 27;
                    break;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    c2 = 28;
                    break;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    c2 = 29;
                    break;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    c2 = 30;
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c2 = 31;
                    break;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    c2 = ' ';
                    break;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    c2 = '!';
                    break;
                }
                break;
            case 1908075304:
                if (str.equals("meetOrSlice")) {
                    c2 = '\"';
                    break;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    c2 = '#';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((RNSVGSymbolManagerInterface) baseViewManager).setVbHeight(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 1:
                ((RNSVGSymbolManagerInterface) baseViewManager).setFilter(view, obj != null ? (String) obj : null);
                break;
            case 2:
                baseViewManager.setOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 3:
                ((RNSVGSymbolManagerInterface) baseViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGSymbolManagerInterface) baseViewManager).setPropList(view, (ReadableArray) obj);
                break;
            case 5:
                ((RNSVGSymbolManagerInterface) baseViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGSymbolManagerInterface) baseViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGSymbolManagerInterface) baseViewManager).setStroke(view, new DynamicFromObject(obj));
                break;
            case '\b':
                ((RNSVGSymbolManagerInterface) baseViewManager).setFontWeight(view, new DynamicFromObject(obj));
                break;
            case '\t':
                ((RNSVGSymbolManagerInterface) baseViewManager).setFillRule(view, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case '\n':
                ((RNSVGSymbolManagerInterface) baseViewManager).setStrokeOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 11:
                ((RNSVGSymbolManagerInterface) baseViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case '\f':
                ((RNSVGSymbolManagerInterface) baseViewManager).setFillOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case '\r':
                ((RNSVGSymbolManagerInterface) baseViewManager).setStrokeDashoffset(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 14:
                ((RNSVGSymbolManagerInterface) baseViewManager).setFill(view, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGSymbolManagerInterface) baseViewManager).setFont(view, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGSymbolManagerInterface) baseViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case 17:
                ((RNSVGSymbolManagerInterface) baseViewManager).setMinX(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 18:
                ((RNSVGSymbolManagerInterface) baseViewManager).setMinY(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 19:
                ((RNSVGSymbolManagerInterface) baseViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 20:
                ((RNSVGSymbolManagerInterface) baseViewManager).setStrokeMiterlimit(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 21:
                ((RNSVGSymbolManagerInterface) baseViewManager).setAlign(view, obj != null ? (String) obj : null);
                break;
            case 22:
                ((RNSVGSymbolManagerInterface) baseViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 23:
                ((RNSVGSymbolManagerInterface) baseViewManager).setVectorEffect(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 24:
                ((RNSVGSymbolManagerInterface) baseViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGSymbolManagerInterface) baseViewManager).setVbWidth(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 26:
                ((RNSVGSymbolManagerInterface) baseViewManager).setFontSize(view, new DynamicFromObject(obj));
                break;
            case 27:
                ((RNSVGSymbolManagerInterface) baseViewManager).setStrokeDasharray(view, new DynamicFromObject(obj));
                break;
            case 28:
                ((RNSVGSymbolManagerInterface) baseViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGSymbolManagerInterface) baseViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 30:
                ((RNSVGSymbolManagerInterface) baseViewManager).setStrokeLinecap(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 31:
                ((RNSVGSymbolManagerInterface) baseViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case ' ':
                ((RNSVGSymbolManagerInterface) baseViewManager).setStrokeLinejoin(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '!':
                ((RNSVGSymbolManagerInterface) baseViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\"':
                ((RNSVGSymbolManagerInterface) baseViewManager).setMeetOrSlice(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '#':
                ((RNSVGSymbolManagerInterface) baseViewManager).setStrokeWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
