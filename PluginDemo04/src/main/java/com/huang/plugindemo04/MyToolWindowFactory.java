package com.huang.plugindemo04;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @Author lei.huang
 * @Description TODO
 **/
public class MyToolWindowFactory implements ToolWindowFactory {

	@Override
	public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
		toolWindow.getContentManager().addContent(
				toolWindow.getContentManager().getFactory().createContent(
						new MainToolWindow(project), "", false));
		toolWindow.setAvailable(true);
	}
}
