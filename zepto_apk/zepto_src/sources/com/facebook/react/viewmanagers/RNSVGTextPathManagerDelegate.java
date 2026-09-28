package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGTextPathManagerInterface;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ClassUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public class RNSVGTextPathManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGTextPathManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        str.getClass();
        BaseViewManager baseViewManager = this.f19368a;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2012158909:
                if (str.equals("spacing")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1993948267:
                if (str.equals("startOffset")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1603134955:
                if (str.equals("lengthAdjust")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1171891896:
                if (str.equals("alignmentBaseline")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1139902161:
                if (str.equals("verticalAlign")) {
                    c2 = 6;
                    break;
                }
                break;
            case -1081239615:
                if (str.equals("matrix")) {
                    c2 = 7;
                    break;
                }
                break;
            case -1077554975:
                if (str.equals("method")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -993894751:
                if (str.equals("propList")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -933864895:
                if (str.equals("markerEnd")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -933857362:
                if (str.equals("markerMid")) {
                    c2 = 11;
                    break;
                }
                break;
            case -925180581:
                if (str.equals(CLConstants.MODE_ROTATE)) {
                    c2 = '\f';
                    break;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    c2 = 14;
                    break;
                }
                break;
            case -729118945:
                if (str.equals("fillRule")) {
                    c2 = 15;
                    break;
                }
                break;
            case -416535885:
                if (str.equals("strokeOpacity")) {
                    c2 = 16;
                    break;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    c2 = 17;
                    break;
                }
                break;
            case -53677816:
                if (str.equals("fillOpacity")) {
                    c2 = 18;
                    break;
                }
                break;
            case -44578051:
                if (str.equals("strokeDashoffset")) {
                    c2 = 19;
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    c2 = 20;
                    break;
                }
                break;
            case WKSRecord.Service.ERPC /* 121 */:
                if (str.equals("y")) {
                    c2 = 21;
                    break;
                }
                break;
            case 3220:
                if (str.equals("dx")) {
                    c2 = 22;
                    break;
                }
                break;
            case 3221:
                if (str.equals("dy")) {
                    c2 = 23;
                    break;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    c2 = 24;
                    break;
                }
                break;
            case 3148879:
                if (str.equals("font")) {
                    c2 = 25;
                    break;
                }
                break;
            case 3211051:
                if (str.equals("href")) {
                    c2 = 26;
                    break;
                }
                break;
            case 3344108:
                if (str.equals("mask")) {
                    c2 = 27;
                    break;
                }
                break;
            case 3373707:
                if (str.equals(CLConstants.FIELD_PAY_INFO_NAME)) {
                    c2 = 28;
                    break;
                }
                break;
            case 3530071:
                if (str.equals("side")) {
                    c2 = 29;
                    break;
                }
                break;
            case 78845486:
                if (str.equals("strokeMiterlimit")) {
                    c2 = 30;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c2 = 31;
                    break;
                }
                break;
            case 104482996:
                if (str.equals("vectorEffect")) {
                    c2 = ' ';
                    break;
                }
                break;
            case 217109576:
                if (str.equals("markerStart")) {
                    c2 = '!';
                    break;
                }
                break;
            case 275888445:
                if (str.equals("baselineShift")) {
                    c2 = '\"';
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    c2 = '#';
                    break;
                }
                break;
            case 401643183:
                if (str.equals("strokeDasharray")) {
                    c2 = '$';
                    break;
                }
                break;
            case 778043962:
                if (str.equals("inlineSize")) {
                    c2 = '%';
                    break;
                }
                break;
            case 917656469:
                if (str.equals("clipPath")) {
                    c2 = '&';
                    break;
                }
                break;
            case 917735020:
                if (str.equals("clipRule")) {
                    c2 = '\'';
                    break;
                }
                break;
            case 1027575302:
                if (str.equals("strokeLinecap")) {
                    c2 = '(';
                    break;
                }
                break;
            case 1054434908:
                if (str.equals("midLine")) {
                    c2 = ')';
                    break;
                }
                break;
            case 1637488243:
                if (str.equals("textLength")) {
                    c2 = '*';
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c2 = '+';
                    break;
                }
                break;
            case 1790285174:
                if (str.equals("strokeLinejoin")) {
                    c2 = ',';
                    break;
                }
                break;
            case 1847674614:
                if (str.equals("responsible")) {
                    c2 = Soundex.SILENT_MARKER;
                    break;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    c2 = ClassUtils.PACKAGE_SEPARATOR_CHAR;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((RNSVGTextPathManagerInterface) baseViewManager).setSpacing(view, obj != null ? (String) obj : null);
                break;
            case 1:
                ((RNSVGTextPathManagerInterface) baseViewManager).setStartOffset(view, new DynamicFromObject(obj));
                break;
            case 2:
                ((RNSVGTextPathManagerInterface) baseViewManager).setLengthAdjust(view, obj != null ? (String) obj : null);
                break;
            case 3:
                ((RNSVGTextPathManagerInterface) baseViewManager).setFilter(view, obj != null ? (String) obj : null);
                break;
            case 4:
                baseViewManager.setOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 5:
                ((RNSVGTextPathManagerInterface) baseViewManager).setAlignmentBaseline(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSVGTextPathManagerInterface) baseViewManager).setVerticalAlign(view, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGTextPathManagerInterface) baseViewManager).setMatrix(view, (ReadableArray) obj);
                break;
            case '\b':
                ((RNSVGTextPathManagerInterface) baseViewManager).setMethod(view, obj != null ? (String) obj : null);
                break;
            case '\t':
                ((RNSVGTextPathManagerInterface) baseViewManager).setPropList(view, (ReadableArray) obj);
                break;
            case '\n':
                ((RNSVGTextPathManagerInterface) baseViewManager).setMarkerEnd(view, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSVGTextPathManagerInterface) baseViewManager).setMarkerMid(view, obj != null ? (String) obj : null);
                break;
            case '\f':
                ((RNSVGTextPathManagerInterface) baseViewManager).setRotate(view, new DynamicFromObject(obj));
                break;
            case '\r':
                ((RNSVGTextPathManagerInterface) baseViewManager).setStroke(view, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGTextPathManagerInterface) baseViewManager).setFontWeight(view, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGTextPathManagerInterface) baseViewManager).setFillRule(view, obj != null ? ((Double) obj).intValue() : 1);
                break;
            case 16:
                ((RNSVGTextPathManagerInterface) baseViewManager).setStrokeOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 17:
                ((RNSVGTextPathManagerInterface) baseViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case 18:
                ((RNSVGTextPathManagerInterface) baseViewManager).setFillOpacity(view, obj != null ? ((Double) obj).floatValue() : 1.0f);
                break;
            case 19:
                ((RNSVGTextPathManagerInterface) baseViewManager).setStrokeDashoffset(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 20:
                ((RNSVGTextPathManagerInterface) baseViewManager).setX(view, new DynamicFromObject(obj));
                break;
            case 21:
                ((RNSVGTextPathManagerInterface) baseViewManager).setY(view, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGTextPathManagerInterface) baseViewManager).setDx(view, new DynamicFromObject(obj));
                break;
            case 23:
                ((RNSVGTextPathManagerInterface) baseViewManager).setDy(view, new DynamicFromObject(obj));
                break;
            case 24:
                ((RNSVGTextPathManagerInterface) baseViewManager).setFill(view, new DynamicFromObject(obj));
                break;
            case 25:
                ((RNSVGTextPathManagerInterface) baseViewManager).setFont(view, new DynamicFromObject(obj));
                break;
            case 26:
                ((RNSVGTextPathManagerInterface) baseViewManager).setHref(view, obj != null ? (String) obj : null);
                break;
            case 27:
                ((RNSVGTextPathManagerInterface) baseViewManager).setMask(view, obj != null ? (String) obj : null);
                break;
            case 28:
                ((RNSVGTextPathManagerInterface) baseViewManager).setName(view, obj != null ? (String) obj : null);
                break;
            case 29:
                ((RNSVGTextPathManagerInterface) baseViewManager).setSide(view, obj != null ? (String) obj : null);
                break;
            case 30:
                ((RNSVGTextPathManagerInterface) baseViewManager).setStrokeMiterlimit(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 31:
                ((RNSVGTextPathManagerInterface) baseViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case ' ':
                ((RNSVGTextPathManagerInterface) baseViewManager).setVectorEffect(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '!':
                ((RNSVGTextPathManagerInterface) baseViewManager).setMarkerStart(view, obj != null ? (String) obj : null);
                break;
            case '\"':
                ((RNSVGTextPathManagerInterface) baseViewManager).setBaselineShift(view, new DynamicFromObject(obj));
                break;
            case '#':
                ((RNSVGTextPathManagerInterface) baseViewManager).setFontSize(view, new DynamicFromObject(obj));
                break;
            case '$':
                ((RNSVGTextPathManagerInterface) baseViewManager).setStrokeDasharray(view, new DynamicFromObject(obj));
                break;
            case '%':
                ((RNSVGTextPathManagerInterface) baseViewManager).setInlineSize(view, new DynamicFromObject(obj));
                break;
            case Type.A6 /* 38 */:
                ((RNSVGTextPathManagerInterface) baseViewManager).setClipPath(view, obj != null ? (String) obj : null);
                break;
            case '\'':
                ((RNSVGTextPathManagerInterface) baseViewManager).setClipRule(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '(':
                ((RNSVGTextPathManagerInterface) baseViewManager).setStrokeLinecap(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case ')':
                ((RNSVGTextPathManagerInterface) baseViewManager).setMidLine(view, obj != null ? (String) obj : null);
                break;
            case '*':
                ((RNSVGTextPathManagerInterface) baseViewManager).setTextLength(view, new DynamicFromObject(obj));
                break;
            case '+':
                ((RNSVGTextPathManagerInterface) baseViewManager).setDisplay(view, obj != null ? (String) obj : null);
                break;
            case ',':
                ((RNSVGTextPathManagerInterface) baseViewManager).setStrokeLinejoin(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '-':
                ((RNSVGTextPathManagerInterface) baseViewManager).setResponsible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '.':
                ((RNSVGTextPathManagerInterface) baseViewManager).setStrokeWidth(view, new DynamicFromObject(obj));
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
