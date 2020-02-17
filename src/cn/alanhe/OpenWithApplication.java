package cn.alanhe;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.fileTypes.NativeFileType;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class OpenWithApplication extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        assert file != null;
        NativeFileType.openAssociatedApplication(file);
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        assert file != null;
        Presentation presentation = e.getPresentation();
        presentation.setEnabled(!file.isDirectory());
    }
}
