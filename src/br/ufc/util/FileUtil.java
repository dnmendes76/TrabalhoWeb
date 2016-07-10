package br.ufc.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	public static void salvarImagem(String path, MultipartFile img){
		
		try {
			File file = new File(path);
			FileUtils.writeByteArrayToFile(file, img.getBytes());
			System.out.println("Salvo em: " + file);
			
		} catch (IOException e) {
			System.out.println("Não Salvou :(");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}