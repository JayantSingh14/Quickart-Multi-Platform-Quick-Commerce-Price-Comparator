package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;

@RequiresApi
@RestrictTo
/* loaded from: classes.dex */
final class EmojiTextWatcher implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f4411a;

    /* renamed from: b, reason: collision with root package name */
    public EmojiCompat.InitCallback f4412b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4413c = true;

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f4414a;

        public InitCallbackImpl(EditText editText) {
            this.f4414a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public final void b() {
            EmojiTextWatcher.a((EditText) this.f4414a.get(), 1);
        }
    }

    public EmojiTextWatcher(EditText editText) {
        this.f4411a = editText;
    }

    public static void a(EditText editText, int i2) {
        int length;
        if (i2 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat emojiCompatA = EmojiCompat.a();
            if (editableText == null) {
                length = 0;
            } else {
                emojiCompatA.getClass();
                length = editableText.length();
            }
            emojiCompatA.g(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        EditText editText = this.f4411a;
        if (editText.isInEditMode() || !this.f4413c || EmojiCompat.f4294k == null || i3 > i4 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iB = EmojiCompat.a().b();
        if (iB != 0) {
            if (iB == 1) {
                EmojiCompat.a().g((Spannable) charSequence, i2, i4 + i2);
                return;
            } else if (iB != 3) {
                return;
            }
        }
        EmojiCompat emojiCompatA = EmojiCompat.a();
        if (this.f4412b == null) {
            this.f4412b = new InitCallbackImpl(editText);
        }
        emojiCompatA.h(this.f4412b);
    }
}
