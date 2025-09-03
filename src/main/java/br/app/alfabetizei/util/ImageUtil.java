package br.app.alfabetizei.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;

import br.app.alfabetizei.dto.ImageDto;

public class ImageUtil {
	private static MediaType getType(String extensao) {
		switch (extensao.toLowerCase()) {
		case "png":
			return MediaType.IMAGE_PNG;
		case "jpg":
			return MediaType.IMAGE_JPEG;
		case "jpeg":
			return MediaType.IMAGE_JPEG;
		case "gif":
			return MediaType.IMAGE_GIF;
		case "webp":
			return MediaType.valueOf("image/webp");
		default:
			return MediaType.APPLICATION_OCTET_STREAM; 
		}
		
	}
	
	public static ImageDto getImage(String path) {
		byte[] bytes = {};
		String extensao = "";
		
		try {
			Path baseDir = Paths
					.get(new ClassPathResource(path).getURI());
			try (var stream = Files.list(baseDir)) {
				Path primeiro = stream.sorted(Comparator.naturalOrder()).findFirst().orElse(null);

				if (primeiro != null) {
					bytes = Files.readAllBytes(primeiro);
					extensao = primeiro.getFileName().toString()
							.substring(primeiro.getFileName().toString().lastIndexOf(".") + 1);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Imagem não encontrada");
		}

		MediaType mediaType = ImageUtil.getType(extensao);
		
		ImageDto image = ImageDto.builder().type(mediaType).bytes(bytes).build();
		return image;
	}
}
