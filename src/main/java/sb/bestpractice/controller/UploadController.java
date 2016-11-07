package sb.bestpractice.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import sb.bestpractice.model.Location;

@Controller
public class UploadController {
	
	@GetMapping("/")
	public String startPage(Model model) {
		model.addAttribute("location", new Location());
		return "mainpage";
	}
	
	@PostMapping("/uploadimage")
	public String uploadImage(@RequestParam String name, @RequestPart MultipartFile image, Model model) {
		System.out.println("Received name: " + name);
		try {
			if (image.isEmpty()) {
				System.out.println("No file uploaded");
				model.addAttribute("upload", "NOK");
			} else {
				image.transferTo(new File("D:\\!Temp\\Test\\" + image.getOriginalFilename()));
				model.addAttribute("upload", "OK");
			}
		} catch (Exception e) {
			System.out.println("Unknown error uploading filename");
		}
		return "mainpage";
	}

}
