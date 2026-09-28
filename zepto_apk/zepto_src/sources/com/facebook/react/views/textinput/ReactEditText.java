package com.facebook.react.views.textinput;

import android.R;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.facebook.react.views.text.TextAttributes;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.internal.span.CustomLetterSpacingSpan;
import com.facebook.react.views.text.internal.span.CustomLineHeightSpan;
import com.facebook.react.views.text.internal.span.CustomStyleSpan;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactBackgroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactForegroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactSpan;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;
import com.facebook.react.views.text.internal.span.ReactTextPaintHolderSpan;
import com.facebook.react.views.text.internal.span.ReactUnderlineSpan;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public class ReactEditText extends AppCompatEditText {
    public static final QwertyKeyListener Q = QwertyKeyListener.getInstanceForFullKeyboard();
    public boolean A;
    public String B;
    public int C;
    public int D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public String I;
    public Overflow J;
    public StateWrapper K;
    public boolean L;
    public EventDispatcher M;

    /* renamed from: g, reason: collision with root package name */
    public final InputMethodManager f20181g;

    /* renamed from: h, reason: collision with root package name */
    public final String f20182h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20183i;

    /* renamed from: j, reason: collision with root package name */
    public final int f20184j;

    /* renamed from: k, reason: collision with root package name */
    public final int f20185k;

    /* renamed from: l, reason: collision with root package name */
    public int f20186l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f20187m;
    public TextWatcherDelegator n;
    public int o;
    public boolean p;
    public String q;
    public boolean r;
    public String s;
    public SelectionWatcher t;
    public ContentSizeWatcher u;
    public ScrollWatcher v;
    public InternalKeyListener w;
    public boolean x;
    public boolean y;
    public final TextAttributes z;

    public static class InternalKeyListener implements KeyListener {

        /* renamed from: a, reason: collision with root package name */
        public int f20189a = 0;

        @Override // android.text.method.KeyListener
        public final void clearMetaKeyState(View view, Editable editable, int i2) {
            ReactEditText.Q.clearMetaKeyState(view, editable, i2);
        }

        @Override // android.text.method.KeyListener
        public final int getInputType() {
            return this.f20189a;
        }

        @Override // android.text.method.KeyListener
        public final boolean onKeyDown(View view, Editable editable, int i2, KeyEvent keyEvent) {
            return ReactEditText.Q.onKeyDown(view, editable, i2, keyEvent);
        }

        @Override // android.text.method.KeyListener
        public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
            return ReactEditText.Q.onKeyOther(view, editable, keyEvent);
        }

        @Override // android.text.method.KeyListener
        public final boolean onKeyUp(View view, Editable editable, int i2, KeyEvent keyEvent) {
            return ReactEditText.Q.onKeyUp(view, editable, i2, keyEvent);
        }
    }

    public class TextWatcherDelegator implements TextWatcher {
        public TextWatcherDelegator() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            ArrayList arrayList;
            ReactEditText reactEditText = ReactEditText.this;
            if (reactEditText.f20183i || (arrayList = reactEditText.f20187m) == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((TextWatcher) it.next()).afterTextChanged(editable);
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ArrayList arrayList;
            ReactEditText reactEditText = ReactEditText.this;
            if (reactEditText.f20183i || (arrayList = reactEditText.f20187m) == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((TextWatcher) it.next()).beforeTextChanged(charSequence, i2, i3, i4);
            }
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ArrayList arrayList;
            QwertyKeyListener qwertyKeyListener = ReactEditText.Q;
            ReactEditText reactEditText = ReactEditText.this;
            if (!reactEditText.f20183i && (arrayList = reactEditText.f20187m) != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).onTextChanged(charSequence, i2, i3, i4);
                }
            }
            reactEditText.k();
            reactEditText.h();
        }
    }

    public ReactEditText(ThemedReactContext themedReactContext) {
        super(themedReactContext, null);
        this.f20182h = "ReactEditText";
        this.q = null;
        this.x = false;
        this.y = false;
        this.A = false;
        this.B = null;
        this.C = -1;
        this.D = -1;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = null;
        this.J = Overflow.f19918b;
        this.K = null;
        this.L = false;
        setFocusableInTouchMode(false);
        Object systemService = themedReactContext.getSystemService("input_method");
        Assertions.c(systemService);
        this.f20181g = (InputMethodManager) systemService;
        this.f20184j = getGravity() & 8388615;
        this.f20185k = getGravity() & 112;
        this.f20186l = 0;
        this.f20183i = false;
        this.r = false;
        this.f20187m = null;
        this.n = null;
        this.o = getInputType();
        if (this.w == null) {
            this.w = new InternalKeyListener();
        }
        this.v = null;
        this.z = new TextAttributes();
        d();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26 && i2 <= 27) {
            setLayerType(1, null);
        }
        ViewCompat.z(this, new ReactAccessibilityDelegate(this, isFocusable(), getImportantForAccessibility()) { // from class: com.facebook.react.views.textinput.ReactEditText.1
            @Override // com.facebook.react.uimanager.ReactAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
            public final boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
                if (i3 != 16) {
                    return super.performAccessibilityAction(view, i3, bundle);
                }
                ReactEditText reactEditText = ReactEditText.this;
                int length = reactEditText.getText().length();
                if (length > 0) {
                    reactEditText.setSelection(length);
                }
                QwertyKeyListener qwertyKeyListener = ReactEditText.Q;
                return reactEditText.i();
            }
        });
        ActionMode.Callback callback = new ActionMode.Callback() { // from class: com.facebook.react.views.textinput.ReactEditText.2
            @Override // android.view.ActionMode.Callback
            public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                if (ReactEditText.this.F) {
                    return false;
                }
                menu.removeItem(R.id.pasteAsPlainText);
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public final void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return true;
            }
        };
        setCustomSelectionActionModeCallback(callback);
        setCustomInsertionActionModeCallback(callback);
    }

    private TextWatcherDelegator getTextWatcherDelegator() {
        if (this.n == null) {
            this.n = new TextWatcherDelegator();
        }
        return this.n;
    }

    @Override // android.widget.TextView
    public final void addTextChangedListener(TextWatcher textWatcher) {
        if (this.f20187m == null) {
            this.f20187m = new ArrayList();
            super.addTextChangedListener(getTextWatcherDelegator());
        }
        this.f20187m.add(textWatcher);
    }

    @Override // android.view.View
    public final void clearFocus() {
        setFocusableInTouchMode(false);
        super.clearFocus();
        this.f20181g.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public final void d() {
        TextAttributes textAttributes = this.z;
        setTextSize(0, textAttributes.a());
        float fB = textAttributes.b();
        if (Float.isNaN(fB)) {
            return;
        }
        setLetterSpacing(fB);
    }

    public final boolean e() {
        return (getInputType() & 131072) != 0;
    }

    public final void f(int i2, int i3) {
        if (i2 == -1 || i3 == -1) {
            return;
        }
        super.setSelection(Math.max(0, Math.min(i2, getText() == null ? 0 : getText().length())), Math.max(0, Math.min(i3, getText() == null ? 0 : getText().length())));
    }

    public final void finalize() {
        TextLayoutManager.f20136b.remove(Integer.valueOf(getId()));
    }

    public final void g(ReactTextUpdate reactTextUpdate) {
        TextAttributes textAttributes;
        if (((getInputType() & 144) == 0 || !TextUtils.equals(getText(), reactTextUpdate.f20099a)) && reactTextUpdate.f20100b >= this.f20186l) {
            Spannable spannable = reactTextUpdate.f20099a;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannable);
            Object[] spans = getText().getSpans(0, length(), Object.class);
            int i2 = 0;
            while (true) {
                if (i2 >= spans.length) {
                    break;
                }
                Object obj = spans[i2];
                int spanFlags = getText().getSpanFlags(obj);
                boolean z = (spanFlags & 33) == 33;
                if (obj instanceof ReactSpan) {
                    getText().removeSpan(obj);
                }
                if (z) {
                    int spanStart = getText().getSpanStart(obj);
                    int spanEnd = getText().getSpanEnd(obj);
                    getText().removeSpan(obj);
                    Editable text = getText();
                    if (spanStart <= spannableStringBuilder.length() && spanEnd <= spannableStringBuilder.length()) {
                        int i3 = spanStart;
                        while (true) {
                            if (i3 >= spanEnd) {
                                spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                                break;
                            } else if (text.charAt(i3) != spannableStringBuilder.charAt(i3)) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                i2++;
            }
            Object[] spans2 = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ReactAbsoluteSizeSpan.class);
            int length = spans2.length;
            int i4 = 0;
            while (true) {
                textAttributes = this.z;
                if (i4 >= length) {
                    break;
                }
                Object obj2 = spans2[i4];
                if (((ReactAbsoluteSizeSpan) obj2).getSize() == textAttributes.a()) {
                    spannableStringBuilder.removeSpan(obj2);
                }
                i4++;
            }
            for (Object obj3 : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ReactBackgroundColorSpan.class)) {
                if (Integer.valueOf(((ReactBackgroundColorSpan) obj3).getBackgroundColor()).equals(BackgroundStyleApplicator.g(this))) {
                    spannableStringBuilder.removeSpan(obj3);
                }
            }
            for (Object obj4 : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ReactForegroundColorSpan.class)) {
                if (((ReactForegroundColorSpan) obj4).getForegroundColor() == getCurrentTextColor()) {
                    spannableStringBuilder.removeSpan(obj4);
                }
            }
            for (Object obj5 : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ReactStrikethroughSpan.class)) {
                if ((getPaintFlags() & 16) != 0) {
                    spannableStringBuilder.removeSpan(obj5);
                }
            }
            for (Object obj6 : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ReactUnderlineSpan.class)) {
                if ((getPaintFlags() & 8) != 0) {
                    spannableStringBuilder.removeSpan(obj6);
                }
            }
            for (Object obj7 : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), CustomLetterSpacingSpan.class)) {
                if (((CustomLetterSpacingSpan) obj7).f20157a == textAttributes.b()) {
                    spannableStringBuilder.removeSpan(obj7);
                }
            }
            for (Object obj8 : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), CustomStyleSpan.class)) {
                CustomStyleSpan customStyleSpan = (CustomStyleSpan) obj8;
                int i5 = customStyleSpan.f20159a;
                if (i5 == -1) {
                    i5 = 0;
                }
                if (i5 == this.D) {
                    if (Objects.equals(customStyleSpan.f20162d, this.B)) {
                        int i6 = customStyleSpan.f20160b;
                        if (i6 == -1) {
                            i6 = 400;
                        }
                        if (i6 == this.C) {
                            if (Objects.equals(customStyleSpan.f20161c, getFontFeatureSettings())) {
                                spannableStringBuilder.removeSpan(obj8);
                            }
                        }
                    }
                }
            }
            this.p = reactTextUpdate.f20101c;
            this.L = true;
            if (spannable.length() == 0) {
                setText((CharSequence) null);
            } else {
                getText().replace(0, length(), spannableStringBuilder);
            }
            this.L = false;
            int breakStrategy = getBreakStrategy();
            int i7 = reactTextUpdate.f20107i;
            if (breakStrategy != i7) {
                setBreakStrategy(i7);
            }
            k();
        }
    }

    public boolean getDisableFullscreenUI() {
        return this.r;
    }

    public int getGravityHorizontal() {
        return getGravity() & 8388615;
    }

    public String getReturnKeyType() {
        return this.s;
    }

    public int getStagedInputType() {
        return this.o;
    }

    @Nullable
    public StateWrapper getStateWrapper() {
        return this.K;
    }

    public String getSubmitBehavior() {
        return this.q;
    }

    public final void h() {
        ContentSizeWatcher contentSizeWatcher = this.u;
        if (contentSizeWatcher != null) {
            contentSizeWatcher.a();
        }
        ReactContext reactContextC = UIManagerHelper.c(this);
        if (this.K != null || reactContextC.isBridgeless()) {
            return;
        }
        ReactTextInputLocalData reactTextInputLocalData = new ReactTextInputLocalData(this);
        UIManagerModule uIManagerModule = (UIManagerModule) reactContextC.getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null) {
            uIManagerModule.setViewLocalData(getId(), reactTextInputLocalData);
        }
    }

    public final boolean i() {
        setFocusableInTouchMode(true);
        boolean zRequestFocus = super.requestFocus(WKSRecord.Service.CISCO_FNA, null);
        if (getShowSoftInputOnFocus()) {
            this.f20181g.showSoftInput(this, 0);
        }
        return zRequestFocus;
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        if (this.p) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                if (textInlineImageSpan.a() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    @Override // android.view.View
    public final boolean isLayoutRequested() {
        return false;
    }

    public final boolean j() {
        String submitBehavior = getSubmitBehavior();
        return submitBehavior == null ? !e() : submitBehavior.equals("submit") || submitBehavior.equals("blurAndSubmit");
    }

    public final void k() {
        if (this.K == null || getId() == -1) {
            return;
        }
        Editable text = getText();
        boolean z = text != null && text.length() > 0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (z) {
            try {
                spannableStringBuilder.append(text.subSequence(0, text.length()));
            } catch (IndexOutOfBoundsException e2) {
                ReactSoftExceptionLogger.logSoftException(this.f20182h, e2);
            }
        }
        if (!z) {
            if (getHint() != null && getHint().length() > 0) {
                spannableStringBuilder.append(getHint());
            } else if (ViewUtil.b(this) != 2) {
                spannableStringBuilder.append((CharSequence) "I");
            }
        }
        TextAttributes textAttributes = this.z;
        spannableStringBuilder.setSpan(new ReactAbsoluteSizeSpan(textAttributes.a()), 0, spannableStringBuilder.length(), 16711698);
        spannableStringBuilder.setSpan(new ReactForegroundColorSpan(getCurrentTextColor()), 0, spannableStringBuilder.length(), 16711698);
        Integer numG = BackgroundStyleApplicator.g(this);
        if (numG != null && numG.intValue() != 0) {
            spannableStringBuilder.setSpan(new ReactBackgroundColorSpan(numG.intValue()), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 16) != 0) {
            spannableStringBuilder.setSpan(new ReactStrikethroughSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 8) != 0) {
            spannableStringBuilder.setSpan(new ReactUnderlineSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        float fB = textAttributes.b();
        if (!Float.isNaN(fB)) {
            spannableStringBuilder.setSpan(new CustomLetterSpacingSpan(fB), 0, spannableStringBuilder.length(), 16711698);
        }
        if (this.D != -1 || this.C != -1 || this.B != null || getFontFeatureSettings() != null) {
            spannableStringBuilder.setSpan(new CustomStyleSpan(this.D, this.C, getFontFeatureSettings(), this.B, getContext().getAssets()), 0, spannableStringBuilder.length(), 16711698);
        }
        float fC = textAttributes.c();
        if (!Float.isNaN(fC)) {
            spannableStringBuilder.setSpan(new CustomLineHeightSpan(fC), 0, spannableStringBuilder.length(), 16711698);
        }
        spannableStringBuilder.setSpan(new ReactTextPaintHolderSpan(new TextPaint(getPaint())), 0, spannableStringBuilder.length(), 18);
        TextLayoutManager.f20136b.put(Integer.valueOf(getId()), spannableStringBuilder);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            r9 = this;
            r0 = 5
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            java.lang.String r5 = r9.s
            r6 = 6
            if (r5 == 0) goto L6a
            r5.getClass()
            r7 = -1
            int r8 = r5.hashCode()
            switch(r8) {
                case -1273775369: goto L58;
                case -906336856: goto L4d;
                case 3304: goto L42;
                case 3089282: goto L37;
                case 3377907: goto L2c;
                case 3387192: goto L21;
                case 3526536: goto L16;
                default: goto L15;
            }
        L15:
            goto L62
        L16:
            java.lang.String r8 = "send"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L1f
            goto L62
        L1f:
            r7 = r6
            goto L62
        L21:
            java.lang.String r8 = "none"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L2a
            goto L62
        L2a:
            r7 = r0
            goto L62
        L2c:
            java.lang.String r8 = "next"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L35
            goto L62
        L35:
            r7 = r1
            goto L62
        L37:
            java.lang.String r8 = "done"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L40
            goto L62
        L40:
            r7 = r2
            goto L62
        L42:
            java.lang.String r8 = "go"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L4b
            goto L62
        L4b:
            r7 = r3
            goto L62
        L4d:
            java.lang.String r8 = "search"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L56
            goto L62
        L56:
            r7 = r4
            goto L62
        L58:
            java.lang.String r8 = "previous"
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L61
            goto L62
        L61:
            r7 = 0
        L62:
            switch(r7) {
                case 0: goto L70;
                case 1: goto L6e;
                case 2: goto L6c;
                case 3: goto L6a;
                case 4: goto L71;
                case 5: goto L68;
                case 6: goto L66;
                default: goto L65;
            }
        L65:
            goto L6a
        L66:
            r0 = r1
            goto L71
        L68:
            r0 = r4
            goto L71
        L6a:
            r0 = r6
            goto L71
        L6c:
            r0 = r3
            goto L71
        L6e:
            r0 = r2
            goto L71
        L70:
            r0 = 7
        L71:
            boolean r1 = r9.r
            if (r1 == 0) goto L7c
            r1 = 33554432(0x2000000, float:9.403955E-38)
            r0 = r0 | r1
            r9.setImeOptions(r0)
            return
        L7c:
            r9.setImeOptions(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactEditText.l():void");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setTextIsSelectable(true);
        f(selectionStart, selectionEnd);
        if (this.p) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.c();
            }
        }
        if (this.E && !this.G) {
            i();
        }
        this.G = true;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        UIManagerHelper.c(this);
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection != null && this.y) {
            inputConnectionOnCreateInputConnection = new ReactEditTextInputConnectionWrapper(inputConnectionOnCreateInputConnection, this, this.M);
        }
        if (e()) {
            String submitBehavior = getSubmitBehavior();
            if ((submitBehavior == null ? !e() : submitBehavior.equals("blurAndSubmit")) || j()) {
                editorInfo.imeOptions &= -1073741825;
            }
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.p) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.d();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.J != Overflow.f19918b) {
            BackgroundStyleApplicator.a(this, canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.p) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.e();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z, int i2, Rect rect) {
        SelectionWatcher selectionWatcher;
        super.onFocusChanged(z, i2, rect);
        if (!z || (selectionWatcher = this.t) == null) {
            return;
        }
        selectionWatcher.a(getSelectionStart(), getSelectionEnd());
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 66 || e()) {
            return super.onKeyUp(i2, keyEvent);
        }
        this.f20181g.hideSoftInputFromWindow(getWindowToken(), 0);
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        h();
        if (this.H && isFocused()) {
            selectAll();
            this.H = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        ScrollWatcher scrollWatcher = this.v;
        if (scrollWatcher != null) {
            scrollWatcher.a(i2, i3);
        }
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int i2, int i3) {
        super.onSelectionChanged(i2, i3);
        if (this.t == null || !hasFocus()) {
            return;
        }
        this.t.a(i2, i3);
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.p) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                textInlineImageSpan.f();
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i2) {
        if (i2 == 16908322) {
            i2 = R.id.pasteAsPlainText;
        }
        return super.onTextContextMenuItem(i2);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.x = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2 && this.x) {
            if (!canScrollVertically(-1) && !canScrollVertically(1) && !canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.x = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public final void removeTextChangedListener(TextWatcher textWatcher) {
        ArrayList arrayList = this.f20187m;
        if (arrayList != null) {
            arrayList.remove(textWatcher);
            if (this.f20187m.isEmpty()) {
                this.f20187m = null;
                super.removeTextChangedListener(getTextWatcherDelegator());
            }
        }
    }

    @Override // android.view.View
    public final boolean requestFocus(int i2, Rect rect) {
        return isFocused();
    }

    public void setAllowFontScaling(boolean z) {
        TextAttributes textAttributes = this.z;
        if (textAttributes.f20128a != z) {
            textAttributes.f20128a = z;
            d();
        }
    }

    public void setAutoFocus(boolean z) {
        this.E = z;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        BackgroundStyleApplicator.i(this, Integer.valueOf(i2));
    }

    public void setBorderRadius(float f2) {
        BorderRadiusProp borderRadiusProp = BorderRadiusProp.f19836a;
        BackgroundStyleApplicator.l(this, BorderRadiusProp.values()[0], Float.isNaN(f2) ? null : new LengthPercentage(PixelUtil.a(f2), LengthPercentageType.f19394a));
    }

    public void setBorderStyle(@Nullable String str) {
        BackgroundStyleApplicator.m(this, str == null ? null : BorderStyle.a(str));
    }

    public void setContentSizeWatcher(@Nullable ContentSizeWatcher contentSizeWatcher) {
        this.u = contentSizeWatcher;
    }

    public void setContextMenuHidden(boolean z) {
        this.F = z;
    }

    public void setDisableFullscreenUI(boolean z) {
        this.r = z;
        l();
    }

    public void setEventDispatcher(@Nullable EventDispatcher eventDispatcher) {
        this.M = eventDispatcher;
    }

    public void setFontFamily(String str) {
        this.B = str;
        this.A = true;
    }

    @Override // android.widget.TextView
    public void setFontFeatureSettings(String str) {
        if (Objects.equals(str, getFontFeatureSettings())) {
            return;
        }
        super.setFontFeatureSettings(str);
        this.A = true;
    }

    public void setFontSize(float f2) {
        this.z.f20129b = f2;
        d();
    }

    public void setFontStyle(String str) {
        int iB = ReactTypefaceUtils.b(str);
        if (iB != this.D) {
            this.D = iB;
            this.A = true;
        }
    }

    public void setFontWeight(String str) {
        int iD = ReactTypefaceUtils.d(str);
        if (iD != this.C) {
            this.C = iD;
            this.A = true;
        }
    }

    public void setGravityHorizontal(int i2) {
        if (i2 == 0) {
            i2 = this.f20184j;
        }
        setGravity(i2 | (getGravity() & (-8388616)));
    }

    public void setGravityVertical(int i2) {
        if (i2 == 0) {
            i2 = this.f20185k;
        }
        setGravity(i2 | (getGravity() & (-113)));
    }

    @Override // android.widget.TextView
    public void setInputType(int i2) {
        Typeface typeface = super.getTypeface();
        super.setInputType(i2);
        this.o = i2;
        super.setTypeface(typeface);
        if (e()) {
            setSingleLine(false);
        }
        if (this.w == null) {
            this.w = new InternalKeyListener();
        }
        InternalKeyListener internalKeyListener = this.w;
        internalKeyListener.f20189a = i2;
        setKeyListener(internalKeyListener);
    }

    public void setLetterSpacingPt(float f2) {
        this.z.f20131d = f2;
        d();
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2) {
        this.z.f20130c = i2;
    }

    public void setMaxFontSizeMultiplier(float f2) {
        TextAttributes textAttributes = this.z;
        if (f2 != textAttributes.f20132e) {
            if (f2 == 0.0f || f2 >= 1.0f) {
                textAttributes.f20132e = f2;
            } else {
                FLog.q("ReactNative", "maxFontSizeMultiplier must be NaN, 0, or >= 1");
                textAttributes.f20132e = Float.NaN;
            }
            d();
        }
    }

    public void setOnKeyPress(boolean z) {
        this.y = z;
    }

    public void setOverflow(@Nullable String str) {
        if (str == null) {
            this.J = Overflow.f19918b;
        } else {
            Overflow overflowA = Overflow.a(str);
            if (overflowA == null) {
                overflowA = Overflow.f19918b;
            }
            this.J = overflowA;
        }
        invalidate();
    }

    public void setPlaceholder(@Nullable String str) {
        if (Objects.equals(str, this.I)) {
            return;
        }
        this.I = str;
        setHint(str);
    }

    public void setReturnKeyType(String str) {
        this.s = str;
        l();
    }

    public void setScrollWatcher(@Nullable ScrollWatcher scrollWatcher) {
        this.v = scrollWatcher;
    }

    public void setSelectTextOnFocus(boolean z) {
        super.setSelectAllOnFocus(z);
        this.H = z;
    }

    public void setSelectionWatcher(@Nullable SelectionWatcher selectionWatcher) {
        this.t = selectionWatcher;
    }

    public void setStagedInputType(int i2) {
        this.o = i2;
    }

    public void setStateWrapper(StateWrapper stateWrapper) {
        this.K = stateWrapper;
    }

    public void setSubmitBehavior(@Nullable String str) {
        this.q = str;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        if (this.p) {
            Editable text = getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class)) {
                if (textInlineImageSpan.a() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }
}
