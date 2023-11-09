//
//package com.java4.camping.img;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//@Controller
//public class imgUpLoadController {
//
//	@PostMapping("/createPost")
//	public String createPost(@RequestParam("image") MultipartFile image, @RequestParam("content") String content) {
//
//		String imagePath = saveImage(image);
//		Post post = new Post();
//		post.setContent(content);
//		post.setImagePath(imagePath);
//		postRepository.save(post);
//
//		return "redirect:/";
//	}
//
//	public String listPosts(Model model) {
//		List<Post> posts = postRepository.findAll();
//		model.addAttribute("posts", posts);
//		return "post/list";
//	}
//
//	@GetMapping("/post/{postId}")
//	public String viewPost(@PathVariable Long postId, Model model) {
//		Post post = postRepository.findById(postId).orElse(null);
//		model.addAttribute("post", post);
//		return "post/view";
//	}
//}
