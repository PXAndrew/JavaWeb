package web.servlet;

import com.shopping.dao.IProductDAO;
import com.shopping.dao.IProductDirDAO;
import com.shopping.dao.impl.ProductDAOImpl;
import com.shopping.dao.impl.ProductDirDAOImpl;
import com.shopping.domain.Product;
import com.shopping.domain.ProductDir;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private IProductDAO productDAO;
    private IProductDirDAO productdirDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAOImpl();
        productdirDAO = new ProductDirDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");  // 接收 post 请求的参数编码
        String cmd = req.getParameter("cmd");

        if (cmd.equals("list")) {
            list(req, resp);
        } else if (cmd.equals("update") || cmd.equals("save")) {
            saveOrUpdate(req, resp);
        } else if (cmd.equals("delete")) {
            delete(req, resp);
        } else if (cmd.equals("edit")) {
            edit(req, resp);
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Product> products = productDAO.list();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/product/views/productList.jsp").forward(req, resp);

    }

    protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Product product = new Product();
        this.requestToObject(req, product);
        if (hasLength(id)) {
            product.setId(Long.valueOf(id));
            productDAO.update(product);
        } else {
            productDAO.save(product);
        }
        resp.sendRedirect(req.getContextPath() + "/product?cmd=list");

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        productDAO.delete(Long.valueOf(id));
        resp.sendRedirect(req.getContextPath() + "/product?cmd=list");
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (hasLength(id)) {
            req.setAttribute("product", productDAO.get(Long.valueOf(id)));
        }
        req.setAttribute("dirs", productdirDAO.list());
        req.getRequestDispatcher("/WEB-INF/product/views/productEdit.jsp").forward(req, resp);
    }

    private void requestToObject(HttpServletRequest request, Product obj) {
        String productName = request.getParameter("productName");
        String brand = request.getParameter("brand");
        String supplier = request.getParameter("supplier");
        String salePrice = request.getParameter("salePrice");
        String costPrice = request.getParameter("costPrice");
        String cutoff = request.getParameter("cutoff");
        String dir_id = request.getParameter("dir_id");

        obj.setProductName(productName);
        obj.setBrand(brand);
        obj.setSupplier(supplier);
        obj.setSalePrice(new BigDecimal(salePrice));
        obj.setCostPrice(new BigDecimal(costPrice));
        obj.setCutoff(Double.valueOf(cutoff));
        ProductDir productDir = new ProductDir();
        productDir.setId(Long.valueOf(dir_id));
        obj.setProductDir(productDir);
    }

    private boolean hasLength(String string) {
        return string != null && !"".equals(string.trim());
    }
}
