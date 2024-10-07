import com.lhstack.tools.plugins.IPlugin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.InputStream;
import java.util.Objects;

public class PluginImpl implements IPlugin {


	@Override
	public JComponent createPanel(String projectHash) {
		return new JLabel("Demo", JLabel.CENTER);
	}

	@Override
	public Icon pluginIcon() {
		try {
			return new ImageIcon(ImageIO.read(Objects.requireNonNull(PluginImpl.class.getClassLoader().getResourceAsStream("a1.png"))));
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Icon pluginTabIcon() {
		try {
			return new ImageIcon(ImageIO.read(Objects.requireNonNull(PluginImpl.class.getClassLoader().getResourceAsStream("a1.png"))));
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String pluginName() {
		return "Demo";
	}

	@Override
	public String pluginDesc() {
		return "这是一个Demo插件描述";
	}

	@Override
	public String pluginVersion() {
		return "0.0.1";
	}
}