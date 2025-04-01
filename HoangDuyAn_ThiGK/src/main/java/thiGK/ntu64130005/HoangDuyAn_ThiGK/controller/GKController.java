package thiGK.ntu64130005.HoangDuyAn_ThiGK.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import thiGK.ntu64130005.HoangDuyAn_ThiGK.model.Page;
import thiGK.ntu64130005.HoangDuyAn_ThiGK.model.Post;

@Controller
public class GKController {
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
	public String getDashBoard() {
		return "index";
	}
	
	@GetMapping("/page/all")
	public String getAllPage(ModelMap model) {
		model.addAttribute("pages", pages);
        return "pagelists";
	}
	
	@GetMapping("/page/{id}")
    public String viewPage(@PathVariable int id, ModelMap model) {
        for (Page page : pages) {
            if (page.id == id) {
                model.addAttribute("page", page);
                return "viewpage";
            }
        }
        return "redirect:/dashboard/pagelist";
    }
	
	@GetMapping("/page/delete/{id}")
    public String deletePage(@PathVariable int id) {
        pages.removeIf(page -> page.id == id);
        return "redirect:/dashboard/pagelist";
    }
	
	@GetMapping("/page/new")
	public String getNewPage() {
        return "addpage";
	}
	
	@GetMapping("/post/all")
	public String getAllPost(ModelMap model) {
		model.addAttribute("posts", posts);
        return "pagelists";
	}
	
	@GetMapping("/post/{id}")
    public String viewPost(@PathVariable int id, ModelMap model) {
        for (Page page : pages) {
            if (page.id == id) {
                model.addAttribute("page", page);
                return "viewpage";
            }
        }
        return "redirect:/dashboard/postlists";
    }
	
	@GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable int id) {
        pages.removeIf(page -> page.id == id);
        return "redirect:/dashboard/postlists";
    }
}
