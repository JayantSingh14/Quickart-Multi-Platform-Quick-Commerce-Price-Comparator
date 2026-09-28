package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.WeakReference;

@RequiresApi
@RestrictTo
/* loaded from: classes.dex */
final class EmojiInputFilter implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f4400a;

    /* renamed from: b, reason: collision with root package name */
    public EmojiCompat.InitCallback f4401b;

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f4402a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference f4403b;

        public InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.f4402a = new WeakReference(textView);
            this.f4403b = new WeakReference(emojiInputFilter);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public final void b() {
            InputFilter[] filters;
            int length;
            TextView textView = (TextView) this.f4402a.get();
            InputFilter inputFilter = (InputFilter) this.f4403b.get();
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    if (textView.isAttachedToWindow()) {
                        CharSequence text = textView.getText();
                        EmojiCompat emojiCompatA = EmojiCompat.a();
                        if (text == null) {
                            length = 0;
                        } else {
                            emojiCompatA.getClass();
                            length = text.length();
                        }
                        CharSequence charSequenceG = emojiCompatA.g(text, 0, length);
                        if (text == charSequenceG) {
                            return;
                        }
                        int selectionStart = Selection.getSelectionStart(charSequenceG);
                        int selectionEnd = Selection.getSelectionEnd(charSequenceG);
                        textView.setText(charSequenceG);
                        if (charSequenceG instanceof Spannable) {
                            Spannable spannable = (Spannable) charSequenceG;
                            if (selectionStart >= 0 && selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionStart, selectionEnd);
                                return;
                            } else if (selectionStart >= 0) {
                                Selection.setSelection(spannable, selectionStart);
                                return;
                            } else {
                                if (selectionEnd >= 0) {
                                    Selection.setSelection(spannable, selectionEnd);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    public EmojiInputFilter(TextView textView) {
        this.f4400a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        TextView textView = this.f4400a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int iB = EmojiCompat.a().b();
        if (iB != 0) {
            if (iB == 1) {
                if ((i5 == 0 && i4 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i2 != 0 || i3 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i2, i3);
                }
                return EmojiCompat.a().g(charSequence, 0, charSequence.length());
            }
            if (iB != 3) {
                return charSequence;
            }
        }
        EmojiCompat emojiCompatA = EmojiCompat.a();
        if (this.f4401b == null) {
            this.f4401b = new InitCallbackImpl(textView, this);
        }
        emojiCompatA.h(this.f4401b);
        return charSequence;
    }
}
