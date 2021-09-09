package com.johnthedev.com.mywebshop.service;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.johnthedev.com.mywebshop.service.storage.StorageFileNotFoundException;
import com.johnthedev.com.mywebshop.service.storage.StorageService;

@Controller
public class FileUploadController {

	private final StorageService storageService;
	private int theProductId;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping("/uploadfile/add")
	public String listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		return "uploadForm-add";
	}
	
	@GetMapping("/uploadfile/update")
	public String updateUploadedImage(@RequestParam("productId") int theId, Model model,
			RedirectAttributes redirectAttributes) throws IOException {

		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));

		model.addAttribute("theId",theId);
		theProductId = theId;
		return "uploadForm";

	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	@PostMapping("/addImage")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes, Model theModel) {

		storageService.store(file);

		String s = new String();		
		s = "/"+storageService.getFilePath()+file.getOriginalFilename();
		String s1 = new String();
		s1 = s.substring(27);
		
		redirectAttributes.addFlashAttribute("imgPath",s1);
	
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");
		
		return "redirect:/products/showFormForAdd";
	}
		
	@PostMapping("/updateImage")
	public String handleImageUpdate(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes, Model theModel) {

		storageService.store(file);

		String s = new String();		
		s = "/"+storageService.getFilePath()+file.getOriginalFilename();
		String s1 = new String();
		s1 = s.substring(27);
		
		redirectAttributes.addFlashAttribute("imgPath",s1);
		
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

	redirectAttributes.addFlashAttribute("productId",1);
	return "redirect:/products/showFormForUpdate?productId="+theProductId+"";


	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
