package com.facebook.react.uimanager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.react.R;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.util.ReactFindViewUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Type;

/* loaded from: classes.dex */
public class ReactAccessibilityDelegate extends ExploreByTouchHelper {
    public static int s = 1056964608;
    public static final HashMap t;
    public final View n;
    public final AccessibilityLinks o;
    public final Handler p;
    public final HashMap q;
    public View r;

    /* renamed from: com.facebook.react.uimanager.ReactAccessibilityDelegate$1, reason: invalid class name */
    class AnonymousClass1 extends Handler {
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ((View) message.obj).sendAccessibilityEvent(4);
        }
    }

    /* renamed from: com.facebook.react.uimanager.ReactAccessibilityDelegate$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19432a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19433b;

        static {
            int[] iArr = new int[Role.values().length];
            f19433b = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19433b[5] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19433b[7] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19433b[9] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19433b[19] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19433b[21] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19433b[22] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19433b[23] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f19433b[24] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f19433b[30] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f19433b[31] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f19433b[32] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f19433b[35] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f19433b[39] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f19433b[40] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f19433b[41] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f19433b[46] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f19433b[47] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f19433b[49] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f19433b[50] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f19433b[52] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f19433b[53] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f19433b[54] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f19433b[56] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f19433b[59] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f19433b[60] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            int[] iArr2 = new int[AccessibilityRole.values().length];
            f19432a = iArr2;
            try {
                iArr2[1] = 1;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f19432a[2] = 2;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f19432a[3] = 3;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f19432a[5] = 4;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f19432a[6] = 5;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f19432a[7] = 6;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f19432a[8] = 7;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f19432a[9] = 8;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f19432a[10] = 9;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f19432a[14] = 10;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f19432a[20] = 11;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f19432a[23] = 12;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                f19432a[24] = 13;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f19432a[28] = 14;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f19432a[29] = 15;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                f19432a[31] = 16;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f19432a[32] = 17;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f19432a[30] = 18;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f19432a[35] = 19;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f19432a[36] = 20;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f19432a[37] = 21;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f19432a[33] = 22;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f19432a[34] = 23;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f19432a[0] = 24;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f19432a[4] = 25;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f19432a[11] = 26;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f19432a[12] = 27;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                f19432a[13] = 28;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f19432a[15] = 29;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f19432a[16] = 30;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                f19432a[17] = 31;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f19432a[18] = 32;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f19432a[19] = 33;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                f19432a[21] = 34;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                f19432a[22] = 35;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                f19432a[25] = 36;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                f19432a[26] = 37;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                f19432a[27] = 38;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                f19432a[38] = 39;
            } catch (NoSuchFieldError unused65) {
            }
        }
    }

    public static class AccessibilityLinks {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f19434a;

        /* loaded from: classes3.dex */
        public static class AccessibleLink {

            /* renamed from: a, reason: collision with root package name */
            public String f19435a;

            /* renamed from: b, reason: collision with root package name */
            public int f19436b;

            /* renamed from: c, reason: collision with root package name */
            public int f19437c;

            /* renamed from: d, reason: collision with root package name */
            public int f19438d;
        }

        public AccessibilityLinks(ClickableSpan[] clickableSpanArr, Spannable spannable) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < clickableSpanArr.length; i2++) {
                ClickableSpan clickableSpan = clickableSpanArr[i2];
                int spanStart = spannable.getSpanStart(clickableSpan);
                int spanEnd = spannable.getSpanEnd(clickableSpan);
                if (spanStart != spanEnd && spanStart >= 0 && spanEnd >= 0 && spanStart <= spannable.length() && spanEnd <= spannable.length()) {
                    AccessibleLink accessibleLink = new AccessibleLink();
                    accessibleLink.f19435a = spannable.subSequence(spanStart, spanEnd).toString();
                    accessibleLink.f19436b = spanStart;
                    accessibleLink.f19437c = spanEnd;
                    accessibleLink.f19438d = (clickableSpanArr.length - 1) - i2;
                    arrayList.add(accessibleLink);
                }
            }
            this.f19434a = arrayList;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class AccessibilityRole {
        public static final AccessibilityRole A;
        public static final AccessibilityRole B;
        public static final /* synthetic */ AccessibilityRole[] C;

        /* renamed from: a, reason: collision with root package name */
        public static final AccessibilityRole f19439a;

        /* renamed from: b, reason: collision with root package name */
        public static final AccessibilityRole f19440b;

        /* renamed from: c, reason: collision with root package name */
        public static final AccessibilityRole f19441c;

        /* renamed from: d, reason: collision with root package name */
        public static final AccessibilityRole f19442d;

        /* renamed from: e, reason: collision with root package name */
        public static final AccessibilityRole f19443e;

        /* renamed from: f, reason: collision with root package name */
        public static final AccessibilityRole f19444f;

        /* renamed from: g, reason: collision with root package name */
        public static final AccessibilityRole f19445g;

        /* renamed from: h, reason: collision with root package name */
        public static final AccessibilityRole f19446h;

        /* renamed from: i, reason: collision with root package name */
        public static final AccessibilityRole f19447i;

        /* renamed from: j, reason: collision with root package name */
        public static final AccessibilityRole f19448j;

        /* renamed from: k, reason: collision with root package name */
        public static final AccessibilityRole f19449k;

        /* renamed from: l, reason: collision with root package name */
        public static final AccessibilityRole f19450l;

        /* renamed from: m, reason: collision with root package name */
        public static final AccessibilityRole f19451m;
        public static final AccessibilityRole n;
        public static final AccessibilityRole o;
        public static final AccessibilityRole p;
        public static final AccessibilityRole q;
        public static final AccessibilityRole r;
        public static final AccessibilityRole s;
        public static final AccessibilityRole t;
        public static final AccessibilityRole u;
        public static final AccessibilityRole v;
        public static final AccessibilityRole w;
        public static final AccessibilityRole x;
        public static final AccessibilityRole y;
        public static final AccessibilityRole z;

        static {
            AccessibilityRole accessibilityRole = new AccessibilityRole("NONE", 0);
            f19439a = accessibilityRole;
            AccessibilityRole accessibilityRole2 = new AccessibilityRole("BUTTON", 1);
            f19440b = accessibilityRole2;
            AccessibilityRole accessibilityRole3 = new AccessibilityRole("DROPDOWNLIST", 2);
            AccessibilityRole accessibilityRole4 = new AccessibilityRole("TOGGLEBUTTON", 3);
            f19441c = accessibilityRole4;
            AccessibilityRole accessibilityRole5 = new AccessibilityRole("LINK", 4);
            f19442d = accessibilityRole5;
            AccessibilityRole accessibilityRole6 = new AccessibilityRole("SEARCH", 5);
            f19443e = accessibilityRole6;
            AccessibilityRole accessibilityRole7 = new AccessibilityRole("IMAGE", 6);
            f19444f = accessibilityRole7;
            AccessibilityRole accessibilityRole8 = new AccessibilityRole("IMAGEBUTTON", 7);
            f19445g = accessibilityRole8;
            AccessibilityRole accessibilityRole9 = new AccessibilityRole("KEYBOARDKEY", 8);
            AccessibilityRole accessibilityRole10 = new AccessibilityRole("TEXT", 9);
            AccessibilityRole accessibilityRole11 = new AccessibilityRole("ADJUSTABLE", 10);
            f19446h = accessibilityRole11;
            AccessibilityRole accessibilityRole12 = new AccessibilityRole("SUMMARY", 11);
            f19447i = accessibilityRole12;
            AccessibilityRole accessibilityRole13 = new AccessibilityRole("HEADER", 12);
            f19448j = accessibilityRole13;
            AccessibilityRole accessibilityRole14 = new AccessibilityRole("ALERT", 13);
            f19449k = accessibilityRole14;
            AccessibilityRole accessibilityRole15 = new AccessibilityRole("CHECKBOX", 14);
            f19450l = accessibilityRole15;
            AccessibilityRole accessibilityRole16 = new AccessibilityRole("COMBOBOX", 15);
            f19451m = accessibilityRole16;
            AccessibilityRole accessibilityRole17 = new AccessibilityRole("MENU", 16);
            n = accessibilityRole17;
            AccessibilityRole accessibilityRole18 = new AccessibilityRole("MENUBAR", 17);
            o = accessibilityRole18;
            AccessibilityRole accessibilityRole19 = new AccessibilityRole("MENUITEM", 18);
            p = accessibilityRole19;
            AccessibilityRole accessibilityRole20 = new AccessibilityRole("PROGRESSBAR", 19);
            q = accessibilityRole20;
            AccessibilityRole accessibilityRole21 = new AccessibilityRole("RADIO", 20);
            r = accessibilityRole21;
            AccessibilityRole accessibilityRole22 = new AccessibilityRole("RADIOGROUP", 21);
            s = accessibilityRole22;
            AccessibilityRole accessibilityRole23 = new AccessibilityRole("SCROLLBAR", 22);
            t = accessibilityRole23;
            AccessibilityRole accessibilityRole24 = new AccessibilityRole("SPINBUTTON", 23);
            u = accessibilityRole24;
            AccessibilityRole accessibilityRole25 = new AccessibilityRole("SWITCH", 24);
            v = accessibilityRole25;
            AccessibilityRole accessibilityRole26 = new AccessibilityRole("TAB", 25);
            w = accessibilityRole26;
            AccessibilityRole accessibilityRole27 = new AccessibilityRole("TABLIST", 26);
            x = accessibilityRole27;
            AccessibilityRole accessibilityRole28 = new AccessibilityRole("TIMER", 27);
            y = accessibilityRole28;
            AccessibilityRole accessibilityRole29 = new AccessibilityRole("LIST", 28);
            z = accessibilityRole29;
            AccessibilityRole accessibilityRole30 = new AccessibilityRole("GRID", 29);
            A = accessibilityRole30;
            AccessibilityRole accessibilityRole31 = new AccessibilityRole("PAGER", 30);
            AccessibilityRole accessibilityRole32 = new AccessibilityRole("SCROLLVIEW", 31);
            AccessibilityRole accessibilityRole33 = new AccessibilityRole("HORIZONTALSCROLLVIEW", 32);
            AccessibilityRole accessibilityRole34 = new AccessibilityRole("VIEWGROUP", 33);
            AccessibilityRole accessibilityRole35 = new AccessibilityRole("WEBVIEW", 34);
            AccessibilityRole accessibilityRole36 = new AccessibilityRole("DRAWERLAYOUT", 35);
            AccessibilityRole accessibilityRole37 = new AccessibilityRole("SLIDINGDRAWER", 36);
            AccessibilityRole accessibilityRole38 = new AccessibilityRole("ICONMENU", 37);
            AccessibilityRole accessibilityRole39 = new AccessibilityRole("TOOLBAR", 38);
            B = accessibilityRole39;
            C = new AccessibilityRole[]{accessibilityRole, accessibilityRole2, accessibilityRole3, accessibilityRole4, accessibilityRole5, accessibilityRole6, accessibilityRole7, accessibilityRole8, accessibilityRole9, accessibilityRole10, accessibilityRole11, accessibilityRole12, accessibilityRole13, accessibilityRole14, accessibilityRole15, accessibilityRole16, accessibilityRole17, accessibilityRole18, accessibilityRole19, accessibilityRole20, accessibilityRole21, accessibilityRole22, accessibilityRole23, accessibilityRole24, accessibilityRole25, accessibilityRole26, accessibilityRole27, accessibilityRole28, accessibilityRole29, accessibilityRole30, accessibilityRole31, accessibilityRole32, accessibilityRole33, accessibilityRole34, accessibilityRole35, accessibilityRole36, accessibilityRole37, accessibilityRole38, accessibilityRole39};
        }

        public static AccessibilityRole a(String str) {
            if (str == null) {
                return f19439a;
            }
            for (AccessibilityRole accessibilityRole : values()) {
                if (accessibilityRole.name().equalsIgnoreCase(str)) {
                    return accessibilityRole;
                }
            }
            throw new IllegalArgumentException("Invalid accessibility role value: ".concat(str));
        }

        public static AccessibilityRole b(View view) {
            Role role = (Role) view.getTag(R.id.role);
            if (role == null) {
                return (AccessibilityRole) view.getTag(R.id.accessibility_role);
            }
            int iOrdinal = role.ordinal();
            if (iOrdinal == 0) {
                return f19449k;
            }
            if (iOrdinal == 5) {
                return f19440b;
            }
            if (iOrdinal == 7) {
                return f19450l;
            }
            if (iOrdinal == 9) {
                return f19451m;
            }
            if (iOrdinal == 19) {
                return A;
            }
            if (iOrdinal == 35) {
                return f19439a;
            }
            if (iOrdinal == 56) {
                return x;
            }
            if (iOrdinal == 46) {
                return t;
            }
            if (iOrdinal == 47) {
                return f19443e;
            }
            if (iOrdinal == 49) {
                return f19446h;
            }
            if (iOrdinal == 50) {
                return u;
            }
            if (iOrdinal == 59) {
                return y;
            }
            if (iOrdinal == 60) {
                return B;
            }
            switch (iOrdinal) {
                case 21:
                    return f19448j;
                case 22:
                    return f19444f;
                case 23:
                    return f19442d;
                case 24:
                    return z;
                default:
                    switch (iOrdinal) {
                        case 30:
                            return n;
                        case 31:
                            return o;
                        case 32:
                            return p;
                        default:
                            switch (iOrdinal) {
                                case 39:
                                    return q;
                                case 40:
                                    return r;
                                case 41:
                                    return s;
                                default:
                                    switch (iOrdinal) {
                                        case Type.TLSA /* 52 */:
                                            return f19447i;
                                        case 53:
                                            return v;
                                        case 54:
                                            return w;
                                        default:
                                            return null;
                                    }
                            }
                    }
            }
        }

        public static String c(AccessibilityRole accessibilityRole) {
            switch (accessibilityRole.ordinal()) {
                case 0:
                case 4:
                case 11:
                case 12:
                case 13:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 21:
                case 22:
                case 25:
                case 26:
                case 27:
                case Type.A6 /* 38 */:
                    return "android.view.View";
                case 1:
                    return "android.widget.Button";
                case 2:
                    return "android.widget.Spinner";
                case 3:
                    return "android.widget.ToggleButton";
                case 5:
                    return "android.widget.EditText";
                case 6:
                    return "android.widget.ImageView";
                case 7:
                    return "android.widget.ImageButton";
                case 8:
                    return "android.inputmethodservice.Keyboard$Key";
                case 9:
                    return "android.widget.TextView";
                case 10:
                    return "android.widget.SeekBar";
                case 14:
                    return "android.widget.CheckBox";
                case 20:
                    return "android.widget.RadioButton";
                case 23:
                    return "android.widget.SpinButton";
                case 24:
                    return "android.widget.Switch";
                case 28:
                    return "android.widget.AbsListView";
                case 29:
                    return "android.widget.GridView";
                case 30:
                    return "androidx.viewpager.widget.ViewPager";
                case 31:
                    return "android.widget.ScrollView";
                case 32:
                    return "android.widget.HorizontalScrollView";
                case 33:
                    return "android.view.ViewGroup";
                case 34:
                    return "android.webkit.WebView";
                case 35:
                    return "androidx.drawerlayout.widget.DrawerLayout";
                case 36:
                    return "android.widget.SlidingDrawer";
                case 37:
                    return "com.android.internal.view.menu.IconMenuView";
                default:
                    throw new IllegalArgumentException("Invalid accessibility role value: " + accessibilityRole);
            }
        }

        public static AccessibilityRole valueOf(String str) {
            return (AccessibilityRole) Enum.valueOf(AccessibilityRole.class, str);
        }

        public static AccessibilityRole[] values() {
            return (AccessibilityRole[]) C.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Role {

        /* renamed from: a, reason: collision with root package name */
        public static final Role f19452a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Role[] f19453b;

        /* JADX INFO: Fake field, exist only in values array */
        Role EF1;

        static {
            Role role = new Role("ALERT", 0);
            Role role2 = new Role("ALERTDIALOG", 1);
            Role role3 = new Role("APPLICATION", 2);
            Role role4 = new Role("ARTICLE", 3);
            Role role5 = new Role("BANNER", 4);
            Role role6 = new Role("BUTTON", 5);
            Role role7 = new Role("CELL", 6);
            Role role8 = new Role("CHECKBOX", 7);
            Role role9 = new Role("COLUMNHEADER", 8);
            Role role10 = new Role("COMBOBOX", 9);
            Role role11 = new Role("COMPLEMENTARY", 10);
            Role role12 = new Role("CONTENTINFO", 11);
            Role role13 = new Role("DEFINITION", 12);
            Role role14 = new Role("DIALOG", 13);
            Role role15 = new Role("DIRECTORY", 14);
            Role role16 = new Role("DOCUMENT", 15);
            Role role17 = new Role("FEED", 16);
            Role role18 = new Role("FIGURE", 17);
            Role role19 = new Role("FORM", 18);
            Role role20 = new Role("GRID", 19);
            Role role21 = new Role("GROUP", 20);
            Role role22 = new Role("HEADING", 21);
            Role role23 = new Role("IMG", 22);
            Role role24 = new Role("LINK", 23);
            f19452a = role24;
            f19453b = new Role[]{role, role2, role3, role4, role5, role6, role7, role8, role9, role10, role11, role12, role13, role14, role15, role16, role17, role18, role19, role20, role21, role22, role23, role24, new Role("LIST", 24), new Role("LISTITEM", 25), new Role("LOG", 26), new Role("MAIN", 27), new Role("MARQUEE", 28), new Role("MATH", 29), new Role("MENU", 30), new Role("MENUBAR", 31), new Role("MENUITEM", 32), new Role("METER", 33), new Role("NAVIGATION", 34), new Role("NONE", 35), new Role("NOTE", 36), new Role("OPTION", 37), new Role("PRESENTATION", 38), new Role("PROGRESSBAR", 39), new Role("RADIO", 40), new Role("RADIOGROUP", 41), new Role("REGION", 42), new Role("ROW", 43), new Role("ROWGROUP", 44), new Role("ROWHEADER", 45), new Role("SCROLLBAR", 46), new Role("SEARCHBOX", 47), new Role("SEPARATOR", 48), new Role("SLIDER", 49), new Role("SPINBUTTON", 50), new Role("STATUS", 51), new Role("SUMMARY", 52), new Role("SWITCH", 53), new Role("TAB", 54), new Role("TABLE", 55), new Role("TABLIST", 56), new Role("TABPANEL", 57), new Role("TERM", 58), new Role("TIMER", 59), new Role("TOOLBAR", 60), new Role("TOOLTIP", 61), new Role("TREE", 62), new Role("TREEGRID", 63), new Role("TREEITEM", 64)};
        }

        public static Role valueOf(String str) {
            return (Role) Enum.valueOf(Role.class, str);
        }

        public static Role[] values() {
            return (Role[]) f19453b.clone();
        }
    }

    static {
        HashMap map = new HashMap();
        t = map;
        map.put("activate", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3189g.a()));
        map.put("longpress", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3190h.a()));
        map.put("increment", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3191i.a()));
        map.put("decrement", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3192j.a()));
        map.put("expand", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3193k.a()));
        map.put("collapse", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3194l.a()));
    }

    public ReactAccessibilityDelegate(int i2, View view, boolean z) {
        super(view);
        this.n = view;
        this.q = new HashMap();
        this.p = new AnonymousClass1();
        view.setFocusable(z);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        view.setImportantForAccessibility(i2);
        this.o = (AccessibilityLinks) view.getTag(R.id.accessibility_links);
    }

    public static CharSequence q(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        if (accessibilityNodeInfoCompat != null) {
            accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f3185a));
        } else if (view == null) {
            accessibilityNodeInfoCompat2 = null;
        } else {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain);
            try {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
            } catch (NullPointerException unused) {
            }
        }
        if (accessibilityNodeInfoCompat2 != null) {
            CharSequence contentDescription = accessibilityNodeInfoCompat2.f3185a.getContentDescription();
            CharSequence charSequenceI = accessibilityNodeInfoCompat2.i();
            boolean zIsEmpty = TextUtils.isEmpty(charSequenceI);
            boolean z = view instanceof EditText;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(contentDescription) && (!z || zIsEmpty)) {
                sb.append(contentDescription);
            } else if (!zIsEmpty) {
                sb.append(charSequenceI);
            } else if (view instanceof ViewGroup) {
                StringBuilder sb2 = new StringBuilder();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain();
                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain2);
                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                    childAt.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain2);
                    if (s(childAt, accessibilityNodeInfoCompat3) && !r(childAt, accessibilityNodeInfoCompat3)) {
                        CharSequence charSequenceQ = q(childAt, null);
                        if (!TextUtils.isEmpty(charSequenceQ)) {
                            sb2.append(((Object) charSequenceQ) + ", ");
                        }
                    }
                }
                int length = sb2.length();
                if (length > 0) {
                    sb2.delete(length - 2, length);
                }
                return sb2.toString();
            }
            return sb;
        }
        return null;
    }

    public static boolean r(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean z;
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f3185a;
        if (accessibilityNodeInfo.isVisibleToUser()) {
            if (!(Build.VERSION.SDK_INT >= 28 ? accessibilityNodeInfo.isScreenReaderFocusable() : accessibilityNodeInfoCompat.f(1))) {
                if (!accessibilityNodeInfo.isClickable() && !accessibilityNodeInfo.isLongClickable() && !accessibilityNodeInfo.isFocusable()) {
                    ArrayList arrayListD = accessibilityNodeInfoCompat.d();
                    if (!arrayListD.contains(16) && !arrayListD.contains(32) && !arrayListD.contains(1)) {
                        z = false;
                    }
                    if (!z) {
                    }
                }
                z = true;
                if (!z) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean s(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        int importantForAccessibility = view.getImportantForAccessibility();
        if (importantForAccessibility != 4) {
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f3185a;
            if (importantForAccessibility != 2 || accessibilityNodeInfo.getChildCount() > 0) {
                AccessibilityNodeInfo.CollectionInfo collectionInfo = accessibilityNodeInfo.getCollectionInfo();
                if ((collectionInfo != null ? new AccessibilityNodeInfoCompat.CollectionInfoCompat(collectionInfo) : null) == null) {
                    if (TextUtils.isEmpty(accessibilityNodeInfoCompat.i()) && TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
                        if (TextUtils.isEmpty(Build.VERSION.SDK_INT >= 26 ? accessibilityNodeInfo.getHintText() : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY"))) {
                        }
                    }
                    return true;
                }
                if (TextUtils.isEmpty(accessibilityNodeInfoCompat.h()) && !accessibilityNodeInfo.isCheckable()) {
                    AccessibilityNodeInfo.RangeInfo rangeInfo = accessibilityNodeInfo.getRangeInfo();
                    AccessibilityNodeInfoCompat.RangeInfoCompat rangeInfoCompat = rangeInfo != null ? new AccessibilityNodeInfoCompat.RangeInfoCompat(rangeInfo) : null;
                    if (rangeInfoCompat != null) {
                        float fB = rangeInfoCompat.b();
                        float fC = rangeInfoCompat.c();
                        float fA = rangeInfoCompat.a();
                        if (fB - fC <= 0.0f || fA < fC || fA > fB) {
                        }
                    }
                    if (!accessibilityNodeInfo.isCheckable()) {
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view;
                            int childCount = viewGroup.getChildCount();
                            for (int i2 = 0; i2 < childCount; i2++) {
                                View childAt = viewGroup.getChildAt(i2);
                                if (childAt != null) {
                                    AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
                                    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain);
                                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                                    childAt.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
                                    if (accessibilityNodeInfoObtain.isVisibleToUser() && !r(childAt, accessibilityNodeInfoCompat2) && s(childAt, accessibilityNodeInfoCompat2)) {
                                    }
                                }
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void t(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityRole accessibilityRole, Context context) {
        accessibilityNodeInfoCompat.m(AccessibilityRole.c(accessibilityRole));
        if (accessibilityRole.equals(AccessibilityRole.f19442d)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.link_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.f19444f)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.image_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.f19445g)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.imagebutton_description));
            accessibilityNodeInfoCompat.n(true);
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.f19440b)) {
            accessibilityNodeInfoCompat.n(true);
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.f19441c)) {
            accessibilityNodeInfoCompat.n(true);
            accessibilityNodeInfoCompat.f3185a.setCheckable(true);
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.f19447i)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.summary_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.f19448j)) {
            accessibilityNodeInfoCompat.r(true);
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.f19449k)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.alert_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.f19451m)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.combobox_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.n)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.menu_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.o)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.menubar_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.p)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.menuitem_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.q)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.progressbar_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.s)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.radiogroup_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.t)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.scrollbar_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.u)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.spinbutton_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.w)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.rn_tab_description));
            return;
        }
        if (accessibilityRole.equals(AccessibilityRole.x)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.tablist_description));
        } else if (accessibilityRole.equals(AccessibilityRole.y)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.timer_description));
        } else if (accessibilityRole.equals(AccessibilityRole.B)) {
            accessibilityNodeInfoCompat.t(context.getString(R.string.toolbar_description));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final int e(float f2, float f3) {
        Layout layout;
        AccessibilityLinks.AccessibleLink accessibleLink;
        AccessibilityLinks accessibilityLinks = this.o;
        if (accessibilityLinks == null) {
            return Integer.MIN_VALUE;
        }
        ArrayList arrayList = accessibilityLinks.f19434a;
        if (arrayList.size() == 0) {
            return Integer.MIN_VALUE;
        }
        View view = this.n;
        if (!(view instanceof TextView)) {
            return Integer.MIN_VALUE;
        }
        TextView textView = (TextView) view;
        if (!(textView.getText() instanceof Spanned) || (layout = textView.getLayout()) == null) {
            return Integer.MIN_VALUE;
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) ((f3 - textView.getTotalPaddingTop()) + textView.getScrollY())), (f2 - textView.getTotalPaddingLeft()) + textView.getScrollX());
        ClickableSpan clickableSpan = (ClickableSpan) p(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        if (clickableSpan == null) {
            return Integer.MIN_VALUE;
        }
        Spanned spanned = (Spanned) textView.getText();
        int spanStart = spanned.getSpanStart(clickableSpan);
        int spanEnd = spanned.getSpanEnd(clickableSpan);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                accessibleLink = null;
                break;
            }
            accessibleLink = (AccessibilityLinks.AccessibleLink) it.next();
            if (accessibleLink.f19436b == spanStart && accessibleLink.f19437c == spanEnd) {
                break;
            }
        }
        if (accessibleLink != null) {
            return accessibleLink.f19438d;
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void f(ArrayList arrayList) {
        AccessibilityLinks accessibilityLinks = this.o;
        if (accessibilityLinks == null) {
            return;
        }
        for (int i2 = 0; i2 < accessibilityLinks.f19434a.size(); i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
    public final AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.o != null) {
            return super.getAccessibilityNodeProvider(view);
        }
        return null;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final boolean j(int i2, int i3, Bundle bundle) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011e  */
    @Override // androidx.customview.widget.ExploreByTouchHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r18, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r19) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.ReactAccessibilityDelegate.l(int, androidx.core.view.accessibility.AccessibilityNodeInfoCompat):void");
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        ReadableMap readableMap = (ReadableMap) view.getTag(R.id.accessibility_value);
        if (readableMap != null && readableMap.hasKey("min") && readableMap.hasKey("now") && readableMap.hasKey("max")) {
            Dynamic dynamic = readableMap.getDynamic("min");
            Dynamic dynamic2 = readableMap.getDynamic("now");
            Dynamic dynamic3 = readableMap.getDynamic("max");
            if (dynamic != null) {
                ReadableType type = dynamic.getType();
                ReadableType readableType = ReadableType.Number;
                if (type == readableType && dynamic2 != null && dynamic2.getType() == readableType && dynamic3 != null && dynamic3.getType() == readableType) {
                    int iAsInt = dynamic.asInt();
                    int iAsInt2 = dynamic2.asInt();
                    int iAsInt3 = dynamic3.asInt();
                    if (iAsInt3 <= iAsInt || iAsInt2 < iAsInt || iAsInt3 < iAsInt2) {
                        return;
                    }
                    accessibilityEvent.setItemCount(iAsInt3 - iAsInt);
                    accessibilityEvent.setCurrentItemIndex(iAsInt2);
                }
            }
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (view.getTag(R.id.accessibility_state_expanded) != null) {
            accessibilityNodeInfoCompat.a(((Boolean) view.getTag(R.id.accessibility_state_expanded)).booleanValue() ? 524288 : 262144);
        }
        AccessibilityRole accessibilityRoleB = AccessibilityRole.b(view);
        String str = (String) view.getTag(R.id.accessibility_hint);
        if (accessibilityRoleB != null) {
            t(accessibilityNodeInfoCompat, accessibilityRoleB, view.getContext());
        }
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f3185a;
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                accessibilityNodeInfo.setTooltipText(str);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY", str);
            }
        }
        Object tag = view.getTag(R.id.labelled_by);
        if (tag != null) {
            View viewA = ReactFindViewUtil.a(view.getRootView(), (String) tag);
            this.r = viewA;
            if (viewA != null) {
                accessibilityNodeInfo.setLabeledBy(viewA);
            }
        }
        ReadableMap readableMap = (ReadableMap) view.getTag(R.id.accessibility_state);
        boolean z = true;
        if (readableMap != null) {
            view.getContext();
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                Dynamic dynamic = readableMap.getDynamic(strNextKey);
                if (strNextKey.equals("selected") && dynamic.getType() == ReadableType.Boolean) {
                    accessibilityNodeInfo.setSelected(dynamic.asBoolean());
                } else if (strNextKey.equals("disabled") && dynamic.getType() == ReadableType.Boolean) {
                    accessibilityNodeInfo.setEnabled(!dynamic.asBoolean());
                } else if (strNextKey.equals("checked") && dynamic.getType() == ReadableType.Boolean) {
                    boolean zAsBoolean = dynamic.asBoolean();
                    accessibilityNodeInfo.setCheckable(true);
                    accessibilityNodeInfo.setChecked(zAsBoolean);
                }
            }
        }
        ReadableArray readableArray = (ReadableArray) view.getTag(R.id.accessibility_actions);
        ReadableMap readableMap2 = (ReadableMap) view.getTag(R.id.accessibility_collection_item);
        if (readableMap2 != null) {
            accessibilityNodeInfoCompat.p(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.b(readableMap2.getBoolean("heading"), readableMap2.getInt("rowIndex"), readableMap2.getInt("rowSpan"), readableMap2.getInt("columnIndex"), readableMap2.getInt("columnSpan")));
        }
        if (readableArray != null) {
            int i2 = 0;
            while (i2 < readableArray.size()) {
                ReadableMap map = readableArray.getMap(i2);
                if (!map.hasKey(CLConstants.FIELD_PAY_INFO_NAME)) {
                    throw new IllegalArgumentException("Unknown accessibility action.");
                }
                int iIntValue = s;
                String string = map.hasKey("label") ? map.getString("label") : null;
                HashMap map2 = t;
                boolean z2 = z;
                if (map2.containsKey(map.getString(CLConstants.FIELD_PAY_INFO_NAME))) {
                    iIntValue = ((Integer) map2.get(map.getString(CLConstants.FIELD_PAY_INFO_NAME))).intValue();
                } else {
                    s++;
                }
                this.q.put(Integer.valueOf(iIntValue), map.getString(CLConstants.FIELD_PAY_INFO_NAME));
                accessibilityNodeInfoCompat.b(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(iIntValue, string));
                i2++;
                z = z2;
            }
        }
        boolean z3 = z;
        ReadableMap readableMap3 = (ReadableMap) view.getTag(R.id.accessibility_value);
        if (readableMap3 != null && readableMap3.hasKey("min") && readableMap3.hasKey("now") && readableMap3.hasKey("max")) {
            Dynamic dynamic2 = readableMap3.getDynamic("min");
            Dynamic dynamic3 = readableMap3.getDynamic("now");
            Dynamic dynamic4 = readableMap3.getDynamic("max");
            if (dynamic2 != null) {
                ReadableType type = dynamic2.getType();
                ReadableType readableType = ReadableType.Number;
                if (type == readableType && dynamic3 != null && dynamic3.getType() == readableType && dynamic4 != null && dynamic4.getType() == readableType) {
                    int iAsInt = dynamic2.asInt();
                    int iAsInt2 = dynamic3.asInt();
                    int iAsInt3 = dynamic4.asInt();
                    if (iAsInt3 > iAsInt && iAsInt2 >= iAsInt && iAsInt3 >= iAsInt2) {
                        accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.d(iAsInt, iAsInt3, iAsInt2, 0).f3202a);
                    }
                }
            }
        }
        String str2 = (String) view.getTag(R.id.react_test_id);
        if (str2 != null) {
            accessibilityNodeInfo.setViewIdResourceName(str2);
        }
        boolean z4 = (TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription()) && TextUtils.isEmpty(accessibilityNodeInfoCompat.i())) ? z3 : false;
        boolean z5 = (readableArray == null && readableMap == null && tag == null && accessibilityRoleB == null) ? false : z3;
        if (z4 && z5) {
            accessibilityNodeInfoCompat.q(q(view, accessibilityNodeInfoCompat));
        }
    }

    public final Object p(int i2, int i3, Class cls) {
        View view = this.n;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        if (!(textView.getText() instanceof Spanned)) {
            return null;
        }
        Object[] spans = ((Spanned) textView.getText()).getSpans(i2, i3, cls);
        if (spans.length > 0) {
            return spans[0];
        }
        return null;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
        if (i2 == 524288) {
            view.setTag(R.id.accessibility_state_expanded, Boolean.FALSE);
        }
        if (i2 == 262144) {
            view.setTag(R.id.accessibility_state_expanded, Boolean.TRUE);
        }
        HashMap map = this.q;
        if (!map.containsKey(Integer.valueOf(i2))) {
            return super.performAccessibilityAction(view, i2, bundle);
        }
        final WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("actionName", (String) map.get(Integer.valueOf(i2)));
        ReactContext reactContext = (ReactContext) view.getContext();
        if (reactContext.hasActiveReactInstance()) {
            int id = view.getId();
            int iD = UIManagerHelper.d(reactContext);
            UIManager uIManagerF = UIManagerHelper.f(reactContext, ViewUtil.a(id), true);
            if (uIManagerF != null) {
                uIManagerF.getEventDispatcher().g(new Event(iD, id) { // from class: com.facebook.react.uimanager.ReactAccessibilityDelegate.2
                    @Override // com.facebook.react.uimanager.events.Event
                    public final WritableMap getEventData() {
                        return writableMapCreateMap;
                    }

                    @Override // com.facebook.react.uimanager.events.Event
                    public final String getEventName() {
                        return "topAccessibilityAction";
                    }
                });
            }
        } else {
            ReactSoftExceptionLogger.logSoftException("ReactAccessibilityDelegate", new ReactNoCrashSoftException("Cannot get RCTEventEmitter, no CatalystInstance"));
        }
        AccessibilityRole accessibilityRole = (AccessibilityRole) view.getTag(R.id.accessibility_role);
        ReadableMap readableMap = (ReadableMap) view.getTag(R.id.accessibility_value);
        if (accessibilityRole != AccessibilityRole.f19446h || (i2 != AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3191i.a() && i2 != AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3192j.a())) {
            return true;
        }
        if (readableMap != null && !readableMap.hasKey("text")) {
            Handler handler = this.p;
            if (handler.hasMessages(1, view)) {
                handler.removeMessages(1, view);
            }
            handler.sendMessageDelayed(handler.obtainMessage(1, view), 200L);
        }
        return super.performAccessibilityAction(view, i2, bundle);
    }
}
