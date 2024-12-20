package sit.int202.crudproduct.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sit.int202.crudproduct.entities.Product;
import sit.int202.crudproduct.services.ProductService;
import sit.int202.crudproduct.services.ProductlineService;

import java.io.IOException;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductlineService productlineService;
    private final ProductService productService;
    private final HttpServletResponse httpServletResponse;

    public ProductController(ProductService productService, ProductlineService productlineService, HttpServletResponse httpServletResponse) {
        this.productService = productService;
        this.productlineService = productlineService;
        this.httpServletResponse = httpServletResponse;
    }

    @GetMapping("/all")
    public String getAllProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        System.out.println(productService.findAll());
        return "product_list";

    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("lines", productlineService.findAll());
        return "create_form";
    }

    @PostMapping("/create")
    public void createProduct(Product product, HttpServletResponse httpServletResponse) throws IOException {
        productService.createProduct(product);
        httpServletResponse.sendRedirect("/products/all");
    }

    @PostMapping("/delete")
    public String deletePoduct(@RequestParam("id") String id) {
        productService.deleteProduct(id);
        return "redirect:/products/all";
    }


    @GetMapping("/update")
    public String updateForm(@RequestParam("productCode") String productCode, ModelMap model) {
        model.addAttribute("product", productService.getProduct(productCode));
        model.addAttribute("lines", productlineService.findAll());
        return "update_form";
    }


    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, ModelMap model) {
        Product updatedProduct = productService.updateProduct(product);
        model.addAttribute("product", updatedProduct);

        return "redirect:/products/all";
    }

}
