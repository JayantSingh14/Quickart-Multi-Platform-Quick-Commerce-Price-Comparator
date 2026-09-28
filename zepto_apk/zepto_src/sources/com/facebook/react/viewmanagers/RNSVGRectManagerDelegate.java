package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGRectManagerInterface;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import org.apache.commons.lang3.CharUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public class RNSVGRectManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGRectManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
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
            case -1221029593:
                if (str.equals(Snapshot.HEIGHT)) {
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
            case -729118945:
                if (str.equals("fillRule")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    c2 = 11;
                    break;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case WKSRecord.Service.ERPC /* 121 */:
                if (str.equals("y")) {
                    c2 = 14;
                    break;
                }
                break;
            case 3654:
                if (str.equals("rx")) {
                    c2 = 15;
                    break;
                }
                break;
            case 3655:
                if (str.equals("ry")) {
                    c2 = 16;
                    break;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    c2 = 17;
                    break;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
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
            case 94842723:
                if (str.equals("color")) {
                    c2 = 21;
                    break;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    c2 = 22;
                    break;
                }
                break;
            case 113126854:
                if (str.equals(Snapshot.WIDTH)) {
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
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    c2 = 25;
                    break;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    c2 = 26;
                    break;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    c2 = 27;
                    break;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    c2 = 28;
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c2 = 29;
                    break;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    c2 = 30;
                    break;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    c2 = 31;
                    break;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    c2 = ' ';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((RNSVGRectManagerInterface) baseViewManager).setFilter(view, obj != null ? (String) obj : null);
                break;
            case 1:
                baseViewManager.setOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 2:
                ((RNSVGRectManagerInterface) baseViewManager).setHeight(view, new DynamicFromObject(obj));
                break;
            case 3:
                ((RNSVGRectManagerInterface) baseViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case 4:
                ((RNSVGRectManagerInterface) baseViewManager).setPropList(view, (ReadableArray) obj);
                break;
            case 5:
                ((RNSVGRectManagerInterface) baseViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGRectManagerInterface) baseViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSVGRectManagerInterface) baseViewManager).setStroke(view, new DynamicFromObject(obj));
                break;
            case '\b':
                ((RNSVGRectManagerInterface) baseViewManager).setFillRule(view, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case '\t':
                ((RNSVGRectManagerInterface) baseViewManager).setStrokeOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case '\n':
                ((RNSVGRectManagerInterface) baseViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSVGRectManagerInterface) baseViewManager).setFillOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case '\f':
                ((RNSVGRectManagerInterface) baseViewManager).setStrokeDashoffset(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case '\r':
                ((RNSVGRectManagerInterface) baseViewManager).setX(view, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGRectManagerInterface) baseViewManager).setY(view, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGRectManagerInterface) baseViewManager).setRx(view, new DynamicFromObject(obj));
                break;
            case 16:
                ((RNSVGRectManagerInterface) baseViewManager).setRy(view, new DynamicFromObject(obj));
                break;
            case 17:
                ((RNSVGRectManagerInterface) baseViewManager).setFill(view, new DynamicFromObject(obj));
                break;
            case 18:
                ((RNSVGRectManagerInterface) baseViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case 19:
                ((RNSVGRectManagerInterface) baseViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 20:
                ((RNSVGRectManagerInterface) baseViewManager).setStrokeMiterlimit(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 21:
                ((RNSVGRectManagerInterface) baseViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 22:
                ((RNSVGRectManagerInterface) baseViewManager).setVectorEffect(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 23:
                ((RNSVGRectManagerInterface) baseViewManager).setWidth(view, new DynamicFromObject(obj));
                break;
            case 24:
                ((RNSVGRectManagerInterface) baseViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGRectManagerInterface) baseViewManager).setStrokeDasharray(view, new DynamicFromObject(obj));
                break;
            case 26:
                ((RNSVGRectManagerInterface) baseViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGRectManagerInterface) baseViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 28:
                ((RNSVGRectManagerInterface) baseViewManager).setStrokeLinecap(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 29:
                ((RNSVGRectManagerInterface) baseViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case 30:
                ((RNSVGRectManagerInterface) baseViewManager).setStrokeLinejoin(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 31:
                ((RNSVGRectManagerInterface) baseViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case ' ':
                ((RNSVGRectManagerInterface) baseViewManager).setStrokeWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
