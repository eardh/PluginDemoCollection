import com.lhstack.tools.plugins.IPlugin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PluginImpl implements IPlugin {


	private final Map<String, JLabel> cache = new HashMap<>();

	private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1, r -> {
		Thread thread = new Thread(r);
		thread.setName("Demo-Plugin-Scheduled-Thread #" + thread.getId());
		return thread;
	});

	@Override
	public JComponent createPanel(String projectHash) {
		return cache.computeIfAbsent(projectHash, key -> {
			return new JLabel(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")), JLabel.CENTER);
		});
	}

	@Override
	public void closeProject(String projectHash) {
		//关闭项目,移除项目对应打开的组件
		cache.remove(projectHash);
	}

	@Override
	public void unInstall() {
		//清除缓存
		cache.clear();
		//停止线程池
		scheduledExecutorService.shutdown();
	}

	@Override
	public void install() {
		//初始化任务调度,更新所有组件时间
		scheduledExecutorService.schedule(new Runnable() {
			@Override
			public void run() {
				String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
				cache.forEach((key, value) -> value.setText(date));
				scheduledExecutorService.schedule(this, 200, TimeUnit.MILLISECONDS);
			}
		}, 200, TimeUnit.MILLISECONDS);
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