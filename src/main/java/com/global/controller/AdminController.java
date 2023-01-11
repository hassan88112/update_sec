package com.global.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.global.Entity.Category;
import com.global.Service.CategoryService;

@Controller
public class AdminController {
	
	@Autowired
	private CategoryService categoryService;
	

	@GetMapping("/admin")
	public String adminHome(){

        return "adminHome";
    }
	
		
	@GetMapping("/admin/categories")
	public String getCat(Model model){
     model.addAttribute("categories",categoryService.getAllCategories());
        return "categories";
    }
	
	@GetMapping("/admin/categories/add")  //action bt2 button da byro7 ly /admin/categories/add
	public String getCatAdd(Model model){

		model.addAttribute("category",new Category());
        return "categoriesAdd";
    }
	
	@PostMapping("/admin/categories/add")  // da by add category gdeed
	public String postCatAdd(@ModelAttribute ("category") Category category){
		
		categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
		
	
	@GetMapping("/admin/categories/delete/{id}")
	public String deletecategory(@PathVariable int id) {	
			
        categoryService.deleteCat(id);      
		return "redirect:/admin/categories";
		
	}
	@GetMapping("/admin/categories/update/{id}")  //action bt2 button da byro7 ly /admin/categories/add
	public String updateCat(Model model ,@PathVariable int id ){

        Optional<Category> c =categoryService.grtCatById(id);
        if(c.isPresent()) {        	
        	model.addAttribute("category",c.get());
        	return "categoriesAdd";
        }else {
        	return "404";
        }
		
    }
	/*
	@PostMapping("/admin/categories/update")
	public String updateCategoryAdd(@ModelAttribute Category category) {
		
		Category c=new Category();
		c.setId(category.getId());
		c.setName(category.getName());
		categoryService.addCategory(c);
	//	session.setAttribute("message", "Category deleted successfully");
		return "redirect:/admin/categories";
	}*/
	
	
}
/*
 * @PutMapping("/task/{id}")
	public ResponseEntity<?> update(@RequestBody Task t, @PathVariable Long id) {

		if (taskService.exsistById(id)) {
			
			Task t1 = taskService.getById(id).orElseThrow();
			t1.setTitle(t.getTitle());
			t1.setType(t.getType());
			t1.setDueDate(t.getDueDate());
			t1.setDescription(t.getDescription());

			taskService.addtask(t1);
			return ResponseEntity.ok().body(t1);

		} else {
			HashMap<String, String> message = new HashMap<>();
			message.put("message", id + "Task not found or match");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
 */
 
