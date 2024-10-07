import dev.coolrequest.tool.CoolToolPanel;
import dev.coolrequest.tool.ToolPanelFactory;

import javax.swing.*;
import java.awt.*;

public class ToolFactory implements ToolPanelFactory {
    @Override
    public CoolToolPanel createToolPanel() {
        return new CoolToolPanel() {
            @Override
            public JPanel createPanel() {
                return new MainPanel();
            }

            @Override
            public void showTool() {

            }

            @Override
            public void closeTool() {

            }
        };
    }

    public static class MainPanel extends JPanel {
        public MainPanel() {
            setLayout(new BorderLayout());
            add(new JLabel("Hello Cool Request",SwingConstants.CENTER), BorderLayout.CENTER);
        }
    }
}