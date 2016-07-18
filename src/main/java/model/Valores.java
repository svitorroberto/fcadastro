package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import aditional.RodarImagem;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
public class Valores {
	
	public static void main(String[] args){
//		String filename = "8569675";
//		String foto = "D:"+File.separator+"img_filiado"+File.separator+"imagem"+File.separator+filename+ ".jpeg";
//		Imagem img = new Imagem();
//    	img.setIe_empresa("0001");
//    	img.setIe_filial("0001");
//    	img.setIe_tipoimg("JPG");
//    	img.setIe_serie("1");
//    	img.setIe_fornece("1404");
//    	img.setIe_numero("1404");
//    	Path path = Paths.get(foto);
//    	try {
//			img.setIe_imagem(Files.readAllBytes(path));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//    	ImagemDaoImpl idi = new ImagemDaoImpl();
//    	idi.gravarImagem(img);
		File img = new File("D:"+File.separator+"img_filiado"+File.separator+"imagem"+File.separator+"12790426"+ ".jpg");
		RodarImagem ri = new RodarImagem();
		BufferedImage bi = new BufferedImage(320, 240, BufferedImage.TYPE_INT_ARGB);
		try {
			bi = ImageIO.read(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ri.rotateImage(bi, 90.0);
		
		
	
	}

}
