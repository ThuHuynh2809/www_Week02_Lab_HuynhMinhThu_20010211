package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.frontend.model;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.models.Product;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.backend.services.ProductServices;

public class ProductModel {
    private final ProductServices services =new ProductServices();
    public void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        String unit = req.getParameter("unit");
        String manu = req.getParameter("manu");
        String status = req.getParameter("status");

        Product product =new Product(name,desc,unit,manu, ProductStatus.valueOf(status));
        services.insert(product);
        resp.sendRedirect("products.jsp");
    }

    public void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        long id =Long.parseLong(req.getParameter("id"));
        services.updateStatus(id, ProductStatus.IN_ACTIVE);
        resp.sendRedirect("products.jsp");
    }
}