package com.facebook.react.views.textinput;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.facebook.react.uimanager.events.EventDispatcher;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
class ReactEditTextInputConnectionWrapper extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final ReactEditText f20191a;

    /* renamed from: b, reason: collision with root package name */
    public final EventDispatcher f20192b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20193c;

    /* renamed from: d, reason: collision with root package name */
    public String f20194d;

    public ReactEditTextInputConnectionWrapper(InputConnection inputConnection, ReactEditText reactEditText, EventDispatcher eventDispatcher) {
        super(inputConnection, false);
        this.f20194d = null;
        this.f20192b = eventDispatcher;
        this.f20191a = reactEditText;
    }

    public final void a(String str) {
        if (str.equals(StringUtils.LF)) {
            str = "Enter";
        }
        ReactTextInputKeyPressEvent reactTextInputKeyPressEvent = new ReactTextInputKeyPressEvent(-1, this.f20191a.getId());
        reactTextInputKeyPressEvent.f20198a = str;
        this.f20192b.g(reactTextInputKeyPressEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        this.f20193c = true;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence, int i2) {
        String string = charSequence.toString();
        if (string.length() <= 2) {
            if (string.equals("")) {
                string = "Backspace";
            }
            if (this.f20193c) {
                this.f20194d = string;
            } else {
                a(string);
            }
        }
        return super.commitText(charSequence, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i2, int i3) {
        a("Backspace");
        return super.deleteSurroundingText(i2, i3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        this.f20193c = false;
        String str = this.f20194d;
        if (str != null) {
            a(str);
            this.f20194d = null;
        }
        return super.endBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            boolean z = keyEvent.getUnicodeChar() < 58 && keyEvent.getUnicodeChar() > 47;
            if (keyEvent.getKeyCode() == 67) {
                a("Backspace");
            } else if (keyEvent.getKeyCode() == 66) {
                a("Enter");
            } else if (z) {
                a(String.valueOf(keyEvent.getNumber()));
            }
        }
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int i2) {
        ReactEditText reactEditText = this.f20191a;
        int selectionStart = reactEditText.getSelectionStart();
        int selectionEnd = reactEditText.getSelectionEnd();
        boolean composingText = super.setComposingText(charSequence, i2);
        int selectionStart2 = reactEditText.getSelectionStart();
        String strValueOf = (selectionStart2 < selectionStart || selectionStart2 <= 0 || (!(selectionStart == selectionEnd) && (selectionStart2 == selectionStart))) ? "Backspace" : String.valueOf(reactEditText.getText().charAt(selectionStart2 - 1));
        if (this.f20193c) {
            this.f20194d = strValueOf;
            return composingText;
        }
        a(strValueOf);
        return composingText;
    }
}
