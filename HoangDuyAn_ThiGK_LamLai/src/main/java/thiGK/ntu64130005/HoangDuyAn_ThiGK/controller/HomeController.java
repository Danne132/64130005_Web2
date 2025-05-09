package thiGK.ntu64130005.HoangDuyAn_ThiGK.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import thiGK.ntu64130005.HoangDuyAn_ThiGK.model.Page;
import thiGK.ntu64130005.HoangDuyAn_ThiGK.model.Post;

@Controller
public class HomeController {
	ArrayList<Page> pages = new ArrayList<Page>(Arrays.asList(
			new Page(1, "Home", "home, index", "Đây là trang chủ", 0),
			new Page(2, "About", "about, company", "About Us Page", 1)
			));
	ArrayList<Post> posts = new ArrayList<>(Arrays.asList(
            new Post("1", "Bài viết 1", "Nội dung bài viết 1", "C1"),
            new Post("2", "Bài viết 2", "Nội dung bài viết 2", "C2"),
            new Post("3", "Bài viết 3", "Nội dung bài viết 3", "C3")
        ));
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/page/all")
	public String getAllPage(ModelMap model) {
		model.addAttribute("pages", pages);
        return "pages/pagelists";
	}
	
	@GetMapping("/page/new")
	public String getNewPage() {
        return "pages/addpage";
	}
	
	@RequestMapping(value = "/addpage", method = RequestMethod.POST)
	public String addPage(ModelMap model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String pageName = request.getParameter("namePage");
		String keyword = request.getParameter("keyword");
		String content = request.getParameter("content");
		int parentPageId = Integer.parseInt(request.getParameter("parentPageId"));
		Page page = new Page(id, pageName, keyword, content, parentPageId);
		pages.add(page);
		model.addAttribute("pages", pages);
		return "pages/pagelists";
	}
	
	@GetMapping("/page/view/{id}")
	public String viewPage(@PathVariable("id") int id, ModelMap model) {
	    for (Page page : pages) {
	        if (page.getId() == id) {
	            model.addAttribute("page", page);
	            break;
	        }
	    }
	    return "pages/viewPage";
	}
	
    @GetMapping("/page/delete/{id}")
    public String deletePage(@PathVariable("id") int id) {
        pages.removeIf(page -> page.getId() == id);
        return "redirect:/page/all";
    }
	
	@GetMapping("/post/all")
	public String getAllPost(ModelMap model) {
		model.addAttribute("posts", posts);
        return "posts/postlists";
	}
	
	@GetMapping("/post/new")
	public String getNewPost() {
        return "posts/addPost";
	}
	
	@RequestMapping(value = "/addpost", method = RequestMethod.POST)
	public String addPost(ModelMap model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String pageName = request.getParameter("title");
		String keyword = request.getParameter("content");
		String content = request.getParameter("categoryId");
		Post page = new Post(id, pageName, keyword, content);
		posts.add(page);
		model.addAttribute("posts", posts);
		return "posts/postlists";
	}
	
	@GetMapping("/post/view/{id}")
	public String viewPost(@PathVariable("id") String id, ModelMap model) {
	    for (Post post : posts) {
	        if (post.getId().equals(id)) {
	            model.addAttribute("post", post);
	            break;
	        }
	    }
	    return "posts/viewPost";
	}
	
    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable("id") String id) {
        posts.removeIf(post -> post.getId().equals(id));
        return "redirect:/post/all";
    }
}
