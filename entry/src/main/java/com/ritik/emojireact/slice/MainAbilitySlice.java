package com.ritik.emojireact.slice;

import com.ritik.emojireact.ResourceTable;
import com.ritik.emojireactionlibrary.ClickInterface;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import com.ritik.emojireactionlibrary.EmojiReactionView;
import ohos.agp.window.dialog.ToastDialog;

public class MainAbilitySlice extends AbilitySlice {

    EmojiReactionView myImage;
    int clickedEmoji = 0;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        System.out.println("EMOJIREACT : MainAbilitySlice");
        myImage = (EmojiReactionView) findComponentById(ResourceTable.Id_image);



        myImage.setOnEmojiClickListener(new ClickInterface() {
            @Override
            public void onEmojiClicked(int emojiIndex, int x, int y) {
                String message;
                if (x != -1) {
                    switch (emojiIndex) {
                        case 0:
                            message = " Great!! ";
                            break;
                        case 1:
                            message = " Hehe ";
                            break;
                        case 2:
                            message = " Loved... ";
                            break;
                        case 3:
                            message = " Shocked!! ";
                            break;
                        case 4:
                            message = " Sad... ";
                            break;
                        case 5:
                            message = " Lit!! ";
                            break;
                        default:
                            message = " ** ";
                    }
                    ToastDialog toastDialog = new ToastDialog(getContext());
                    toastDialog.setText(message).show();
                }
                clickedEmoji = emojiIndex;
            }

            @Override
            public void onEmojiUnclicked(int emojiIndex, int x, int y) {

            }

        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
