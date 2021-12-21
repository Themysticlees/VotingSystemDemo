package net.codejava;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import antlr.StringUtils;

@Controller
public class MainController {
	
	@GetMapping("/register")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
		model.addAttribute("listProfession", listProfession);
		
		return "register_form";
	}
	
	@Autowired
	UserRepo repo;
	
	@PostMapping("/register")
	public String submitForm(@ModelAttribute("user") User user,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		//String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String fileName = multipartFile.getOriginalFilename();
		
		user.setPhotos(fileName);
		User savedUser = repo.save(user);
		String uploadDir = "user-photos/" + savedUser.getId();
		
		 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		
		System.out.println(user);
		//repo.save(user);
		return "register_success";
	}
}
