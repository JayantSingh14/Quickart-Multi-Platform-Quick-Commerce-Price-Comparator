package com.chuckerteam.chucker.internal.ui.transaction;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.chuckerteam.chucker.R;
import com.chuckerteam.chucker.databinding.ChuckerTransactionItemBodyLineBinding;
import com.chuckerteam.chucker.databinding.ChuckerTransactionItemCopyBinding;
import com.chuckerteam.chucker.databinding.ChuckerTransactionItemHeadersBinding;
import com.chuckerteam.chucker.databinding.ChuckerTransactionItemImageBinding;
import com.chuckerteam.chucker.internal.support.ChessboardDrawable;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public abstract class TransactionPayloadViewHolder extends RecyclerView.ViewHolder {

    @Metadata
    public static final class BodyLineViewHolder extends TransactionPayloadViewHolder {
        public final ChuckerTransactionItemBodyLineBinding u;

        /* JADX WARN: Illegal instructions before constructor call */
        public BodyLineViewHolder(ChuckerTransactionItemBodyLineBinding bodyBinding) {
            Intrinsics.checkNotNullParameter(bodyBinding, "bodyBinding");
            TextView textView = bodyBinding.f16685a;
            Intrinsics.checkNotNullExpressionValue(textView, "getRoot(...)");
            super(textView);
            this.u = bodyBinding;
        }

        @Override // com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadViewHolder
        public final void q(TransactionPayloadItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (item instanceof TransactionPayloadItem.BodyLineItem) {
                this.u.f16686b.setText(((TransactionPayloadItem.BodyLineItem) item).f16962a);
            }
        }
    }

    @Metadata
    public static final class CopyViewHolder extends TransactionPayloadViewHolder {
        public final ChuckerTransactionItemCopyBinding u;
        public final Function0 v;

        /* JADX WARN: Illegal instructions before constructor call */
        public CopyViewHolder(ChuckerTransactionItemCopyBinding copyBinding, Function0 onCopyBodyListener) {
            Intrinsics.checkNotNullParameter(copyBinding, "copyBinding");
            Intrinsics.checkNotNullParameter(onCopyBodyListener, "onCopyBodyListener");
            LinearLayout linearLayout = copyBinding.f16687a;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "getRoot(...)");
            super(linearLayout);
            this.u = copyBinding;
            this.v = onCopyBodyListener;
        }

        @Override // com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadViewHolder
        public final void q(TransactionPayloadItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (item instanceof TransactionPayloadItem.CopyItem) {
                ChuckerTransactionItemCopyBinding chuckerTransactionItemCopyBinding = this.u;
                chuckerTransactionItemCopyBinding.f16688b.setVisibility(0);
                chuckerTransactionItemCopyBinding.f16688b.setOnClickListener(new e(this, 2));
            }
        }
    }

    @Metadata
    public static final class HeaderViewHolder extends TransactionPayloadViewHolder {
        public final ChuckerTransactionItemHeadersBinding u;

        /* JADX WARN: Illegal instructions before constructor call */
        public HeaderViewHolder(ChuckerTransactionItemHeadersBinding headerBinding) {
            Intrinsics.checkNotNullParameter(headerBinding, "headerBinding");
            TextView textView = headerBinding.f16689a;
            Intrinsics.checkNotNullExpressionValue(textView, "getRoot(...)");
            super(textView);
            this.u = headerBinding;
        }

        @Override // com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadViewHolder
        public final void q(TransactionPayloadItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (item instanceof TransactionPayloadItem.HeaderItem) {
                this.u.f16690b.setText(((TransactionPayloadItem.HeaderItem) item).f16963a);
            }
        }
    }

    @Metadata
    public static final class ImageViewHolder extends TransactionPayloadViewHolder {
        public final ChuckerTransactionItemImageBinding u;

        @Metadata
        public static final class Companion {
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public ImageViewHolder(ChuckerTransactionItemImageBinding imageBinding) {
            Intrinsics.checkNotNullParameter(imageBinding, "imageBinding");
            FrameLayout frameLayout = imageBinding.f16691a;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "getRoot(...)");
            super(frameLayout);
            this.u = imageBinding;
        }

        @Override // com.chuckerteam.chucker.internal.ui.transaction.TransactionPayloadViewHolder
        public final void q(TransactionPayloadItem item) {
            ChessboardDrawable chessboardDrawable;
            ChessboardDrawable chessboardDrawable2;
            Intrinsics.checkNotNullParameter(item, "item");
            if (item instanceof TransactionPayloadItem.ImageItem) {
                ChuckerTransactionItemImageBinding chuckerTransactionItemImageBinding = this.u;
                TransactionPayloadItem.ImageItem imageItem = (TransactionPayloadItem.ImageItem) item;
                chuckerTransactionItemImageBinding.f16692b.setImageBitmap(imageItem.f16964a);
                Double d2 = imageItem.f16965b;
                if (d2 == null) {
                    chessboardDrawable2 = null;
                } else {
                    double dDoubleValue = d2.doubleValue();
                    View view = this.f11653a;
                    if (dDoubleValue < 0.25d) {
                        int i2 = ChessboardDrawable.f16748b;
                        Context context = view.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        int i3 = R.color.chucker_chessboard_even_square_light;
                        int i4 = R.color.chucker_chessboard_odd_square_light;
                        int i5 = R.dimen.chucker_half_grid;
                        Intrinsics.checkNotNullParameter(context, "context");
                        chessboardDrawable = new ChessboardDrawable(context.getColor(i3), context.getColor(i4), context.getResources().getDimensionPixelSize(i5));
                    } else {
                        int i6 = ChessboardDrawable.f16748b;
                        Context context2 = view.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                        int i7 = R.color.chucker_chessboard_even_square_dark;
                        int i8 = R.color.chucker_chessboard_odd_square_dark;
                        int i9 = R.dimen.chucker_half_grid;
                        Intrinsics.checkNotNullParameter(context2, "context");
                        chessboardDrawable = new ChessboardDrawable(context2.getColor(i7), context2.getColor(i8), context2.getResources().getDimensionPixelSize(i9));
                    }
                    chessboardDrawable2 = chessboardDrawable;
                }
                chuckerTransactionItemImageBinding.f16691a.setBackground(chessboardDrawable2);
            }
        }
    }

    public abstract void q(TransactionPayloadItem transactionPayloadItem);
}
