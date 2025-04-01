package thiGK.ntu64130005.HoangDuyAn_ThiGK.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import thiGK.ntu64130005.HoangDuyAn_ThiGK.model.Page;

@Controller
public class GKController {
	ArrayList<Page> pages = new ArrayList<Page>(Arrays.asList(
			new Page(1, "Home", "home, index", "Đây là trang chủ", 0),
			new Page(2, "About", "about, company", "About Us Page", 1)
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
}
