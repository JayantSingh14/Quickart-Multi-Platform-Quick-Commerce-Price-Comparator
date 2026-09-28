package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {

    /* renamed from: c, reason: collision with root package name */
    public static int f3184c;

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f3185a;

    /* renamed from: b, reason: collision with root package name */
    public int f3186b = -1;

    public static class AccessibilityActionCompat {

        /* renamed from: e, reason: collision with root package name */
        public static final AccessibilityActionCompat f3187e = new AccessibilityActionCompat(1, (String) null);

        /* renamed from: f, reason: collision with root package name */
        public static final AccessibilityActionCompat f3188f = new AccessibilityActionCompat(2, (String) null);

        /* renamed from: g, reason: collision with root package name */
        public static final AccessibilityActionCompat f3189g;

        /* renamed from: h, reason: collision with root package name */
        public static final AccessibilityActionCompat f3190h;

        /* renamed from: i, reason: collision with root package name */
        public static final AccessibilityActionCompat f3191i;

        /* renamed from: j, reason: collision with root package name */
        public static final AccessibilityActionCompat f3192j;

        /* renamed from: k, reason: collision with root package name */
        public static final AccessibilityActionCompat f3193k;

        /* renamed from: l, reason: collision with root package name */
        public static final AccessibilityActionCompat f3194l;

        /* renamed from: m, reason: collision with root package name */
        public static final AccessibilityActionCompat f3195m;
        public static final AccessibilityActionCompat n;
        public static final AccessibilityActionCompat o;
        public static final AccessibilityActionCompat p;

        /* renamed from: a, reason: collision with root package name */
        public final Object f3196a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3197b;

        /* renamed from: c, reason: collision with root package name */
        public final Class f3198c;

        /* renamed from: d, reason: collision with root package name */
        public final AccessibilityViewCommand f3199d;

        static {
            new AccessibilityActionCompat(4, (String) null);
            new AccessibilityActionCompat(8, (String) null);
            f3189g = new AccessibilityActionCompat(16, (String) null);
            f3190h = new AccessibilityActionCompat(32, (String) null);
            new AccessibilityActionCompat(64, (String) null);
            new AccessibilityActionCompat(128, (String) null);
            new AccessibilityActionCompat(AccessibilityViewCommand.MoveAtGranularityArguments.class, 256);
            new AccessibilityActionCompat(AccessibilityViewCommand.MoveAtGranularityArguments.class, 512);
            new AccessibilityActionCompat(AccessibilityViewCommand.MoveHtmlArguments.class, 1024);
            new AccessibilityActionCompat(AccessibilityViewCommand.MoveHtmlArguments.class, 2048);
            f3191i = new AccessibilityActionCompat(4096, (String) null);
            f3192j = new AccessibilityActionCompat(KEYRecord.Flags.FLAG2, (String) null);
            new AccessibilityActionCompat(16384, (String) null);
            new AccessibilityActionCompat(32768, (String) null);
            new AccessibilityActionCompat(65536, (String) null);
            new AccessibilityActionCompat(AccessibilityViewCommand.SetSelectionArguments.class, 131072);
            f3193k = new AccessibilityActionCompat(262144, (String) null);
            f3194l = new AccessibilityActionCompat(524288, (String) null);
            f3195m = new AccessibilityActionCompat(1048576, (String) null);
            new AccessibilityActionCompat(AccessibilityViewCommand.SetTextArguments.class, 2097152);
            int i2 = Build.VERSION.SDK_INT;
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            n = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            o = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            new AccessibilityActionCompat(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            p = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            new AccessibilityActionCompat(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            new AccessibilityActionCompat(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            new AccessibilityActionCompat(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            new AccessibilityActionCompat(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            new AccessibilityActionCompat(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            new AccessibilityActionCompat(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            new AccessibilityActionCompat(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            new AccessibilityActionCompat(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            new AccessibilityActionCompat(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            new AccessibilityActionCompat(i2 >= 34 ? Api34Impl.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public AccessibilityActionCompat(int i2, String str) {
            this(null, i2, str, null, null);
        }

        public final int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f3196a).getId();
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            Object obj2 = ((AccessibilityActionCompat) obj).f3196a;
            Object obj3 = this.f3196a;
            return obj3 == null ? obj2 == null : obj3.equals(obj2);
        }

        public final int hashCode() {
            Object obj = this.f3196a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
            String strE = AccessibilityNodeInfoCompat.e(this.f3197b);
            if (strE.equals("ACTION_UNKNOWN")) {
                Object obj = this.f3196a;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    strE = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb.append(strE);
            return sb.toString();
        }

        public AccessibilityActionCompat(Class cls, int i2) {
            this(null, i2, null, null, cls);
        }

        public AccessibilityActionCompat(Object obj, int i2, String str, AccessibilityViewCommand accessibilityViewCommand, Class cls) {
            this.f3197b = i2;
            this.f3199d = accessibilityViewCommand;
            if (obj == null) {
                this.f3196a = new AccessibilityNodeInfo.AccessibilityAction(i2, str);
            } else {
                this.f3196a = obj;
            }
            this.f3198c = cls;
        }
    }

    @RequiresApi
    public static class Api30Impl {
        public static CharSequence a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api33Impl {
        public static String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api34Impl {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api35Impl {
    }

    /* loaded from: classes3.dex */
    public static class CollectionInfoCompat {

        /* renamed from: a, reason: collision with root package name */
        public final AccessibilityNodeInfo.CollectionInfo f3200a;

        public static final class Builder {
        }

        public CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo collectionInfo) {
            this.f3200a = collectionInfo;
        }

        public static CollectionInfoCompat a(int i2, int i3, int i4) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, false, i4));
        }

        public static CollectionInfoCompat b(int i2, int i3, boolean z) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z));
        }
    }

    /* loaded from: classes3.dex */
    public static class CollectionItemInfoCompat {

        /* renamed from: a, reason: collision with root package name */
        public final AccessibilityNodeInfo.CollectionItemInfo f3201a;

        public static final class Builder {
        }

        public CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo) {
            this.f3201a = collectionItemInfo;
        }

        public static CollectionItemInfoCompat a(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2));
        }

        public static CollectionItemInfoCompat b(boolean z, int i2, int i3, int i4, int i5) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z));
        }
    }

    /* loaded from: classes3.dex */
    public static class RangeInfoCompat {

        /* renamed from: a, reason: collision with root package name */
        public final AccessibilityNodeInfo.RangeInfo f3202a;

        public RangeInfoCompat(AccessibilityNodeInfo.RangeInfo rangeInfo) {
            this.f3202a = rangeInfo;
        }

        public static RangeInfoCompat d(float f2, float f3, float f4, int i2) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i2, f2, f3, f4));
        }

        public final float a() {
            return this.f3202a.getCurrent();
        }

        public final float b() {
            return this.f3202a.getMax();
        }

        public final float c() {
            return this.f3202a.getMin();
        }
    }

    /* loaded from: classes3.dex */
    public static final class TouchDelegateInfoCompat {
    }

    public AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f3185a = accessibilityNodeInfo;
    }

    public static String e(int i2) {
        if (i2 == 1) {
            return "ACTION_FOCUS";
        }
        if (i2 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i2) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case KEYRecord.Flags.FLAG2 /* 8192 */:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i2) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i2) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public final void a(int i2) {
        this.f3185a.addAction(i2);
    }

    public final void b(AccessibilityActionCompat accessibilityActionCompat) {
        this.f3185a.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f3196a);
    }

    public final ArrayList c(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3185a;
        ArrayList<Integer> integerArrayList = accessibilityNodeInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        accessibilityNodeInfo.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public final ArrayList d() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f3185a.getActionList();
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i2), 0, null, null, null));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f3185a;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.f3185a;
        if (accessibilityNodeInfo2 == null) {
            if (accessibilityNodeInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo2.equals(accessibilityNodeInfo)) {
            return false;
        }
        return this.f3186b == accessibilityNodeInfoCompat.f3186b;
    }

    public final boolean f(int i2) {
        Bundle extras = this.f3185a.getExtras();
        return extras != null && (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i2) == i2;
    }

    public final void g(Rect rect) {
        this.f3185a.getBoundsInParent(rect);
    }

    public final CharSequence h() {
        int i2 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3185a;
        return i2 >= 30 ? Api30Impl.a(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3185a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final CharSequence i() {
        boolean zIsEmpty = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3185a;
        if (zIsEmpty) {
            return accessibilityNodeInfo.getText();
        }
        ArrayList arrayListC = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        ArrayList arrayListC2 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        ArrayList arrayListC3 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        ArrayList arrayListC4 = c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(accessibilityNodeInfo.getText(), 0, accessibilityNodeInfo.getText().length()));
        for (int i2 = 0; i2 < arrayListC.size(); i2++) {
            spannableString.setSpan(new AccessibilityClickableSpanCompat(((Integer) arrayListC4.get(i2)).intValue(), this, accessibilityNodeInfo.getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) arrayListC.get(i2)).intValue(), ((Integer) arrayListC2.get(i2)).intValue(), ((Integer) arrayListC3.get(i2)).intValue());
        }
        return spannableString;
    }

    public final void j(AccessibilityActionCompat accessibilityActionCompat) {
        this.f3185a.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f3196a);
    }

    public final void k(int i2, boolean z) {
        Bundle extras = this.f3185a.getExtras();
        if (extras != null) {
            int i3 = extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i2);
            if (!z) {
                i2 = 0;
            }
            extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }

    public final void l(Rect rect) {
        this.f3185a.setBoundsInParent(rect);
    }

    public final void m(CharSequence charSequence) {
        this.f3185a.setClassName(charSequence);
    }

    public final void n(boolean z) {
        this.f3185a.setClickable(z);
    }

    public final void o(CollectionInfoCompat collectionInfoCompat) {
        this.f3185a.setCollectionInfo(collectionInfoCompat == null ? null : collectionInfoCompat.f3200a);
    }

    public final void p(CollectionItemInfoCompat collectionItemInfoCompat) {
        this.f3185a.setCollectionItemInfo(collectionItemInfoCompat.f3201a);
    }

    public final void q(CharSequence charSequence) {
        this.f3185a.setContentDescription(charSequence);
    }

    public final void r(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f3185a.setHeading(z);
        } else {
            k(2, z);
        }
    }

    public final void s(String str) {
        int i2 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3185a;
        if (i2 >= 26) {
            accessibilityNodeInfo.setHintText(str);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", str);
        }
    }

    public final void t(String str) {
        this.f3185a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        g(rect);
        sb.append("; boundsInParent: " + rect);
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3185a;
        accessibilityNodeInfo.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            Api34Impl.b(accessibilityNodeInfo, rect);
        } else {
            Rect rect2 = (Rect) accessibilityNodeInfo.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
            if (rect2 != null) {
                rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(accessibilityNodeInfo.getPackageName());
        sb.append("; className: ");
        sb.append(accessibilityNodeInfo.getClassName());
        sb.append("; text: ");
        sb.append(i());
        sb.append("; error: ");
        sb.append(accessibilityNodeInfo.getError());
        sb.append("; maxTextLength: ");
        sb.append(accessibilityNodeInfo.getMaxTextLength());
        sb.append("; stateDescription: ");
        sb.append(h());
        sb.append("; contentDescription: ");
        sb.append(accessibilityNodeInfo.getContentDescription());
        sb.append("; tooltipText: ");
        sb.append(i2 >= 28 ? accessibilityNodeInfo.getTooltipText() : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY"));
        sb.append("; viewIdResName: ");
        sb.append(accessibilityNodeInfo.getViewIdResourceName());
        sb.append("; uniqueId: ");
        sb.append(i2 >= 33 ? Api33Impl.a(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY"));
        sb.append("; checkable: ");
        sb.append(accessibilityNodeInfo.isCheckable());
        sb.append("; checked: ");
        sb.append(accessibilityNodeInfo.isChecked());
        sb.append("; fieldRequired: ");
        sb.append(accessibilityNodeInfo.getExtras().getBoolean("androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY"));
        sb.append("; focusable: ");
        sb.append(accessibilityNodeInfo.isFocusable());
        sb.append("; focused: ");
        sb.append(accessibilityNodeInfo.isFocused());
        sb.append("; selected: ");
        sb.append(accessibilityNodeInfo.isSelected());
        sb.append("; clickable: ");
        sb.append(accessibilityNodeInfo.isClickable());
        sb.append("; longClickable: ");
        sb.append(accessibilityNodeInfo.isLongClickable());
        sb.append("; contextClickable: ");
        sb.append(accessibilityNodeInfo.isContextClickable());
        sb.append("; enabled: ");
        sb.append(accessibilityNodeInfo.isEnabled());
        sb.append("; password: ");
        sb.append(accessibilityNodeInfo.isPassword());
        sb.append("; scrollable: " + accessibilityNodeInfo.isScrollable());
        sb.append("; containerTitle: ");
        sb.append(i2 >= 34 ? Api34Impl.c(accessibilityNodeInfo) : accessibilityNodeInfo.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY"));
        sb.append("; granularScrollingSupported: ");
        sb.append(f(67108864));
        sb.append("; importantForAccessibility: ");
        sb.append(accessibilityNodeInfo.isImportantForAccessibility());
        sb.append("; visible: ");
        sb.append(accessibilityNodeInfo.isVisibleToUser());
        sb.append("; isTextSelectable: ");
        sb.append(i2 >= 33 ? Api33Impl.b(accessibilityNodeInfo) : f(8388608));
        sb.append("; accessibilityDataSensitive: ");
        sb.append(i2 >= 34 ? Api34Impl.d(accessibilityNodeInfo) : f(64));
        sb.append("; [");
        ArrayList arrayListD = d();
        for (int i3 = 0; i3 < arrayListD.size(); i3++) {
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) arrayListD.get(i3);
            String strE = e(accessibilityActionCompat.a());
            if (strE.equals("ACTION_UNKNOWN")) {
                Object obj = accessibilityActionCompat.f3196a;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    strE = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb.append(strE);
            if (i3 != arrayListD.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final void u(boolean z) {
        this.f3185a.setScrollable(z);
    }

    public final void v(CharSequence charSequence) {
        int i2 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3185a;
        if (i2 >= 30) {
            Api30Impl.b(accessibilityNodeInfo, charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public final void w(CharSequence charSequence) {
        this.f3185a.setText(charSequence);
    }
}
