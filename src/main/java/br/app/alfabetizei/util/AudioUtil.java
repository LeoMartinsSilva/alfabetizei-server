package br.app.alfabetizei.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import org.springframework.core.io.ClassPathResource;

public class AudioUtil {
	
	public static ClassPathResource getAudio(String path) {
		try {
			Path baseDir = Paths
					.get(new ClassPathResource(path).getURI());
			try (var stream = Files.list(baseDir)) {
				Path primeiro = stream.sorted(Comparator.naturalOrder()).findFirst().orElse(null);

				if (primeiro != null) {
					return new ClassPathResource(path + "/" + primeiro.getFileName().toString());
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
