package com.netease.wcf.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.netease.wcf.demo.bean.Product;
import com.netease.wcf.demo.bean.User;
import com.netease.wcf.demo.service.ProductService;
import com.netease.wcf.demo.util.Response;

@Controller
public class ProductController {

    private static final Logger LOGGER = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView show(HttpSession session, @RequestParam("productId") Integer productId) {
        User user = (User) session.getAttribute("user");
        ModelAndView mv = productService.getProduct(user,productId);
        mv.setViewName("show");
        LOGGER.debug("show:" + mv);
        return mv;
    }

    @RequestMapping(value = "/api/delete", method = RequestMethod.POST)
    @ResponseBody
    public Response delete(@RequestParam("productId") Integer productId) {
        int result = productService.putOffProduct(productId);
        if (result == 1) {
            return new Response("Delete success.", true, 200);
        } else {
            return new Response("Delete fail.", false, 500);
        }
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(HttpSession session, @RequestParam("productId") Integer productId){
        User user = (User)session.getAttribute("user");
        ModelAndView mv = productService.getProduct(user, productId);
        return mv;
    }
    
    @RequestMapping(value="/editSubmit", method=RequestMethod.POST)
    public String editSubmit(Model model, @ModelAttribute Product product) {

        //Product product = new Product(title, digest, image, price, detail);
        LOGGER.debug(product.toString());
        int result = productService.updateProduct(product);
        if (result > 0) {
            LOGGER.debug("update product success." + product.toString());
            model.addAttribute("product", product);
        }
        return "publishSubmit";
    }

    @RequestMapping(value = "/api/upload", method = RequestMethod.POST)
    @ResponseBody
    public Response uploadImage(@RequestParam("file") CommonsMultipartFile file, HttpSession session) {
        long startTime = System.currentTimeMillis();

        String uploadFileName = file.getOriginalFilename();
        String filePath = session.getServletContext().getRealPath("/");
        String fileName = "image/" + UUID.randomUUID().toString();
        String fileSuffix = uploadFileName.substring(uploadFileName.lastIndexOf("."));

        File newFile = new File(filePath + fileName + fileSuffix);
        try {
            file.transferTo(newFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("upload file cost time：" + String.valueOf(endTime - startTime) + "ms");
        return new Response(fileName + fileSuffix, true, 200);

    }

    @RequestMapping(value = "/publishSubmit", method = RequestMethod.POST)
    public String publishSubmit(Model model, @RequestParam("title") String title, @RequestParam("digest") String digest, @RequestParam("image") String image,
            @RequestParam("detail") String detail, @RequestParam("price") Float price) {

        Product product = new Product(title, digest, image, price, detail);
        LOGGER.debug(product.toString());
        int result = productService.saveProduct(product);
        if (result > 0) {
            LOGGER.debug("save product success." + product.toString());
            model.addAttribute("product", product);
        }
        return "publishSubmit";
    }

}
