package com.huang.plugindemo04;

import com.intellij.icons.AllIcons;
import com.intellij.mock.MockProject;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.impl.ActionButton;
import com.intellij.openapi.actionSystem.impl.ActionButtonWithText;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.ui.AnActionButton;
import com.intellij.ui.BalloonImpl;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBOptionButton;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.dsl.builder.impl.PanelBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lei.huang
 * @Description TODO
 **/
public class MainToolWindow extends SimpleToolWindowPanel {

	private Map<String, JComponent> componentMap = new HashMap<String, JComponent>();

	public MainToolWindow(Project project) {
		super(false, false);

		DefaultActionGroup actionGroup = new DefaultActionGroup();
		actionGroup.add(new Button("1"));
		actionGroup.add(new Button("2"));
		actionGroup.add(new Button("3"));
		actionGroup.add(new Button("4"));
		actionGroup.add(new Button("5"));

		ActionToolbar actionToolbar = ActionManager.getInstance().createActionToolbar("bar1", actionGroup, false);

		SimpleToolWindowPanel panel1 = new SimpleToolWindowPanel(true);
		panel1.add(new JBLabel("panel1"));
		componentMap.put("1", panel1);

		SimpleToolWindowPanel panel2 = new SimpleToolWindowPanel(true);
		panel2.add(new JBLabel("panel2"));
		componentMap.put("2", panel2);

		SimpleToolWindowPanel panel3 = new SimpleToolWindowPanel(true);
		panel3.add(new JBLabel("panel3"));
		componentMap.put("3", panel3);

		setToolbar(actionToolbar.getComponent());
		setContent(panel1);
	}

	class Button extends AnActionButton {

		private String label;

		public Button(@NlsContexts.Button String text) {
			super(text);
			label = text;
		}

		@Override
		public void actionPerformed(@NotNull AnActionEvent e) {
			JComponent jComponent = componentMap.get(label);
			MainToolWindow.this.setContent(jComponent);
		}
	}
}