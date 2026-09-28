package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public final class EmojiTextViewHelper {

    /* renamed from: a, reason: collision with root package name */
    public final HelperInternal f4406a;

    public static class HelperInternal {
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            return inputFilterArr;
        }

        public boolean b() {
            return false;
        }

        public void c(boolean z) {
        }

        public void d(boolean z) {
        }

        public TransformationMethod e(TransformationMethod transformationMethod) {
            return transformationMethod;
        }
    }

    @RequiresApi
    public static class HelperInternal19 extends HelperInternal {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f4407a;

        /* renamed from: b, reason: collision with root package name */
        public final EmojiInputFilter f4408b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f4409c = true;

        public HelperInternal19(TextView textView) {
            this.f4407a = textView;
            this.f4408b = new EmojiInputFilter(textView);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            if (!this.f4409c) {
                SparseArray sparseArray = new SparseArray(1);
                for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
                    InputFilter inputFilter = inputFilterArr[i2];
                    if (inputFilter instanceof EmojiInputFilter) {
                        sparseArray.put(i2, inputFilter);
                    }
                }
                if (sparseArray.size() == 0) {
                    return inputFilterArr;
                }
                int length = inputFilterArr.length;
                InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    if (sparseArray.indexOfKey(i4) < 0) {
                        inputFilterArr2[i3] = inputFilterArr[i4];
                        i3++;
                    }
                }
                return inputFilterArr2;
            }
            int length2 = inputFilterArr.length;
            int i5 = 0;
            while (true) {
                EmojiInputFilter emojiInputFilter = this.f4408b;
                if (i5 >= length2) {
                    InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                    System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                    inputFilterArr3[length2] = emojiInputFilter;
                    return inputFilterArr3;
                }
                if (inputFilterArr[i5] == emojiInputFilter) {
                    return inputFilterArr;
                }
                i5++;
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final boolean b() {
            return this.f4409c;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final void c(boolean z) {
            if (z) {
                TextView textView = this.f4407a;
                textView.setTransformationMethod(e(textView.getTransformationMethod()));
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final void d(boolean z) {
            this.f4409c = z;
            TextView textView = this.f4407a;
            textView.setTransformationMethod(e(textView.getTransformationMethod()));
            textView.setFilters(a(textView.getFilters()));
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final TransformationMethod e(TransformationMethod transformationMethod) {
            return this.f4409c ? ((transformationMethod instanceof EmojiTransformationMethod) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new EmojiTransformationMethod(transformationMethod) : transformationMethod instanceof EmojiTransformationMethod ? ((EmojiTransformationMethod) transformationMethod).f4415a : transformationMethod;
        }
    }

    @RequiresApi
    public static class SkippingHelper19 extends HelperInternal {

        /* renamed from: a, reason: collision with root package name */
        public final HelperInternal19 f4410a;

        public SkippingHelper19(TextView textView) {
            this.f4410a = new HelperInternal19(textView);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final InputFilter[] a(InputFilter[] inputFilterArr) {
            return !(EmojiCompat.f4294k != null) ? inputFilterArr : this.f4410a.a(inputFilterArr);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final boolean b() {
            return this.f4410a.f4409c;
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final void c(boolean z) {
            if (EmojiCompat.f4294k != null) {
                this.f4410a.c(z);
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final void d(boolean z) {
            boolean z2 = EmojiCompat.f4294k != null;
            HelperInternal19 helperInternal19 = this.f4410a;
            if (z2) {
                helperInternal19.d(z);
            } else {
                helperInternal19.f4409c = z;
            }
        }

        @Override // androidx.emoji2.viewsintegration.EmojiTextViewHelper.HelperInternal
        public final TransformationMethod e(TransformationMethod transformationMethod) {
            return !(EmojiCompat.f4294k != null) ? transformationMethod : this.f4410a.e(transformationMethod);
        }
    }

    public EmojiTextViewHelper(TextView textView) {
        this.f4406a = new SkippingHelper19(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f4406a.a(inputFilterArr);
    }

    public final boolean b() {
        return this.f4406a.b();
    }

    public final void c(boolean z) {
        this.f4406a.c(z);
    }

    public final void d(boolean z) {
        this.f4406a.d(z);
    }

    public final TransformationMethod e(AllCapsTransformationMethod allCapsTransformationMethod) {
        return this.f4406a.e(allCapsTransformationMethod);
    }
}
