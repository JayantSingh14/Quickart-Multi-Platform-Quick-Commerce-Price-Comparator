package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGMarkerManagerInterface;
import org.apache.commons.lang3.CharUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Type;

/* loaded from: classes.dex */
public class RNSVGMarkerManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGMarkerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
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
            case -1008621499:
                if (str.equals("orient")) {
                    c2 = 4;
                    break;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    c2 = 5;
                    break;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    c2 = 6;
                    break;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    c2 = 7;
                    break;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    c2 = 11;
                    break;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
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
            case 3148879:
                if (str.equals("font")) {
                    c2 = 16;
                    break;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    c2 = 17;
                    break;
                }
                break;
            case 3351622:
                if (str.equals("minX")) {
                    c2 = 18;
                    break;
                }
                break;
            case 3351623:
                if (str.equals("minY")) {
                    c2 = 19;
                    break;
                }
                break;
            case 3373707:
                if (str.equals(CLConstants.FIELD_PAY_INFO_NAME)) {
                    c2 = 20;
                    break;
                }
                break;
            case 3496485:
                if (str.equals("refX")) {
                    c2 = 21;
                    break;
                }
                break;
            case 3496486:
                if (str.equals("refY")) {
                    c2 = 22;
                    break;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    c2 = 23;
                    break;
                }
                break;
            case 92903173:
                if (str.equals("align")) {
                    c2 = 24;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c2 = 25;
                    break;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    c2 = 26;
                    break;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    c2 = 27;
                    break;
                }
                break;
            case 218785621:
                if (str.equals("markerUnits")) {
                    c2 = 28;
                    break;
                }
                break;
            case 220478892:
                if (str.equals("markerWidth")) {
                    c2 = 29;
                    break;
                }
                break;
            case 240482938:
                if (str.equals("vbWidth")) {
                    c2 = 30;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    c2 = 31;
                    break;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    c2 = ' ';
                    break;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    c2 = '!';
                    break;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    c2 = '\"';
                    break;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    c2 = '#';
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c2 = '$';
                    break;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    c2 = '%';
                    break;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    c2 = '&';
                    break;
                }
                break;
            case 1908075304:
                if (str.equals("meetOrSlice")) {
                    c2 = '\'';
                    break;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    c2 = '(';
                    break;
                }
                break;
            case 2106883585:
                if (str.equals("markerHeight")) {
                    c2 = ')';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((RNSVGMarkerManagerInterface) baseViewManager).setVbHeight(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 1:
                ((RNSVGMarkerManagerInterface) baseViewManager).setFilter(view, obj != null ? (String) obj : null);
                break;
            case 2:
                baseViewManager.setOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 3:
                ((RNSVGMarkerManagerInterface) baseViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGMarkerManagerInterface) baseViewManager).setOrient(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((RNSVGMarkerManagerInterface) baseViewManager).setPropList(view, (ReadableArray) obj);
                break;
            case 6:
                ((RNSVGMarkerManagerInterface) baseViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGMarkerManagerInterface) baseViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case '\b':
                ((RNSVGMarkerManagerInterface) baseViewManager).setStroke(view, new DynamicFromObject(obj));
                break;
            case '\t':
                ((RNSVGMarkerManagerInterface) baseViewManager).setFontWeight(view, new DynamicFromObject(obj));
                break;
            case '\n':
                ((RNSVGMarkerManagerInterface) baseViewManager).setFillRule(view, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 11:
                ((RNSVGMarkerManagerInterface) baseViewManager).setStrokeOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case '\f':
                ((RNSVGMarkerManagerInterface) baseViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case '\r':
                ((RNSVGMarkerManagerInterface) baseViewManager).setFillOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 14:
                ((RNSVGMarkerManagerInterface) baseViewManager).setStrokeDashoffset(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 15:
                ((RNSVGMarkerManagerInterface) baseViewManager).setFill(view, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGMarkerManagerInterface) baseViewManager).setFont(view, new DynamicFromObject(obj));
                break;
            case 17:
                ((RNSVGMarkerManagerInterface) baseViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSVGMarkerManagerInterface) baseViewManager).setMinX(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 19:
                ((RNSVGMarkerManagerInterface) baseViewManager).setMinY(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 20:
                ((RNSVGMarkerManagerInterface) baseViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 21:
                ((RNSVGMarkerManagerInterface) baseViewManager).setRefX(view, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGMarkerManagerInterface) baseViewManager).setRefY(view, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGMarkerManagerInterface) baseViewManager).setStrokeMiterlimit(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 24:
                ((RNSVGMarkerManagerInterface) baseViewManager).setAlign(view, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGMarkerManagerInterface) baseViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 26:
                ((RNSVGMarkerManagerInterface) baseViewManager).setVectorEffect(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 27:
                ((RNSVGMarkerManagerInterface) baseViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSVGMarkerManagerInterface) baseViewManager).setMarkerUnits(view, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGMarkerManagerInterface) baseViewManager).setMarkerWidth(view, new DynamicFromObject(obj));
                break;
            case 30:
                ((RNSVGMarkerManagerInterface) baseViewManager).setVbWidth(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 31:
                ((RNSVGMarkerManagerInterface) baseViewManager).setFontSize(view, new DynamicFromObject(obj));
                break;
            case ' ':
                ((RNSVGMarkerManagerInterface) baseViewManager).setStrokeDasharray(view, new DynamicFromObject(obj));
                break;
            case '!':
                ((RNSVGMarkerManagerInterface) baseViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case '\"':
                ((RNSVGMarkerManagerInterface) baseViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '#':
                ((RNSVGMarkerManagerInterface) baseViewManager).setStrokeLinecap(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '$':
                ((RNSVGMarkerManagerInterface) baseViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case '%':
                ((RNSVGMarkerManagerInterface) baseViewManager).setStrokeLinejoin(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case Type.A6 /* 38 */:
                ((RNSVGMarkerManagerInterface) baseViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\'':
                ((RNSVGMarkerManagerInterface) baseViewManager).setMeetOrSlice(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '(':
                ((RNSVGMarkerManagerInterface) baseViewManager).setStrokeWidth(view, new DynamicFromObject(obj));
                break;
            case ')':
                ((RNSVGMarkerManagerInterface) baseViewManager).setMarkerHeight(view, new DynamicFromObject(obj));
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
